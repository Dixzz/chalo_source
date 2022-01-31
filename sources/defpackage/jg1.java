package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.utilities.R;
import app.zophop.utilities.models.InAppMessageDetails;

/* renamed from: jg1  reason: default package */
/* compiled from: InAppMessageBottomSheet.kt */
public final class jg1 extends hl4 {
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public a k;
    public boolean l;

    /* renamed from: jg1$a */
    /* compiled from: InAppMessageBottomSheet.kt */
    public interface a {
        void a(boolean z);
    }

    public jg1(a aVar) {
        n86.e(aVar, "_handler");
        this.k = aVar;
    }

    public final void d(String str, String str2, String str3, String str4) {
        ed1 l2 = hj1.l("inapp message bottomsheet button clicked", Long.MIN_VALUE, "ctaType", str);
        l2.a("messageId", str2);
        hj1.p(l2, ProductPromotionsObject.KEY_TITLE, str3, "buttonText", str4).g(l2);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.inapp_message_bottomsheet, (ViewGroup) null, false);
        Bundle arguments = getArguments();
        n86.d(inflate, "view");
        this.f = (ImageView) inflate.findViewById(R.id.image);
        this.g = (TextView) inflate.findViewById(R.id.title);
        this.h = (TextView) inflate.findViewById(R.id.sub_title);
        this.i = (TextView) inflate.findViewById(R.id.positive_btn);
        this.j = (TextView) inflate.findViewById(R.id.negative_btn);
        if (arguments != null) {
            InAppMessageDetails inAppMessageDetails = (InAppMessageDetails) arguments.getParcelable("data");
            if (inAppMessageDetails != null) {
                if (InAppMessageDetails.s != null) {
                    ml1<Drawable> p = gl1.g(c()).p(InAppMessageDetails.s);
                    p.a(new rs1().j(R.drawable.nearby_click));
                    p.e(this.f);
                }
                ImageView imageView = this.f;
                int i2 = 8;
                if (imageView != null) {
                    imageView.setVisibility(InAppMessageDetails.i == 0 ? 8 : 1);
                }
                TextView textView = this.g;
                if (textView != null) {
                    textView.setVisibility(InAppMessageDetails.j == 0 ? 8 : 1);
                }
                TextView textView2 = this.h;
                if (textView2 != null) {
                    textView2.setVisibility(InAppMessageDetails.k == 0 ? 8 : 1);
                }
                TextView textView3 = this.j;
                if (textView3 != null) {
                    textView3.setVisibility(InAppMessageDetails.p == 0 ? 8 : 1);
                }
                TextView textView4 = this.g;
                if (textView4 != null) {
                    textView4.setText(InAppMessageDetails.q);
                }
                TextView textView5 = this.h;
                if (textView5 != null) {
                    textView5.setText(InAppMessageDetails.r);
                }
                if (inAppMessageDetails.a() == 1) {
                    TextView textView6 = this.i;
                    if (textView6 != null) {
                        textView6.setText(InAppMessageDetails.m);
                    }
                    TextView textView7 = this.i;
                    if (textView7 != null) {
                        textView7.setVisibility(inAppMessageDetails.a());
                    }
                } else {
                    TextView textView8 = this.i;
                    if (textView8 != null) {
                        textView8.setText(InAppMessageDetails.t);
                    }
                    TextView textView9 = this.i;
                    if (textView9 != null) {
                        if (InAppMessageDetails.o != 0) {
                            i2 = 1;
                        }
                        textView9.setVisibility(i2);
                    }
                }
                TextView textView10 = this.j;
                if (textView10 != null) {
                    textView10.setText(InAppMessageDetails.u);
                }
                if (InAppMessageDetails.h == 0) {
                    TextView textView11 = this.g;
                    if (textView11 != null) {
                        textView11.setGravity(3);
                    }
                    TextView textView12 = this.h;
                    if (textView12 != null) {
                        textView12.setGravity(3);
                    }
                } else {
                    TextView textView13 = this.g;
                    if (textView13 != null) {
                        textView13.setGravity(1);
                    }
                    TextView textView14 = this.h;
                    if (textView14 != null) {
                        textView14.setGravity(1);
                    }
                }
            }
            if (inAppMessageDetails != null) {
                String str = InAppMessageDetails.n;
                String str2 = InAppMessageDetails.v;
                String str3 = InAppMessageDetails.w;
                TextView textView15 = this.i;
                if (textView15 != null) {
                    textView15.setOnClickListener(new cg1(inAppMessageDetails, str, this, str2));
                }
                TextView textView16 = this.j;
                if (textView16 != null) {
                    textView16.setOnClickListener(new dg1(this, inAppMessageDetails, str3));
                }
            }
        }
        return inflate;
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        a aVar = this.k;
        if (aVar != null && aVar != null) {
            aVar.a(this.l);
        }
    }
}
