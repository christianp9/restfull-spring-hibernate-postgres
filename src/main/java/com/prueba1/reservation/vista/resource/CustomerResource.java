/**
 * 
 */
package com.prueba1.reservation.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba1.reservation.model.Customer;
import com.prueba1.reservation.negocio.services.CustomerService;
import com.prueba1.reservation.vista.resource.vo.CustomerVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * representa el servicio web de cliente
 * 
 * @author Christianp99
 *
 */
@RestController
@RequestMapping("/api/customer")
@Api(tags = "customer")
public class CustomerResource {

	private final CustomerService customerService;

	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	@ApiOperation(value = "Create customer", notes = "Service to crate a new customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Customer create successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerVO customerVo) {
		Customer customer = new Customer();
		customer.setNameCLI(customerVo.getNameCLI());
		customer.setLastCLI(customerVo.getLastCLI());
		customer.setAddressCLI(customerVo.getAddressCLI());
		customer.setPhoneCLI(customerVo.getPhoneCLI());
		customer.setEmailCLI(customerVo.getEmailCLI());

		return new ResponseEntity<>(this.customerService.create(customer), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "update customer", notes = "Service to update a customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Customer updated successfully"),
			@ApiResponse(code = 404, message = "Customer not found") })
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, CustomerVO customerVo) {

		Customer customer = this.customerService.findByidentyCLI(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else {
			customer.setNameCLI(customerVo.getNameCLI());
			customer.setLastCLI(customerVo.getLastCLI());
			customer.setAddressCLI(customerVo.getAddressCLI());
			customer.setPhoneCLI(customerVo.getPhoneCLI());
			customer.setEmailCLI(customerVo.getEmailCLI());
		}

		return new ResponseEntity<>(this.customerService.update(customer), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete customer", notes = "Service to delete a customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Customer deleted successfully"),
			@ApiResponse(code = 404, message = "Customer not found") })
	public void removeCustomer(@PathVariable("id") String id) {
		Customer customer = this.customerService.findByidentyCLI(id);
		if (customer != null) {
			this.customerService.delete(customer);
		}
	}

	@GetMapping
	@ApiOperation(value = "to list customer", notes = "Service to list all customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Customers found"),
			@ApiResponse(code = 404, message = "Customers not found") })
	public ResponseEntity<List<Customer>> findAll() {
		return ResponseEntity.ok(this.customerService.findAll());
	}
}
