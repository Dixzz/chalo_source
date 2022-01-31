package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.fb;
import defpackage.kc;
import java.util.Objects;

/* renamed from: gb  reason: default package */
/* compiled from: PreferencesProto */
public final class gb extends kc<gb, a> implements Object {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final gb DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile kd<gb> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    /* renamed from: gb$a */
    /* compiled from: PreferencesProto */
    public static final class a extends kc.a<gb, a> implements Object {
        public a() {
            super(gb.DEFAULT_INSTANCE);
        }

        public a(db dbVar) {
            super(gb.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: gb$b */
    /* compiled from: PreferencesProto */
    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);
        
        private final int value;

        private b(int i) {
            this.value = i;
        }

        public static b forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static b valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        gb gbVar = new gb();
        DEFAULT_INSTANCE = gbVar;
        kc.m(gb.class, gbVar);
    }

    public static a E() {
        return (a) DEFAULT_INSTANCE.e();
    }

    public static void n(gb gbVar, long j) {
        gbVar.valueCase_ = 4;
        gbVar.value_ = Long.valueOf(j);
    }

    public static void o(gb gbVar, String str) {
        Objects.requireNonNull(gbVar);
        Objects.requireNonNull(str);
        gbVar.valueCase_ = 5;
        gbVar.value_ = str;
    }

    public static void p(gb gbVar, fb.a aVar) {
        Objects.requireNonNull(gbVar);
        gbVar.value_ = aVar.b();
        gbVar.valueCase_ = 6;
    }

    public static void q(gb gbVar, double d) {
        gbVar.valueCase_ = 7;
        gbVar.value_ = Double.valueOf(d);
    }

    public static void s(gb gbVar, boolean z) {
        gbVar.valueCase_ = 1;
        gbVar.value_ = Boolean.valueOf(z);
    }

    public static void t(gb gbVar, float f) {
        gbVar.valueCase_ = 2;
        gbVar.value_ = Float.valueOf(f);
    }

    public static void u(gb gbVar, int i) {
        gbVar.valueCase_ = 3;
        gbVar.value_ = Integer.valueOf(i);
    }

    public static gb w() {
        return DEFAULT_INSTANCE;
    }

    public long A() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0;
    }

    public String B() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public fb C() {
        if (this.valueCase_ == 6) {
            return (fb) this.value_;
        }
        return fb.p();
    }

    public b D() {
        return b.forNumber(this.valueCase_);
    }

    @Override // defpackage.kc
    public final Object g(kc.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new pd(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", fb.class});
            case 3:
                return new gb();
            case 4:
                return new a(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                kd<gb> kdVar = PARSER;
                if (kdVar == null) {
                    synchronized (gb.class) {
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

    public boolean v() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double x() {
        return this.valueCase_ == 7 ? ((Double) this.value_).doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public float y() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int z() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }
}
