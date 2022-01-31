package com.freshchat.consumer.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.k.n;
import com.freshchat.consumer.sdk.service.Status;

public abstract class ah<T extends n> extends b {
    private View Q;
    private ViewStub eS;
    private View eV;
    private View gK;
    private View lG;
    private AppCompatImageView lO;
    private AppCompatImageView mt;
    private AppCompatImageView oT;
    private TextView pd;
    public T pe;
    private BroadcastReceiver pg = new aj(this);

    private void iz() {
        if (ig().length > 0) {
            IntentFilter intentFilter = new IntentFilter();
            for (String str : ig()) {
                intentFilter.addAction(str);
            }
            D().b(this.pg, intentFilter);
        }
    }

    public void U(int i) {
        int i2;
        int i3 = -2;
        if (i == 2) {
            i3 = aq.o(this, R.dimen.freshchat_error_image_height_landscape);
            i2 = aq.o(this, R.dimen.freshchat_error_image_width_landscape);
        } else {
            i2 = -2;
        }
        i.a(this.lO, i3, i2);
        i.a(this.mt, i3, i2);
        i.a(this.oT, i3, i2);
    }

    public void a(Status status) {
        View view;
        if (status != null) {
            int i = ak.pi[status.ordinal()];
            if (i == 1) {
                view = this.eV;
            } else if (i == 2) {
                view = this.gK;
            } else if (i == 3) {
                hP();
                return;
            } else if (i == 4) {
                bv(hV());
                return;
            } else if (i == 5) {
                view = this.lG;
            } else {
                return;
            }
            h(view);
        }
    }

    public void a(boolean z, View.OnClickListener onClickListener) {
        if (!z) {
            View inflate = this.eS.inflate();
            inflate.bringToFront();
            View findViewById = inflate.findViewById(R.id.freshchat_contact_us_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            }
        }
    }

    public void bv(String str) {
        h(this.Q);
        this.pd.setText(as.fromHtml(str));
    }

    public abstract String dA();

    public abstract void dh();

    public void h(View view) {
        i.c(this.eV);
        i.c(this.gK);
        i.c(this.lG);
        i.c(m5if());
        i.c(this.Q);
        i.b(view);
    }

    public abstract void hP();

    public abstract String hV();

    public void i(View view) {
        h(view);
    }

    public abstract void ie();

    /* renamed from: if  reason: not valid java name */
    public abstract View m5if();

    public abstract String[] ig();

    @Override // defpackage.f0, defpackage.ve
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        U(configuration.orientation);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        iz();
        dh();
    }

    @Override // defpackage.f0, defpackage.ve
    public void onDestroy() {
        if (ig().length > 0) {
            D().d(this.pg);
        }
        super.onDestroy();
    }

    @Override // com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_search_faq) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.pe.jh();
        return true;
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.b, com.freshchat.consumer.sdk.activity.a
    public void onResume() {
        super.onResume();
        a(this.pe.jf());
    }

    public void u() {
        e(dA());
        C();
        this.eS = (ViewStub) findViewById(R.id.freshchat_contact_us_stub);
        this.eV = findViewById(R.id.faq_loading);
        this.gK = findViewById(R.id.faq_no_internet);
        this.lG = findViewById(R.id.faq_error);
        this.Q = findViewById(R.id.faq_empty);
        this.pd = (TextView) findViewById(R.id.faq_empty_description);
        this.oT = (AppCompatImageView) findViewById(R.id.freshchat_empty_image);
        this.mt = (AppCompatImageView) findViewById(R.id.freshchat_no_internet_image);
        this.lO = (AppCompatImageView) findViewById(R.id.freshchat_error_image);
        ((TextView) findViewById(R.id.faq_retry)).setOnClickListener(new ai(this));
        U(getResources().getConfiguration().orientation);
    }
}
