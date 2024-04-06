package org.APIUtilities;

import io.restassured.filter.Filter;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.ArrayList;
import java.util.List;
public class ApiLoggingUtil {


        /**
         * Logging utilities used for api request
         * and response logging.
         * @author Sabitu Gautam
         */

        private static final String LOGGING_LEVEL = System.getProperty("LOG_LEVEL","LOW");

        public static List<Filter> getLoggingFilter() {

            List<Filter> restAssuredFilters = new ArrayList<>();

            if (LOGGING_LEVEL == null || "LOW".equals(LOGGING_LEVEL)) {
                restAssuredFilters.add(new ErrorLoggingFilter());
            } else {
                restAssuredFilters.add(new RequestLoggingFilter());
                restAssuredFilters.add(new ResponseLoggingFilter());

            }

            return restAssuredFilters;
        }

}
