package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* renamed from: zu0  reason: default package */
/* compiled from: LanguageSelectSplashScreen.kt */
public final class zu0 extends BottomSheetBehavior.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior<LinearLayout> f4214a;

    public zu0(BottomSheetBehavior<LinearLayout> bottomSheetBehavior) {
        this.f4214a = bottomSheetBehavior;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
    public void a(View view, float f) {
        n86.e(view, "view");
        this.f4214a.M(3);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
    public void b(View view, int i) {
        n86.e(view, "view");
        this.f4214a.M(3);
    }
}
