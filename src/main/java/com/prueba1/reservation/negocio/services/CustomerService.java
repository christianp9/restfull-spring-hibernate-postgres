/**
 * 
 */
package com.prueba1.reservation.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba1.reservation.model.Customer;
import com.prueba1.reservation.negocio.repository.CustomerRepository;

/**
 * definir los servicios de cliente
 * 
 * @author MARTIN2
 *
 */
@Service
@Transactional(readOnly = true)
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/*
	 * metodo para guardar un cliente
	 * 
	 */
	@Transactional
	public Customer create(Customer customer) {
		return this.customerRepository.save(customer);
	}

	/*
	 * metodo para actualizar
	 */
	@Transactional
	public Customer update(Customer customer) {
		return this.customerRepository.save(customer);
	}

	/*
	 * metodo para eliminar
	 */
	@Transactional
	public void delete(Customer customer) {
		this.customerRepository.delete(customer);
	}
	/*
	 * metodo para buscar por id
	 */

	public Customer findByidentyCLI(String identyCLI) {
		return this.customerRepository.findByidentyCLI(identyCLI);
	}
	
	public List<Customer> findAll(){
		return this.customerRepository.findAll();
	}
}
