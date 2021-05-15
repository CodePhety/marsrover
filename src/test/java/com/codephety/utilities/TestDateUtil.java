package com.codephety.utilities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestDateUtil {

    @Test
    public void testFormatDate(){
        DateUtil dateUtil = new DateUtil();
        String date1 = "02/27/17";
        String date2 = "April 31, 2018";
        String date3 = "Jul-13-2016";
        String date4 = "June 2, 2018";

        Assert.assertEquals("2017-02-27", dateUtil.formatDateToYYYYDDMM(date1));
        Assert.assertEquals("2018-05-01", dateUtil.formatDateToYYYYDDMM(date2));
        Assert.assertEquals("2016-07-13", dateUtil.formatDateToYYYYDDMM(date3));
        Assert.assertEquals("2018-06-02", dateUtil.formatDateToYYYYDDMM(date4));
    }


}
