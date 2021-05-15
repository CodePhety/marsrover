package com.codephety.utilities;

import com.codephety.constants.AppConstants;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class NasaRoverAPIHelperTest {

    @Mock
    private NasaRoverAPIHelper nasaRoverAPIHelper;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private AppConstants appConstants;

    @Mock
    private DateUtil dateUtil;


    @Test
    public void testBuildPlanetaryURL(){
       //String result = nasaRoverAPIHelper.buildPlanetaryURL("test");
      //Assert.assertEquals("", result);
    }

    @Test
    public void testFetchMarsRoverData(){
    }



}
