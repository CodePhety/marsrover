package com.codephety.utilities;

import com.codephety.constants.AppConstants;
import com.codephety.objects.PlaneteryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class NasaRoverAPIHelper {

    private static Logger logger = LoggerFactory.getLogger(NasaRoverAPIHelper.class);

    @Value("${nasa.api.key}")
    private String API_KEY;

    @Value("${nasa.base.url}")
    private String BASE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppConstants appConstants;

    @Autowired
    private DateUtil dateUtil;

    public PlaneteryData fetchMarsRoverData(String date) {
        logger.debug("Calling NASA API....");
        return WebClient.builder()
                .baseUrl(buildPlanetaryURL(date))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build().get().retrieve().bodyToMono(PlaneteryData.class).block();
    }

    public ResponseEntity<PlaneteryData> fetchMarsRoverDataWithRestTemplate(String date) {
        logger.debug("Calling NASA API with rest template....");
        return restTemplate.getForEntity(buildPlanetaryURL(date), PlaneteryData.class);
    }

    public String buildPlanetaryURL(String date) {
        return new StringBuilder(BASE_URL)
                .append("?")
                .append(appConstants.API_PARAM_VALUE)
                .append(API_KEY)
                .append("&")
                .append(appConstants.DATE_PARAM_VALUE)
                .append(dateUtil.formatDateToYYYYDDMM(date)).toString();
    }


}
