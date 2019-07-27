/**
 * 
 */
package com.prueba1.reservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba1.reservation.model.Customer;

/**
 * @author christianp99
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	/**
	 * GET apellido
	 * **/
	public List<Customer> findByLastCLI(String lastCLI);
	
	public Customer findByidentyCLI(String identyCLI );
	
}
