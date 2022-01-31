package defpackage;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import defpackage.n1;
import defpackage.v1;

/* renamed from: q1  reason: default package */
/* compiled from: MenuDialogHelper */
public class q1 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, v1.a {
    public p1 f;
    public e0 g;
    public n1 h;

    public q1(p1 p1Var) {
        this.f = p1Var;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f.r(((n1.a) this.h.a()).getItem(i), 0);
    }

    @Override // defpackage.v1.a
    public void onCloseMenu(p1 p1Var, boolean z) {
        e0 e0Var;
        if ((z || p1Var == this.f) && (e0Var = this.g) != null) {
            e0Var.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        n1 n1Var = this.h;
        p1 p1Var = this.f;
        v1.a aVar = n1Var.k;
        if (aVar != null) {
            aVar.onCloseMenu(p1Var, true);
        }
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.g.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.g.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.v1.a
    public boolean onOpenSubMenu(p1 p1Var) {
        return false;
    }
}
