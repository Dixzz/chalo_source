package defpackage;

import java.nio.charset.Charset;

/* renamed from: pv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class pv3 implements pw3 {
    public static final zv3 b = new sv3();

    /* renamed from: a  reason: collision with root package name */
    public final zv3 f2858a;

    public pv3() {
        zv3 zv3;
        zv3[] zv3Arr = new zv3[2];
        zv3Arr[0] = su3.f3259a;
        try {
            zv3 = (zv3) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zv3 = b;
        }
        zv3Arr[1] = zv3;
        rv3 rv3 = new rv3(zv3Arr);
        Charset charset = tu3.f3407a;
        this.f2858a = rv3;
    }
}
