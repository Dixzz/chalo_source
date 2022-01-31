package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.UAirship;
import com.urbanairship.actions.WalletLoadingActivity;
import java.util.List;
import java.util.Map;

/* renamed from: al5  reason: default package */
/* compiled from: WalletLoadingActivity */
public class al5 implements Runnable {
    public final /* synthetic */ Uri f;
    public final /* synthetic */ WalletLoadingActivity g;

    /* renamed from: al5$a */
    /* compiled from: WalletLoadingActivity */
    public class a implements uq5<String> {
        public a(al5 al5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public String a(int i, Map map, String str) throws Exception {
            if (!(i / 100 == 3) || map == null || map.get("Location") == null) {
                return null;
            }
            return (String) ((List) map.get("Location")).get(0);
        }
    }

    public al5(WalletLoadingActivity walletLoadingActivity, Uri uri) {
        this.g = walletLoadingActivity;
        this.f = uri;
    }

    public void run() {
        try {
            yj5.a("Runner starting", new Object[0]);
            qq5 qq5 = new qq5();
            Uri uri = this.f;
            qq5.d = FirebasePerformance.HttpMethod.GET;
            qq5.f2981a = uri;
            qq5.i = false;
            qq5.e(UAirship.l().q);
            tq5 b = qq5.b(new a(this));
            if (b.e != null) {
                this.g.h.j(new WalletLoadingActivity.b(Uri.parse(b.a("Location")), null));
                return;
            }
            yj5.i("No result found for Wallet URL, finishing action.", new Object[0]);
            this.g.h.j(new WalletLoadingActivity.b(null, null));
        } catch (rq5 e) {
            this.g.h.j(new WalletLoadingActivity.b(null, e));
        }
    }
}
