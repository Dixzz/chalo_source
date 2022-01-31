package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.lang.reflect.Field;
import java.util.Arrays;

/* renamed from: ni2  reason: default package */
public final class ni2 {
    public int A;
    public int B;
    public Field C;
    public Object D;
    public Object E;
    public Object F;

    /* renamed from: a  reason: collision with root package name */
    public final oi2 f2560a;
    public final Object[] b;
    public Class<?> c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int[] n;
    public int o;
    public int p;
    public int q = Integer.MAX_VALUE;
    public int r = RtlSpacingHelper.UNDEFINED;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = 0;
    public int x;
    public int y;
    public int z;

    public ni2(Class<?> cls, String str, Object[] objArr) {
        this.c = cls;
        oi2 oi2 = new oi2(str);
        this.f2560a = oi2;
        this.b = objArr;
        this.d = oi2.a();
        int a2 = oi2.a();
        this.e = a2;
        int[] iArr = null;
        if (a2 == 0) {
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.l = 0;
            this.k = 0;
            this.m = 0;
            this.n = null;
            return;
        }
        int a3 = oi2.a();
        this.f = a3;
        int a4 = oi2.a();
        this.g = a4;
        this.h = oi2.a();
        this.i = oi2.a();
        this.l = oi2.a();
        this.k = oi2.a();
        this.j = oi2.a();
        this.m = oi2.a();
        int a5 = oi2.a();
        this.n = a5 != 0 ? new int[a5] : iArr;
        this.o = (a3 << 1) + a4;
    }

    public static Field b(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(hj1.g0(arrays, name.length() + hj1.g0(str, 40)));
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            throw new RuntimeException(hj1.a0(sb, " not found. Known fields are ", arrays));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f3, code lost:
        if (d() != false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0171, code lost:
        if (r3 != false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0178, code lost:
        if (d() != false) goto L_0x017a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ni2.a():boolean");
    }

    public final Object c() {
        Object[] objArr = this.b;
        int i2 = this.o;
        this.o = i2 + 1;
        return objArr[i2];
    }

    public final boolean d() {
        return (this.d & 1) == 1;
    }

    public final boolean e() {
        return d() && this.z <= pg2.GROUP.id();
    }
}
