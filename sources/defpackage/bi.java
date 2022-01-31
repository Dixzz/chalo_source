package defpackage;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* renamed from: bi  reason: default package */
/* compiled from: ViewModelProvider */
public class bi extends ei {
    public static bi c;
    public Application b;

    public bi(Application application) {
        this.b = application;
    }

    @Override // defpackage.ei, defpackage.ci
    public <T extends zh> T a(Class<T> cls) {
        if (!lg.class.isAssignableFrom(cls)) {
            return (T) super.a(cls);
        }
        try {
            return cls.getConstructor(Application.class).newInstance(this.b);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }
}
