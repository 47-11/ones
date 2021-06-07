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
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for MasterdataHorseControllerApi
 */
@Ignore
public class MasterdataHorseControllerApiTest {

    private final MasterdataHorseControllerApi api = new MasterdataHorseControllerApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getHorseByUuidTest() throws ApiException {
        String uuid = null;
        MasterdataHorse response = 
        api.getHorseByUuid(uuid);
        
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
    public void postRegisterHorseTest() throws ApiException {
        RegisterHorse registerHorse = null;
        Object response = 
        api.postRegisterHorse(registerHorse);
        
        // TODO: test validations
    }
    
}
