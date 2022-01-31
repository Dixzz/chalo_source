package defpackage;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import app.zophop.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textview.MaterialTextView;
import java.util.Objects;

/* renamed from: vy0  reason: default package */
/* compiled from: OnlineCardRechargeTutorialBottomSheet.kt */
public final class vy0 extends pl0<pw> {
    public final h76<s56> h;

    /* renamed from: vy0$a */
    /* compiled from: OnlineCardRechargeTutorialBottomSheet.kt */
    public static final class a extends BottomSheetBehavior.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<FrameLayout> f3692a;

        public a(BottomSheetBehavior<FrameLayout> bottomSheetBehavior) {
            this.f3692a = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void a(View view, float f) {
            n86.e(view, "bottomSheet");
            this.f3692a.M(3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void b(View view, int i) {
            n86.e(view, "bottomSheet");
            this.f3692a.M(3);
        }
    }

    public vy0(h76<s56> h76) {
        n86.e(h76, "gotItClickListener");
        this.h = h76;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.pl0
    public pw d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "lInflater");
        View inflate = layoutInflater.inflate(R.layout.bottomsheet_card_recharge_tutorial, (ViewGroup) null, false);
        int i = R.id.barrier_1;
        Barrier barrier = (Barrier) inflate.findViewById(R.id.barrier_1);
        if (barrier != null) {
            i = R.id.barrier_2;
            Barrier barrier2 = (Barrier) inflate.findViewById(R.id.barrier_2);
            if (barrier2 != null) {
                i = R.id.btn_got_it;
                MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.btn_got_it);
                if (materialTextView != null) {
                    i = R.id.guideline_left;
                    Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                    if (guideline != null) {
                        i = R.id.guideline_right;
                        Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                        if (guideline2 != null) {
                            i = R.id.step_one;
                            TextView textView = (TextView) inflate.findViewById(R.id.step_one);
                            if (textView != null) {
                                i = R.id.step_one_copy;
                                MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.step_one_copy);
                                if (materialTextView2 != null) {
                                    i = R.id.step_one_title;
                                    MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.step_one_title);
                                    if (materialTextView3 != null) {
                                        i = R.id.step_two;
                                        TextView textView2 = (TextView) inflate.findViewById(R.id.step_two);
                                        if (textView2 != null) {
                                            i = R.id.step_two_copy;
                                            MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.step_two_copy);
                                            if (materialTextView4 != null) {
                                                i = R.id.step_two_title;
                                                MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.step_two_title);
                                                if (materialTextView5 != null) {
                                                    i = R.id.title;
                                                    MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.title);
                                                    if (materialTextView6 != null) {
                                                        pw pwVar = new pw((ConstraintLayout) inflate, barrier, barrier2, materialTextView, guideline, guideline2, textView, materialTextView2, materialTextView3, textView2, materialTextView4, materialTextView5, materialTextView6);
                                                        n86.d(pwVar, "inflate(lInflater)");
                                                        return pwVar;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.pl0
    public void e() {
        Dialog dialog = getDialog();
        Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior<FrameLayout> e = ((gl4) dialog).e();
        e.M(3);
        setCancelable(false);
        a aVar = new a(e);
        if (!e.I.contains(aVar)) {
            e.I.add(aVar);
        }
        T t = this.f;
        n86.c(t);
        ((pw) t).b.setOnClickListener(new gy0(this));
        ui1.m0(new ed1("ocr tutorial bottomsheet displayed", Long.MIN_VALUE));
    }

    @Override // defpackage.pl0
    public void f() {
    }
}
