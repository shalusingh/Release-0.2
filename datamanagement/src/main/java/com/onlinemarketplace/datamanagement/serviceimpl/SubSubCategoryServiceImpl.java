/**
 *
 */
package com.onlinemarketplace.datamanagement.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.SubSubCategoryRepository;
import com.onlinemarketplace.datamanagement.service.SubSubCategoryService;

/**
 * @author jitendra Dec 5, 2015 2015
 */
@Service
@Transactional
public class SubSubCategoryServiceImpl
    implements SubSubCategoryService {

    @Autowired
    private SubSubCategoryRepository repositry;

    @Autowired
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.datamanagement.service.BaseService#getRepository()
     */
    public SubSubCategoryRepository getRepository() {
        // TODO Auto-generated method stub
        return repositry;
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
