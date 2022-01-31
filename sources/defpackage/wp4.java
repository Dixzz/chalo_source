package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: wp4  reason: default package */
/* compiled from: IndicatorViewController */
public final class wp4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3823a;
    public final TextInputLayout b;
    public LinearLayout c;
    public int d;
    public FrameLayout e;
    public Animator f;
    public final float g;
    public int h;
    public int i;
    public CharSequence j;
    public boolean k;
    public TextView l;
    public CharSequence m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    /* renamed from: wp4$a */
    /* compiled from: IndicatorViewController */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3824a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ TextView d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f3824a = i;
            this.b = textView;
            this.c = i2;
            this.d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            TextView textView;
            wp4 wp4 = wp4.this;
            wp4.h = this.f3824a;
            wp4.f = null;
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.c == 1 && (textView = wp4.this.l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public wp4(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f3823a = context;
        this.b = textInputLayout;
        this.g = (float) context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.c == null && this.e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f3823a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.e = new FrameLayout(this.f3823a);
            this.c.addView(this.e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.e.setVisibility(0);
            this.e.addView(textView);
        } else {
            this.c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.c.setVisibility(0);
        this.d++;
    }

    public void b() {
        if ((this.c == null || this.b.getEditText() == null) ? false : true) {
            EditText editText = this.b.getEditText();
            boolean J1 = hd3.J1(this.f3823a);
            LinearLayout linearLayout = this.c;
            int i2 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            AtomicInteger atomicInteger = r8.f3055a;
            linearLayout.setPaddingRelative(h(J1, i2, editText.getPaddingStart()), h(J1, R.dimen.material_helper_text_font_1_3_padding_top, this.f3823a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), h(J1, i2, editText.getPaddingEnd()), 0);
        }
    }

    public void c() {
        Animator animator = this.f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i4 == i2 ? 1.0f : 0.0f);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(zj4.f4184a);
                list.add(ofFloat);
                if (i4 == i2) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.g, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(zj4.d);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean e() {
        if (this.i != 1 || this.l == null || TextUtils.isEmpty(this.j)) {
            return false;
        }
        return true;
    }

    public final TextView f(int i2) {
        if (i2 == 1) {
            return this.l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    public int g() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int h(boolean z, int i2, int i3) {
        return z ? this.f3823a.getResources().getDimensionPixelSize(i2) : i3;
    }

    public void i() {
        this.j = null;
        c();
        if (this.h == 1) {
            if (!this.q || TextUtils.isEmpty(this.p)) {
                this.i = 0;
            } else {
                this.i = 2;
            }
        }
        l(this.h, this.i, k(this.l, null));
    }

    public void j(TextView textView, int i2) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            if (!(i2 == 0 || i2 == 1) || (frameLayout = this.e) == null) {
                linearLayout.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i3 = this.d - 1;
            this.d = i3;
            LinearLayout linearLayout2 = this.c;
            if (i3 == 0) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    public final boolean k(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.b;
        AtomicInteger atomicInteger = r8.f3055a;
        return textInputLayout.isLaidOut() && this.b.isEnabled() && (this.i != this.h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void l(int i2, int i3, boolean z) {
        TextView f2;
        TextView f3;
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.q, this.r, 2, i2, i3);
                d(arrayList, this.k, this.l, 1, i2, i3);
                hd3.v2(animatorSet, arrayList);
                animatorSet.addListener(new a(i3, f(i2), i2, f(i3)));
                animatorSet.start();
            } else if (i2 != i3) {
                if (!(i3 == 0 || (f3 = f(i3)) == null)) {
                    f3.setVisibility(0);
                    f3.setAlpha(1.0f);
                }
                if (!(i2 == 0 || (f2 = f(i2)) == null)) {
                    f2.setVisibility(4);
                    if (i2 == 1) {
                        f2.setText((CharSequence) null);
                    }
                }
                this.h = i3;
            }
            this.b.w();
            this.b.y(z, false);
            this.b.F();
        }
    }
}
