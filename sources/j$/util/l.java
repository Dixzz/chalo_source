package j$.util;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.function.C0129f;
import j$.util.function.q;
import java.util.Objects;

public class l implements q {

    /* renamed from: a  reason: collision with root package name */
    private double f1683a;
    private double b;
    private long count;
    private double max = Double.NEGATIVE_INFINITY;
    private double min = Double.POSITIVE_INFINITY;
    private double sum;

    private void d(double d) {
        double d2 = d - this.f1683a;
        double d3 = this.sum;
        double d4 = d3 + d2;
        this.f1683a = (d4 - d3) - d2;
        this.sum = d4;
    }

    @Override // j$.util.function.q
    public void accept(double d) {
        this.count++;
        this.b += d;
        d(d);
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
    }

    public void b(l lVar) {
        this.count += lVar.count;
        this.b += lVar.b;
        d(lVar.sum);
        d(lVar.f1683a);
        this.min = Math.min(this.min, lVar.min);
        this.max = Math.max(this.max, lVar.max);
    }

    public final double c() {
        double d = this.sum + this.f1683a;
        return (!Double.isNaN(d) || !Double.isInfinite(this.b)) ? d : this.b;
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Double.valueOf(c());
        objArr[3] = Double.valueOf(this.min);
        objArr[4] = Double.valueOf(this.count > 0 ? c() / ((double) this.count) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        objArr[5] = Double.valueOf(this.max);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
