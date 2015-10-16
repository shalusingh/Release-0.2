package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.ProductPropertyName;


@Repository
@Transactional
public interface ProductPropertyNameRepository extends JpaRepository< ProductPropertyName,Long> {

}
