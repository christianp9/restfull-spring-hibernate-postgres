/**
 * 
 */
package com.prueba1.reservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

/**
 * @author MARTIN2
 *
 */
@Data
@Entity
@EntityScan("Reservation")
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")  
	private String idRES;
	@Temporal(TemporalType.DATE)
	private Date dateinit;
	@Temporal(TemporalType.DATE)
	private Date datefinsh;
	private int quantityPER;
	private String descriptionRES;
	@ManyToOne
	@JoinColumn(name = "idCLI")
	private Customer customer;
}
