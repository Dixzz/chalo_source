package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookingPassRouteInfo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: sa1  reason: default package */
/* compiled from: CustomPassRadioButton */
public class sa1 extends RelativeLayout implements View.OnClickListener {
    public static final /* synthetic */ int t = 0;
    public final Context f;
    public final TextView g = ((TextView) findViewById(R.id.pass_fare));
    public final TextView h = ((TextView) findViewById(R.id.pass_type));
    public final RadioButton i;
    public final View j = findViewById(R.id.pass_radio_button_layout);
    public List<BookingPassRouteInfo> k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public final TextView p = ((TextView) findViewById(R.id.actual_price));
    public final TextView q = ((TextView) findViewById(R.id.discount));
    public String r;
    public List<String> s;

    /* renamed from: sa1$a */
    /* compiled from: CustomPassRadioButton */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                sa1 sa1 = sa1.this;
                int i = sa1.t;
                sa1.a();
            }
            sa1.this.setChecked(z);
        }
    }

    public sa1(Context context) {
        super(context);
        this.f = context;
        addView(LayoutInflater.from(context).inflate(R.layout.custom_radio_pass_button, (ViewGroup) null));
        RadioButton radioButton = (RadioButton) findViewById(R.id.pass_radio_button);
        this.i = radioButton;
        setOnClickListener(this);
        radioButton.setOnCheckedChangeListener(new a());
    }

    public final void a() {
        LinearLayout linearLayout = (LinearLayout) getParent();
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (linearLayout.getChildAt(i2).findViewById(R.id.pass_radio_button) instanceof RadioButton) {
                    ((RadioButton) linearLayout.getChildAt(i2).findViewById(R.id.pass_radio_button)).setChecked(false);
                }
            }
        }
    }

    public String getAgencyName() {
        return this.n;
    }

    public String getConfigId() {
        return this.r;
    }

    public double getFare() {
        Matcher matcher = Pattern.compile("\\d+").matcher(this.g.getText());
        matcher.find();
        return Double.valueOf(matcher.group()).doubleValue();
    }

    public String getNumberOfDays() {
        return this.l;
    }

    public String getPassType() {
        return this.h.getText().toString();
    }

    public String getPassengerType() {
        return this.m;
    }

    public View getRootView() {
        return this.i;
    }

    public String getRouteText() {
        return this.i.getText().toString();
    }

    public List<BookingPassRouteInfo> getRoutesInfo() {
        return this.k;
    }

    public List<String> getSpecialFeaturesList() {
        return this.s;
    }

    public boolean getVerificationStatus() {
        return this.o;
    }

    public void onClick(View view) {
        if (!this.i.isChecked()) {
            a();
            setChecked(true);
        }
    }

    public void setActualFare(String str) {
        TextView textView = this.p;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        TextView textView2 = this.p;
        textView2.setText(ui1.H() + str);
    }

    public void setActualFareVisibility(int i2) {
        this.q.setVisibility(i2);
        this.p.setVisibility(i2);
    }

    public void setAgencyName(String str) {
        this.n = str;
    }

    public void setChecked(boolean z) {
        this.i.setChecked(z);
    }

    public void setConfig(String str) {
        this.r = str;
    }

    public void setDiscount(String str) {
        this.q.setText(str);
    }

    public void setFare(String str) {
        TextView textView = this.g;
        textView.setText(ui1.H() + str);
    }

    public void setNumberOfDays(String str) {
        this.l = str;
    }

    public void setPassType(String str) {
        this.m = str;
    }

    public void setPassTypeText(String str) {
        this.h.setText(str);
    }

    public void setRouteInfo(List<BookingPassRouteInfo> list) {
        this.k = list;
    }

    public void setRouteText(String str) {
        this.i.setText(str);
    }

    public void setSpecialFeatures(List<String> list) {
        this.s = list;
    }

    public void setTopPadding(int i2) {
        this.j.setPadding(0, i2, 0, 0);
    }

    public void setVerificationStatus(boolean z) {
        this.o = z;
    }

    public void setPassTypeText(SpannableStringBuilder spannableStringBuilder) {
        this.h.setText(spannableStringBuilder);
    }
}
