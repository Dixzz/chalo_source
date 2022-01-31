package server.zophop;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.logging.Level;

public class Constants {
    public static final String AGENCY = "agency";
    public static final String ANALYTICS_RABBIT_URL = "";
    public static final int CHECKOUT_DISTANCE = 500;
    public static final String CHECKOUT_TYPE = "checkOutType";
    public static final String CITY = "city";
    public static final String CITY_DATA = "cityData";
    public static final String CONTUCTOR_TICKET_ENDPOINT = "/ticketTransaction?isConductor=true";
    public static final int DEFAULT_BUS_STOP_TIME = 20;
    public static final int DEFAULT_HALT_TIME = 300;
    public static final String DEVELOPMENT_ANALYTICS = "test_analytics";
    public static final String DEVELOPMENT_APPLICATION = "test_appengine";
    public static final String DEVELOPMENT_EXCHANGE = "test_zophop";
    public static final String DEVELOPMENT_LOGGING = "test_logging";
    public static final String DEVELOPMENT_POSTGRES_MPASS_URL = "http://dev.zophop.com/mticketing/punchMPass";
    public static final String DEVELOPMENT_PunchPass_URL = "http://dev.zophop.com/mticketing/punchPass";
    public static String DISPATCH_ANDROID_REASON = "checked out by dispatcher app";
    public static final String DISPATCH_TYPE_FIX = "Fix";
    public static final String DISPATCH_TYPE_MANUAL = "Manual";
    public static String DISPATCH_WEB_REASON = "checked out by dispatcher dashboard";
    public static final String ELASTIC_SEARCH_BASIC_AUTH_PASSWORD = "Chalo@123";
    public static final String ELASTIC_SEARCH_BASIC_AUTH_USERNAME = "chalo";
    public static final String ELASTIC_SEARCH_FORWARD_URL = "http://13.232.94.4:9200/";
    public static final String END_STOP_STOP_NAME = "endStopName";
    public static final String ENVIRONMENT = "production";
    public static final String FIREBASE_DUMMY = "https://testzophop.firebaseio.com/";
    public static final String GPS_DEVICE_STREAMID = "streamId";
    public static final String GPS_DISPATCH = "vehicles";
    public static final String GPS_FEED_CITY = "city";
    public static final String GPS_FEED_MODE = "mode";
    public static final String HALTED = "HALTED";
    public static long HALTING_CHECKOUT_TIMESTAMP_THRESHOLD = 900000;
    public static final double HALTING_CONSICUTIVE_DISTANCE = 10.0d;
    public static final double HALTING_END_TO_END_DISTANCE = 100.0d;
    public static long HALTING_TIMESTAMP_THRESHOLD = DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL;
    public static final String IS_BUS_ON_ROUTE = "isBusOnRoute";
    public static final String LATITUDE = "latitude";
    public static final String LIVE_FIREBASE_ASSAM = "https://dazzling-fire-assam.firebaseio.com/";
    public static final String LIVE_FIREBASE_BANGALORE = "https://dazzling-fire-bangalore.firebaseio.com/";
    public static final String LIVE_FIREBASE_BELGAUM = "https://belgaum.firebaseio.com/";
    public static final String LIVE_FIREBASE_BHUBANESHWAR = "https://bhubaneshwar.firebaseio.com/";
    public static final String LIVE_FIREBASE_BIHAR = "https://dazzling-fire-bihar.firebaseio.com/";
    public static final String LIVE_FIREBASE_CHENNAI = "https://dazzling-fire-chennai.firebaseio.com/";
    public static final String LIVE_FIREBASE_DELHI = "https://dazzling-fire-delhi.firebaseio.com/";
    public static final String LIVE_FIREBASE_HUBLI = "https://dazzling-fire-hubli.firebaseio.com/";
    public static final String LIVE_FIREBASE_JAIPUR = "https://dazzling-fire-jaipur.firebaseio.com/";
    public static final String LIVE_FIREBASE_MANGALORE = "https://dazzling-fire-mangalore.firebaseio.com/";
    public static final String LIVE_FIREBASE_PRIMARY = "https://dazzling-fire-3689.firebaseio.com/";
    public static final String LIVE_FIREBASE_SHARD1 = "https://dazzling-fire-shard1.firebaseio.com/";
    public static final String LIVE_FIREBASE_SHARD2 = "https://dazzling-fire-shard2.firebaseio.com/";
    public static final String LIVE_FIREBASE_SHARD3 = "https://dazzling-fire-shard3.firebaseio.com/";
    public static final String LIVE_FIREBASE_TELANGANA = "https://dazzling-fire-telangana.firebaseio.com/";
    public static final String LIVE_FIREBASE_UDUPI = "https://dazzling-fire-udupi.firebaseio.com/";
    public static final String LIVE_FIREBASE_UP = "https://dazzling-fire-up.firebaseio.com/";
    public static final String LIVE_FIREBASE_VIJAYWADA = "https://dazzling-fire-vijaywada.firebaseio.com/";
    public static final Level LOGGER_HANDLE;
    public static final Level LOGGER_LEVEL;
    public static final String LOGGING_RABBIT_URL = "";
    public static final String LONGITUDE = "longitude";
    public static String MANUAL_CHECKOUT_REASON = "Manual Checkout";
    public static final long MIN_ETA_TO_DESTINATION = 10;
    public static final int MIN_HALT_TIME = 120;
    public static final String NOT_DISPATCHED = "Not dispatched today";
    public static final String NOT_FOUND = "Not found";
    public static final String NOT_RECEIVIN_GPS_DATA = "Not Receiving Gps Data";
    public static final String NOT_RUNNING = "Not Running";
    public static final String PREVIOUS_ROUTE_ID = "pRouteId";
    public static final String PREVIOUS_STREAM_ID = "pStreamId";
    public static final String PRODUCTION_ANALYTICS = "analytics";
    public static final String PRODUCTION_APPLICATION = "appengine";
    public static final String PRODUCTION_EXCHANGE = "zophop";
    public static final String PRODUCTION_LOGGING = "new_logging";
    public static final String PRODUCTION_POSTGRES_PUNCH_MPASS_URL = "";
    public static final String PRODUCTION_POSTGRES_PUNCH_PASS_URL = "http://production.zophop.com/mticketing/punchPass";
    public static final String PRODUCTION_RABBIT_URL = "";
    public static final String PUNCH_PASS_ENDPOINT = "/punchPass";
    public static final String PUNCH_TICKET_ENDPOINT = "/punchTicket";
    public static final String QUEUE = "queue";
    public static final String ROUTES = "Routes";
    public static final String ROUTE_NAME = "routeName";
    public static final double Radian = 57.2958d;
    public static final String SOURCE = "source";
    public static final String START_STOP_NAME = "startStopName";
    public static final String STATIC_FIREBASE_URL = "https://dazzling-fire-3689.firebaseio.com/";
    public static final String STATUS = "status";
    public static final String STATUS_DEVIATED = "Deviated";
    public static final String STATUS_GPS_TIMEOUT = "GPS timeout";
    public static final String STATUS_INCORRECT_CHECK_IN = "Incorrect Check-in";
    public static final String STATUS_OUT_OF_SERVICE_TIME = "Out Of Service Time";
    public static final String STOPS = "Stops";
    public static final long TASK_ERROR_TIMESTAMP_VALUE = -2;
    public static final long THRESHOLD_TIMESTAMP = 10000;
    public static final String TIMESTAMP = "timeStamp";
    public static final long UNUSED_TASK_TIMESTMP_VALUE = -1;
    public static final String VEHICLE_ID = "vehicleId";

    static {
        Level level = Level.ALL;
        LOGGER_LEVEL = level;
        LOGGER_HANDLE = level;
    }

    public static String getAnalyticsQueue() {
        return PRODUCTION_ANALYTICS;
    }

    public static String getApplicationQueue() {
        return PRODUCTION_APPLICATION;
    }

    public static String getExchange() {
        return PRODUCTION_EXCHANGE;
    }

    public static String getLoggingRabbitUrl() {
        return DEVELOPMENT_LOGGING;
    }

    public static String getPunchMpassEndpoint() {
        return "";
    }

    public static String getPunchPassEndpoint() {
        return PRODUCTION_POSTGRES_PUNCH_PASS_URL;
    }
}
