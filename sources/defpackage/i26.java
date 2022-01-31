package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: i26  reason: default package */
/* compiled from: ViewPump.kt */
public final class i26 {
    public static i26 e;
    public static final j56 f = hd3.a2(a.f);
    public static final b g = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public final List<h26> f1466a;
    public final List<h26> b;
    public final boolean c;
    public final boolean d;

    /* renamed from: i26$a */
    /* compiled from: ViewPump.kt */
    public static final class a extends o86 implements h76<n26> {
        public static final a f = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public n26 invoke() {
            return new n26();
        }
    }

    /* renamed from: i26$b */
    /* compiled from: ViewPump.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ s96[] f1467a;

        static {
            r86 r86 = new r86(z86.a(b.class), "reflectiveFallbackViewCreator", "getReflectiveFallbackViewCreator()Lio/github/inflationx/viewpump/FallbackViewCreator;");
            Objects.requireNonNull(z86.f4146a);
            f1467a = new s96[]{r86};
        }

        public b() {
        }

        public final i26 a() {
            i26 i26 = i26.e;
            if (i26 != null) {
                return i26;
            }
            i26 i262 = new i26(y56.y(new ArrayList()), true, true, false, null);
            i26.e = i262;
            return i262;
        }

        public b(j86 j86) {
        }
    }

    public i26(List list, boolean z, boolean z2, boolean z3, j86 j86) {
        this.b = list;
        this.c = z;
        this.d = z2;
        this.f1466a = y56.B(y56.s(list, new l26()));
    }

    public final g26 a(f26 f26) {
        n86.f(f26, "originalRequest");
        List<h26> list = this.f1466a;
        n86.f(list, "interceptors");
        n86.f(f26, "request");
        n86.f(f26, "request");
        if (list.size() > 0) {
            return list.get(0).intercept(new m26(list, 1, f26));
        }
        throw new AssertionError("no interceptors added to the chain");
    }
}
