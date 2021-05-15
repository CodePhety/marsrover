package com.codephety.utilities;

import com.codephety.objects.PlaneteryData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileManagementHelper {

    @Value("${input.filename}")
    private String inputFileName;

    @Value("${output.filename}")
    private String outputFileName;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private ObjectMapper objectMapper;

    private static Logger logger = LoggerFactory.getLogger(FileManagementHelper.class);


    public List<String> readInputFile() {
        List<String> listOfDatesFromFile = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(inputFileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        try {
            BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null; ) {
                listOfDatesFromFile.add(dateUtil.formatDateToYYYYDDMM(line));
            }
        } catch (IOException e) {
            logger.error("[File Read Error] {}", e.getMessage(), e);
        }
        return listOfDatesFromFile;
    }

    public void createTextFileWithGivenData(String data) {
        try {
            File outputFile = new File(outputFileName);
            outputFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            logger.error("[File Write Error] Data:{}  Exception Message: {}", data, e.getMessage(), e);
        }
    }


    public String convertObjectToJSONString(List<PlaneteryData> input) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            logger.error("[Data Mapper Error] Data:{}  Exception Message: {}", input, e.getMessage(), e);
        }
        return result;
    }

}
