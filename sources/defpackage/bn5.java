package defpackage;

import android.net.Uri;
import com.urbanairship.iam.InAppMessage;
import defpackage.bz5;
import defpackage.do5;
import defpackage.gm5;
import java.util.Objects;

/* renamed from: bn5  reason: default package */
/* compiled from: InAppAutomation */
public class bn5 implements bz5.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ln5 f454a;
    public final /* synthetic */ pn5 b;
    public final /* synthetic */ gm5.b c;
    public final /* synthetic */ dn5 d;

    public bn5(dn5 dn5, ln5 ln5, pn5 pn5, gm5.b bVar) {
        this.d = dn5;
        this.f454a = ln5;
        this.b = pn5;
        this.c = bVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.bz5.c
    public int run() {
        String str = this.f454a.o;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1161803523:
                if (str.equals("actions")) {
                    c2 = 0;
                    break;
                }
                break;
            case -379237425:
                if (str.equals("in_app_message")) {
                    c2 = 1;
                    break;
                }
                break;
            case 647890911:
                if (str.equals("deferred")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                dn5 dn5 = this.d;
                ln5 ln5 = this.f454a;
                em5 em5 = this.d.o;
                gm5.b bVar = this.c;
                Objects.requireNonNull(dn5);
                em5.b.put(ln5.f2243a, (vn5) ln5.a());
                dn5.q.put(ln5.f2243a, em5);
                bVar.a(0);
                return 0;
            case 1:
                dn5 dn52 = this.d;
                ln5 ln52 = this.f454a;
                hn5 hn5 = this.d.p;
                gm5.b bVar2 = this.c;
                Objects.requireNonNull(dn52);
                hn5.g(ln52, (InAppMessage) ln52.a(), new cn5(dn52, ln52, hn5, bVar2));
                break;
            case 2:
                dn5 dn53 = this.d;
                ln5<? extends mn5> ln53 = this.f454a;
                pn5 pn5 = this.b;
                gm5.b bVar3 = this.c;
                Objects.requireNonNull(dn53);
                co5 co5 = (co5) ln53.a();
                String l = dn53.g.l();
                if (l != null) {
                    try {
                        do5 do5 = dn53.l;
                        Uri uri = co5.f;
                        dp5 dp5 = dn53.j;
                        Objects.requireNonNull(dp5.e);
                        tq5<do5.c> a2 = do5.a(uri, l, pn5, dp5.d(System.currentTimeMillis() - dp5.f878a.e("com.urbanairship.iam.tags.TAG_PREFER_LOCAL_DATA_TIME", 600000)), dn53.j.c());
                        if (!a2.c()) {
                            yj5.a("Failed to resolve deferred schedule, will retry. Schedule: %s, Response: %s", ln53.f2243a, a2);
                        } else {
                            T t = a2.e;
                            if (!t.f871a) {
                                bVar3.a(dn53.m(ln53));
                                return 2;
                            }
                            InAppMessage inAppMessage = t.b;
                            if (inAppMessage != null) {
                                hn5 hn52 = dn53.p;
                                hn52.g(ln53, inAppMessage, new cn5(dn53, ln53, hn52, bVar3));
                            } else {
                                bVar3.a(2);
                            }
                            return 0;
                        }
                    } catch (rq5 e) {
                        if (co5.g) {
                            yj5.b(e, "Failed to resolve deferred schedule, will retry. Schedule: %s", ln53.f2243a);
                            return 1;
                        }
                        yj5.b(e, "Failed to resolve deferred schedule. Schedule: %s", ln53.f2243a);
                        bVar3.a(2);
                    } catch (zn5 e2) {
                        yj5.b(e2, "Failed to resolve deferred schedule: %s", ln53.f2243a);
                        return 1;
                    }
                }
                return 1;
        }
        return 0;
    }
}
