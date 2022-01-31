package com.razorpay;

import android.content.Context;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BaseConfig */
public final class r$_Y_ implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f698a;

    public r$_Y_(Context context) {
        this.f698a = context;
    }

    @Override // com.razorpay.Callback
    public final void run(ResponseObject responseObject) {
        String str;
        try {
            if (responseObject.getResponseCode() == 200) {
                BaseConfig.saveConfigDataToPreferences(this.f698a, new JSONObject(responseObject.getResponseResult()).toString());
                List<String> list = responseObject.getHeaders().get("Settingversion");
                if (list != null && list.size() > 0 && (str = list.get(0)) != null && !str.isEmpty()) {
                    BaseConfig.setConfigVersionToPreferences(this.f698a, str);
                }
            }
        } catch (Exception unused) {
        }
    }
}
