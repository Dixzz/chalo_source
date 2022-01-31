package com.razorpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.razorpay.AdvertisingIdUtil;

/* compiled from: AdvertisingIdUtil */
public final class a_$P$ extends AsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private AdvertisingIdUtil.AdvertisingIdCallback f692a;
    @SuppressLint({"StaticFieldLeak"})
    private Context b;

    public a_$P$(Context context, AdvertisingIdUtil.AdvertisingIdCallback advertisingIdCallback) {
        this.b = context;
        this.f692a = advertisingIdCallback;
    }

    private String a() {
        String message;
        G__G_ g__g_ = new G__G_((byte) 0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!this.b.bindService(intent, g__g_, 1)) {
            return "permission disabled";
        }
        try {
            message = new R$$r_(g__g_.a()).a();
        } catch (Exception e) {
            message = e.getMessage();
        } catch (Throwable th) {
            this.b.unbindService(g__g_);
            throw th;
        }
        this.b.unbindService(g__g_);
        return message;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ String doInBackground(Void[] voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        super.onPostExecute(str2);
        this.f692a.onResult(str2);
    }
}
