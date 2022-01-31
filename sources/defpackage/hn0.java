package defpackage;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.RouteDialogInfo;
import app.zophop.models.RouteLevelAvailability;
import java.util.Map;

/* renamed from: hn0  reason: default package */
/* compiled from: RouteAvailabilityDialog */
public class hn0 extends DialogFragment {
    public static int l = 2;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public RouteDialogInfo k;

    /* renamed from: hn0$a */
    /* compiled from: RouteAvailabilityDialog */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (!TextUtils.isEmpty(hn0.this.i)) {
                hn0.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hn0.this.i)));
            }
            hn0.this.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l = getArguments().getInt("status");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RouteLevelAvailability routeLevelAvailability;
        View inflate = layoutInflater.inflate(R.layout.autosubscribe_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.done);
        textView.setVisibility(8);
        TextView textView2 = (TextView) inflate.findViewById(R.id.autosubscribe_dialog_title);
        TextView textView3 = (TextView) inflate.findViewById(R.id.autosubscribe_dialog_body);
        TextView textView4 = (TextView) inflate.findViewById(R.id.cancel);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.subscription_icon);
        getDialog().setCanceledOnTouchOutside(false);
        textView4.setTextColor(getResources().getColor(R.color.chalo_primary));
        Map<String, RouteLevelAvailability> G = xt.f3961a.c().G();
        if (!(G == null || (routeLevelAvailability = G.get(String.valueOf(l))) == null)) {
            RouteDialogInfo routeDialogInfo = routeLevelAvailability.getRouteDialogInfo();
            this.k = routeDialogInfo;
            this.f = routeDialogInfo.getTitle();
            this.g = this.k.getSubtitle();
            this.h = this.k.getCtaTitle();
            this.i = this.k.getCta();
            this.j = this.k.getImageUrl();
            textView2.setText(this.f);
            textView3.setText(this.g);
            textView4.setText(this.h);
            if (!TextUtils.isEmpty(this.j)) {
                ml1<Drawable> p = gl1.d(getActivity()).p(this.j);
                rs1 rs1 = new rs1();
                int i2 = l;
                int i3 = R.drawable.less_coverage_dialogue;
                if (i2 == -1) {
                    i3 = R.drawable.off_duty_dialogue;
                } else if (i2 == 0) {
                    i3 = R.drawable.zero_coverage_dialogue;
                }
                p.a(rs1.j(i3));
                p.e(imageView);
            }
            textView4.setOnClickListener(new a());
        }
        textView.setVisibility(8);
        return inflate;
    }
}
