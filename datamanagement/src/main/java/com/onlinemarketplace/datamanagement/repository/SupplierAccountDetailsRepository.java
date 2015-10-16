package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.SupplierAccountDetails;


@Repository
@Transactional
public interface SupplierAccountDetailsRepository extends JpaRepository<SupplierAccountDetails,Long> {

}
