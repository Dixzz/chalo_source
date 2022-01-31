package com.razorpay;

import android.content.Context;
import com.razorpay.AdvertisingIdUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseUtils */
public final class E$_6$ implements AdvertisingIdUtil.AdvertisingIdCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ JSONObject f671a;
    private /* synthetic */ Context b;
    private /* synthetic */ RzpJSONCallback c;

    public E$_6$(JSONObject jSONObject, Context context, RzpJSONCallback rzpJSONCallback) {
        this.f671a = jSONObject;
        this.b = context;
        this.c = rzpJSONCallback;
    }

    @Override // com.razorpay.AdvertisingIdUtil.AdvertisingIdCallback
    public final void onResult(String str) {
        try {
            this.f671a.put("advertising_id", str);
            this.f671a.put(AnalyticsConstants.IS_ROMING, BaseUtils.isNetworkRoaming(this.b));
            this.f671a.put(AnalyticsConstants.CARRIER_NETWORK, BaseUtils.getCarrierOperatorName(this.b));
            this.f671a.put(AnalyticsConstants.CARRIER_ID, AnalyticsConstants.NULL);
            Map<String, String> deviceAttributes = BaseUtils.getDeviceAttributes(this.b);
            this.f671a.put(AnalyticsConstants.DEVICE_ID, deviceAttributes.get(AnalyticsConstants.DEVICE_ID));
            this.f671a.put(AnalyticsConstants.DEVICE_MANUFACTURER, deviceAttributes.get(AnalyticsConstants.DEVICE_MANUFACTURER));
            this.f671a.put(AnalyticsConstants.DEVICE_MODEL, deviceAttributes.get(AnalyticsConstants.DEVICE_MODEL));
            this.f671a.put(AnalyticsConstants.SERIAL_NUMBER, BaseUtils.buildSerial());
            this.f671a.put(AnalyticsConstants.IP_ADDRESS, BaseUtils.ipAddress);
            this.f671a.put(AnalyticsConstants.WIFI_SSID, BaseUtils.getWifiSSID(this.b));
            this.f671a.put(AnalyticsConstants.ANDROID_ID, BaseUtils.getAndroidId(this.b));
            this.f671a.put(AnalyticsConstants.SAFETY_NET_BASIC_INTEGRITY, "true");
            this.f671a.put(AnalyticsConstants.SAFETY_NET_CTS_PROFILE_MATCH, AnalyticsConstants.NULL);
            this.c.onResponse(this.f671a);
        } catch (JSONException e) {
            AnalyticsUtil.reportError(e, AnalyticsConstants.WARNING, e.getMessage());
        }
    }
}
