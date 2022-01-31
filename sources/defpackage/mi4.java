package defpackage;

import com.google.android.gms.common.api.Scope;
import defpackage.x22;

/* renamed from: mi4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class mi4 {

    /* renamed from: a  reason: collision with root package name */
    public static final x22.g<ai4> f2383a;
    public static final x22.g<ai4> b;
    public static final x22.a<ai4, zh4> c;
    public static final x22.a<ai4, li4> d;
    public static final x22<zh4> e;

    static {
        x22.g<ai4> gVar = new x22.g<>();
        f2383a = gVar;
        x22.g<ai4> gVar2 = new x22.g<>();
        b = gVar2;
        ji4 ji4 = new ji4();
        c = ji4;
        ki4 ki4 = new ki4();
        d = ki4;
        new Scope("profile");
        new Scope("email");
        e = new x22<>("SignIn.API", ji4, gVar);
        gj1.l(ki4, "Cannot construct an Api with a null ClientBuilder");
        gj1.l(gVar2, "Cannot construct an Api with a null ClientKey");
    }
}
