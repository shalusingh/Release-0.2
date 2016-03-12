/**
 *
 */
package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Authentication;

/**
 * @author jitendra Dec 23, 2015 2015
 */
@Repository
@Transactional
public interface AuthenticationRepository
    extends JpaRepository<Authentication, Long> {

    @Query("SELECT a FROM Authentication a WHERE a.authCode = :authCode AND a.appId = :appId")
    public Authentication get(@Param("authCode") String authCode, @Param("appId") Long appId);

    @Query("SELECT a FROM Authentication a WHERE a.authCode = :authCode")
    public Authentication get(@Param("authCode") String authCode);

}
