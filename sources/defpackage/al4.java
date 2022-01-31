package defpackage;

import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: al4  reason: default package */
/* compiled from: BottomAppBar */
public class al4 implements Runnable {
    public final /* synthetic */ ActionMenuView f;
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ BottomAppBar i;

    public al4(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.i = bottomAppBar;
        this.f = actionMenuView;
        this.g = i2;
        this.h = z;
    }

    public void run() {
        ActionMenuView actionMenuView = this.f;
        actionMenuView.setTranslationX((float) this.i.e(actionMenuView, this.g, this.h));
    }
}
