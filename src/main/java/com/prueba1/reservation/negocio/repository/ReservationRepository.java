package com.prueba1.reservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba1.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
	@Query("Select r from Reservation r where r.dateinit =:dateinit and r.datefinsh =:datefinsh")
	public List<Reservation> finf(@Param("dateinit") Date datefinsh,@Param("datefinsh") Date dateinit);
}