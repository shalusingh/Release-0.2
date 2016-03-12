/**
 *
 */
package com.onlinemarketplace.datamanagement.serviceimpl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Authentication;
import com.onlinemarketplace.dataentity.enums.Right;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.AuthenticationService;

/**
 * @author jitendra Dec 23, 2015 2015
 */
@ContextConfiguration(classes = {
    DataManagementApplicationContext.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthenticationServiceImplTest {

    @Autowired
    private AuthenticationService authenticationService;

    public void putAuthentication() throws Exception {
        Authentication authentication = new Authentication();
        authentication.setAppId(123456789L);
        authentication.setAuthCode(new String("123456789"));
        authentication.setRight(Right.READ);
        authenticationService.getRepository().save(authentication);
    }

    @Test
    public void getRecord() {
        Authentication authentication = authenticationService.getRepository().get("123456789", 123456789l);
        Assert.assertNotNull(authentication);
    }

    @Test
    public void getRecordByAuthCode() {
        Authentication authentication = authenticationService.getRepository().get("123456789");
        Assert.assertNotNull(authentication);
    }

}
