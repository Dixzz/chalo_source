package defpackage;

import java.util.Arrays;

/* renamed from: i3  reason: default package */
/* compiled from: SolverVariable */
public class i3 {
    public static int m = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1468a;
    public int b = -1;
    public int c = -1;
    public int d = 0;
    public float e;
    public boolean f = false;
    public float[] g = new float[9];
    public float[] h = new float[9];
    public a i;
    public d3[] j = new d3[16];
    public int k = 0;
    public int l = 0;

    /* renamed from: i3$a */
    /* compiled from: SolverVariable */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i3(a aVar) {
        this.i = aVar;
    }

    public final void a(d3 d3Var) {
        int i2 = 0;
        while (true) {
            int i3 = this.k;
            if (i2 >= i3) {
                d3[] d3VarArr = this.j;
                if (i3 >= d3VarArr.length) {
                    this.j = (d3[]) Arrays.copyOf(d3VarArr, d3VarArr.length * 2);
                }
                d3[] d3VarArr2 = this.j;
                int i4 = this.k;
                d3VarArr2[i4] = d3Var;
                this.k = i4 + 1;
                return;
            } else if (this.j[i2] != d3Var) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(d3 d3Var) {
        int i2 = this.k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.j[i3] == d3Var) {
                while (i3 < i2 - 1) {
                    d3[] d3VarArr = this.j;
                    int i4 = i3 + 1;
                    d3VarArr[i3] = d3VarArr[i4];
                    i3 = i4;
                }
                this.k--;
                return;
            }
            i3++;
        }
    }

    public void c() {
        this.i = a.UNKNOWN;
        this.d = 0;
        this.b = -1;
        this.c = -1;
        this.e = 0.0f;
        this.f = false;
        int i2 = this.k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3] = null;
        }
        this.k = 0;
        this.l = 0;
        this.f1468a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public void d(f3 f3Var, float f2) {
        this.e = f2;
        this.f = true;
        int i2 = this.k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3].k(this, false);
        }
        this.k = 0;
    }

    public final void e(d3 d3Var) {
        int i2 = this.k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3].l(d3Var, false);
        }
        this.k = 0;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("");
        i0.append(this.b);
        return i0.toString();
    }
}
