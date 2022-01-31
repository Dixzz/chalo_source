package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.b1;
import defpackage.e8;
import java.lang.ref.WeakReference;

/* renamed from: n0  reason: default package */
/* compiled from: AppCompatDialog */
public class n0 extends Dialog implements g0 {
    public h0 f;
    public final e8.a g;

    /* renamed from: n0$a */
    /* compiled from: AppCompatDialog */
    public class a implements e8.a {
        public a() {
        }

        @Override // defpackage.e8.a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return n0.this.b(keyEvent);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n0(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            if (r6 != 0) goto L_0x0014
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.res.Resources$Theme r2 = r5.getTheme()
            int r3 = androidx.appcompat.R.attr.dialogTheme
            r2.resolveAttribute(r3, r1, r0)
            int r1 = r1.resourceId
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r4.<init>(r5, r1)
            n0$a r1 = new n0$a
            r1.<init>()
            r4.g = r1
            h0 r1 = r4.a()
            if (r6 != 0) goto L_0x0035
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            int r2 = androidx.appcompat.R.attr.dialogTheme
            r5.resolveAttribute(r2, r6, r0)
            int r6 = r6.resourceId
        L_0x0035:
            r1.x(r6)
            r5 = 0
            r1.k(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n0.<init>(android.content.Context, int):void");
    }

    public h0 a() {
        if (this.f == null) {
            p2<WeakReference<h0>> p2Var = h0.f;
            this.f = new i0(getContext(), getWindow(), this, this);
        }
        return this.f;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    public boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean c(int i) {
        return a().s(i);
    }

    public void dismiss() {
        super.dismiss();
        a().l();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return e8.b(this.g, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().c(i);
    }

    public void invalidateOptionsMenu() {
        a().i();
    }

    public void onCreate(Bundle bundle) {
        a().h();
        super.onCreate(bundle);
        a().k(bundle);
    }

    public void onStop() {
        super.onStop();
        a().q();
    }

    @Override // defpackage.g0
    public void onSupportActionModeFinished(b1 b1Var) {
    }

    @Override // defpackage.g0
    public void onSupportActionModeStarted(b1 b1Var) {
    }

    @Override // defpackage.g0
    public b1 onWindowStartingSupportActionMode(b1.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().t(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().y(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().u(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().v(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().y(getContext().getString(i));
    }
}
