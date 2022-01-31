package defpackage;

import android.os.Bundle;
import android.view.View;

/* renamed from: gv0  reason: default package */
/* compiled from: LoadingSpinnerFragment.kt */
public final class gv0 extends ue {
    public static final /* synthetic */ int g = 0;
    public ly f;

    /* renamed from: gv0$a */
    /* compiled from: LoadingSpinnerFragment.kt */
    public interface a {
        void t();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        if (r11.getBoolean("show_negative_button") != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r23, android.view.ViewGroup r24, android.os.Bundle r25) {
        /*
        // Method dump skipped, instructions count: 507
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gv0.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        ly lyVar = this.f;
        if (lyVar != null) {
            lyVar.g.setVisibility(0);
            ly lyVar2 = this.f;
            if (lyVar2 != null) {
                lyVar2.g.d();
            } else {
                n86.l("viewBinding");
                throw null;
            }
        } else {
            n86.l("viewBinding");
            throw null;
        }
    }
}
