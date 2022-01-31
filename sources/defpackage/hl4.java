package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* renamed from: hl4  reason: default package */
/* compiled from: BottomSheetDialogFragment */
public class hl4 extends o0 {
    private boolean waitingForDismissAllowingStateLoss;

    /* renamed from: hl4$b */
    /* compiled from: BottomSheetDialogFragment */
    public class b extends BottomSheetBehavior.c {
        public b(a aVar) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void a(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void b(View view, int i) {
            if (i == 5) {
                hl4.this.dismissAfterAnimation();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.y == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof gl4) {
            gl4 gl4 = (gl4) getDialog();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = gl4.h;
            bottomSheetBehavior2.I.remove(gl4.m);
        }
        b bVar = new b(null);
        if (!bottomSheetBehavior.I.contains(bVar)) {
            bottomSheetBehavior.I.add(bVar);
        }
        bottomSheetBehavior.M(5);
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof gl4)) {
            return false;
        }
        boolean z2 = ((gl4) dialog).e().v;
        return false;
    }

    @Override // defpackage.ue
    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    @Override // defpackage.ue
    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // defpackage.ue, defpackage.o0
    public Dialog onCreateDialog(Bundle bundle) {
        return new gl4(getContext(), getTheme());
    }
}
