package defpackage;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: mg1  reason: default package */
/* compiled from: ReportFragment */
public class mg1 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ng1 f2372a;

    public mg1(ng1 ng1) {
        this.f2372a = ng1;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f2372a.a();
        return true;
    }
}
