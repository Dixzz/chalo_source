package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.urbanairship.R;

public class WalletLoadingActivity extends dl5 {
    public final oh<b> h = new oh<>();

    public class a implements ph<b> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ph
        public void a(b bVar) {
            b bVar2 = bVar;
            if (bVar2.b != null || bVar2.f721a == null) {
                WalletLoadingActivity.this.finish();
                return;
            }
            WalletLoadingActivity.this.startActivity(new Intent("android.intent.action.VIEW", bVar2.f721a));
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Uri f721a;
        public Exception b;

        public b(Uri uri, Exception exc) {
            this.f721a = uri;
            this.b = exc;
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.dl5, defpackage.ve, defpackage.y4
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ua_activity_wallet_loading);
        Uri data = getIntent().getData();
        if (data == null) {
            yj5.i("User URI null, unable to process link.", new Object[0]);
            finish();
            return;
        }
        this.h.f(this, new a());
        pj5.f2814a.submit(new al5(this, data));
    }
}
