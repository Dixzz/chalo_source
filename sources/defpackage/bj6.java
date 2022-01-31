package defpackage;

/* renamed from: bj6  reason: default package */
/* compiled from: CacheStrategy.kt */
public final class bj6 {

    /* renamed from: a  reason: collision with root package name */
    public final ji6 f443a;
    public final ni6 b;

    public bj6(ji6 ji6, ni6 ni6) {
        this.f443a = ji6;
        this.b = ni6;
    }

    public static final boolean a(ni6 ni6, ji6 ji6) {
        n86.f(ni6, "response");
        n86.f(ji6, "request");
        int i = ni6.j;
        if (!(i == 200 || i == 410 || i == 414 || i == 501 || i == 203 || i == 204)) {
            if (i != 307) {
                if (!(i == 308 || i == 404 || i == 405)) {
                    switch (i) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (ni6.c(ni6, "Expires", null, 2) == null && ni6.a().c == -1 && !ni6.a().f && !ni6.a().e) {
                return false;
            }
        }
        if (ni6.a().b || ji6.a().b) {
            return false;
        }
        return true;
    }
}
