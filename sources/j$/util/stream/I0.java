package j$.util.stream;

import java.security.PrivilegedAction;

public final /* synthetic */ class I0 implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ I0 f1708a = new I0();

    private /* synthetic */ I0() {
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        boolean z = i3.f1797a;
        return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
    }
}
