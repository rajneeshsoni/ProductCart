package com.productcart.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.productcart.api.model.CartRequest;
import com.productcart.api.model.EcomCart;
import com.productcart.api.model.ProductCart;
import com.productcart.api.model.Users;
import com.productcart.api.repository.ProductCartRepo;
import com.productcart.api.repository.ProductRepository;
import com.productcart.api.repository.UserRepository;

@Service
@Transactional
public class ProductCartService {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	@Autowired
	private ProductCartRepo cartRepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	private ProductRepository prductcaTrepo;
	
	
	
	

	

	public String validateProduct(ProductCart productcart, String value) {

		InstanceInfo info = eurekaClient.getNextServerFromEureka("GETPRODUCT", false);
		String url = "http://" + info.getHostName() + ":" + info.getPort() + "product/{id}";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", value);
		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> result = new RestTemplate().exchange(url, HttpMethod.GET, entity, String.class,
				productcart.getId());

		// ResponseEntity<String> result = new RestTemplate().getForEntity(url,
		// String.class, productcart.getId());
		return result.getBody();
	}

	
	  public String addCard(CartRequest productcart ,String username)
	  { 
		  int cartId=0;
		  Users userDetails =userrepo.findByUsername(username);
		  try
		  {  
			  EcomCart ecard =  cartRepo.findByUsername(username);
			 
			  cartId = ecard.getId();
			  if(ecard.getId() != null)
			  {
				  List<ProductCart> productCat = new ArrayList<ProductCart>();
				  for(int i =0; i<productcart.getCartList().size();i++)
				  {
					  ProductCart procart = new ProductCart();
					  procart.setProductAmount(productcart.getCartList().get(i).getProductAmount());
					  procart.setProductId(productcart.getCartList().get(i).getProductId());
					  procart.setProductName(productcart.getCartList().get(i).getProductName());
					  procart.setProductUnit(productcart.getCartList().get(i).getProductUnit());
					  procart.setUsername(username);
					  procart.setUserId(userDetails.getId());
					  procart.setCartId(cartId);
					  prductcaTrepo.save(procart);
					 
					  
				  }
				  //ecard.setProductCat(productCat);
				 
			  }
			  
		  }catch (Exception e) {
			
		
	 
		  EcomCart cart = new EcomCart();
		  cart.setUsername(username);
		  List<ProductCart> productCat = new ArrayList<ProductCart>();
		  cart.setUserId(userDetails.getId());
		  cart = cartRepo.save(cart);
		  cartId= cart.getId();
		  for(int i =0; i<productcart.getCartList().size();i++)
		  {
			  ProductCart procart = new ProductCart();
			  procart.setProductAmount(productcart.getCartList().get(i).getProductAmount());
			  procart.setProductId(productcart.getCartList().get(i).getProductId());
			  procart.setProductName(productcart.getCartList().get(i).getProductName());
			  procart.setProductUnit(productcart.getCartList().get(i).getProductUnit());
			  procart.setUsername(username);
			  procart.setUserId(userDetails.getId());
			  procart.setCartId(cartId);
			  prductcaTrepo.save(procart);
			  
		  }
		 
		  
		  
		  }
	 
	  
		 return "Your Cart No :"+ cartId;
	  }
	 
	  
	  public void removeCard(String username)
	  {
		  cartRepo.deleteByUsername(username);
	  }

}
