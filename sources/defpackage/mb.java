package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.eb;
import defpackage.fb;
import defpackage.gb;
import defpackage.kb;
import defpackage.xb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

/* renamed from: mb  reason: default package */
/* compiled from: PreferencesSerializer.kt */
public final class mb implements sa<kb> {

    /* renamed from: a  reason: collision with root package name */
    public static final mb f2347a = new mb();

    /* renamed from: mb$a */
    /* compiled from: PreferencesSerializer.kt */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2348a = {1, 2, 4, 5, 6, 7, 3, 8};

        static {
            gb.b.values();
            gb.b bVar = gb.b.BOOLEAN;
            gb.b bVar2 = gb.b.FLOAT;
            gb.b bVar3 = gb.b.DOUBLE;
            gb.b bVar4 = gb.b.INTEGER;
            gb.b bVar5 = gb.b.LONG;
            gb.b bVar6 = gb.b.STRING;
            gb.b bVar7 = gb.b.STRING_SET;
            gb.b bVar8 = gb.b.VALUE_NOT_SET;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.sa
    public kb a() {
        return new hb(null, true, 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.io.OutputStream, k66] */
    @Override // defpackage.sa
    public Object b(kb kbVar, OutputStream outputStream, k66 k66) {
        kc kcVar;
        Map<kb.a<?>, Object> a2 = kbVar.a();
        eb.a q = eb.q();
        for (Map.Entry<kb.a<?>, Object> entry : a2.entrySet()) {
            Object value = entry.getValue();
            String str = entry.getKey().f2041a;
            if (value instanceof Boolean) {
                gb.a E = gb.E();
                boolean booleanValue = ((Boolean) value).booleanValue();
                E.d();
                gb.s((gb) E.g, booleanValue);
                kcVar = E.b();
                n86.d(kcVar, "newBuilder().setBoolean(value).build()");
            } else if (value instanceof Float) {
                gb.a E2 = gb.E();
                float floatValue = ((Number) value).floatValue();
                E2.d();
                gb.t((gb) E2.g, floatValue);
                kcVar = E2.b();
                n86.d(kcVar, "newBuilder().setFloat(value).build()");
            } else if (value instanceof Double) {
                gb.a E3 = gb.E();
                double doubleValue = ((Number) value).doubleValue();
                E3.d();
                gb.q((gb) E3.g, doubleValue);
                kcVar = E3.b();
                n86.d(kcVar, "newBuilder().setDouble(value).build()");
            } else if (value instanceof Integer) {
                gb.a E4 = gb.E();
                int intValue = ((Number) value).intValue();
                E4.d();
                gb.u((gb) E4.g, intValue);
                kcVar = E4.b();
                n86.d(kcVar, "newBuilder().setInteger(value).build()");
            } else if (value instanceof Long) {
                gb.a E5 = gb.E();
                long longValue = ((Number) value).longValue();
                E5.d();
                gb.n((gb) E5.g, longValue);
                kcVar = E5.b();
                n86.d(kcVar, "newBuilder().setLong(value).build()");
            } else if (value instanceof String) {
                gb.a E6 = gb.E();
                E6.d();
                gb.o((gb) E6.g, (String) value);
                kcVar = E6.b();
                n86.d(kcVar, "newBuilder().setString(value).build()");
            } else if (value instanceof Set) {
                gb.a E7 = gb.E();
                fb.a r = fb.r();
                r.d();
                fb.o((fb) r.g, (Set) value);
                E7.d();
                gb.p((gb) E7.g, r);
                kcVar = E7.b();
                n86.d(kcVar, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
            } else {
                throw new IllegalStateException(n86.j("PreferencesSerializer does not support type: ", value.getClass().getName()));
            }
            Objects.requireNonNull(q);
            Objects.requireNonNull(str);
            q.d();
            ((xc) eb.o((eb) q.g)).put(str, (gb) kcVar);
        }
        eb ebVar = (eb) q.b();
        int serializedSize = ebVar.getSerializedSize();
        Logger logger = xb.b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        xb.e eVar = new xb.e(outputStream, serializedSize);
        ebVar.a(eVar);
        if (eVar.f > 0) {
            eVar.f0();
        }
        return s56.f3190a;
    }

    @Override // defpackage.sa
    public Object c(InputStream inputStream, k66<? super kb> k66) throws IOException, ga {
        n86.e(inputStream, "input");
        try {
            eb r = eb.r(inputStream);
            n86.d(r, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
            kb.b[] bVarArr = new kb.b[0];
            n86.e(bVarArr, "pairs");
            hb hbVar = new hb(null, false, 1);
            kb.b[] bVarArr2 = (kb.b[]) Arrays.copyOf(bVarArr, 0);
            n86.e(bVarArr2, "pairs");
            hbVar.b();
            for (kb.b bVar : bVarArr2) {
                Objects.requireNonNull(bVar);
                hbVar.d(null, null);
            }
            Map<String, gb> p = r.p();
            n86.d(p, "preferencesProto.preferencesMap");
            for (Map.Entry<String, gb> entry : p.entrySet()) {
                String key = entry.getKey();
                gb value = entry.getValue();
                n86.d(key, "name");
                n86.d(value, FirebaseAnalytics.Param.VALUE);
                gb.b D = value.D();
                switch (D == null ? -1 : a.f2348a[D.ordinal()]) {
                    case -1:
                        throw new ga("Value case is null.", null, 2);
                    case 0:
                    default:
                        throw new l56();
                    case 1:
                        hbVar.c(hj1.i(key, "name", key), Boolean.valueOf(value.v()));
                        break;
                    case 2:
                        hbVar.c(hj1.i(key, "name", key), Float.valueOf(value.y()));
                        break;
                    case 3:
                        hbVar.c(hj1.i(key, "name", key), Double.valueOf(value.x()));
                        break;
                    case 4:
                        hbVar.c(hj1.i(key, "name", key), Integer.valueOf(value.z()));
                        break;
                    case 5:
                        hbVar.c(hj1.i(key, "name", key), Long.valueOf(value.A()));
                        break;
                    case 6:
                        kb.a i = hj1.i(key, "name", key);
                        String B = value.B();
                        n86.d(B, "value.string");
                        hbVar.c(i, B);
                        break;
                    case 7:
                        kb.a i2 = hj1.i(key, "name", key);
                        List<String> q = value.C().q();
                        n86.d(q, "value.stringSet.stringsList");
                        hbVar.c(i2, y56.D(q));
                        break;
                    case 8:
                        throw new ga("Value not set.", null, 2);
                }
            }
            return new hb(y56.C(hbVar.a()), true);
        } catch (nc e) {
            throw new ga("Unable to parse preferences proto.", e);
        }
    }
}
