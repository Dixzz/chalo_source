package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import app.zophop.R;

/* renamed from: la1  reason: default package */
/* compiled from: AlertInfoView */
public class la1 implements View.OnClickListener {
    public final /* synthetic */ na1 f;

    public la1(na1 na1) {
        this.f = na1;
    }

    public void onClick(View view) {
        Activity activity = this.f.l;
        String packageName = activity.getPackageName();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", activity.getString(R.string.zophop_recommend_subject));
        intent.putExtra("android.intent.extra.TEXT", String.format(activity.getString(R.string.zophop_recommend_text), xt.f3961a.P().a(packageName)));
        intent.setType("text/plain");
        activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.invite_friend)));
    }
}
