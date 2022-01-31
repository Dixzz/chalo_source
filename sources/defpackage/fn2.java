package defpackage;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* renamed from: fn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class fn2 implements PrivilegedExceptionAction<Unsafe> {
    public static final Unsafe a() throws Exception {
        Field[] declaredFields = Unsafe.class.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.security.PrivilegedExceptionAction
    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
        return a();
    }
}
