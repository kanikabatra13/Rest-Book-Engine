package com.bookengine.ws.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;


public final class BookServiceClient {
	
	 private BookServiceClient() {
	    } 

	 public static void main(String args[]) throws Exception {

    	 List<Object> providers = new ArrayList<Object>();
         JacksonJsonProvider provider = new JacksonJsonProvider();
         provider.addUntouchable(Response.class);
         providers.add(provider);
         
         /*****************************************************************************************
          * GET METHOD invoke
          *****************************************************************************************/
         System.out.println("GET METHOD .........................................................");
         WebClient getClient = WebClient.create("http://localhost:8081", providers);
         
         //Configuring the CXF logging interceptor for the outgoing message
         WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
       //Configuring the CXF logging interceptor for the incoming response
         WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
         
         // change application/xml  to get in xml format
         getClient = getClient.accept("application/json").type("application/json").path("/bookservice/book/X1");
         
         //The following lines are to show how to log messages without the CXF interceptors
         String getRequestURI = getClient.getCurrentURI().toString();
         System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
         String getRequestHeaders = getClient.getHeaders().toString();
         System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
         
         //to see as raw XML/json
         String response = getClient.get(String.class);
         System.out.println("GET METHOD Response: ...." + response);
         
        //to get the response as object of Employee class
        //Employee employee = client.get(Employee.class);
        //System.out.println("Name:" + employee.getFirstName());
        //System.out.println("privileges:" + employee.getPrivileges());
        
      
//		Book book = getClient.get(Book.class);
//         System.out.println("Book Name:" +book.getBookName());
//         System.out.println("Book Name:" +book.getAuthorName());
         
         
         /*****************************************************************************************
          * GET METHOD invoke author name
          *****************************************************************************************/
//         System.out.println("GET METHOD .........................................................");
//         WebClient getClient2 = WebClient.create("http://localhost:8081", providers);
//         
//         //Configuring the CXF logging interceptor for the outgoing message
//         WebClient.getConfig(getClient2).getOutInterceptors().add(new LoggingOutInterceptor());
//       //Configuring the CXF logging interceptor for the incoming response
//         WebClient.getConfig(getClient2).getInInterceptors().add(new LoggingInInterceptor());
//         
//         // change application/xml  to get in xml format
//         getClient2 = getClient2.accept("application/json").type("application/json").path("/bookservice/book/kanika");
//         
//         //The following lines are to show how to log messages without the CXF interceptors
//         String getRequestURI2 = getClient2.getCurrentURI().toString();
//         System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
//         String getRequestHeaders2 = getClient2.getHeaders().toString();
//         System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
//         
//         //to see as raw XML/json
//         String response2 = getClient2.get(String.class);
//         System.out.println("GET METHOD Response: ...." + response2);
         
         System.exit(0);
}
}
