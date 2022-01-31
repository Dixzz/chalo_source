package defpackage;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* renamed from: dl5  reason: default package */
/* compiled from: ThemedActivity */
public abstract class dl5 extends ve {
    public static Boolean g;
    public cl5 f;

    @Override // androidx.activity.ComponentActivity
    @SuppressLint({"UnknownNullness"})
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.a(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    public void e(boolean z) {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            if (cl5.a() != null) {
                this.f.a().o(z);
                this.f.a().v(z);
            }
        } else if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(z);
            getActionBar().setHomeButtonEnabled(z);
        }
    }

    public MenuInflater getMenuInflater() {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            return cl5.f581a.f();
        }
        return super.getMenuInflater();
    }

    public void invalidateOptionsMenu() {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.i();
        } else {
            super.invalidateOptionsMenu();
        }
    }

    @Override // defpackage.ve
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.j(configuration);
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve, defpackage.y4
    public void onCreate(Bundle bundle) {
        h0 h0Var;
        int identifier;
        if (g == null) {
            try {
                Class.forName("h0");
                g = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                g = Boolean.FALSE;
            }
        }
        boolean z = false;
        if (g.booleanValue() && (identifier = getResources().getIdentifier("colorPrimary", "attr", getPackageName())) != 0) {
            TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{identifier});
            z = obtainStyledAttributes.hasValue(0);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            cl5 cl5 = new cl5();
            p2<WeakReference<h0>> p2Var = h0.f;
            cl5.f581a = new i0(this, null, null, this);
            this.f = cl5;
        }
        cl5 cl52 = this.f;
        if (!(cl52 == null || (h0Var = cl52.f581a) == null)) {
            h0Var.h();
            cl52.f581a.k(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // defpackage.ve
    public void onDestroy() {
        super.onDestroy();
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.l();
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.m(bundle);
        }
    }

    @Override // defpackage.ve
    public void onPostResume() {
        super.onPostResume();
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.n();
        }
    }

    @Override // defpackage.ve
    public void onStop() {
        super.onStop();
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.q();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.y(charSequence);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.t(i);
        } else {
            super.setContentView(i);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"UnknownNullness"})
    public void setContentView(View view) {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.u(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // androidx.activity.ComponentActivity
    @SuppressLint({"UnknownNullness"})
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        cl5 cl5 = this.f;
        if (cl5 != null) {
            cl5.f581a.v(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }
}
