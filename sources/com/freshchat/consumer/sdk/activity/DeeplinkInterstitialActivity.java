package com.freshchat.consumer.sdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;

public class DeeplinkInterstitialActivity extends Activity {
    public static final String TAG = DeeplinkInterstitialActivity.class.getName();
    public Intent br = null;

    public void onCreate(Bundle bundle) {
        Uri parse;
        super.onCreate(bundle);
        Intent aI = aa.aI(getApplicationContext());
        Intent intent = getIntent();
        this.br = intent;
        long j = 0;
        try {
            j = intent.getLongExtra("MARKETING_ID", -1);
            boolean booleanExtra = this.br.getBooleanExtra("NOTIFICATION_CLICKED", false);
            String str = TAG;
            ai.d(str, "Marketing message with id : " + j + ", clicked: " + booleanExtra);
            if (booleanExtra) {
                aa.f(getApplicationContext(), j);
            }
        } catch (Exception e) {
            q.a(e);
        }
        try {
            if (this.br.hasExtra("DEEPLINK_URL")) {
                String stringExtra = this.br.getStringExtra("DEEPLINK_URL");
                if (as.a(stringExtra) && (parse = Uri.parse(stringExtra)) != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("MARKETING_ID", j);
                    DeepLinkUtils.c(getApplicationContext(), parse, bundle2);
                }
            } else if (this.br.getBooleanExtra("LAUNCH_APP_ON_CLICK", false)) {
                aI = aa.aI(getApplicationContext());
            }
            if (aI != null) {
                aI.putExtras(this.br.getExtras());
                startActivityForResult(aI, 0);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        finish();
    }
}
