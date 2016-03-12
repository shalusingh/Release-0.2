/**
 *
 */
package com.onlinemarketplace.datamanagement.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.AuthenticationRepository;
import com.onlinemarketplace.datamanagement.service.AuthenticationService;

/**
 * @author jitendra Dec 23, 2015 2015
 */
@Service
@Transactional
public class AuthenticationServiceImpl
    implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.datamanagement.service.BaseService#getRepository()
     */
    public AuthenticationRepository getRepository() {
        return authenticationRepository;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.datamanagement.service.BaseService#getEntityManager()
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
