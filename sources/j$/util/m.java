package j$.util;

import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.function.C0130g;
import j$.util.function.w;
import java.util.Objects;

public class m implements w {
    private long count;
    private int max = RtlSpacingHelper.UNDEFINED;
    private int min = Integer.MAX_VALUE;
    private long sum;

    @Override // j$.util.function.w
    public void accept(int i) {
        this.count++;
        this.sum += (long) i;
        this.min = Math.min(this.min, i);
        this.max = Math.max(this.max, i);
    }

    public void b(m mVar) {
        this.count += mVar.count;
        this.sum += mVar.sum;
        this.min = Math.min(this.min, mVar.min);
        this.max = Math.max(this.max, mVar.max);
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
        objArr[3] = Integer.valueOf(this.min);
        long j = this.count;
        objArr[4] = Double.valueOf(j > 0 ? ((double) this.sum) / ((double) j) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        objArr[5] = Integer.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
