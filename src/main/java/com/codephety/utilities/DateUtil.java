package com.codephety.utilities;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;

@Component
public class DateUtil {

    @Value("${accepted.date.formats}")
    private List<String> acceptedDateFormats;

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public String formatDateToYYYYDDMM(String input) {
        String result = "";

        //TODO: EXTERNALIZE LIST OF ACCEPTED FORMATS
        //List<String> dateFormats = acceptedDateFormats;
        List<String> dateFormats = Arrays.asList("MM/dd/yy", "MMMM dd, yyyy", "MMM-dd-yyyy", "yyyy-MM-dd");

        for (String format : dateFormats) {
            try {
                result = new SimpleDateFormat(format).parse(input).toString();
            } catch (ParseException e) {
                logger.debug("[Date Parse Failure] Input Date {} Format: ", input, format);
            }
        }
        return LocalDate.parse(result, new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .parseLenient()
                .appendPattern("EEE MMM d HH:mm:ss zzz yyyy")
                .toFormatter()).toString();
    }

}
