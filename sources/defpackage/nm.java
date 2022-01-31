package defpackage;

/* renamed from: nm  reason: default package */
/* compiled from: SimpleSQLiteQuery */
public final class nm implements rm {
    public final String f;
    public final Object[] g;

    public nm(String str) {
        this.f = str;
        this.g = null;
    }

    @Override // defpackage.rm
    public String a() {
        return this.f;
    }

    @Override // defpackage.rm
    public void c(qm qmVar) {
        Object[] objArr = this.g;
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                if (obj == null) {
                    qmVar.E0(i);
                } else if (obj instanceof byte[]) {
                    qmVar.h0(i, (byte[]) obj);
                } else if (obj instanceof Float) {
                    qmVar.N(i, (double) ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    qmVar.N(i, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    qmVar.d0(i, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    qmVar.d0(i, (long) ((Integer) obj).intValue());
                } else if (obj instanceof Short) {
                    qmVar.d0(i, (long) ((Short) obj).shortValue());
                } else if (obj instanceof Byte) {
                    qmVar.d0(i, (long) ((Byte) obj).byteValue());
                } else if (obj instanceof String) {
                    qmVar.z(i, (String) obj);
                } else if (obj instanceof Boolean) {
                    qmVar.d0(i, ((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                }
            }
        }
    }

    public nm(String str, Object[] objArr) {
        this.f = str;
        this.g = objArr;
    }
}
