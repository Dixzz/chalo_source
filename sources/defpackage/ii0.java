package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.SuggestNextCityActivity;

/* renamed from: ii0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ii0 implements View.OnClickListener {
    public final /* synthetic */ wi0 f;

    public /* synthetic */ ii0(wi0 wi0) {
        this.f = wi0;
    }

    public final void onClick(View view) {
        wi0 wi0 = this.f;
        n86.e(wi0, "this$0");
        Activity activity = (Activity) wi0.c;
        n86.e(activity, "launcherActivity");
        activity.startActivity(new Intent(activity, SuggestNextCityActivity.class));
    }
}
