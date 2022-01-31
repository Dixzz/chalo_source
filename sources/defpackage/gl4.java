package defpackage;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: gl4  reason: default package */
/* compiled from: BottomSheetDialog */
public class gl4 extends n0 {
    public BottomSheetBehavior<FrameLayout> h;
    public FrameLayout i;
    public boolean j;
    public boolean k;
    public boolean l;
    public BottomSheetBehavior.c m;

    /* renamed from: gl4$a */
    /* compiled from: BottomSheetDialog */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            gl4 gl4 = gl4.this;
            if (gl4.j && gl4.isShowing()) {
                gl4 gl42 = gl4.this;
                if (!gl42.l) {
                    TypedArray obtainStyledAttributes = gl42.getContext().obtainStyledAttributes(new int[]{16843611});
                    gl42.k = obtainStyledAttributes.getBoolean(0, true);
                    obtainStyledAttributes.recycle();
                    gl42.l = true;
                }
                if (gl42.k) {
                    gl4.this.cancel();
                }
            }
        }
    }

    /* renamed from: gl4$b */
    /* compiled from: BottomSheetDialog */
    public class b extends z7 {
        public b() {
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            if (gl4.this.j) {
                e9Var.f942a.addAction(CommonUtils.BYTES_IN_A_MEGABYTE);
                e9Var.f942a.setDismissable(true);
                return;
            }
            e9Var.f942a.setDismissable(false);
        }

        @Override // defpackage.z7
        public boolean g(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                gl4 gl4 = gl4.this;
                if (gl4.j) {
                    gl4.cancel();
                    return true;
                }
            }
            return super.g(view, i, bundle);
        }
    }

    /* renamed from: gl4$c */
    /* compiled from: BottomSheetDialog */
    public class c implements View.OnTouchListener {
        public c(gl4 gl4) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: gl4$d */
    /* compiled from: BottomSheetDialog */
    public class d extends BottomSheetBehavior.c {
        public d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void a(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void b(View view, int i) {
            if (i == 5) {
                gl4.this.cancel();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public gl4(android.content.Context r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 != 0) goto L_0x0019
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources$Theme r1 = r4.getTheme()
            int r2 = com.google.android.material.R.attr.bottomSheetDialogTheme
            boolean r1 = r1.resolveAttribute(r2, r5, r0)
            if (r1 == 0) goto L_0x0017
            int r5 = r5.resourceId
            goto L_0x0019
        L_0x0017:
            int r5 = com.google.android.material.R.style.Theme_Design_Light_BottomSheetDialog
        L_0x0019:
            r3.<init>(r4, r5)
            r3.j = r0
            r3.k = r0
            gl4$d r4 = new gl4$d
            r4.<init>()
            r3.m = r4
            r3.c(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gl4.<init>(android.content.Context, int):void");
    }

    public void cancel() {
        e();
        super.cancel();
    }

    public final FrameLayout d() {
        if (this.i == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.i = frameLayout;
            BottomSheetBehavior<FrameLayout> H = BottomSheetBehavior.H((FrameLayout) frameLayout.findViewById(R.id.design_bottom_sheet));
            this.h = H;
            H.B(this.m);
            this.h.K(this.j);
        }
        return this.i;
    }

    public BottomSheetBehavior<FrameLayout> e() {
        if (this.h == null) {
            d();
        }
        return this.h;
    }

    public final View f(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        d();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.i.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.i.findViewById(R.id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new a());
        r8.v(frameLayout, new b());
        frameLayout.setOnTouchListener(new c(this));
        return this.i;
    }

    @Override // defpackage.n0
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(RtlSpacingHelper.UNDEFINED);
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.h;
        if (bottomSheetBehavior != null && bottomSheetBehavior.y == 5) {
            bottomSheetBehavior.M(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.j != z) {
            this.j = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.h;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.K(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.j) {
            this.j = true;
        }
        this.k = z;
        this.l = true;
    }

    @Override // defpackage.n0, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(f(i2, null, null));
    }

    @Override // defpackage.n0, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(f(0, view, null));
    }

    @Override // defpackage.n0
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(f(0, view, layoutParams));
    }
}
