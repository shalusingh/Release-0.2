/**
 *
 */
package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.SubSubCategory;

/**
 * @author jitendra Dec 5, 2015 2015
 */
@Repository
@Transactional
public interface SubSubCategoryRepository
    extends JpaRepository<SubSubCategory, Long> {

}
