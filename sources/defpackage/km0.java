package defpackage;

import android.os.Bundle;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: km0  reason: default package */
/* compiled from: CheckInEndDialog.kt */
public final class km0 extends hm0 {
    public static final /* synthetic */ int q = 0;
    public a p;

    /* renamed from: km0$a */
    /* compiled from: CheckInEndDialog.kt */
    public enum a {
        DESTINAITON_REACHED,
        MANUAL,
        SERVER_ERROR
    }

    /* renamed from: km0$b */
    /* compiled from: CheckInEndDialog.kt */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2078a = {1, 3, 2};

        static {
            a.values();
            a aVar = a.DESTINAITON_REACHED;
            a aVar2 = a.SERVER_ERROR;
            a aVar3 = a.MANUAL;
        }
    }

    public km0() {
        super(null, 1);
    }

    @Override // defpackage.hm0
    public void e(Bundle bundle) {
        String str;
        super.e(bundle);
        a aVar = null;
        if (bundle == null) {
            str = null;
        } else {
            str = bundle.getString("check_in_stop_source");
        }
        if (str != null) {
            aVar = a.valueOf(str);
        }
        this.p = aVar;
    }

    @Override // defpackage.hm0
    public void f() {
        String str;
        a aVar = this.p;
        int i = aVar == null ? -1 : b.f2078a[aVar.ordinal()];
        if (i == 1) {
            str = getString(R.string.check_in_dialog_title_proximity);
            n86.d(str, "getString(R.string.check…n_dialog_title_proximity)");
        } else if (i == 2) {
            str = getString(R.string.check_in_dialog_title_server);
            n86.d(str, "getString(R.string.check_in_dialog_title_server)");
        } else if (i != 3) {
            str = "";
        } else {
            str = getString(R.string.check_in_dialog_confirm);
            n86.d(str, "getString(R.string.check_in_dialog_confirm)");
        }
        T t = this.g;
        n86.c(t);
        ((ww) t).c.setText(str);
    }

    @Override // defpackage.hm0
    public void g() {
        a aVar = this.p;
        int i = aVar == null ? -1 : b.f2078a[aVar.ordinal()];
        if (i == 1) {
            T t = this.g;
            n86.c(t);
            ((ww) t).d.setVisibility(8);
        } else if (i == 2) {
            T t2 = this.g;
            n86.c(t2);
            ((ww) t2).d.setVisibility(8);
        } else if (i == 3) {
            T t3 = this.g;
            n86.c(t3);
            TextView textView = ((ww) t3).d;
            n86.d(textView, "");
            textView.setVisibility(0);
            String string = getString(R.string.cancel);
            n86.d(string, "getString(R.string.cancel)");
            String upperCase = string.toUpperCase();
            n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
            textView.setText(upperCase);
            textView.setOnClickListener(new am0(this));
        }
    }

    @Override // defpackage.hm0
    public void h() {
        a aVar = this.p;
        int i = aVar == null ? -1 : b.f2078a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            T t = this.g;
            n86.c(t);
            TextView textView = ((ww) t).e;
            textView.setText(getString(R.string.okay));
            textView.setOnClickListener(new bm0(this));
        } else if (i == 3) {
            T t2 = this.g;
            n86.c(t2);
            TextView textView2 = ((ww) t2).e;
            textView2.setText(getString(R.string.yes));
            textView2.setOnClickListener(new cm0(this));
        }
    }
}
