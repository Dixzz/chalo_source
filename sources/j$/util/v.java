package j$.util;

import java.security.AccessController;

/* access modifiers changed from: package-private */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1856a = ((Boolean) AccessController.doPrivileged(i.f1680a)).booleanValue();

    static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
