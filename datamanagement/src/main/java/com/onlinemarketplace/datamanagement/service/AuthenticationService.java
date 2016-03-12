/**
 *
 */
package com.onlinemarketplace.datamanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.AuthenticationRepository;

/**
 * @author jitendra Dec 23, 2015 2015
 */
@Service
@Transactional
public interface AuthenticationService
    extends BaseService<AuthenticationRepository> {

}
