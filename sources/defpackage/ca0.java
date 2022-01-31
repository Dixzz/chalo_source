package defpackage;

import android.net.Uri;
import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.ui.activities.ReportProblemActivity;
import app.zophop.ui.activities.WebViewActivity;
import defpackage.xt;

/* renamed from: ca0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ca0 implements View.OnClickListener {
    public final /* synthetic */ ReportProblemActivity f;
    public final /* synthetic */ lm0 g;

    public /* synthetic */ ca0(ReportProblemActivity reportProblemActivity, lm0 lm0) {
        this.f = reportProblemActivity;
        this.g = lm0;
    }

    public final void onClick(View view) {
        ReportProblemActivity reportProblemActivity = this.f;
        lm0 lm0 = this.g;
        ReportProblemActivity.a aVar = ReportProblemActivity.r;
        n86.e(reportProblemActivity, "this$0");
        Uri.Builder builder = new Uri.Builder();
        String f2 = xt.f3961a.t().f("reclaimPassesRequestUrl");
        n86.d(f2, "DependencyFactory.getFir…_RECLAIM_REQUEST_URL_KEY)");
        int length = f2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = n86.g(f2.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        Uri.Builder encodedPath = builder.encodedPath(f2.subSequence(i, length + 1).toString());
        StringBuilder sb = new StringBuilder();
        xt.t1 t1Var = xt.f3961a;
        UserProfile e = t1Var.L().e();
        if (e != null) {
            if (e.getFirstName() != null) {
                sb.append(e.getFirstName());
            }
            if (e.getLastName() != null) {
                sb.append(" ");
                sb.append(e.getLastName());
            }
        }
        String sb2 = sb.toString();
        n86.d(sb2, "nameBuilder.toString()");
        encodedPath.appendQueryParameter("entry.1987039175", sb2).appendQueryParameter("entry.58353678", t1Var.L().getUserId());
        String uri = builder.build().toString();
        n86.d(uri, "builder.build().toString()");
        WebViewActivity.h0(reportProblemActivity, uri, reportProblemActivity.getString(R.string.app_name), false, false);
        lm0.dismiss();
    }
}
