package j$.util.stream;

import j$.util.stream.AbstractC0184m1;
import java.util.Collections;
import java.util.EnumSet;

/* renamed from: j$.util.stream.n1  reason: case insensitive filesystem */
public final class C0188n1 {
    static {
        AbstractC0184m1.a aVar = AbstractC0184m1.a.CONCURRENT;
        AbstractC0184m1.a aVar2 = AbstractC0184m1.a.UNORDERED;
        AbstractC0184m1.a aVar3 = AbstractC0184m1.a.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(aVar, aVar2, aVar3));
        Collections.unmodifiableSet(EnumSet.of(aVar, aVar2));
        Collections.unmodifiableSet(EnumSet.of(aVar3));
        Collections.unmodifiableSet(EnumSet.of(aVar2, aVar3));
        Collections.emptySet();
    }

    static double a(double[] dArr) {
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (!Double.isNaN(d) || !Double.isInfinite(d2)) ? d : d2;
    }

    static double[] b(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
        return dArr;
    }
}
