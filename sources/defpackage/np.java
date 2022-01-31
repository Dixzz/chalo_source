package defpackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: np  reason: default package */
/* compiled from: Data */
public final class np {
    public static final String b = tp.e("Data");
    public static final np c;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f2585a;

    /* renamed from: np$a */
    /* compiled from: Data */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Object> f2586a = new HashMap();

        public np a() {
            np npVar = new np(this.f2586a);
            np.c(npVar);
            return npVar;
        }

        public a b(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.f2586a.put(key, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.f2586a.put(key, value);
                    } else {
                        int i = 0;
                        if (cls == boolean[].class) {
                            Map<String, Object> map2 = this.f2586a;
                            boolean[] zArr = (boolean[]) value;
                            String str = np.b;
                            Boolean[] boolArr = new Boolean[zArr.length];
                            while (i < zArr.length) {
                                boolArr[i] = Boolean.valueOf(zArr[i]);
                                i++;
                            }
                            map2.put(key, boolArr);
                        } else if (cls == byte[].class) {
                            Map<String, Object> map3 = this.f2586a;
                            byte[] bArr = (byte[]) value;
                            String str2 = np.b;
                            Byte[] bArr2 = new Byte[bArr.length];
                            while (i < bArr.length) {
                                bArr2[i] = Byte.valueOf(bArr[i]);
                                i++;
                            }
                            map3.put(key, bArr2);
                        } else if (cls == int[].class) {
                            Map<String, Object> map4 = this.f2586a;
                            int[] iArr = (int[]) value;
                            String str3 = np.b;
                            Integer[] numArr = new Integer[iArr.length];
                            while (i < iArr.length) {
                                numArr[i] = Integer.valueOf(iArr[i]);
                                i++;
                            }
                            map4.put(key, numArr);
                        } else if (cls == long[].class) {
                            Map<String, Object> map5 = this.f2586a;
                            long[] jArr = (long[]) value;
                            String str4 = np.b;
                            Long[] lArr = new Long[jArr.length];
                            while (i < jArr.length) {
                                lArr[i] = Long.valueOf(jArr[i]);
                                i++;
                            }
                            map5.put(key, lArr);
                        } else if (cls == float[].class) {
                            Map<String, Object> map6 = this.f2586a;
                            float[] fArr = (float[]) value;
                            String str5 = np.b;
                            Float[] fArr2 = new Float[fArr.length];
                            while (i < fArr.length) {
                                fArr2[i] = Float.valueOf(fArr[i]);
                                i++;
                            }
                            map6.put(key, fArr2);
                        } else if (cls == double[].class) {
                            Map<String, Object> map7 = this.f2586a;
                            double[] dArr = (double[]) value;
                            String str6 = np.b;
                            Double[] dArr2 = new Double[dArr.length];
                            while (i < dArr.length) {
                                dArr2[i] = Double.valueOf(dArr[i]);
                                i++;
                            }
                            map7.put(key, dArr2);
                        } else {
                            throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                        }
                    }
                }
            }
            return this;
        }
    }

    static {
        np npVar = new np(new HashMap());
        c(npVar);
        c = npVar;
    }

    public np() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(2:18|19)|20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|(7:3|4|5|6|(2:8|9)|10|11)|27|28|29|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.np a(byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x004c
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x003d, all -> 0x0033 }
            r2.<init>(r1)     // Catch:{ IOException | ClassNotFoundException -> 0x003d, all -> 0x0033 }
            int r5 = r2.readInt()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
        L_0x0019:
            if (r5 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            r0.put(r3, r4)     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            int r5 = r5 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0043
        L_0x002d:
            r5 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x0034
        L_0x0031:
            r5 = r2
            goto L_0x003e
        L_0x0033:
            r0 = move-exception
        L_0x0034:
            if (r5 == 0) goto L_0x0039
            r5.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            throw r0
        L_0x003d:
        L_0x003e:
            if (r5 == 0) goto L_0x0043
            r5.close()
        L_0x0043:
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            np r5 = new np
            r5.<init>(r0)
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.np.a(byte[]):np");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|(2:34|35)|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|21|24|25|(0)|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|(2:7|5)|8|9|10|11|13|(2:15|16)(2:17|18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[SYNTHETIC, Splitter:B:27:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC, Splitter:B:34:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(defpackage.np r4) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.np.c(np):byte[]");
    }

    public String b(String str) {
        Object obj = this.f2585a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || np.class != obj.getClass()) {
            return false;
        }
        np npVar = (np) obj;
        Set<String> keySet = this.f2585a.keySet();
        if (!keySet.equals(npVar.f2585a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f2585a.get(str);
            Object obj3 = npVar.f2585a.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f2585a.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f2585a.isEmpty()) {
            for (String str : this.f2585a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f2585a.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public np(np npVar) {
        this.f2585a = new HashMap(npVar.f2585a);
    }

    public np(Map<String, ?> map) {
        this.f2585a = new HashMap(map);
    }
}
