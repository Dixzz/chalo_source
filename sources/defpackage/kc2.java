package defpackage;

import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import defpackage.ic2;
import java.lang.reflect.Field;
import java.util.Objects;

/* renamed from: kc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class kc2<T> extends ic2.a {
    public final T f;

    public kc2(T t) {
        this.f = t;
    }

    @RecentlyNonNull
    public static <T> T L(@RecentlyNonNull ic2 ic2) {
        if (ic2 instanceof kc2) {
            return ((kc2) ic2).f;
        }
        IBinder asBinder = ic2.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i == 1) {
            Objects.requireNonNull(field, "null reference");
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T) field.get(asBinder);
                } catch (NullPointerException e) {
                    throw new IllegalArgumentException("Binder object is null.", e);
                } catch (IllegalAccessException e2) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException(hj1.v(64, "Unexpected number of IObjectWrapper declared fields: ", declaredFields.length));
        }
    }
}
