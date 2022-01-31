package defpackage;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import app.zophop.models.Stop;
import app.zophop.pubsub.eventbus.events.CheckInDestinationUpdated;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: pp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class pp0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f2836a;

    public /* synthetic */ pp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f2836a = homeScreenMainFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        String str;
        HomeScreenMainFragment homeScreenMainFragment = this.f2836a;
        ActivityResult activityResult = (ActivityResult) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        if (activityResult.f == -1) {
            Intent intent = activityResult.g;
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("result_picked");
            }
            if (str != null) {
                Stop stop = (Stop) hj1.s(str, Stop.class);
                pa1 k = homeScreenMainFragment.k();
                if (stop != null) {
                    k.b.c.e.setText(stop.getName());
                }
                k.c(-1);
                jz5.b().g(new CheckInDestinationUpdated(stop));
            }
        }
    }
}
