package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import app.zophop.R;
import app.zophop.models.EtaUpdateInfo;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.MagicPassPunchInfo;
import app.zophop.models.mTicketing.ProductActiveStatus;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductDuration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.room.ProductRepository;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.MPassPurchaseActivity;
import app.zophop.ui.adapters.ProductInfo;
import app.zophop.ui.views.MagicPassInfoView;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import com.razorpay.BaseConstants;
import defpackage.ft0;
import defpackage.ii1;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyTypefaceSpan;
import io.github.inflationx.calligraphy3.TypefaceUtils;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.logging.LoggingConstants;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;
import zophop.models.StationType;

/* renamed from: vn  reason: default package */
/* compiled from: ViewGroupUtilsApi14 */
public class vn {
    public static re1 A(String str) throws JSONException {
        re1 re1;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("notification_id");
        String optString = jSONObject.optString(ProductPromotionsObject.KEY_TITLE);
        String optString2 = jSONObject.optString("message");
        String optString3 = jSONObject.optString("image_url");
        long j = jSONObject.getLong("timestamp");
        boolean optBoolean = jSONObject.optBoolean("alert_seen", false);
        boolean optBoolean2 = jSONObject.optBoolean("is_silent", false);
        long optLong = jSONObject.optLong("expiry_time", 2604658865908L);
        JSONArray optJSONArray = jSONObject.optJSONArray("city_list");
        String optString4 = jSONObject.optString("notification_type", "ALERT");
        String optString5 = jSONObject.optString("deeplink_product_config_id", null);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
        }
        if (jSONObject.has("meta")) {
            re1 = new re1(string, j, optString3, optString2, optString, optBoolean, B(jSONObject.getString("meta")));
        } else {
            re1 = new re1(string, j, optString3, optString2, optString, optBoolean, null);
        }
        re1.n = optBoolean2;
        re1.m = arrayList;
        re1.o = optString4;
        re1.p = optString5;
        re1.q = optLong;
        return re1;
    }

    public static HashMap<String, ProductInfo> A0(List<String> list, ProductConfigurationMap productConfigurationMap) {
        ProductInfo productInfo;
        ArrayList arrayList;
        ArrayList arrayList2;
        HashMap<String, ProductInfo> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        if (productConfigurationMap != null) {
            for (int i = 0; i < list.size(); i++) {
                List<ProductConfiguration> productConfiguration = productConfigurationMap.getProductConfiguration(list.get(i).toLowerCase());
                if (productConfiguration != null) {
                    for (int i2 = 0; i2 < productConfiguration.size(); i2++) {
                        ProductConfiguration productConfiguration2 = productConfiguration.get(i2);
                        String productType = productConfiguration2.getProductType();
                        if ((productType != null && (productType.equals(SuperPassConstants.PRODUCT_TYPE_SUPER_PASS) || productType.equals("pass") || productType.equals("magicPass") || productType.equals("routePass") || productType.equals("rpPass") || productType.equals("singleJourneyTicket") || productType.equals("sjPass") || productType.equals("scanPay") || productType.equals("superSaver"))) && productConfiguration2.isProductConfigSupportedOnCurrentAppVersion()) {
                            ProductInfo productInfo2 = new ProductInfo(productConfiguration2.getProductId(), productConfiguration2.getProductName(), productConfiguration2.getProductDesc(), productConfiguration2.getProductLogo(), productConfiguration2.getProductPriority(), productConfiguration2.getProductGroup());
                            productInfo2.l = productConfiguration2.getProductLabel();
                            productInfo2.j = productConfiguration2.getProductAdditionalInfo();
                            productInfo2.n = productConfiguration2.getProductType();
                            productInfo2.o = productConfiguration2.getProductSubType();
                            productInfo2.r = productConfiguration2.getIsActive();
                            productInfo2.s = productConfiguration2.getInactiveReason();
                            productInfo2.t = productConfiguration2.getIsVisible();
                            boolean equalsIgnoreCase = productConfiguration2.getProductType().equalsIgnoreCase("magicPass");
                            if (equalsIgnoreCase) {
                                productInfo = hashMap.get(productConfiguration2.getProductSubType());
                            } else {
                                productInfo = hashMap.get(productConfiguration2.getProductId());
                            }
                            if (productInfo == null || productInfo2.m >= productInfo.m) {
                                if (productInfo == null || productInfo2.m < productInfo.m) {
                                    if (!P0(productConfiguration2)) {
                                        productInfo2.r = false;
                                        if (equalsIgnoreCase) {
                                            hashMap2.put(productConfiguration2.getProductSubType(), productInfo2);
                                        } else {
                                            hashMap2.put(productConfiguration2.getProductId(), productInfo2);
                                        }
                                    } else if (equalsIgnoreCase) {
                                        hashMap.put(productConfiguration2.getProductSubType(), productInfo2);
                                    } else {
                                        hashMap.put(productConfiguration2.getProductId(), productInfo2);
                                    }
                                } else if (P0(productConfiguration2)) {
                                    List<String> list2 = productInfo.p;
                                    if (list2 == null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        arrayList3.add(productInfo.i);
                                        arrayList3.add(productInfo2.i);
                                        arrayList = arrayList3;
                                    } else {
                                        list2.add(productInfo2.i);
                                        arrayList = list2;
                                    }
                                    productInfo.p = arrayList;
                                    if (equalsIgnoreCase) {
                                        hashMap.put(productConfiguration2.getProductSubType(), productInfo);
                                    } else {
                                        hashMap.put(productConfiguration2.getProductId(), productInfo);
                                    }
                                }
                            } else if (P0(productConfiguration2)) {
                                List<String> list3 = productInfo.p;
                                if (list3 == null) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(productInfo.i);
                                    arrayList2 = arrayList4;
                                } else {
                                    list3.add(productInfo.i);
                                    arrayList2 = list3;
                                }
                                productInfo2.p = arrayList2;
                                if (equalsIgnoreCase) {
                                    hashMap.put(productConfiguration2.getProductSubType(), productInfo2);
                                } else {
                                    hashMap.put(productConfiguration2.getProductId(), productInfo2);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            String str = (String) entry.getKey();
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, (ProductInfo) entry.getValue());
            }
        }
        return hashMap;
    }

    public static se1 B(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        double optDouble = jSONObject.optDouble("radius", 5.0d);
        if (!jSONObject.has("lat") || !jSONObject.has("lon")) {
            return new se1(null, optDouble);
        }
        return new se1(new LatLng(jSONObject.getDouble("lat"), jSONObject.getDouble("lon")), optDouble);
    }

    public static int B0(RideDetails rideDetails, List<MagicPassPunchInfo> list) {
        TreeMap treeMap = new TreeMap();
        long Q = ui1.Q();
        if (!(rideDetails == null || rideDetails.get_rideInfoList() == null)) {
            for (int i = 0; i < rideDetails.get_rideInfoList().size(); i++) {
                if (Q - xt.f3961a.t().c("syncingTime") < rideDetails.get_rideInfoList().get(i).getActivationTimeStamp()) {
                    treeMap.put(Long.valueOf(rideDetails.get_rideInfoList().get(i).getActivationTimeStamp()), "a");
                }
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (Q - xt.f3961a.t().c("syncingTime") < list.get(i2).getPunchingTime()) {
                treeMap.put(Long.valueOf(list.get(i2).getPunchingTime()), "b");
            }
        }
        String str = "";
        int i3 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            i3++;
            if (str.equals("a") && ((String) entry.getValue()).equals("b")) {
                i3--;
            }
            str = (String) entry.getValue();
            String str2 = entry.getKey() + ProductDiscountsObject.KEY_DELIMITER + ((String) entry.getValue());
        }
        long Q2 = ui1.Q();
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (list.get(i5).getPunchingTime() < Q2 - xt.f3961a.t().c("syncingTime")) {
                i4++;
            }
        }
        return i4 + i3;
    }

    public static List<re1> C(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            arrayList.add(A(jSONObject.getString(keys.next())));
        }
        return arrayList;
    }

    public static Bitmap C0(View view) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, measuredWidth, measuredHeight);
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static fv0 D(String str, String str2, boolean z, boolean z2, int i, ft0.b bVar) {
        ft0 ft0 = new ft0(i, bVar);
        Bundle c = hj1.c("loader_title", null, "loader_message", str2);
        c.putBoolean("loader_title_visibility", z2);
        ft0.setCancelable(z);
        ft0.setArguments(c);
        return ft0;
    }

    public static int D0() {
        int i = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta")).get(7);
        if (i == 1) {
            return 6;
        }
        if (i == 3) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 5) {
            return 3;
        }
        if (i != 6) {
            return i != 7 ? 0 : 5;
        }
        return 4;
    }

    public static String E(Context context, String str) {
        ProductConfiguration m0 = m0(str);
        if (m0 == null || TextUtils.isEmpty(m0.getProductName())) {
            return context.getString(R.string.tag_text_ticket_type);
        }
        return m0.getProductName();
    }

    public static void E0(View view, Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static Bitmap F(Context context, float f, int i, boolean z) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bus_icon_layout, (ViewGroup) null, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bus_direction_icon);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.bus_icon);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.info_layout);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.info_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.updated_time);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (((int) Math.floor((double) i)) >= ui1.x(xt.f3961a.k().d().getName())) {
            layoutParams.setMargins(0, (int) ui1.n(30.0f, context), 0, 0);
            imageView2.setImageResource(R.drawable.live_bus2_delay);
            imageView.setImageResource(R.drawable.live_bus2_direction_delay);
            textView.setVisibility(0);
            imageView3.setVisibility(0);
            linearLayout.setVisibility(0);
            textView.setText("Updated\n" + i + " min ago");
        } else if (z) {
            layoutParams.setMargins(0, (int) ui1.n(30.0f, context), 0, 0);
            imageView2.setImageResource(R.drawable.live_bus2);
            imageView.setImageResource(R.drawable.live_bus2_direction);
            textView.setVisibility(0);
            imageView3.setVisibility(0);
            linearLayout.setVisibility(0);
            textView.setText(context.getResources().getString(R.string.halted));
        } else {
            layoutParams.setMargins(0, (int) ui1.n(0.0f, context), 0, 0);
            imageView2.setImageResource(R.drawable.live_bus2);
            imageView.setImageResource(R.drawable.live_bus2_direction);
            textView.setVisibility(8);
            imageView3.setVisibility(8);
            linearLayout.setVisibility(8);
        }
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams);
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ((ImageView) inflate.findViewById(R.id.bus_direction_icon)).setImageDrawable(new q61(context.getResources(), bitmap, f, bitmap));
        return C0(inflate);
    }

    public static jp F0(int i) {
        if (i == 0) {
            return jp.EXPONENTIAL;
        }
        if (i == 1) {
            return jp.LINEAR;
        }
        throw new IllegalArgumentException(hj1.J("Could not convert ", i, " to BackoffPolicy"));
    }

    public static LatLng G(e44 e44) {
        try {
            VisibleRegion c1 = e44.e().f1339a.c1();
            try {
                return e44.e().f1339a.M2(new kc2(new Point(e44.e().a(c1.farRight).x / 2, e44.e().a(c1.nearLeft).y / 2)));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static up G0(int i) {
        if (i == 0) {
            return up.NOT_REQUIRED;
        }
        if (i == 1) {
            return up.CONNECTED;
        }
        if (i == 2) {
            return up.UNMETERED;
        }
        if (i == 3) {
            return up.NOT_ROAMING;
        }
        if (i == 4) {
            return up.METERED;
        }
        throw new IllegalArgumentException(hj1.J("Could not convert ", i, " to NetworkType"));
    }

    public static ArrayList<String> H(Itinerary itinerary) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Leg> it = itinerary.legs.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().last_stop_id);
        }
        return arrayList;
    }

    public static zp H0(int i) {
        if (i == 0) {
            return zp.ENQUEUED;
        }
        if (i == 1) {
            return zp.RUNNING;
        }
        if (i == 2) {
            return zp.SUCCEEDED;
        }
        if (i == 3) {
            return zp.FAILED;
        }
        if (i == 4) {
            return zp.BLOCKED;
        }
        if (i == 5) {
            return zp.CANCELLED;
        }
        throw new IllegalArgumentException(hj1.J("Could not convert ", i, " to State"));
    }

    public static String I() {
        int i = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta")).get(7);
        if (i == 1) {
            return "sunday";
        }
        if (i == 3) {
            return "tuesday";
        }
        if (i == 4) {
            return "wednesday";
        }
        if (i == 5) {
            return "thursday";
        }
        if (i != 6) {
            return i != 7 ? "monday" : "saturday";
        }
        return "friday";
    }

    public static boolean I0(String str) {
        return str.equalsIgnoreCase("CSTC") || str.equalsIgnoreCase("CTC") || str.equalsIgnoreCase("WBSTC");
    }

    public static int J(RideDetails rideDetails) {
        if (rideDetails == null || rideDetails.get_rideInfoList() == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < rideDetails.get_rideInfoList().size(); i2++) {
            if (DateUtils.isToday(rideDetails.get_rideInfoList().get(i2).getActivationTimeStamp())) {
                i++;
            }
        }
        return i;
    }

    public static boolean J0(Context context) {
        return ((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled(LoggingConstants.GPS);
    }

    public static String K(int i, int i2, int i3, String str) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        return new SimpleDateFormat(str).format(instance.getTime());
    }

    public static boolean K0(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static double L(LatLng latLng, LatLng latLng2) {
        double d = latLng.latitude;
        double d2 = latLng.longitude;
        double d3 = latLng2.latitude;
        double pow = Math.pow(Math.sin(((d3 - d) * 0.017453292519943295d) / 2.0d), 2.0d);
        double cos = Math.cos(d * 0.017453292519943295d);
        double pow2 = (Math.pow(Math.sin(((latLng2.longitude - d2) * 0.017453292519943295d) / 2.0d), 2.0d) * Math.cos(d3 * 0.017453292519943295d) * cos) + pow;
        return Math.atan2(Math.sqrt(pow2), Math.sqrt(1.0d - pow2)) * 2.0d * 6378.137d;
    }

    public static boolean L0(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String M(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (d >= 1.0d || d <= -1.0d) {
            return ui1.H() + decimalFormat.format(d);
        }
        return ui1.H() + "0" + decimalFormat.format(d);
    }

    public static boolean M0(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException unused) {
            if (J0(context) || O0(context)) {
                return true;
            }
            return false;
        }
    }

    public static CalligraphyTypefaceSpan N(Context context, wg1 wg1) {
        return TypefaceUtils.getSpan(TypefaceUtils.load(context.getAssets(), wg1.toString()));
    }

    public static boolean N0(MPass mPass, ProductConfiguration productConfiguration) {
        ProductCategory s0;
        if (mPass == null || productConfiguration == null || Q0(mPass) || (s0 = s0(productConfiguration.getProductCategoryList(), mPass.getPassengerType())) == null) {
            return false;
        }
        if (!mPass.is_isVerificationRequired() || s0.isCategoryIsRenewable()) {
            return true;
        }
        return false;
    }

    public static String O(Context context, long j) {
        int i = (int) (j / 3600000);
        if (i == 0) {
            int i2 = (int) (j / DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(" ");
            sb.append(context.getResources().getString(i2 == 1 ? R.string.minute : R.string.minutes));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append(" ");
        sb2.append(context.getResources().getString(i == 1 ? R.string.hour : R.string.hours));
        return sb2.toString();
    }

    public static boolean O0(Context context) {
        return ((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled(AnalyticsConstants.NETWORK);
    }

    public static int P(TransitMode transitMode) {
        int ordinal = transitMode.ordinal();
        if (ordinal == 0) {
            return R.drawable.train_nearby_card_item_icon;
        }
        if (ordinal == 1) {
            return R.drawable.bus_nearby_card_item_icon;
        }
        if (ordinal == 2) {
            return R.drawable.metro_nearby_card_item_icon;
        }
        if (ordinal != 3) {
            return ordinal != 5 ? R.drawable.train_homescreen : R.drawable.ferry_nearby_card_item_icon;
        }
        return R.drawable.monorail_nearby_card_item_icon;
    }

    public static boolean P0(ProductConfiguration productConfiguration) {
        if (!"singleJourneyTicket".equalsIgnoreCase(productConfiguration.getProductType()) || !"singleJourneyTicket".equalsIgnoreCase(productConfiguration.getProductSubType())) {
            return productConfiguration.getIsActive();
        }
        if (!productConfiguration.getIsActive()) {
            return false;
        }
        return c(productConfiguration.getProductCategoryList()).getIsActive();
    }

    public static ze1 Q(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("image_url");
        String string2 = jSONObject.getString("notification_id");
        return new ze1(string, jSONObject.optString("negative_button_copy", null), jSONObject.optString("negative_button_cta", null), jSONObject.optString("positive_button_copy", null), jSONObject.optString("positive_button_cta", null), jSONObject.optString(ProductPromotionsObject.KEY_TITLE, null), string2, jSONObject.getLong("recieved_at_millis"), jSONObject.optString("title_bg_color", null), jSONObject.optBoolean("dismiss_on_positive_button", false), jSONObject.optLong("expiry_time_absolute_millis", 0));
    }

    public static boolean Q0(MPass mPass) {
        if (mPass.get_productType() == null) {
            return false;
        }
        return mPass.get_productType().equals("superSaver");
    }

    public static int R(TransitMode transitMode) {
        if (TransitMode.train.equals(transitMode)) {
            return R.drawable.train_location_trip_details;
        }
        if (TransitMode.metro.equals(transitMode)) {
            return R.drawable.metro_location_trip_details;
        }
        if (TransitMode.monorail.equals(transitMode)) {
            return R.drawable.monorail_location_trip_details;
        }
        return TransitMode.ferry.equals(transitMode) ? R.drawable.live_ferry_list : R.drawable.route_list_live_direction;
    }

    public static boolean R0(long j, int i, boolean z) {
        if (vt.f3680a.equals(BaseConstants.DEVELOPMENT)) {
            return false;
        }
        if ((!z || i < 7200) && ((int) ((ui1.Q() - j) / 1000)) < 900) {
            return false;
        }
        return true;
    }

    @SuppressLint({"ValidFragment"})
    public static DialogFragment S(String str, String str2, boolean z, boolean z2, View.OnClickListener onClickListener, String str3, boolean z3) {
        g71 g71 = new g71(str2, z3, str, z2, onClickListener, str3);
        g71.setCancelable(z);
        return g71;
    }

    public static Uri S0(Fragment fragment) {
        File file;
        String T = hj1.T("JPEG_", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), "_");
        if (!(fragment == null || fragment.getContext() == null)) {
            try {
                file = File.createTempFile(T, ".jpg", fragment.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
            } catch (Exception e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                Toast.makeText(fragment.getContext(), fragment.getContext().getString(R.string.toast_generic_error_message), 0).show();
                file = null;
            }
            if (file != null) {
                Uri b = FileProvider.b(fragment.getContext(), "app.zophop.fileprovider", file);
                ArrayList arrayList = new ArrayList();
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                for (ResolveInfo resolveInfo : fragment.getActivity().getPackageManager().queryIntentActivities(intent, 0)) {
                    String str = resolveInfo.activityInfo.packageName;
                    Intent intent2 = new Intent(intent);
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                    intent2.setPackage(str);
                    intent2.putExtra("output", b);
                    arrayList.add(intent2);
                }
                Intent intent3 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent3.setType("image/*");
                intent3.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                Intent createChooser = Intent.createChooser(intent3, "Select Source");
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
                fragment.startActivityForResult(createChooser, 227);
                return b;
            }
        }
        return null;
    }

    public static fv0 T(String str, String str2, boolean z, boolean z2) {
        fv0 fv0 = new fv0();
        Bundle c = hj1.c("loader_title", str, "loader_message", str2);
        c.putBoolean("loader_title_visibility", z2);
        fv0.setCancelable(z);
        fv0.setArguments(c);
        return fv0;
    }

    public static Notification T0(Context context, PendingIntent pendingIntent, int i, CharSequence charSequence, String str, String str2) {
        int b = q5.b(context, R.color.orange_primary);
        f5 f5Var = new f5(context, null);
        Notification notification = f5Var.v;
        notification.icon = i;
        f5Var.q = b;
        notification.tickerText = f5.d(str);
        f5Var.v.when = System.currentTimeMillis();
        f5Var.g(charSequence);
        f5Var.f(str);
        f5Var.g = pendingIntent;
        f5Var.i(16, true);
        if (Build.VERSION.SDK_INT >= 26) {
            f5Var.t = str2;
        }
        e5 e5Var = new e5();
        e5Var.d(str);
        f5Var.l(e5Var);
        Notification b2 = f5Var.b();
        b2.flags = 16 | b2.flags;
        return b2;
    }

    public static gv0 U(String str, String str2, boolean z, boolean z2) {
        gv0 gv0 = new gv0();
        Bundle c = hj1.c("loader_title", null, "loader_message", str2);
        c.putBoolean("loader_title_visibility", z2);
        gv0.setCancelable(z);
        gv0.setArguments(c);
        return gv0;
    }

    public static boolean U0(Intent intent, String str, boolean z) {
        String stringExtra = intent.getStringExtra(str);
        if (String.valueOf(true).equalsIgnoreCase(stringExtra)) {
            return true;
        }
        if (String.valueOf(false).equalsIgnoreCase(stringExtra)) {
            return false;
        }
        return z;
    }

    public static int V(sf1 sf1) {
        String optString = sf1.h.optString("pre_auto_dist", null);
        if (optString != null) {
            return Integer.parseInt(optString);
        }
        if (ui1.Y()) {
            return Integer.parseInt("1000");
        }
        return Integer.parseInt("3000");
    }

    public static void V0(e44 e44) {
        MapStyleOptions mapStyleOptions = new MapStyleOptions("[\n  {\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#d1d8dd\"\n      }\n    ]\n  },\n  {\n    \"elementType\": \"labels.text.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#688695\"\n      }\n    ]\n  },\n  {\n    \"elementType\": \"labels.text.stroke\",\n    \"stylers\": [\n      {\n        \"weight\": 3\n      }\n    ]\n  },\n  {\n    \"featureType\": \"landscape\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#d1d8dd\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"landscape\",\n    \"elementType\": \"geometry.stroke\",\n    \"stylers\": [\n      {\n        \"visibility\": \"on\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"landscape.man_made\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"visibility\": \"on\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"landscape.man_made\",\n    \"elementType\": \"geometry.stroke\",\n    \"stylers\": [\n      {\n        \"color\": \"#bbbbbb\"\n      },\n      {\n        \"visibility\": \"on\"\n      },\n      {\n        \"weight\": 0.5\n      }\n    ]\n  },\n  {\n    \"featureType\": \"landscape.natural.landcover\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"visibility\": \"on\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"poi.business\",\n    \"elementType\": \"geometry.stroke\",\n    \"stylers\": [\n      {\n        \"color\": \"#000000\"\n      },\n      {\n        \"visibility\": \"off\"\n      },\n      {\n        \"weight\": 0.5\n      }\n    ]\n  },\n  {\n    \"featureType\": \"poi.park\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#b3e08d\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"poi.sports_complex\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#b3e08d\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"road\",\n    \"elementType\": \"geometry\",\n    \"stylers\": [\n      {\n        \"color\": \"#ffffff\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"road\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#f0f0f0\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"road\",\n    \"elementType\": \"geometry.stroke\",\n    \"stylers\": [\n      {\n        \"color\": \"#ffffff\"\n      },\n      {\n        \"weight\": 0.5\n      }\n    ]\n  },\n  {\n    \"featureType\": \"road.highway\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#f8f8f8\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"road.highway\",\n    \"elementType\": \"labels.icon\",\n    \"stylers\": [\n      {\n        \"visibility\": \"off\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"transit.line\",\n    \"elementType\": \"geometry\",\n    \"stylers\": [\n      {\n        \"color\": \"#a7a7a7\"\n      },\n      {\n        \"weight\": 0.5\n      }\n    ]\n  },\n  {\n    \"featureType\": \"transit.station.airport\",\n    \"elementType\": \"labels.icon\",\n    \"stylers\": [\n      {\n        \"visibility\": \"off\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"transit.station.bus\",\n    \"elementType\": \"labels.icon\",\n    \"stylers\": [\n      {\n        \"visibility\": \"off\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"transit.station.rail\",\n    \"elementType\": \"labels.icon\",\n    \"stylers\": [\n      {\n        \"visibility\": \"off\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"water\",\n    \"elementType\": \"geometry.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#9ec2e1\"\n      }\n    ]\n  },\n  {\n    \"featureType\": \"water\",\n    \"elementType\": \"labels.text.fill\",\n    \"stylers\": [\n      {\n        \"color\": \"#757575\"\n      }\n    ]\n  }\n]");
        Objects.requireNonNull(e44);
        try {
            e44.f924a.T0(mapStyleOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static int W(sf1 sf1) {
        String optString = sf1.h.optString("pref_walk_dist", null);
        if (optString != null) {
            return Integer.parseInt(optString);
        }
        if (ui1.Y()) {
            return Integer.parseInt("400");
        }
        return Integer.parseInt("1000");
    }

    public static void W0(LinearLayout linearLayout) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getChildAt(i).getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        }
        linearLayout.invalidate();
    }

    public static int X(LegMode legMode) {
        int ordinal = legMode.ordinal();
        if (ordinal == 0) {
            return R.drawable.monorail_trip_planner;
        }
        if (ordinal == 1) {
            return R.drawable.metro_trip_planner;
        }
        if (ordinal == 2) {
            return R.drawable.auto_trip_planner;
        }
        if (ordinal == 3) {
            return R.drawable.cab_trip_planner;
        }
        if (ordinal == 4) {
            return R.drawable.walk_trip_planner;
        }
        if (ordinal != 6) {
            return ordinal != 7 ? R.drawable.train_trip_planner : R.drawable.ferry_trip_planner;
        }
        return R.drawable.bus_trip_planner;
    }

    public static void X0(Context context, EditText editText) {
        editText.setOnEditorActionListener(new bd1(editText, context));
    }

    public static String Y(Context context) {
        if (((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnectedOrConnecting()) {
            return hh1.WIFI.name();
        }
        if (Build.VERSION.SDK_INT > 29) {
            return hh1.CELLULAR.name();
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return hh1.CELLULAR_2G.name();
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return hh1.CELLULAR_3G.name();
            case 13:
                return hh1.CELLULAR_4G.name();
            default:
                return hh1.UNKNOWN.name();
        }
    }

    public static boolean Y0(String str) {
        ProductBranding branding;
        ProductConfiguration h0 = xt.f3961a.c().h0(str);
        if (h0 == null || (branding = h0.getBranding()) == null) {
            return false;
        }
        return branding.isVisible();
    }

    public static Bitmap Z(TransitMode transitMode, CharSequence charSequence, Context context) {
        return a0(null, transitMode, charSequence, context, null, null);
    }

    public static void Z0(View view, Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void a(ed1 ed1, MTicket mTicket) {
        ed1.a("bookingId", mTicket.getMTicketId());
        ed1.a("passengerTypes", e0(mTicket.getPassengerDetails()));
        ed1.a(SuperPassJsonKeys.FARE, String.valueOf(mTicket.getTotalFare()));
        ed1.a("startDate", jh1.c(mTicket.getBookingTime()));
        ed1.a("expiryDate", jh1.c(mTicket.getExpirationTime()));
        ed1.a("city", mTicket.getCityName());
        ed1.a("agency", mTicket.getAgency());
        ed1.a("upTripRouteId", mTicket.getUpTripRouteStopsInfo().getRouteId());
        ed1.a("upTripStartStopId", mTicket.getUpTripRouteStopsInfo().getStartStopId());
        ed1.a("upTripEndStopId", mTicket.getUpTripRouteStopsInfo().getEndStopId());
        ed1.a("isFreeRide", String.valueOf(mTicket.isFreeRide()));
    }

    public static Bitmap a0(String str, TransitMode transitMode, CharSequence charSequence, Context context, Integer num, Integer num2) {
        int i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.new_marker_view, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.mode_description);
        View findViewById = inflate.findViewById(R.id.marker_container);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.mode_icon);
        int ordinal = transitMode.ordinal();
        if (ordinal != 1) {
            i = ordinal != 2 ? ordinal != 3 ? ordinal != 5 ? R.drawable.live_bg_train : R.drawable.live_bg_ferry : R.drawable.live_bg_monorail : R.drawable.live_bg_metro;
        } else {
            i = (TextUtils.isEmpty(str) || ((int) Math.floor((double) Integer.parseInt(str))) < ui1.x(xt.f3961a.k().d().getName())) ? R.drawable.live_bg_bus : R.drawable.live_buses_homescreen;
        }
        findViewById.setBackgroundResource(i);
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            textView.setVisibility(8);
        }
        int ordinal2 = transitMode.ordinal();
        imageView.setImageResource(ordinal2 != 1 ? ordinal2 != 2 ? ordinal2 != 3 ? ordinal2 != 5 ? R.drawable.live_train : R.drawable.live_ferry : R.drawable.live_monorail : R.drawable.live_metro : R.drawable.live_bus);
        if (!(num == null || num2 == null)) {
            inflate.setPadding(num.intValue(), num2.intValue(), num.intValue(), num2.intValue());
        }
        return C0(inflate);
    }

    public static va1 a1(Activity activity, String str, CharSequence charSequence) {
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.right_margin_bus);
        va1 va1 = new va1(activity, (FrameLayout) ((ViewGroup) activity.getWindow().getDecorView()), 0, activity.getResources().getDimensionPixelSize(R.dimen.distance_from_fav_icon_bus) + (activity.getResources().getDimensionPixelSize(R.dimen.action_bar_height) / 2), dimensionPixelSize, 0);
        va1.f = charSequence;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.favourite_tutorial, (ViewGroup) va1.b, false);
        va1.e = inflate;
        ((FrameLayout.LayoutParams) inflate.getLayoutParams()).setMargins(0, va1.c, va1.d, 0);
        va1.b.addView(va1.e);
        va1.e.findViewById(R.id.fav_tutorial_done).setOnClickListener(new ta1(va1, str));
        if (va1.f != null) {
            ((TextView) va1.e.findViewById(R.id.title)).setText(va1.f);
        }
        return va1;
    }

    public static void b(ed1 ed1, MPass mPass) {
        ed1.a("bookingId", mPass.getBookingPassId());
        ed1.a("passengerTypes", mPass.getPassengerType());
        ed1.a(SuperPassJsonKeys.FARE, String.valueOf(mPass.getFare()));
        ed1.a("startDate", jh1.c(mPass.getBookingTime()));
        ed1.a("expiryDate", jh1.c(mPass.getExpiryTime()));
        ed1.a("city", mPass.getCity());
        ed1.a("agency", mPass.getAgency());
        if (mPass.getRouteStopsInfo() != null) {
            ed1.a("upTripRouteId", mPass.getRouteStopsInfo().getRouteId());
        }
        if (mPass.get_productType() != null && mPass.get_productType().equals("superSaver")) {
            ed1.a("ss max trip price", Integer.valueOf(mPass.get_maxTripsPrice()));
            ed1.a(SuperPassJsonKeys.CATEGORY_NAME, mPass.get_productCategory());
            ed1.a("ss total trip count", Integer.valueOf(mPass.get_maxTrips()));
            ed1.a("ss daily trip count", Integer.valueOf(mPass.get_maxTripsPerDay()));
        }
        ed1.a("productType", mPass.get_productType());
    }

    public static int b0(View view) {
        return view.getMeasuredWidth() - (view.getPaddingLeft() + view.getPaddingRight());
    }

    public static void b1(Activity activity) {
        if (!(xt.f3961a.l().h.optString("report_issue:tutorial_shown", null) != null)) {
            jz5.b().g(hj1.l("Report Issue hint shown", Long.MIN_VALUE, "shown in", activity.getClass().getSimpleName()));
            a1(activity, "report_issue:tutorial_shown", "Facing any problem? \nReport here");
        }
    }

    public static ProductActiveStatus c(List<ProductCategory> list) {
        if (list == null) {
            return new ProductActiveStatus(false, null);
        }
        String str = null;
        for (ProductCategory productCategory : list) {
            if (productCategory.isCategoryActive()) {
                return new ProductActiveStatus(true, null);
            }
            str = productCategory.getInactiveReason();
        }
        return new ProductActiveStatus(false, str);
    }

    public static Notification c0(Context context, jf1 jf1, boolean z, String str) {
        Intent intent;
        String str2 = jf1.f1916a;
        String str3 = jf1.b;
        int currentTimeMillis = (int) System.currentTimeMillis();
        UserProfile H = ov.H(jf1.c);
        if (z) {
            intent = MPassPurchaseActivity.r0(context, "sourceNotification", "flowReapplication", ov.D(jf1.d, H), null);
        } else {
            intent = MPassPurchaseActivity.r0(context, "sourceNotification", "flowPaymentPostVerification", ov.I(jf1.d, H), null);
        }
        intent.setFlags(268468224);
        return T0(context, PendingIntent.getActivity(context, currentTimeMillis, intent, 268435456), R.drawable.logo_notification, str2, str3, str);
    }

    public static int c1(zp zpVar) {
        int ordinal = zpVar.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    i = 4;
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + zpVar + " to int");
                    }
                }
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[SYNTHETIC, Splitter:B:35:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.mp d(byte[] r7) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn.d(byte[]):mp");
    }

    public static String d0(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString(str);
        return (AnalyticsConstants.NULL.equalsIgnoreCase(optString) || optString == null) ? "" : optString;
    }

    public static void d1(SpannableStringBuilder spannableStringBuilder, String str) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#727171")), length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), length, spannableStringBuilder.length(), 17);
    }

    public static void e(String str, boolean z) {
        ed1 l = hj1.l("zophop call failure", 3600000, AnalyticsConstants.CALL, str);
        l.a(AnalyticsConstants.NETWORK, String.valueOf(z));
        jz5.b().g(l);
    }

    public static String e0(HashMap<String, MTicketPassengerInfo> hashMap) {
        JSONArray jSONArray = new JSONArray();
        for (String str : hashMap.keySet()) {
            jSONArray.put(str);
        }
        return jSONArray.toString();
    }

    public static String e1(re1 re1) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", re1.j);
        jSONObject.put("message", re1.h);
        jSONObject.put("notification_id", re1.f);
        jSONObject.put("image_url", re1.i);
        jSONObject.put(ProductPromotionsObject.KEY_TITLE, re1.g);
        jSONObject.put("alert_seen", re1.k);
        jSONObject.put("notification_type", re1.a());
        List<String> list = re1.m;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            jSONObject.put("city_list", jSONArray);
        }
        jSONObject.put("is_silent", re1.n);
        jSONObject.put("expiry_time", re1.q);
        String str2 = re1.p;
        if (str2 != null) {
            jSONObject.put("deeplink_product_config_id", str2);
        }
        se1 se1 = re1.l;
        if (se1 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("radius", se1.b);
            jSONObject2.put("lat", se1.f3205a.latitude);
            jSONObject2.put("lon", se1.f3205a.longitude);
            jSONObject.put("meta", jSONObject2.toString());
        }
        return jSONObject.toString();
    }

    public static boolean f(HorizontalScrollView horizontalScrollView, ViewGroup viewGroup) {
        int measuredWidth = viewGroup.getMeasuredWidth();
        if (measuredWidth > b0(horizontalScrollView) || measuredWidth <= 0) {
            return false;
        }
        int floor = (int) Math.floor((((double) b0(horizontalScrollView)) * 1.0d) / ((double) viewGroup.getChildCount()));
        int i = 0;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getMeasuredWidth() > i) {
                i = childAt.getMeasuredWidth();
            }
        }
        if (i < floor) {
            return true;
        }
        return false;
    }

    public static String f0(Context context, double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat.format(d) + context.getString(R.string.tv_percentage_off_suffix);
    }

    public static String f1(ze1 ze1) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("image_url", ze1.g);
        jSONObject.put("notification_id", ze1.n);
        jSONObject.put("negative_button_copy", ze1.i);
        jSONObject.put("negative_button_cta", ze1.k);
        jSONObject.put("positive_button_copy", ze1.h);
        jSONObject.put("positive_button_cta", ze1.j);
        jSONObject.put(ProductPromotionsObject.KEY_TITLE, ze1.f);
        jSONObject.put("expiry_time_absolute_millis", ze1.l);
        jSONObject.put("recieved_at_millis", ze1.o);
        jSONObject.put("title_bg_color", ze1.m);
        jSONObject.put("dismiss_on_positive_button", ze1.p);
        return jSONObject.toString();
    }

    public static String g(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static Intent g0(androidx.fragment.app.Fragment fragment) {
        File file;
        try {
            file = File.createTempFile(hj1.T("JPEG_", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), "_"), ".jpg", fragment.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
            Toast.makeText(fragment.getContext(), fragment.getContext().getString(R.string.toast_generic_error_message), 0).show();
            file = null;
        }
        if (file == null) {
            return null;
        }
        Uri b = FileProvider.b(fragment.getContext(), "app.zophop.fileprovider", file);
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo resolveInfo : fragment.c().getPackageManager().queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent2.setPackage(str);
            intent2.putExtra("output", b);
            arrayList.add(intent2);
        }
        Intent intent3 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent3.setType("image/*");
        intent3.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        Intent createChooser = Intent.createChooser(intent3, "Select Source");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        createChooser.putExtra("output", b.toString());
        return createChooser;
    }

    public static void g1(e44 e44, int i, LatLng... latLngArr) {
        e44.j(new bh1(latLngArr, e44, i));
    }

    public static ProductActiveStatus h(MPass mPass, ProductConfiguration productConfiguration) {
        ProductCategory productCategory;
        boolean z;
        if (productConfiguration == null || mPass == null) {
            return new ProductActiveStatus(false, null);
        }
        if (Q0(mPass)) {
            List<ProductCategory> productCategoryList = productConfiguration.getProductCategoryList();
            if (productCategoryList != null) {
                String categoryId = mPass.get_grouping().getCategoryId();
                Iterator<ProductCategory> it = productCategoryList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    productCategory = it.next();
                    if (productCategory.getCategoryId().equals(categoryId)) {
                        break;
                    }
                }
            }
            productCategory = null;
        } else {
            productCategory = s0(productConfiguration.getProductCategoryList(), mPass.getPassengerType());
        }
        List<ProductFareMapping> t0 = t0(mPass, productConfiguration.getProductFareMapping());
        List<ProductDuration> productDurations = productConfiguration.getProductDurations();
        if (productCategory == null || t0 == null || productDurations == null) {
            return new ProductActiveStatus(false, null);
        }
        if (productCategory.isCategoryIsRenewable()) {
            return new ProductActiveStatus(true, null);
        }
        if (!productConfiguration.getIsActive()) {
            return new ProductActiveStatus(false, productConfiguration.getInactiveReason());
        }
        if (!Q0(mPass) && !productCategory.isCategoryActive()) {
            return new ProductActiveStatus(false, productCategory.getInactiveReason());
        }
        long noOfDays = ((long) mPass.getNoOfDays()) * 86400000;
        Iterator<ProductDuration> it2 = productDurations.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            ProductDuration next = it2.next();
            if (next.getValidity() == noOfDays) {
                if (!next.getIsActive()) {
                    return new ProductActiveStatus(false, next.getInactiveReason());
                }
                z = true;
            }
        }
        if (!z) {
            return new ProductActiveStatus(false, null);
        }
        ProductFareMapping u0 = u0(mPass, t0);
        if (u0 == null) {
            return new ProductActiveStatus(false, null);
        }
        if (u0.getLegacyIsActive().booleanValue()) {
            return new ProductActiveStatus(true, null);
        }
        return new ProductActiveStatus(false, u0.getInactiveReason());
    }

    public static md1 h0(JSONObject jSONObject) throws JSONException {
        return new md1(jSONObject.getString("description"), jSONObject.getString("place_id"));
    }

    /* JADX WARN: Incorrect args count in method signature: (Lapp/zophop/models/mTicketing/MTicket;Lapp/zophop/models/Route;Lapp/zophop/models/mTicketing/ProductConfiguration;Landroid/content/Context;)Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>; */
    public static Map i(ProductConfiguration productConfiguration, Context context) {
        if (!productConfiguration.getIsActive()) {
            String inactiveReason = productConfiguration.getInactiveReason();
            if (inactiveReason == null) {
                inactiveReason = context.getResources().getString(R.string.recent_products_disabled_dialog_copy);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("keyDialogTitle", context.getResources().getString(R.string.recent_products_disabled_dialog_title));
            hashMap.put("keyDialogCopy", inactiveReason);
            hashMap.put("keyDialogReason", "product temporarily disabled");
            return hashMap;
        }
        ProductActiveStatus c = c(productConfiguration.getProductCategoryList());
        if (c.getIsActive()) {
            return null;
        }
        String inactiveReason2 = c.getInactiveReason();
        if (inactiveReason2 == null) {
            inactiveReason2 = context.getResources().getString(R.string.recent_products_disabled_dialog_copy);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("keyDialogTitle", context.getResources().getString(R.string.recent_products_disabled_dialog_title));
        hashMap2.put("keyDialogCopy", inactiveReason2);
        hashMap2.put("keyDialogReason", "product temporarily disabled");
        return hashMap2;
    }

    public static boolean i0(sf1 sf1) {
        String optString = sf1.h.optString("pref_ac", null);
        if (optString != null) {
            return Boolean.valueOf(optString).booleanValue();
        }
        return true;
    }

    public static CharSequence j(CharSequence charSequence, String str, int i, boolean z) {
        return (str == null || !charSequence.toString().toLowerCase().contains(str.toLowerCase())) ? charSequence : k(charSequence, charSequence.toString().toLowerCase().indexOf(str.toLowerCase()), str.length(), i, z);
    }

    public static boolean j0(sf1 sf1) {
        String optString = sf1.h.optString("pref_non_ac", null);
        if (optString != null) {
            return Boolean.valueOf(optString).booleanValue();
        }
        return true;
    }

    public static SpannableStringBuilder k(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(charSequence);
        int i4 = i2 + i;
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i4, 0);
        if (z) {
            spannableString.setSpan(new StyleSpan(1), i, i4, 0);
        }
        spannableStringBuilder.append((CharSequence) spannableString);
        return spannableStringBuilder;
    }

    public static ProductCategory k0(List<ProductCategory> list, String str) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            ProductCategory productCategory = list.get(i);
            if (str.equalsIgnoreCase(productCategory.getCategoryId())) {
                return productCategory;
            }
        }
        return null;
    }

    public static Stop l(zophop.models.Stop stop) {
        return new Stop(stop.getStop_id(), stop.getStop_name(), new LatLng(stop.getStop_lat(), stop.getStop_lon()), TransitMode.getTransitMode(stop.getStation_type().toString()));
    }

    public static ProductCategory l0(String str, String str2) {
        ProductConfiguration m0 = m0(str);
        for (int i = 0; i < m0.getProductCategoryList().size(); i++) {
            if (m0.getProductCategoryList().get(i).getCategoryId().equalsIgnoreCase(str2)) {
                return m0.getProductCategoryList().get(i);
            }
        }
        return null;
    }

    public static zophop.models.Stop m(Stop stop) {
        zophop.models.Stop stop2 = new zophop.models.Stop();
        stop2.setStop_id(stop.getId());
        StationType stationType = StationType.getStationType(stop.getMode().toString());
        stop2.setStation_type(stationType);
        stop2.setTranport_type(stationType.toString());
        stop2.setStop_lat(stop.getLatLong().latitude);
        stop2.setStop_lon(stop.getLatLong().longitude);
        stop2.setStop_name(stop.getName());
        return stop2;
    }

    public static ProductConfiguration m0(String str) {
        return xt.f3961a.c().h0(str);
    }

    public static pf1 n(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new pf1(mf1.a(jSONObject.getString("desc_loc")), Long.valueOf(jSONObject.getString("timestamp")).longValue());
    }

    public static ProductFareMapping n0(String str, String str2, long j) {
        List<ProductFareMapping> list = m0(str).getProductFareMapping().get(str2);
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            ProductFareMapping productFareMapping = list.get(i);
            if (productFareMapping.getDurationId() == j) {
                return productFareMapping;
            }
        }
        return null;
    }

    public static double o(long j) {
        return new BigDecimal(String.valueOf(j)).setScale(2, 4).divide(new BigDecimal(String.valueOf(100)), 4).doubleValue();
    }

    public static ProductFareMapping o0(List<String> list, List<ProductFareMapping> list2, long j) {
        if (list2 == null) {
            return null;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getDurationId() == j) {
                if (list == null && list2.get(i).getSpecialFeatures() == null) {
                    return list2.get(i);
                }
                if (!(list == null || list2.get(i).getSpecialFeatures() == null || !list.equals(list2.get(i).getSpecialFeatures()))) {
                    return list2.get(i);
                }
            }
        }
        return null;
    }

    public static double p(LatLng latLng, LatLng latLng2) {
        Location location = new Location("");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        Location location2 = new Location("");
        location2.setLatitude(latLng2.latitude);
        location2.setLongitude(latLng2.longitude);
        return (double) location.distanceTo(location2);
    }

    public static String p0(String str) {
        String str2 = "";
        for (String str3 : str.replaceAll("[$&+.,:;=?@#|]", " ").replaceAll("  ", " ").trim().split(" ")) {
            String trim = str3.trim();
            if (!trim.equalsIgnoreCase("")) {
                str2 = hj1.T(str2, g(trim), " ");
            }
        }
        return str2.trim();
    }

    public static String q(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static ii1.a q0(List<EtaUpdateInfo> list) {
        ii1.a aVar = new ii1.a();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (EtaUpdateInfo etaUpdateInfo : list) {
            int etaInSeconds = etaUpdateInfo.getEtaInSeconds() - ((int) ((currentTimeMillis - etaUpdateInfo.getEtaUpdateTimeInMillis()) / 1000));
            if (etaInSeconds > 0) {
                arrayList.add(new i10(etaInSeconds, etaUpdateInfo.getEtaUpdateTimeInMillis()));
            }
        }
        if (arrayList.size() != 0) {
            aVar.f1519a = new j10(arrayList).a();
            aVar.b = arrayList;
            aVar.d = ii1.a.EnumC0027a.SUCCESS;
        } else {
            aVar.d = ii1.a.EnumC0027a.FAILURE;
        }
        return aVar;
    }

    public static void r(String str, Context context) {
        xt.t1 t1Var = xt.f3961a;
        if (ui1.b0(TransitMode.bus, t1Var.k().d()) && t1Var.L().m()) {
            new ProductRepository(context).updateExpiryState(str);
        }
    }

    public static String r0(Context context, MPass mPass, RideDetails rideDetails) {
        String str;
        String name = MagicPassInfoView.b.NO_RECLAIM.name();
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("superSaverStore", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (mPass.get_productType() != null && mPass.get_productType().equals("superSaver") && mPass.getStartingTime() <= ui1.Q() && !mPass.isPassExpired() && mPass.getExpiryTime() >= ui1.Q()) {
            if (mPass.getStatus() == null || !mPass.getStatus().equals("INACTIVE")) {
                if ((rideDetails == null || rideDetails.get_rideInfoList() == null) && mPass.getBookingPassId() != null && !sharedPreferences.contains(mPass.getBookingPassId())) {
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("app_open_daily_store", 0);
                    sharedPreferences2.edit();
                    if (ui1.Q() - sharedPreferences2.getLong("appOpenTime", ui1.Q()) <= xt.f3961a.t().c("syncingTime")) {
                        z = true;
                    }
                    if (z && (mPass.getStatus() == null || (!mPass.getStatus().equals("FAILED") && !mPass.getStatus().equals("PENDING")))) {
                        str = MagicPassInfoView.b.APP_RECLAIM.name();
                    }
                }
                jz5.b().g(hj1.l("ss reclaim", Long.MIN_VALUE, "ss reclaim type", name));
            } else {
                edit.putBoolean(mPass.getBookingPassId(), true);
                edit.commit();
                xt.f3961a.c().n0(mPass.getBookingPassId());
                str = MagicPassInfoView.b.BACKEND_RECLIAM.name();
            }
            name = str;
            jz5.b().g(hj1.l("ss reclaim", Long.MIN_VALUE, "ss reclaim type", name));
        }
        return name;
    }

    public static int s(List<Stop> list, Stop stop) {
        int i = -1;
        if (stop == null) {
            return -1;
        }
        for (Stop stop2 : list) {
            if (stop2.getLatLong().latitude == stop.getLatLong().latitude && stop2.getLatLong().longitude == stop.getLatLong().longitude) {
                i = list.indexOf(stop2);
            }
        }
        return i;
    }

    public static ProductCategory s0(List<ProductCategory> list, String str) {
        if (list == null) {
            return null;
        }
        for (ProductCategory productCategory : list) {
            if (productCategory.getCategoryId().equals(str)) {
                return productCategory;
            }
        }
        return null;
    }

    public static String t(String str, String str2) {
        List<ProductConfiguration> I = xt.f3961a.c().I();
        if (I == null) {
            return null;
        }
        for (ProductConfiguration productConfiguration : I) {
            if (productConfiguration.getProductAgency().equalsIgnoreCase(str2) && productConfiguration.getProductType().equalsIgnoreCase(str)) {
                return productConfiguration.getProductId();
            }
        }
        return null;
    }

    public static List<ProductFareMapping> t0(MPass mPass, Map<String, List<ProductFareMapping>> map) {
        String passengerType = mPass.getPassengerType();
        if (map == null || !map.containsKey(passengerType)) {
            return null;
        }
        return map.get(passengerType);
    }

    public static String u(String str, String str2) {
        StringBuilder k0 = hj1.k0(str, ProductDiscountsObject.KEY_DELIMITER);
        k0.append(xt.f3961a.k().d().getDisplayName().toLowerCase());
        k0.append(ProductDiscountsObject.KEY_DELIMITER);
        k0.append(str2);
        return k0.toString();
    }

    public static ProductFareMapping u0(MPass mPass, List<ProductFareMapping> list) {
        long noOfDays = ((long) mPass.getNoOfDays()) * 86400000;
        List<String> specialFeatures = mPass.getSpecialFeatures();
        for (ProductFareMapping productFareMapping : list) {
            if (productFareMapping.getDurationId() == noOfDays) {
                List<String> specialFeatures2 = productFareMapping.getSpecialFeatures();
                if (specialFeatures == null || specialFeatures.size() == 0) {
                    if (specialFeatures2 == null || specialFeatures2.size() == 0) {
                        return productFareMapping;
                    }
                } else if (specialFeatures.equals(productFareMapping.getSpecialFeatures())) {
                    return productFareMapping;
                }
            }
        }
        return null;
    }

    public static String v(String str, String str2, String str3) {
        StringBuilder k0 = hj1.k0(str, ProductDiscountsObject.KEY_DELIMITER);
        k0.append(xt.f3961a.k().d().getDisplayName().toLowerCase());
        k0.append(ProductDiscountsObject.KEY_DELIMITER);
        k0.append(str2);
        k0.append(ProductDiscountsObject.KEY_DELIMITER);
        k0.append(str3);
        return k0.toString();
    }

    public static int v0(int i) {
        switch (i) {
            case -1:
                return R.drawable.ic_coupon;
            case 0:
                return R.drawable.seats_available;
            case 1:
                return R.drawable.standing_available;
            case 2:
                return R.drawable.overcrowded;
            case 3:
                return R.drawable.seats_available;
            case 4:
                return R.drawable.standing_available;
            case 5:
                return R.drawable.overcrowded;
            default:
                return -1;
        }
    }

    public static String w(String str, String str2) {
        StringBuilder k0 = hj1.k0(str, ProductDiscountsObject.KEY_DELIMITER);
        k0.append(xt.f3961a.k().d().getDisplayName().toLowerCase());
        k0.append(ProductDiscountsObject.KEY_DELIMITER);
        k0.append(str2);
        return k0.toString();
    }

    public static ProductConfiguration w0(List<ProductConfiguration> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductType().equalsIgnoreCase("singleJourneyTicket")) {
                return list.get(i);
            }
        }
        return null;
    }

    public static String x(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ref", str);
            jSONObject.put("requestId", i);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Notification x0(Context context, String str, String str2, String str3, String str4) {
        PendingIntent pendingIntent;
        if (str3 != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str3));
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, HomeActivity.class), 134217728);
        }
        return T0(context, pendingIntent, R.drawable.logo_notification, str, str2, str4);
    }

    public static long y(String str) {
        ProductConfiguration h0 = xt.f3961a.c().h0(str);
        if (h0 == null) {
            return 14400000;
        }
        return h0.getProductActiveDuration();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r7 != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r7 != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        r7 = app.zophop.R.drawable.bus_nearby_unselected;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap y0(android.content.Context r3, app.zophop.models.Stop r4, boolean r5, boolean r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn.y0(android.content.Context, app.zophop.models.Stop, boolean, boolean, boolean):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096 A[SYNTHETIC, Splitter:B:33:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.re1 z(android.content.Intent r15) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn.z(android.content.Intent):re1");
    }

    public static SpannableStringBuilder z0(Context context, TripSummary tripSummary, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (tripSummary.isFrequencyTrip()) {
            Pair<TimeInterval, Integer> z = ui1.z(i, tripSummary.getFrequencyList());
            if (z == null) {
                d1(spannableStringBuilder, context.getString(R.string.no_more_trips_today));
            } else if (((TimeInterval) z.first).containsTime(i)) {
                d1(spannableStringBuilder, context.getString(R.string.every));
                spannableStringBuilder.append((CharSequence) String.valueOf(z.second));
                d1(spannableStringBuilder, " min");
            } else {
                d1(spannableStringBuilder, context.getString(R.string.after));
                String replace = jh1.g((long) ((Integer) ((Pair) ((TimeInterval) z.first)).first).intValue()).replace("am", "AM").replace("pm", "PM");
                spannableStringBuilder.append((CharSequence) replace);
                if (replace.length() >= 2) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
                }
            }
        } else {
            String replace2 = jh1.g((long) tripSummary.getArrivalTime()).replace("am", "AM").replace("pm", "PM");
            spannableStringBuilder.append((CharSequence) replace2);
            if (replace2.length() >= 2) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), replace2.length() - 2, replace2.length(), 33);
            }
        }
        return spannableStringBuilder;
    }
}
