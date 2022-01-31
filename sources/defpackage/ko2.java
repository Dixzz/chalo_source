package defpackage;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ko2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ko2 {

    /* renamed from: a  reason: collision with root package name */
    public static final CopyOnWriteArrayList<jo2> f2091a = new CopyOnWriteArrayList<>();

    public static jo2 a(String str) throws GeneralSecurityException {
        Iterator<jo2> it = f2091a.iterator();
        while (it.hasNext()) {
            jo2 next = it.next();
            if (next.zza(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
