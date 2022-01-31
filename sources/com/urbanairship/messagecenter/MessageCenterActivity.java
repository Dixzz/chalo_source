package com.urbanairship.messagecenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

public class MessageCenterActivity extends dl5 {
    public zu5 h;

    @Override // androidx.activity.ComponentActivity, defpackage.dl5, defpackage.ve, defpackage.y4
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Autopilot.c(getApplication());
        if (UAirship.v || UAirship.u) {
            e(true);
            if (bundle != null) {
                this.h = (zu5) getSupportFragmentManager().I("MESSAGE_CENTER_FRAGMENT");
            }
            if (this.h == null) {
                String i = yu5.i(getIntent());
                zu5 zu5 = new zu5();
                Bundle bundle2 = new Bundle();
                bundle2.putString("messageReporting", i);
                zu5.setArguments(bundle2);
                this.h = zu5;
                ke keVar = new ke(getSupportFragmentManager());
                keVar.f(16908290, this.h, "MESSAGE_CENTER_FRAGMENT", 1);
                keVar.e();
            }
            zu5 zu52 = this.h;
            yu5.j();
            zu52.f = null;
            return;
        }
        yj5.c("MessageCenterActivity - unable to create activity, takeOff not called.", new Object[0]);
        finish();
    }

    @Override // defpackage.ve
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String i = yu5.i(intent);
        if (i != null) {
            zu5 zu5 = this.h;
            if (zu5.isResumed()) {
                zu5.e(i);
            } else {
                zu5.l = i;
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }
}
