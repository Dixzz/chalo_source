package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import app.zophop.R;

/* compiled from: CityDiscontinuedActivity.kt */
public final class CityDiscontinuedActivity extends au {
    public static final /* synthetic */ int n = 0;
    public TextView k;
    public FrameLayout l;
    public String m;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.city_discontinued_screen);
        this.m = getIntent().getStringExtra("selectedCity");
        View findViewById = findViewById(R.id.status_detail);
        n86.d(findViewById, "findViewById(R.id.status_detail)");
        TextView textView = (TextView) findViewById;
        n86.e(textView, "<set-?>");
        this.k = textView;
        View findViewById2 = findViewById(R.id.btn_change_city);
        n86.d(findViewById2, "findViewById(R.id.btn_change_city)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        n86.e(frameLayout, "<set-?>");
        this.l = frameLayout;
        this.m = vn.g(this.m);
        String string = getResources().getString(R.string.city_discontinued_copy);
        n86.d(string, "resources.getString(R.st…g.city_discontinued_copy)");
        String e0 = hj1.e0(new Object[]{this.m}, 1, string, "java.lang.String.format(format, *args)");
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setText(e0);
            ed1 ed1 = new ed1("city discontinued screen displayed", Long.MIN_VALUE);
            hj1.K0(ed1, "cityName", this.m, ed1);
            FrameLayout frameLayout2 = this.l;
            if (frameLayout2 != null) {
                frameLayout2.setOnClickListener(new m90(this));
            } else {
                n86.l("_primaryActionButton");
                throw null;
            }
        } else {
            n86.l("_copyTextView");
            throw null;
        }
    }

    public final void h0() {
        Intent intent = new Intent(this, CitySelectionActivity.class);
        intent.putExtra("source", CityDiscontinuedActivity.class.getName());
        intent.putExtra("src", "onboarding");
        startActivity(intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        h0();
    }
}
