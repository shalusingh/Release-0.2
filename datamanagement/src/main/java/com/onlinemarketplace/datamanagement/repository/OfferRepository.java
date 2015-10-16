package com.onlinemarketplace.datamanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Offer;
import com.onlinemarketplace.dataentity.enums.OfferType;



@Repository
@Transactional
public interface OfferRepository extends JpaRepository< Offer,Long> {
	
	@Query("SELECT o FROM Offer o WHERE o.validTo = :validTo")
	public List<Offer> getByvalidTo(@Param("validTo") Date validTo);

	@Query("SELECT o FROM Offer o WHERE o.offerType = :offerType")
	public List<Offer> getByType(@Param("offerType") OfferType offerType);

}
