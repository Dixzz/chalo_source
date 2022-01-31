package app.zophop.ui.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import defpackage.xt;

public class ForceUpdateActivity extends wt {
    @InjectView(R.id.validation_success_ok_button)
    public Button _actionButton;
    @InjectView(R.id.status_icon)
    public ImageView _icon;
    @InjectView(R.id.remind_later)
    public TextView _remindLater;
    @InjectView(R.id.status_copy)
    public TextView _statusCopy;
    @InjectView(R.id.status_detail)
    public TextView _statusDetail;
    public boolean l;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            jz5.b().g(new ed1("app update button clicked", Long.MIN_VALUE));
            String packageName = ForceUpdateActivity.this.getPackageName();
            try {
                ForceUpdateActivity forceUpdateActivity = ForceUpdateActivity.this;
                forceUpdateActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
            } catch (ActivityNotFoundException unused) {
                ForceUpdateActivity forceUpdateActivity2 = ForceUpdateActivity.this;
                forceUpdateActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            jz5.b().g(new ed1("app update postponed", Long.MIN_VALUE));
            xt.f3961a.l().put("prompt_seen", String.valueOf(true));
            ForceUpdateActivity.this.finish();
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        String str;
        String str2;
        setContentView(R.layout.pass_submit_status);
        ButterKnife.inject(this);
        this.l = getIntent().getBooleanExtra("forceUpdate", false);
        getIntent().getBooleanExtra("recommendedUpdate", false);
        xt.t1 t1Var = xt.f3961a;
        t1Var.t().f("appUpdateTitle");
        t1Var.t().f("appUpdateSubTitle");
        String f = t1Var.t().f("appUpdateButton");
        ed1 ed1 = new ed1("app update screen shown", Long.MIN_VALUE);
        if (this.l) {
            str2 = getString(R.string.force_update_title);
            str = getString(R.string.force_update_subtitle);
            this._remindLater.setVisibility(8);
            ed1.a("type", "force");
        } else {
            String string = getString(R.string.recommended_update_title);
            String string2 = getString(R.string.recommended_update_subtitle);
            this._remindLater.setVisibility(0);
            ed1.a("type", "recomended");
            str2 = string;
            str = string2;
        }
        jz5.b().g(ed1);
        this._icon.setImageResource(R.drawable.chalo_logo_app_update);
        this._statusCopy.setText(str2);
        this._statusDetail.setText(str);
        this._actionButton.setText(f);
        this._actionButton.setOnClickListener(new a());
        this._remindLater.setOnClickListener(new b());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }
}
