package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: ra1  reason: default package */
/* compiled from: CustomPassDate */
public class ra1 extends RelativeLayout {
    public final TextView f = ((TextView) findViewById(R.id.pass_date_view));
    public final View g = findViewById(R.id.pass_date_layout);

    public ra1(Context context) {
        super(context);
        addView(LayoutInflater.from(context).inflate(R.layout.custom_pass_date_layout, (ViewGroup) null));
    }

    public String getPassDate() {
        return this.f.getText().toString();
    }

    public void setDateEditListner(View.OnClickListener onClickListener) {
        this.g.setOnClickListener(onClickListener);
    }

    public void setPassDate(String str) {
        this.f.setText(str);
    }
}
