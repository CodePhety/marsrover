package com.codephety.service;

import com.codephety.objects.PlaneteryData;
import com.codephety.utilities.FileManagementHelper;
import com.codephety.utilities.NasaRoverAPIHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class MarsRoverService {

    private static Logger logger = LoggerFactory.getLogger(MarsRoverService.class);

    @Autowired
    private FileManagementHelper fileManagementHelper;

    @Autowired
    private NasaRoverAPIHelper nasaRoverAPIHelper;


    public List<PlaneteryData> fetchMarsRoverDataWithDateFile() {
        List<PlaneteryData> planeteryData = new ArrayList<>();
        try {
            List<String> dates = fileManagementHelper.readInputFile();

            for (String dateElement : dates) {
                planeteryData.add(nasaRoverAPIHelper.fetchMarsRoverData(dateElement));
            }
            //TODO: Store data in H2 db
            fileManagementHelper.createTextFileWithGivenData(fileManagementHelper.convertObjectToJSONString(planeteryData));
        } catch (Exception e) {
            logger.error("Error processing data file", e);
        }
        return planeteryData;
    }


    public PlaneteryData fetchMarsRoverDateWithSingleDate(String date){
        return nasaRoverAPIHelper.fetchMarsRoverData(date);
    }


}
