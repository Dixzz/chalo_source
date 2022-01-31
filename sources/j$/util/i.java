package j$.util;

import java.security.PrivilegedAction;

public final /* synthetic */ class i implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i f1680a = new i();

    private /* synthetic */ i() {
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        boolean z = v.f1856a;
        return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
    }
}
