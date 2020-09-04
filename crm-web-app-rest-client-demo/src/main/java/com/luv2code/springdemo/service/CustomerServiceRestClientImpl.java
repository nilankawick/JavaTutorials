package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.model.Customer;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		System.out.println("DEBUG INFO --> BEANs Initiating the Rest Template");
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Customer> getCustomers() {
		
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);
		System.out.println("DEBUG INFO --> Initiating  GetCustomers the Rest API");
		//System.out.println("DEBUG INFO --> Initiating  GetCustomers the Rest API URL :" + crmRestUrl);
		
		
		/*
		 * Approach 1 standard request without authorization information
		 */		
		/*
		ResponseEntity<List<Customer>> responseEntity = 
				restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
									  new ParameterizedTypeReference<List<Customer>>() {});
		*/
		// End of Approach 1 ***

		
		
		/*
		 * Approach 2 Including the authorization information
		 */		
	    // create headers to pass in api authentication details
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBasicAuth("susan", "test123");

	    // create request
	    HttpEntity request = new HttpEntity(headers);

		// make REST call with authentication header that capture via the HttpEntity request variable
		ResponseEntity<List<Customer>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, request, 
																  new ParameterizedTypeReference<List<Customer>>() {});
		
		
		// End of Approach 2 ***

		
		
		
		// get the list of customers from response
		List<Customer> customers = responseEntity.getBody();

		logger.info("in getCustomers(): customers" + customers);
		
		return customers;
	}

	@Override
	public Customer getCustomer(int theId) {
		System.out.println("DEBUG INFO --> Initiating  GetCustomer ID - " + theId);
		//System.out.println("DEBUG INFO --> Initiating  GetCustomers ID the Rest API URL :" + crmRestUrl);
		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);

		// ****Approach 1 - make REST call the standard approach //
		
		/*
		Customer theCustomer = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Customer.class);
		*/	
		//end of approach 1****//
		
		
		//****Approach 2 make the rest call with authentication ///
		
		// create headers to pass in api authentication details
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBasicAuth("susan", "test123");

	    // create request
	    HttpEntity request = new HttpEntity(headers);
	    ResponseEntity<Customer> responseEntity = restTemplate.exchange(crmRestUrl + "/" + theId, HttpMethod.GET,request, Customer.class);
		
		Customer theCustomer = responseEntity.getBody();
		
		// end of approach 2  ****
		
		
	    
	    logger.info("getCustomer(): theCustomer=" + theCustomer);
		
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
		System.out.println("DEBUG INFO --> Initiating  saveCustomer " + theCustomer);
	//	System.out.println("DEBUG INFO --> calling the following URL to  saveCustomer " + crmRestUrl);
		
		int employeeId = theCustomer.getId();
		
		
		//preparing the header 
		
		HttpHeaders headers = new HttpHeaders();
		/* Not required
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		*/
		headers.setBasicAuth("susan", "test123");
		
	    // build the request
	    HttpEntity<Customer> request = new HttpEntity<>(theCustomer, headers);
		

		// make REST call
		if (employeeId == 0) {
			/* add employee with no authentication
			restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);
			*/
			
			/* add customer with authentication */
			restTemplate.postForEntity(crmRestUrl, request, String.class);
		
		} else {
			/* update employee with no authentication
			restTemplate.put(crmRestUrl,theCustomer);
			*/
			
			/* with Authentication */
			restTemplate.put(crmRestUrl,request);
		}

		logger.info("in saveCustomer(): success");	
	}

	@Override
	public void deleteCustomer(int theId) {
		System.out.println("DEBUG INFO --> Initiating  deleteCustomer for ID: " + theId);
		
		//System.out.println("DEBUG INFO --> calling the following URL to  delete " + crmRestUrl);

		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);

		// Approach 1 - make REST call to delete without authentication
		/*
		restTemplate.delete(crmRestUrl + "/" + theId);
		*/
		
		//Approach 2 - deleting a customer using an authenticated end point
		
		// create headers to pass in api authentication details
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBasicAuth("susan", "test123");

	    // create request
	    HttpEntity request = new HttpEntity(headers);
	    restTemplate.exchange(crmRestUrl + "/" + theId, HttpMethod.DELETE,request, String.class);
		
	  //  System.out.println("DEBUG INFO --> Delete rest template -- " + restTemplate.toString());
		
		logger.info("in deleteCustomer(): deleted customer theId=" + theId);
	}

}
