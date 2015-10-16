package com.onlinemarketplace.datamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.CustomerSocialNetworks;


@Repository
@Transactional
public interface CustomerSocialNetworksRepository extends JpaRepository<CustomerSocialNetworks, Long> {
	
	@Query("SELECT sn FROM CustomerSocialNetworks sn WHERE sn.customerId = :id")
	public List<CustomerSocialNetworks> getByCustomerId(@Param("id") Long id);
	
	@Query("SELECT sn FROM CustomerSocialNetworks sn WHERE sn.customerId = :id AND sn.socialNetworkName= :socialNetworkName")
	public List<CustomerSocialNetworks> getByCustomerIdAndSocialNetworkName(@Param("id") Long id, @Param("socialNetworkName") String socialNetworkName);
	
	
	@Query("SELECT sn FROM CustomerSocialNetworks sn WHERE sn.socialNetworkName= :socialNetworkName")
	public List<CustomerSocialNetworks> getByCustomerSocialNetworkName( @Param("socialNetworkName") String socialNetworkName);
	

}
