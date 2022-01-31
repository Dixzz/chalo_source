package com.razorpay;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class AnalyticsConstants {
    public static final String ABORT = "abort";
    public static final String ACTIVITY_DESTROYED = "activity_destroyed";
    public static final String ADVERTISING_ID = "advertising_id";
    public static final String ALREADY_ASKED = "already:asked";
    public static final String ALREADY_GRANTED = "already:granted";
    public static final String ALREADY_GRANTED_BY_MERCHANT = "already:granted:merchant";
    public static final String ALREADY_NOT_ASKED = "already:not:asked";
    public static final String ALREADY_NOT_GRANTED = "already:not:granted";
    public static final String AMAZONPAY_CH_SOURCE = "ch:amz_pay:and";
    public static final String AMAZONPAY_CU_SOURCE = "cu:amz_pay:and";
    public static final String AMAZONPAY_PASSED = "amazon_pay:passed";
    public static final String AMAZONPAY_SOURCE = "amz_pay:and";
    public static final String AMOUNT = "amount";
    public static final String ANDROID = "Android";
    public static final String ANDROID_ID = "android_id";
    public static final String APP_TOKEN = "app_token";
    public static final String ATTACHED = "attached";
    public static final String BACK = "back";
    public static final String BACK_ALERT = "back:alert";
    public static final String BANK = "bank";
    public static final String BLUETOOTH = "bluetooth";
    public static final String CACHE_HIT = "cache:hit";
    public static final String CACHE_MISS = "cache:miss";
    public static final String CALL = "call";
    public static final String CALLBACK_RECEIVED = "callback:received";
    public static final String CALLED = "called";
    public static final String CALLING = "calling";
    public static final String CALLING_INTERNAL_ERROR = "calling:internal_error";
    public static final String CALLING_INTERNAL_SUCCESS = "calling:internal_success";
    public static final String CALLIN_PROCESS_PAYMENT = "calling:process_payment";
    public static final String CALL_FAIL = "call:fail";
    public static final String CALL_SUCCESS = "call:success";
    public static final String CARD = "card";
    public static final String CARDSAVING = "cardsaving";
    public static final String CARD_NUMBER = "card_number";
    public static final String CARRIER = "carrier";
    public static final String CARRIER_ID = "carrier_id";
    public static final String CARRIER_NETWORK = "carrier_network";
    public static final String CB_SIGN_ENCRYPT_RESPONSE = "cb:sign_encrypt_response";
    public static final String CB_VERIFY_SIGNATURE = "cb:sign_encrypt_response";
    public static final String CELLULAR = "cellular";
    public static final String CELLULAR_NETWORK_TYPE = "cellular_network_type";
    public static final String CHANGED = "changed";
    public static final String CHECKOUT = "checkout";
    public static final String CHECKOUT_ACTIVITY = "checkout:activity";
    public static final String CHECKOUT_ACTIVITY_INIT = "checkout:activity:init";
    public static final String CHECKOUT_LOAD_DURATION = "checkout_load_duration";
    public static final String CHECKOUT_LOGIN = "Checkout Login";
    public static final String CHECKOUT_PAGE_FINISH = "ch:page:finish";
    public static final String CHECKOUT_PAGE_START = "ch:page:start";
    public static final String CHECKOUT_SOURCE = "ch:and";
    public static final String CHK_REGISTER = "check_register";
    public static final String CHOICE_OTP = "choice:otp";
    public static final String CHOICE_PASSWORD = "choice:password";
    public static final String CLICKED = "clicked";
    public static final String COMPLETE = "complete";
    public static final String CONSENT_SHOWED = "otp:autoread:consent:showed";
    public static final String CONTACT = "contact";
    public static final String CONTEXT = "context";
    public static final String CRITICAL = "critical";
    public static final String CUSTOM_APP_CHOOSER = "upi:custom_app_chooser";
    public static final String CUSTOM_UI_SOURCE = "cu:and";
    public static final String DELIMITER_MAIN = "_";
    public static final String DENSITY = "density";
    public static final String DEPRECATED = "deprecated";
    public static final String DESTROY = "destroy";
    public static final String DEVICE = "device";
    public static final String DEVICE_ID = "device_Id";
    public static final String DEVICE_MANUFACTURER = "device_manufacturer";
    public static final String DEVICE_MODEL = "device_model";
    public static final String DEVICE_RESOLUTION = "device_resolution";
    public static final String DEVICE_SIZE = "device_size";
    public static final String DEVICE_TOKEN_SOURCE_SINGLE = "device_token_source_single";
    public static final String EMAIL = "email";
    public static final String END = "end";
    public static final String ERROR = "error";
    public static final String ERROR_DESCRIPTION = "error_description";
    public static final String ERROR_EXCEPTION = "error:exception";
    public static final String EVENTS = "events";
    public static final String EXCEPTION = "exception_received";
    public static final String EXTRACT = "extract";
    public static final String FAIL = "fail";
    public static final String FAILURE = "failure";
    public static final String FLOW = "flow";
    public static final String GOOGLEPAY_CALLBACK = "googlepay:callback";
    public static final String GOOGLEPAY_CH_SOURCE = "ch:google_pay:and";
    public static final String GOOGLEPAY_CU_SOURCE = "cu:google_pay:and";
    public static final String GOOGLEPAY_SOURCE = "google_pay:and";
    public static final String HARD = "hard";
    public static final String HEIGHT = "height";
    public static final String ID = "id";
    public static final String INIT = "init";
    public static final String INTENT = "intent";
    public static final String INTERNAL_CALLBACK = "internal:callback";
    public static final String IP_ADDRESS = "ip_address";
    public static final String IS_ROMING = "is_roming";
    public static final String JS_CONSOLE = "js:console";
    public static final String KEY = "key";
    public static final String LAUNCHED = "launched";
    public static final String LOADED = "loaded";
    public static final String LOCALE = "locale";
    public static final String LOG = "log";
    public static final String MAGIC = "magic";
    public static final String MAGIC_SOURCE = "magic:and";
    public static final String MANUFACTURER = "manufacturer";
    public static final String MERCHANT_BACKEND_ERROR = "merchant_backend:error";
    public static final String MERCHANT_CB_EXTERNAL = "merch:cb:external";
    public static final String MERCHANT_CB_HANDOVER = "merch:cb:handover";
    public static final String MERCHANT_CB_ONERROR = "merch:cb:onerror";
    public static final String MERCHANT_CB_ONSUCCESS = "merch:cb:onsuccess";
    public static final String MERCHANT_KEY = "merchant_key";
    public static final String MERCHANT_OPTIONS = "merchant options";
    public static final String MERCHANT_PACKAGE = "merchant_package";
    public static final String MERCHANT_PASSED_APP = "upi:merchant_passed_app";
    public static final String METHOD = "method";
    public static final String MOBILE_SDK_ERROR = "mobile_sdk:error";
    public static final String MODE = "mode";
    public static final String MODEL = "model";
    public static final String MULTIPLE_TOKENS = "multiple:tokens";
    public static final String NAME = "name";
    public static final String NETBANKING = "netbanking";
    public static final String NETWORK = "network";
    public static final String NETWORK_2G = "2G";
    public static final String NETWORK_3G = "3G";
    public static final String NETWORK_4G = "4G";
    public static final String NETWORK_TYPE = "network_type";
    public static final String NETWORK_UNAVAILABLE = "network:unavailable";
    public static final String NOT_AVAILABLE = "NA";
    public static final String NOW_DENIED = "now:denied";
    public static final String NOW_GRANTED = "now:granted";
    public static final String NULL = "null";
    public static final String ON_CANCEL = "on:cancel";
    public static final String ON_ERROR = "on:error";
    public static final String ORDER_ID = "order_id";
    public static final String OTP = "otp";
    public static final String OTP_MANUAL_USE = "otp:manual:use";
    public static final String OTP_MANUAL_VIEW = "otp:manual:view";
    public static final String OTP_RECEIVE = "otp:receive";
    public static final String OTP_RESEND = "otp:resend";
    public static final String OTP_USE = "otp:use";
    public static final String PAGE_FINISH = "page:finish";
    public static final String PAGE_LOAD_TIME = "page_load_time";
    public static final String PAGE_START = "page:start";
    public static final String PAGE_TYPE = "pagetype";
    public static final String PASSED = "passed";
    public static final String PAYMENT = "payment";
    public static final String PAYMENT_CANCELLED = "pymnt:cancelled";
    public static final String PAYMENT_CONTINUE = "pymnt:continue";
    public static final String PAYMENT_ID = "payment:id";
    public static final String PAYMENT_METHOD = "payment_method";
    public static final String PAYMENT_VALIDATION_FAILURE = "payment_validation:failure";
    public static final String PERMISSION_SMS = "perm:sms";
    public static final String PHONE = "phone";
    public static final String POPULATION = "otp:autoread:population:js";
    public static final String PREFERENCES = "preferences";
    public static final String PRELOAD = "preload";
    public static final String PRELOAD_ABORT_DURATION = "preload_abort_duration";
    public static final String PRELOAD_COMPLETE_DURATION = "preload_finish_duration";
    public static final String PRIMARY_TO_SECONDARY = "primary:secondary";
    public static final String PROCCESS_PAYMENT = "process:payment";
    public static final String PROCCESS_PAYMENT_PAYLAOD = "process:payment_payload";
    public static final String PROCESS_PAYMENT_EXCEPTION = "exception:process_payment";
    public static final String PROPERTIES = "properties";
    public static final String PWAIN_CALLBACK = "pwain:callback";
    public static final String RAZORPAY_AMAZON = "razorpay_amazon";
    public static final String RAZORPAY_OTP = "razorpay_otp";
    public static final String RENDER = "render";
    public static final String RESET = "reset";
    public static final String RESULT_TO_RECEIVED = "result:received";
    public static final String RZPASSIST = "rzpassist";
    public static final String RZPASSIST_SOURCE = "assist:and";
    public static final String SAFETY_NET_BASIC_INTEGRITY = "safety_net basic_integrity";
    public static final String SAFETY_NET_CTS_PROFILE_MATCH = "safety_net_cts_profile_match";
    public static final String SAVED_CARD = "saved card";
    public static final String SCREEN = "screen";
    public static final String SDK = "sdk";
    public static final String SDK_COUNT = "sdk_count";
    public static final String SDK_COUNT_WITH_TOKEN = "sdk_count_with_token";
    public static final String SECONDARY_TO_PRIMARY = "secondary:primary";
    public static final String SELECTED = "selected";
    public static final String SENDER = "sender";
    public static final String SERIAL_NUMBER = "serial_number";
    public static final String SHOULD_SHOW_UPI_INTENT = "upi_intent:should_show";
    public static final String SHOW = "show";
    public static final String SHOWN = "shown";
    public static final String SHOW_WEBVIEW = "show:webview";
    public static final String SMS_RECIEVED = "otp:autoread:sms:recieved";
    public static final String SOFT = "soft";
    public static final String SSL_ERROR = "ssl:error";
    public static final String START = "start";
    public static final String SUBMIT = "submit";
    public static final String SUCCESS = "success";
    public static final String SYMANTEC_ISSUE_HANDLED = "symantec_issue_handled";
    public static final String TASK = "otp:autoread:task:started";
    public static final String TIMEOUT = "otp:autoread:timeout";
    public static final String TIMER = "timer";
    public static final String TIMEZONE = "timezone";
    public static final String TIME_SHAVED_OFF = "time_shaved_off";
    public static final String TLS = "tls";
    public static final String TOKEN = "token";
    public static final String TYPE = "type";
    public static final String UNCAUGHT = "uncaught";
    public static final String UNIDENTIFIED = "unindentified";
    public static final String UPI = "upi";
    public static final String UPI_APPS = "upi:apps";
    public static final String UPI_APPS_CALLBACK = "upi:apps_callback";
    public static final String UPI_APPS_PREFERENCE = "upi_apps:preference";
    public static final String UPI_APP_FROM_CUSTOM_CHOOSER = "upi:app_custom_chooser";
    public static final String UPI_APP_NAME = "upi_app:name";
    public static final String UPI_APP_PACKAGE_NAME = "upi_app_package_name";
    public static final String UPI_IS_REGISTERED = "upi:is_registered";
    public static final String UPI_OTHER_APPS_ORDER = "upi_apps:other_order";
    public static final String UPI_PREFERRED_APPS_ORDER = "upi_apps:preferred_order";
    public static final String URL = "url";
    public static final String USER_AGENT = "user_agent";
    public static final String VALIDATE_VPA = "validate:vpa";
    public static final String VERSION = "version";
    public static final String WALLET = "wallet";
    public static final String WARNING = "warning";
    public static final String WEBVIEW = "webview";
    public static final String WEBVIEW_USER_AGENT = "webview_user_agent";
    public static final String WIDTH = "width";
    public static final String WIFI = "wifi";
    public static final String WIFI_SSID = "wifi_ssid";
}
