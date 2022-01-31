package defpackage;

import java.nio.charset.Charset;

/* renamed from: si3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class si3 implements vj3 {
    public static final dj3 b = new vi3();

    /* renamed from: a  reason: collision with root package name */
    public final dj3 f3217a;

    public si3() {
        dj3 dj3;
        dj3[] dj3Arr = new dj3[2];
        dj3Arr[0] = vh3.f3650a;
        try {
            dj3 = (dj3) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            dj3 = b;
        }
        dj3Arr[1] = dj3;
        ui3 ui3 = new ui3(dj3Arr);
        Charset charset = zh3.f4175a;
        this.f3217a = ui3;
    }
}
