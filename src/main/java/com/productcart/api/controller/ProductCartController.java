package com.productcart.api.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productcart.api.model.ProductCartLog;
import com.productcart.api.model.CartRequest;
import com.productcart.api.model.ProductCart;
import com.productcart.api.repository.ProductCartRepo;
import com.productcart.api.repository.ProductRepository;
import com.productcart.api.services.ProductCartService;
import com.productcart.api.util.JwtUtil;





@RestController
@RequestMapping(path="/productCart") 
public class ProductCartController {
	
	private static Logger log = LoggerFactory.getLogger(ProductCartController.class);
	
	@Autowired
	ProductRepository prodRep;
	
	@Autowired 
	JwtUtil jwtUtils;
	
	@Autowired
	ProductCartService productCart;
	
	@Autowired
	private ProductRepository prductcaTrepo;
	
	@Autowired
	private ProductCartRepo cartRepo;
	
	
	
	@Autowired
	private KafkaTemplate<String, ProductCartLog> kafkaTemplate;

	    private static final String TOPIC = "Kafka_Place_json";
	
	@RequestMapping( method = RequestMethod.PUT)
	public String addProductCart(@RequestBody CartRequest productcart,HttpServletRequest request)
	{
		log.info("productcart>>"+productcart.getCartList().size());
		
		/*
		 * log.info("Token:::"+request.toString()); String responseMessage = null;
		 * productcart.setUsername(jwtUtils.getUsername(request));
		 * 
		 * String result =
		 * productCart.validateProduct(productcart,request.getHeader("authorization"));
		 * log.info("result>>>>>>>>>>"+result); if(result.equals("Y")) {
		 * prodRep.save(productcart); responseMessage ="Item add successfully. "; }else
		 * { responseMessage = "No Item found."; }
		 */
		//int cartId =productCart.addCard(productcart,jwtUtils.getUsername(request));
		return productCart.addCard(productcart, jwtUtils.getUsername(request));
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<ProductCart>  getCartData(@PathVariable String id)
	{
		log.info("getCartData");
		List<ProductCart> cartData= prodRep.findByUsername(id);
		return cartData;
	}
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public void deleteCart(@PathVariable String userName)
	{
		//prodRep.deleteByUsername(userName);
		//return "Delete Cart";
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public String placeOrder(HttpServletRequest request)
	{
		log.info("placeOrder");
		Double totalAmount =0.00;
		
		List<ProductCart> listOfProduct = prductcaTrepo.findByUsername(jwtUtils.getUsername(request));
		
		 kafkaTemplate.send(TOPIC,  new ProductCartLog("PlaceOrder", request.getHeader("authorization"),jwtUtils.getUsername(request) ,listOfProduct, new Date()));
		productCart.removeCard(jwtUtils.getUsername(request));
		for(int i=0;i< listOfProduct.size();i++)
		{
			totalAmount +=listOfProduct.get(i).getProductAmount();
			
			prductcaTrepo.delete(listOfProduct.get(i));
		}
		
			
		
		
	
		return "Send Request for Order place : Your Total amount RS: " +totalAmount;
	}
	
}
