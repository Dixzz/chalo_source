package defpackage;

import java.util.ArrayList;

/* renamed from: g4  reason: default package */
/* compiled from: RunGroup */
public class g4 {
    public static int c;

    /* renamed from: a  reason: collision with root package name */
    public i4 f1211a = null;
    public ArrayList<i4> b = new ArrayList<>();

    public g4(i4 i4Var, int i) {
        c++;
        this.f1211a = i4Var;
    }

    public final long a(b4 b4Var, long j) {
        i4 i4Var = b4Var.d;
        if (i4Var instanceof e4) {
            return j;
        }
        int size = b4Var.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            z3 z3Var = b4Var.k.get(i);
            if (z3Var instanceof b4) {
                b4 b4Var2 = (b4) z3Var;
                if (b4Var2.d != i4Var) {
                    j2 = Math.min(j2, a(b4Var2, ((long) b4Var2.f) + j));
                }
            }
        }
        if (b4Var != i4Var.i) {
            return j2;
        }
        long j3 = j - i4Var.j();
        return Math.min(Math.min(j2, a(i4Var.h, j3)), j3 - ((long) i4Var.h.f));
    }

    public final long b(b4 b4Var, long j) {
        i4 i4Var = b4Var.d;
        if (i4Var instanceof e4) {
            return j;
        }
        int size = b4Var.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            z3 z3Var = b4Var.k.get(i);
            if (z3Var instanceof b4) {
                b4 b4Var2 = (b4) z3Var;
                if (b4Var2.d != i4Var) {
                    j2 = Math.max(j2, b(b4Var2, ((long) b4Var2.f) + j));
                }
            }
        }
        if (b4Var != i4Var.h) {
            return j2;
        }
        long j3 = j + i4Var.j();
        return Math.max(Math.max(j2, b(i4Var.i, j3)), j3 - ((long) i4Var.i.f));
    }
}
