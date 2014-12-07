import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bookengine.ws.Book;
import com.bookengine.ws.Customer;


public class CustomerDAO {
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	public CustomerDAO()
	{
		Customer customer1 = new Customer("1","Kanika", "kanika13", "abc@123", "N Sheridan Road Chicago", "123-678-8890");
		Customer customer2 = new Customer("2","Chirag","kanika13", "abc@123", "N Sheridan Road Chicago", "123-678-8890");
		Customer customer3 = new Customer("3","Mehar", "kanika13", "abc@123", "N Sheridan Road Chicago", "123-678-8890");
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	
	
	public Customer getCustomer(String id) {
		for (Customer customer : customers) {
			if(customer.getCustID().equals(id)) {
				return customer;
			}
		}
		return null;
	}
	
	/**
	 * Add a new customer to the database.
	
	 */
	public Customer addCustomer(String name, String ph, String address , List<Book> books) {
		
		// Create the new book.
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		
	    String id = "" + randomInt;
		Customer customer = new Customer();
		customer.setCustID(id);
		customer.setName(name);
		customer.setPhone(ph);
		customer.setAddress(address);
		customer.setBooks(books);
		
		// Add the new book.
		customers.add(customer);
		
		// Return the new book.
		return customer;
	}

}

