package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: qa1  reason: default package */
/* compiled from: CustomHeaderView */
public class qa1 extends LinearLayout {
    public final TextView f = ((TextView) findViewById(R.id.header_view));

    public qa1(Context context) {
        super(context);
        addView(LayoutInflater.from(context).inflate(R.layout.header_view_layout, (ViewGroup) null));
    }

    public void setHeaderText(String str) {
        this.f.setText(str);
    }
}
