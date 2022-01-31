package com.urbanairship.actions;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.Autopilot;
import com.urbanairship.R;
import com.urbanairship.UAirship;

public class RateAppActivity extends dl5 {
    public AlertDialog h;

    public void onCloseButtonClick(View view) {
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.dl5, defpackage.ve, defpackage.y4
    @SuppressLint({"NewApi"})
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Autopilot.c(getApplication());
        if (!UAirship.v && !UAirship.u) {
            yj5.c("RateAppActivity - unable to create activity, takeOff not called.", new Object[0]);
            finish();
        }
    }

    @Override // defpackage.ve
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        yj5.a("New intent received for rate app activity", new Object[0]);
        Uri data = intent.getData();
        Bundle extras = intent.getExtras();
        yj5.a("Relaunching activity", new Object[0]);
        finish();
        Intent flags = new Intent().setClass(this, getClass()).setData(data).setFlags(268435456);
        if (extras != null) {
            flags.putExtras(extras);
        }
        startActivity(flags);
    }

    @Override // defpackage.ve
    @SuppressLint({"NewApi"})
    public void onPause() {
        super.onPause();
    }

    @Override // defpackage.ve
    @SuppressLint({"NewApi"})
    public void onResume() {
        String str;
        super.onResume();
        AlertDialog alertDialog = this.h;
        if (alertDialog == null || !alertDialog.isShowing()) {
            Intent intent = getIntent();
            if (intent == null) {
                yj5.c("RateAppActivity - Started activity with null intent.", new Object[0]);
                finish();
                return;
            }
            Uri uri = (Uri) intent.getParcelableExtra("store_uri");
            if (uri == null) {
                yj5.c("RateAppActivity - Missing store URI.", new Object[0]);
                finish();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if (intent.getStringExtra(ProductPromotionsObject.KEY_TITLE) != null) {
                builder.setTitle(intent.getStringExtra(ProductPromotionsObject.KEY_TITLE));
            } else {
                int i = R.string.ua_rate_app_action_default_title;
                Object[] objArr = new Object[1];
                String packageName = UAirship.d().getPackageName();
                PackageManager packageManager = UAirship.d().getPackageManager();
                try {
                    str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128));
                } catch (PackageManager.NameNotFoundException unused) {
                    str = "";
                }
                objArr[0] = str;
                builder.setTitle(getString(i, objArr));
            }
            if (intent.getStringExtra(ProductPromotionsObject.KEY_BODY) != null) {
                builder.setMessage(intent.getStringExtra(ProductPromotionsObject.KEY_BODY));
            } else {
                String string = getString(R.string.ua_rate_app_action_default_rate_positive_button);
                builder.setMessage(getString(R.string.ua_rate_app_action_default_body, string));
            }
            builder.setPositiveButton(getString(R.string.ua_rate_app_action_default_rate_positive_button), new xk5(this, uri));
            builder.setNegativeButton(getString(R.string.ua_rate_app_action_default_rate_negative_button), new yk5(this));
            builder.setOnCancelListener(new zk5(this));
            AlertDialog create = builder.create();
            this.h = create;
            create.setCancelable(true);
            this.h.show();
        }
    }
}
