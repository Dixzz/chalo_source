package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.City;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;

/* renamed from: gw0  reason: default package */
/* compiled from: SeatAvailabiltyBottomSheet.kt */
public final class gw0 extends qn0 {
    public final a h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;

    /* renamed from: gw0$a */
    /* compiled from: SeatAvailabiltyBottomSheet.kt */
    public interface a {
        void a();

        void b();

        void c(String str);
    }

    public gw0(Context context, a aVar, String str) {
        n86.e(context, "_context");
        n86.e(str, "dialogGroupKey");
        this.g = str;
        this.h = aVar;
    }

    public static final void d(FragmentManager fragmentManager, Context context, a aVar, String str) {
        n86.e(fragmentManager, "manager");
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(aVar, "listener");
        n86.e(str, "orderedDialogKey");
        gw0 gw0 = new gw0(context, aVar, str);
        gw0.show(fragmentManager, AnalyticsConstants.SHOW);
        gw0.setCancelable(false);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        String name;
        n86.e(layoutInflater, "inflater");
        String str = null;
        View inflate = layoutInflater.inflate(R.layout.seat_availability_bottomsheet, (ViewGroup) null, false);
        n86.d(inflate, "view");
        this.j = (TextView) inflate.findViewById(R.id.got_it);
        this.i = (TextView) inflate.findViewById(R.id.learn_more);
        this.k = (TextView) inflate.findViewById(R.id.seat_occupancy_level_notice);
        this.l = (TextView) inflate.findViewById(R.id.seat_occupancy_title);
        this.m = (TextView) inflate.findViewById(R.id.first_row_occupancy_textview);
        this.n = (TextView) inflate.findViewById(R.id.second_row_occupancy_textview);
        this.o = (TextView) inflate.findViewById(R.id.third_row_occupancy_textview);
        xt.t1 t1Var = xt.f3961a;
        City d = t1Var.k().d();
        if (!(d == null || (name = d.getName()) == null)) {
            str = name.toLowerCase();
            n86.d(str, "(this as java.lang.String).toLowerCase()");
        }
        String str2 = (String) t1Var.l().get(n86.j("seatOccupancyDialoglearnMoreUrl", str));
        String str3 = (String) t1Var.l().get(n86.j("seatAvailabilityApiMode", str));
        if (str3 != null) {
            int parseInt = Integer.parseInt(str3);
            if (parseInt == 1) {
                TextView textView2 = this.l;
                if (textView2 != null) {
                    textView2.setText(getResources().getString(R.string.saTitle));
                }
                TextView textView3 = this.m;
                if (textView3 != null) {
                    textView3.setText(getResources().getString(R.string.seats_available));
                }
                TextView textView4 = this.n;
                if (textView4 != null) {
                    textView4.setText(getResources().getString(R.string.standing_available));
                }
                TextView textView5 = this.o;
                if (textView5 != null) {
                    textView5.setText(getResources().getString(R.string.over_crowded));
                }
                TextView textView6 = this.k;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
            } else if (parseInt == 2) {
                TextView textView7 = this.l;
                if (textView7 != null) {
                    textView7.setText(getResources().getString(R.string.bus_current_occupancy_dialog_title));
                }
                TextView textView8 = this.m;
                if (textView8 != null) {
                    textView8.setText(getResources().getString(R.string.space_available));
                }
                TextView textView9 = this.n;
                if (textView9 != null) {
                    textView9.setText(getResources().getString(R.string.nearing_full_capacity));
                }
                TextView textView10 = this.o;
                if (textView10 != null) {
                    textView10.setText(getResources().getString(R.string.full_capacity_reached));
                }
                String j2 = n86.j("seatOccupancyDialogNotice", str);
                String str4 = (String) t1Var.l().get(j2);
                if (str4 == null) {
                    TextView textView11 = this.k;
                    if (textView11 != null) {
                        textView11.setVisibility(8);
                    }
                } else if (n86.a(str4, "disabled")) {
                    TextView textView12 = this.k;
                    if (textView12 != null) {
                        textView12.setVisibility(8);
                    }
                } else {
                    StringBuilder i0 = hj1.i0("\n                            ");
                    i0.append(getResources().getString(R.string.seat_occupancy_level_notice_header));
                    i0.append("\n                            ");
                    i0.append(t1Var.l().get(j2));
                    i0.append("\n                            ");
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ea6.L(i0.toString()));
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, 24, 33);
                    TextView textView13 = this.k;
                    if (textView13 != null) {
                        textView13.setText(spannableStringBuilder);
                    }
                    TextView textView14 = this.k;
                    if (textView14 != null) {
                        textView14.setVisibility(0);
                    }
                }
            }
        }
        if (str2 == null && (textView = this.i) != null) {
            textView.setVisibility(8);
        }
        TextView textView15 = this.j;
        if (textView15 != null) {
            textView15.setOnClickListener(new zr0(this));
        }
        TextView textView16 = this.i;
        if (textView16 != null) {
            textView16.setOnClickListener(new as0(this, str2));
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
        return inflate;
    }
}
