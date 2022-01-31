package defpackage;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import app.zophop.R;

/* renamed from: tn0  reason: default package */
/* compiled from: ZophopReportFragment */
public class tn0 extends ng1 {
    public String g;
    public String h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;

    public static void b(FragmentManager fragmentManager, String str, String str2) {
        tn0 tn0 = new tn0();
        Bundle bundle = new Bundle();
        bundle.putString("extra:request", str);
        bundle.putString("extra:from", str2);
        tn0.setArguments(bundle);
        tn0.show(fragmentManager, "ReportFragmentTag");
    }

    @Override // defpackage.ng1
    public void a() {
        b00 b00 = b00.f358a;
        c00 a2 = b00.a();
        StringBuilder l0 = hj1.l0("reportIssue:feedback=>", ((Object) ((EditText) getView().findViewById(R.id.report_feedback)).getText()) + "", " from class=> ");
        l0.append(this.h);
        l0.append("\ntripRequest=>");
        l0.append(this.g);
        a2.b(new Throwable(l0.toString()));
        dismiss();
        Toast.makeText(getActivity(), getString(R.string.response_submitted_toast), 0).show();
    }
}
