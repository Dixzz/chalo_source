package j$.util;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.function.C;
import j$.util.function.C0130g;
import j$.util.function.C0131h;
import j$.util.function.w;
import java.util.Objects;

public class n implements C, w {
    private long count;
    private long max = Long.MIN_VALUE;
    private long min = Long.MAX_VALUE;
    private long sum;

    @Override // j$.util.function.w
    public void accept(int i) {
        accept((long) i);
    }

    @Override // j$.util.function.C
    public void accept(long j) {
        this.count++;
        this.sum += j;
        this.min = Math.min(this.min, j);
        this.max = Math.max(this.max, j);
    }

    public void b(n nVar) {
        this.count += nVar.count;
        this.sum += nVar.sum;
        this.min = Math.min(this.min, nVar.min);
        this.max = Math.max(this.max, nVar.max);
    }

    @Override // j$.util.function.C
    public C g(C c) {
        Objects.requireNonNull(c);
        return new C0131h(this, c);
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Long.valueOf(this.min);
        long j = this.count;
        objArr[4] = Double.valueOf(j > 0 ? ((double) this.sum) / ((double) j) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        objArr[5] = Long.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
