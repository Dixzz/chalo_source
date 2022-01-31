package defpackage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;

/* renamed from: na1  reason: default package */
/* compiled from: AlertInfoView */
public class na1 extends CardView {
    public re1 f;
    public View g;
    public TextView h = ((TextView) this.g.findViewById(R.id.alert_time));
    public TextView i = ((TextView) this.g.findViewById(R.id.alert_title));
    public TextView j = ((TextView) this.g.findViewById(R.id.alert_message));
    public ImageView k = ((ImageView) this.g.findViewById(R.id.alert_image));
    public Activity l;

    public na1(Activity activity) {
        super(activity);
        this.l = activity;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.alert_info_layout, (ViewGroup) this, false);
        this.g = inflate;
        addView(inflate);
        View findViewById = this.g.findViewById(R.id.alert_footer);
        this.g.findViewById(R.id.alert_chat_hook).setOnClickListener(new ka1(this));
        findViewById.setOnClickListener(new la1(this));
        if (!xt.f3961a.t().b("showChatOptionsDrawer")) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
    }

    private String getShareBody() {
        String packageName = this.l.getPackageName();
        return this.f.g + "\n\n" + this.f.h + "\n\n" + this.l.getString(R.string.download_now) + xt.f3961a.P().a(packageName);
    }

    public void setAlertInfo(re1 re1) {
        this.k.setImageBitmap(null);
        this.f = re1;
        this.i.setText(re1.g);
        this.j.setText(this.f.h);
        this.h.setText(jh1.h(this.f.j / 1000) + ", " + jh1.c(this.f.j));
        if (!TextUtils.isEmpty(this.f.i)) {
            this.k.setVisibility(0);
            this.k.setImageResource(R.drawable.placeholder_generic);
            ml1<Bitmap> j2 = gl1.f(getContext()).j();
            j2.h(this.f.i);
            j2.f(new ma1(this));
            return;
        }
        this.k.setVisibility(8);
    }
}
