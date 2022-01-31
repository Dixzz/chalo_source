package j$.util.stream;

import java.security.AccessController;

/* access modifiers changed from: package-private */
public final class i3 {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1797a = ((Boolean) AccessController.doPrivileged(I0.f1708a)).booleanValue();

    static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
