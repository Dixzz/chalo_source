package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import defpackage.b1;

/* renamed from: x  reason: default package */
/* compiled from: ActionBar */
public abstract class x {

    /* renamed from: x$b */
    /* compiled from: ActionBar */
    public interface b {
        void a(boolean z);
    }

    @Deprecated
    /* renamed from: x$c */
    /* compiled from: ActionBar */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public void A(CharSequence charSequence) {
    }

    public abstract void B();

    public b1 C(b1.a aVar) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public void c(boolean z) {
    }

    public abstract int d();

    public Context e() {
        return null;
    }

    public abstract void f();

    public boolean g() {
        return false;
    }

    public void h(Configuration configuration) {
    }

    public void i() {
    }

    public boolean j(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean k(KeyEvent keyEvent) {
        return false;
    }

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public void n(boolean z) {
    }

    public abstract void o(boolean z);

    public abstract void p(boolean z);

    public abstract void q(boolean z);

    public abstract void r(boolean z);

    public void s(int i) {
    }

    public void t(int i) {
    }

    public void u(Drawable drawable) {
    }

    public void v(boolean z) {
    }

    public void w(boolean z) {
    }

    public abstract void x(CharSequence charSequence);

    public abstract void y(int i);

    public abstract void z(CharSequence charSequence);

    /* renamed from: x$a */
    /* compiled from: ActionBar */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = i3;
        }

        public a(int i) {
            this(-2, -1, i);
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.gravity = 0;
            this.gravity = aVar.gravity;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }
}
