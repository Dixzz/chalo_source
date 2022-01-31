package com.urbanairship.messagecenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

public class MessageActivity extends dl5 {
    public String h;
    public final vu5 i = new a();

    public class a implements vu5 {
        public a() {
        }

        @Override // defpackage.vu5
        public void a() {
            MessageActivity messageActivity = MessageActivity.this;
            String str = messageActivity.h;
            if (str != null) {
                messageActivity.e0(str);
            }
        }
    }

    public final void d0() {
        if (this.h != null) {
            cv5 cv5 = (cv5) getSupportFragmentManager().I("MessageFragment");
            if (cv5 == null || !this.h.equals(cv5.e())) {
                ke keVar = new ke(getSupportFragmentManager());
                if (cv5 != null) {
                    keVar.p(cv5);
                }
                String str = this.h;
                cv5 cv52 = new cv5();
                Bundle bundle = new Bundle();
                bundle.putString("messageReporting", str);
                cv52.setArguments(bundle);
                keVar.f(16908290, cv52, "MessageFragment", 1);
                keVar.e();
            }
            e0(this.h);
        }
    }

    public final void e0(String str) {
        wu5 d = yu5.j().g.d(str);
        if (d == null) {
            setTitle((CharSequence) null);
        } else {
            setTitle(d.o);
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.dl5, defpackage.ve, defpackage.y4
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Autopilot.c(getApplication());
        if (UAirship.v || UAirship.u) {
            e(true);
            if (bundle == null) {
                this.h = yu5.i(getIntent());
            } else {
                this.h = bundle.getString("messageId");
            }
            if (this.h == null) {
                finish();
            } else {
                d0();
            }
        } else {
            yj5.c("MessageActivity - unable to create activity, takeOff not called.", new Object[0]);
            finish();
        }
    }

    @Override // defpackage.ve
    @SuppressLint({"UnknownNullness"})
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String i2 = yu5.i(intent);
        if (i2 != null) {
            this.h = i2;
            d0();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("messageId", this.h);
    }

    @Override // defpackage.ve
    public void onStart() {
        super.onStart();
        qu5 qu5 = yu5.j().g;
        qu5.f2993a.add(this.i);
    }

    @Override // defpackage.dl5, defpackage.ve
    public void onStop() {
        super.onStop();
        qu5 qu5 = yu5.j().g;
        qu5.f2993a.remove(this.i);
    }
}
