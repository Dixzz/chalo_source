package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: jb1  reason: default package */
/* compiled from: PartnerCard */
public class jb1 extends LinearLayout {
    public final Context f;
    public final View.OnClickListener g;
    public final View.OnClickListener h;

    public jb1(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context);
        this.f = context;
        this.g = onClickListener;
        this.h = onClickListener2;
        LayoutInflater.from(context).inflate(R.layout.partner_card, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.dismiss);
        TextView textView2 = (TextView) findViewById(R.id.learn_more);
        TextView textView3 = (TextView) findViewById(R.id.banner_title);
        TextView textView4 = (TextView) findViewById(R.id.banner_description);
        if (xt.f3961a.k().d().getName().equalsIgnoreCase("guwahati")) {
            textView3.setText(getResources().getString(R.string.partner_title_guwahati));
            textView4.setText(getResources().getString(R.string.partner_description_guwahati));
        }
        textView.setOnClickListener(onClickListener);
        textView2.setOnClickListener(onClickListener2);
    }
}
