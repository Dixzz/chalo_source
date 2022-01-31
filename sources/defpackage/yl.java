package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: yl  reason: default package */
/* compiled from: RoomSQLiteQuery */
public class yl implements rm, qm {
    public static final TreeMap<Integer, yl> n = new TreeMap<>();
    public volatile String f;
    public final long[] g;
    public final double[] h;
    public final String[] i;
    public final byte[][] j;
    public final int[] k;
    public final int l;
    public int m;

    public yl(int i2) {
        this.l = i2;
        int i3 = i2 + 1;
        this.k = new int[i3];
        this.g = new long[i3];
        this.h = new double[i3];
        this.i = new String[i3];
        this.j = new byte[i3][];
    }

    public static yl e(String str, int i2) {
        TreeMap<Integer, yl> treeMap = n;
        synchronized (treeMap) {
            Map.Entry<Integer, yl> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                yl value = ceilingEntry.getValue();
                value.f = str;
                value.m = i2;
                return value;
            }
            yl ylVar = new yl(i2);
            ylVar.f = str;
            ylVar.m = i2;
            return ylVar;
        }
    }

    @Override // defpackage.qm
    public void E0(int i2) {
        this.k[i2] = 1;
    }

    @Override // defpackage.qm
    public void N(int i2, double d) {
        this.k[i2] = 3;
        this.h[i2] = d;
    }

    @Override // defpackage.rm
    public String a() {
        return this.f;
    }

    @Override // defpackage.rm
    public void c(qm qmVar) {
        for (int i2 = 1; i2 <= this.m; i2++) {
            int i3 = this.k[i2];
            if (i3 == 1) {
                qmVar.E0(i2);
            } else if (i3 == 2) {
                qmVar.d0(i2, this.g[i2]);
            } else if (i3 == 3) {
                qmVar.N(i2, this.h[i2]);
            } else if (i3 == 4) {
                qmVar.z(i2, this.i[i2]);
            } else if (i3 == 5) {
                qmVar.h0(i2, this.j[i2]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // defpackage.qm
    public void d0(int i2, long j2) {
        this.k[i2] = 2;
        this.g[i2] = j2;
    }

    public void f() {
        TreeMap<Integer, yl> treeMap = n;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.l), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i2;
                }
            }
        }
    }

    @Override // defpackage.qm
    public void h0(int i2, byte[] bArr) {
        this.k[i2] = 5;
        this.j[i2] = bArr;
    }

    @Override // defpackage.qm
    public void z(int i2, String str) {
        this.k[i2] = 4;
        this.i[i2] = str;
    }
}
