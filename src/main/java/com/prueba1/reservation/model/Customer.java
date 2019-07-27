package com.prueba1.reservation.model;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;
@Data
@Entity
@Table(name = "customer")
@EntityScan("Customer")
@NamedQuery(name = "Customer.findByidentyCLI", query = "Select c from Customer c where c.identyCLI = ?1")

public class Customer {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")  
	private String idCLI;
	private String nameCLI;
	private String lastCLI;
	private String identyCLI;
	private String addressCLI;
	private String phoneCLI;
	private String emailCLI;
	@OneToMany(mappedBy = "customer")
	private Set<Reservation> reservations;
	
	public Customer() {
		
	}
}
