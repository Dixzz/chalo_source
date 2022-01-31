package defpackage;

import java.nio.charset.Charset;

/* renamed from: ul2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ul2 implements nm2 {
    public static final am2 b = new sl2();

    /* renamed from: a  reason: collision with root package name */
    public final am2 f3523a;

    public ul2() {
        am2 am2;
        am2[] am2Arr = new am2[2];
        am2Arr[0] = aa3.f139a;
        try {
            am2 = (am2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            am2 = b;
        }
        am2Arr[1] = am2;
        tl2 tl2 = new tl2(am2Arr);
        Charset charset = ka3.f2038a;
        this.f3523a = tl2;
    }
}
