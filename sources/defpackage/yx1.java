package defpackage;

import com.google.auto.value.AutoValue;
import com.rabbitmq.client.AMQP;

@AutoValue
/* renamed from: yx1  reason: default package */
/* compiled from: EventStoreConfig */
public abstract class yx1 {

    /* renamed from: a  reason: collision with root package name */
    public static final yx1 f4096a;

    static {
        Long l = 10485760L;
        Integer valueOf = Integer.valueOf((int) AMQP.REPLY_SUCCESS);
        Integer num = 10000;
        Long l2 = 604800000L;
        Integer num2 = 81920;
        String str = l == null ? " maxStorageSizeInBytes" : "";
        if (valueOf == null) {
            str = hj1.S(str, " loadBatchSize");
        }
        if (num == null) {
            str = hj1.S(str, " criticalSectionEnterTimeoutMs");
        }
        if (l2 == null) {
            str = hj1.S(str, " eventCleanUpAge");
        }
        if (num2 == null) {
            str = hj1.S(str, " maxBlobByteSizePerRow");
        }
        if (str.isEmpty()) {
            f4096a = new vx1(l.longValue(), valueOf.intValue(), num.intValue(), l2.longValue(), num2.intValue(), null);
            return;
        }
        throw new IllegalStateException(hj1.S("Missing required properties:", str));
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
