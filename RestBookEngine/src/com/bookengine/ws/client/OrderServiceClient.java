package com.bookengine.ws.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.bookengine.ws.service.representation.OrderRequest;


public class OrderServiceClient {

	private OrderServiceClient() {
    } 

 public static void main(String args[]) throws Exception {

	 List<Object> providers = new ArrayList<Object>();
     JacksonJsonProvider provider = new JacksonJsonProvider();
     provider.addUntouchable(Response.class);
     providers.add(provider);
     
     
     /*****************************************************************************************
      * POST METHOD invoke
     *****************************************************************************************/
     System.out.println("POST METHOD .........................................................");
     WebClient postClient = WebClient.create("http://localhost:8081", providers);
     WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
     WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());
              
     // change application/xml  to application/json get in json format
     postClient = postClient.accept("application/xml").type("application/json").path("/orderservice/order");
  	
     String postRequestURI = postClient.getCurrentURI().toString();
     System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
     String postRequestHeaders = postClient.getHeaders().toString();
     System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
     OrderRequest orderRequest = new OrderRequest();
     orderRequest.setBookId("X1");
     
     
  	String responsePost =  postClient.post(orderRequest, String.class);
     System.out.println("POST MEDTHOD Response ........." + responsePost);
     
}
}
