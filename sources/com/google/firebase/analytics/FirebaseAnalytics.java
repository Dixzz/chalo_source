package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final oo3 zzb;
    private ExecutorService zzc;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public enum ConsentStatus {
        GRANTED,
        DENIED
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public enum ConsentType {
        AD_STORAGE,
        ANALYTICS_STORAGE
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public static class Event {
        public static final String ADD_PAYMENT_INFO = "add_payment_info";
        public static final String ADD_SHIPPING_INFO = "add_shipping_info";
        public static final String ADD_TO_CART = "add_to_cart";
        public static final String ADD_TO_WISHLIST = "add_to_wishlist";
        public static final String AD_IMPRESSION = "ad_impression";
        public static final String APP_OPEN = "app_open";
        public static final String BEGIN_CHECKOUT = "begin_checkout";
        public static final String CAMPAIGN_DETAILS = "campaign_details";
        @Deprecated
        public static final String CHECKOUT_PROGRESS = "checkout_progress";
        public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
        @Deprecated
        public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
        public static final String GENERATE_LEAD = "generate_lead";
        public static final String JOIN_GROUP = "join_group";
        public static final String LEVEL_END = "level_end";
        public static final String LEVEL_START = "level_start";
        public static final String LEVEL_UP = "level_up";
        public static final String LOGIN = "login";
        public static final String POST_SCORE = "post_score";
        @Deprecated
        public static final String PRESENT_OFFER = "present_offer";
        public static final String PURCHASE = "purchase";
        @Deprecated
        public static final String PURCHASE_REFUND = "purchase_refund";
        public static final String REFUND = "refund";
        public static final String REMOVE_FROM_CART = "remove_from_cart";
        public static final String SCREEN_VIEW = "screen_view";
        public static final String SEARCH = "search";
        public static final String SELECT_CONTENT = "select_content";
        public static final String SELECT_ITEM = "select_item";
        public static final String SELECT_PROMOTION = "select_promotion";
        @Deprecated
        public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
        public static final String SHARE = "share";
        public static final String SIGN_UP = "sign_up";
        public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
        public static final String TUTORIAL_BEGIN = "tutorial_begin";
        public static final String TUTORIAL_COMPLETE = "tutorial_complete";
        public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
        public static final String VIEW_CART = "view_cart";
        public static final String VIEW_ITEM = "view_item";
        public static final String VIEW_ITEM_LIST = "view_item_list";
        public static final String VIEW_PROMOTION = "view_promotion";
        public static final String VIEW_SEARCH_RESULTS = "view_search_results";
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public static class Param {
        public static final String ACHIEVEMENT_ID = "achievement_id";
        public static final String ACLID = "aclid";
        public static final String AD_FORMAT = "ad_format";
        public static final String AD_PLATFORM = "ad_platform";
        public static final String AD_SOURCE = "ad_source";
        public static final String AD_UNIT_NAME = "ad_unit_name";
        public static final String AFFILIATION = "affiliation";
        public static final String CAMPAIGN = "campaign";
        public static final String CHARACTER = "character";
        @Deprecated
        public static final String CHECKOUT_OPTION = "checkout_option";
        @Deprecated
        public static final String CHECKOUT_STEP = "checkout_step";
        public static final String CONTENT = "content";
        public static final String CONTENT_TYPE = "content_type";
        public static final String COUPON = "coupon";
        public static final String CP1 = "cp1";
        public static final String CREATIVE_NAME = "creative_name";
        public static final String CREATIVE_SLOT = "creative_slot";
        public static final String CURRENCY = "currency";
        public static final String DESTINATION = "destination";
        public static final String DISCOUNT = "discount";
        public static final String END_DATE = "end_date";
        public static final String EXTEND_SESSION = "extend_session";
        public static final String FLIGHT_NUMBER = "flight_number";
        public static final String GROUP_ID = "group_id";
        public static final String INDEX = "index";
        public static final String ITEMS = "items";
        public static final String ITEM_BRAND = "item_brand";
        public static final String ITEM_CATEGORY = "item_category";
        public static final String ITEM_CATEGORY2 = "item_category2";
        public static final String ITEM_CATEGORY3 = "item_category3";
        public static final String ITEM_CATEGORY4 = "item_category4";
        public static final String ITEM_CATEGORY5 = "item_category5";
        public static final String ITEM_ID = "item_id";
        @Deprecated
        public static final String ITEM_LIST = "item_list";
        public static final String ITEM_LIST_ID = "item_list_id";
        public static final String ITEM_LIST_NAME = "item_list_name";
        @Deprecated
        public static final String ITEM_LOCATION_ID = "item_location_id";
        public static final String ITEM_NAME = "item_name";
        public static final String ITEM_VARIANT = "item_variant";
        public static final String LEVEL = "level";
        public static final String LEVEL_NAME = "level_name";
        public static final String LOCATION = "location";
        public static final String LOCATION_ID = "location_id";
        public static final String MEDIUM = "medium";
        public static final String METHOD = "method";
        public static final String NUMBER_OF_NIGHTS = "number_of_nights";
        public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
        public static final String NUMBER_OF_ROOMS = "number_of_rooms";
        public static final String ORIGIN = "origin";
        public static final String PAYMENT_TYPE = "payment_type";
        public static final String PRICE = "price";
        public static final String PROMOTION_ID = "promotion_id";
        public static final String PROMOTION_NAME = "promotion_name";
        public static final String QUANTITY = "quantity";
        public static final String SCORE = "score";
        public static final String SCREEN_CLASS = "screen_class";
        public static final String SCREEN_NAME = "screen_name";
        public static final String SEARCH_TERM = "search_term";
        public static final String SHIPPING = "shipping";
        public static final String SHIPPING_TIER = "shipping_tier";
        @Deprecated
        public static final String SIGN_UP_METHOD = "sign_up_method";
        public static final String SOURCE = "source";
        public static final String START_DATE = "start_date";
        public static final String SUCCESS = "success";
        public static final String TAX = "tax";
        public static final String TERM = "term";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String TRAVEL_CLASS = "travel_class";
        public static final String VALUE = "value";
        public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public static class UserProperty {
        public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
        public static final String SIGN_UP_METHOD = "sign_up_method";
    }

    private FirebaseAnalytics(oo3 oo3) {
        Objects.requireNonNull(oo3, "null reference");
        this.zzb = oo3;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    zza = new FirebaseAnalytics(oo3.a(context, null, null, null, null));
                }
            }
        }
        return zza;
    }

    @Keep
    public static ce4 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        oo3 a2 = oo3.a(context, null, null, null, bundle);
        if (a2 == null) {
            return null;
        }
        return new zzd(a2);
    }

    private final ExecutorService zza() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            if (this.zzc == null) {
                this.zzc = new zzb(this, 0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzc;
        }
        return executorService;
    }

    public final yi4<String> getAppInstanceId() {
        try {
            return hd3.A(zza(), new zza(this));
        } catch (Exception e) {
            oo3 oo3 = this.zzb;
            Objects.requireNonNull(oo3);
            oo3.c.execute(new kp3(oo3, "Failed to schedule task for getAppInstanceId", null));
            return hd3.V0(e);
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) hd3.v(FirebaseInstallations.getInstance().getId(), 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zzb.e(null, str, bundle, false, true, null);
    }

    public final void resetAnalyticsData() {
        oo3 oo3 = this.zzb;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new xo3(oo3));
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        oo3 oo3 = this.zzb;
        Boolean valueOf = Boolean.valueOf(z);
        Objects.requireNonNull(oo3);
        oo3.c.execute(new wo3(oo3, valueOf));
    }

    public final void setConsent(Map<ConsentType, ConsentStatus> map) {
        Bundle bundle = new Bundle();
        ConsentStatus consentStatus = map.get(ConsentType.AD_STORAGE);
        if (consentStatus != null) {
            int i = zzc.zza[consentStatus.ordinal()];
            if (i == 1) {
                bundle.putString("ad_storage", "granted");
            } else if (i == 2) {
                bundle.putString("ad_storage", "denied");
            }
        }
        ConsentStatus consentStatus2 = map.get(ConsentType.ANALYTICS_STORAGE);
        if (consentStatus2 != null) {
            int i2 = zzc.zza[consentStatus2.ordinal()];
            if (i2 == 1) {
                bundle.putString("analytics_storage", "granted");
            } else if (i2 == 2) {
                bundle.putString("analytics_storage", "denied");
            }
        }
        oo3 oo3 = this.zzb;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new yo3(oo3, bundle));
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        oo3 oo3 = this.zzb;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new uo3(oo3, activity, str, str2));
    }

    public final void setDefaultEventParameters(Bundle bundle) {
        oo3 oo3 = this.zzb;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new pp3(oo3, bundle));
    }

    public final void setSessionTimeoutDuration(long j) {
        oo3 oo3 = this.zzb;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new ap3(oo3, j));
    }

    public final void setUserId(String str) {
        oo3 oo3 = this.zzb;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new vo3(oo3, str));
    }

    public final void setUserProperty(String str, String str2) {
        this.zzb.f(null, str, str2, false);
    }
}
