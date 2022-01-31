package defpackage;

import defpackage.kc;
import defpackage.vb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* renamed from: eb  reason: default package */
/* compiled from: PreferencesProto */
public final class eb extends kc<eb, a> implements Object {
    private static final eb DEFAULT_INSTANCE;
    private static volatile kd<eb> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private xc<String, gb> preferences_ = xc.g;

    /* renamed from: eb$a */
    /* compiled from: PreferencesProto */
    public static final class a extends kc.a<eb, a> implements Object {
        public a() {
            super(eb.DEFAULT_INSTANCE);
        }

        public a(db dbVar) {
            super(eb.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: eb$b */
    /* compiled from: PreferencesProto */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final wc<String, gb> f951a = new wc<>(fe.STRING, "", fe.MESSAGE, gb.w());
    }

    static {
        eb ebVar = new eb();
        DEFAULT_INSTANCE = ebVar;
        kc.m(eb.class, ebVar);
    }

    public static Map o(eb ebVar) {
        xc<String, gb> xcVar = ebVar.preferences_;
        if (!xcVar.f) {
            ebVar.preferences_ = xcVar.c();
        }
        return ebVar.preferences_;
    }

    public static a q() {
        return (a) DEFAULT_INSTANCE.e();
    }

    public static eb r(InputStream inputStream) throws IOException {
        kc l = kc.l(DEFAULT_INSTANCE, new vb.c(inputStream, 4096, null), cc.a());
        if (l == null || l.isInitialized()) {
            return (eb) l;
        }
        throw new nc(new xd().getMessage());
    }

    @Override // defpackage.kc
    public final Object g(kc.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new pd(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f951a});
            case 3:
                return new eb();
            case 4:
                return new a(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                kd<eb> kdVar = PARSER;
                if (kdVar == null) {
                    synchronized (eb.class) {
                        kdVar = PARSER;
                        if (kdVar == null) {
                            kdVar = new kc.b<>(DEFAULT_INSTANCE);
                            PARSER = kdVar;
                        }
                    }
                }
                return kdVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Map<String, gb> p() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
