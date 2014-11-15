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
          * GET METHOD invoke for all Books
          *****************************************************************************************/
         System.out.println("GET METHOD for all Books..........................................");
         WebClient getAllClient = WebClient.create("http://localhost:8081", providers);
         WebClient.getConfig(getAllClient).getOutInterceptors().add(new LoggingOutInterceptor());
         WebClient.getConfig(getAllClient).getInInterceptors().add(new LoggingInInterceptor());
         
         // change application/xml  to get in xml format
         getAllClient = getAllClient.accept("application/json").type("application/json").path("/bookservice/book");
                  
         String getAllRequestURI = getAllClient.getCurrentURI().toString();
         System.out.println("Client GET METHOD Request URI:  " + getAllRequestURI);
         String getAllRequestHeaders = getAllClient.getHeaders().toString();
         System.out.println("Client GET METHOD Request Headers:  " + getAllRequestHeaders);
         
         //to see as raw XML/json
         String getAllResponse = getAllClient.get(String.class);
         System.out.println("GET All METHOD Response: ...." + getAllResponse);
         
         
         /*****************************************************************************************
          * GET METHOD invoke Book ID
          *****************************************************************************************/
         System.out.println("\nGET METHOD ...........................................Book ID");
         WebClient getClient = WebClient.create("http://localhost:8081", providers);
         
         //Configuring the CXF logging interceptor for the outgoing message
         WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
       //Configuring the CXF logging interceptor for the incoming response
         WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
         
         // change application/xml  to get in xml format
         getClient = getClient.accept("application/json").type("application/json").path("/bookservice/book/bookId/X1");
         
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
            System.out.println("\nGET METHOD .................................................Author Name");
            WebClient getClient2 = WebClient.create("http://localhost:8081", providers);
        
//         //Configuring the CXF logging interceptor for the outgoing message
            WebClient.getConfig(getClient2).getOutInterceptors().add(new LoggingOutInterceptor());
//       //Configuring the CXF logging interceptor for the incoming response
            WebClient.getConfig(getClient2).getInInterceptors().add(new LoggingInInterceptor());
//         
//         // change application/xml  to get in xml format
            getClient2 = getClient2.accept("application/json").type("application/json").path("/bookservice/book/bookauthor/Julius");
//         
//         //The following lines are to show how to log messages without the CXF interceptors
            String getRequestURI2 = getClient2.getCurrentURI().toString();
            System.out.println("Client GET METHOD Request URI:  " + getRequestURI2);
            String getRequestHeaders2 = getClient2.getHeaders().toString();
             System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders2);
         
//         //to see as raw XML/json
            String response2 = getClient2.get(String.class);
             System.out.println("GET METHOD Response: ...." + response2);
             
             
             
             /*****************************************************************************************
              * GET METHOD invoke Book name
              *****************************************************************************************/
                System.out.println("\nGET METHOD ...................................................Book Name");
                WebClient getClient3 = WebClient.create("http://localhost:8081", providers);
            
//             //Configuring the CXF logging interceptor for the outgoing message
                WebClient.getConfig(getClient3).getOutInterceptors().add(new LoggingOutInterceptor());
//           //Configuring the CXF logging interceptor for the incoming response
                WebClient.getConfig(getClient3).getInInterceptors().add(new LoggingInInterceptor());
//             
//             // change application/xml  to get in xml format
                getClient3 = getClient3.accept("application/json").type("application/json").path("/bookservice/book/bookname/Database Programming");
//             
//             //The following lines are to show how to log messages without the CXF interceptors
                String getRequestURI3 = getClient3.getCurrentURI().toString();
                System.out.println("Client GET METHOD Request URI:  " + getRequestURI3);
                String getRequestHeaders3 = getClient3.getHeaders().toString();
                 System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders3);
             
//             //to see as raw XML/json
                String response3 = getClient3.get(String.class);
                 System.out.println("GET METHOD Response: ...." + response3);
             
         
         System.exit(0);
}
}
