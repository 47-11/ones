/*
 * vdd4ones
 * Rest-Interface for ONES
 *
 * The version of the OpenAPI document: 1.0a
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.fourtyseveneleven.ones.ecm.generated.api;

import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterResponce;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for ApplicationAccountControllerApi
 */
@Ignore
public class ApplicationAccountControllerApiTest {

    private final ApplicationAccountControllerApi api = new ApplicationAccountControllerApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postRegisterAccountTest() throws ApiException {
        RegisterAccount registerAccount = null;
        RegisterResponce response = 
        api.postRegisterAccount(registerAccount);
        
        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void putRegisterAccountUnlockTest() throws ApiException {
        String uuid = null;
        String code = null;
        RegisterResponce response = 
        api.putRegisterAccountUnlock(uuid, code);
        
        // TODO: test validations
    }
    
}