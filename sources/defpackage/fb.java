package defpackage;

import defpackage.kc;
import defpackage.mc;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* renamed from: fb  reason: default package */
/* compiled from: PreferencesProto */
public final class fb extends kc<fb, a> implements Object {
    private static final fb DEFAULT_INSTANCE;
    private static volatile kd<fb> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private mc.c<String> strings_ = od.i;

    /* renamed from: fb$a */
    /* compiled from: PreferencesProto */
    public static final class a extends kc.a<fb, a> implements Object {
        public a() {
            super(fb.DEFAULT_INSTANCE);
        }

        public a(db dbVar) {
            super(fb.DEFAULT_INSTANCE);
        }
    }

    static {
        fb fbVar = new fb();
        DEFAULT_INSTANCE = fbVar;
        kc.m(fb.class, fbVar);
    }

    public static void o(fb fbVar, Iterable iterable) {
        if (!fbVar.strings_.t()) {
            mc.c<String> cVar = fbVar.strings_;
            int size = cVar.size();
            fbVar.strings_ = cVar.f(size == 0 ? 10 : size * 2);
        }
        List list = fbVar.strings_;
        Charset charset = mc.f2352a;
        Objects.requireNonNull(iterable);
        if (iterable instanceof sc) {
            List<?> m = ((sc) iterable).m();
            sc scVar = (sc) list;
            int size2 = list.size();
            for (Object obj : m) {
                if (obj == null) {
                    StringBuilder i0 = hj1.i0("Element at index ");
                    i0.append(scVar.size() - size2);
                    i0.append(" is null.");
                    String sb = i0.toString();
                    int size3 = scVar.size();
                    while (true) {
                        size3--;
                        if (size3 >= size2) {
                            scVar.remove(size3);
                        } else {
                            throw new NullPointerException(sb);
                        }
                    }
                } else if (obj instanceof ub) {
                    scVar.Z((ub) obj);
                } else {
                    scVar.add((String) obj);
                }
            }
        } else if (iterable instanceof ld) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size4 = list.size();
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    StringBuilder i02 = hj1.i0("Element at index ");
                    i02.append(list.size() - size4);
                    i02.append(" is null.");
                    String sb2 = i02.toString();
                    int size5 = list.size();
                    while (true) {
                        size5--;
                        if (size5 >= size4) {
                            list.remove(size5);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else {
                    list.add(obj2);
                }
            }
        }
    }

    public static fb p() {
        return DEFAULT_INSTANCE;
    }

    public static a r() {
        return (a) DEFAULT_INSTANCE.e();
    }

    @Override // defpackage.kc
    public final Object g(kc.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new pd(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new fb();
            case 4:
                return new a(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                kd<fb> kdVar = PARSER;
                if (kdVar == null) {
                    synchronized (fb.class) {
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

    public List<String> q() {
        return this.strings_;
    }
}
