package defpackage;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* renamed from: xh  reason: default package */
/* compiled from: SavedStateViewModelFactory */
public final class xh extends di {
    public static final Class<?>[] f = {Application.class, wh.class};
    public static final Class<?>[] g = {wh.class};

    /* renamed from: a  reason: collision with root package name */
    public final Application f3928a;
    public final ci b;
    public final Bundle c;
    public final zg d;
    public final km e;

    @SuppressLint({"LambdaLast"})
    public xh(Application application, mm mmVar, Bundle bundle) {
        ci ciVar;
        this.e = mmVar.getSavedStateRegistry();
        this.d = mmVar.getLifecycle();
        this.c = bundle;
        this.f3928a = application;
        if (application != null) {
            if (bi.c == null) {
                bi.c = new bi(application);
            }
            ciVar = bi.c;
        } else {
            if (ei.f975a == null) {
                ei.f975a = new ei();
            }
            ciVar = ei.f975a;
        }
        this.b = ciVar;
    }

    public static <T> Constructor<T> d(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // defpackage.di, defpackage.ci
    public <T extends zh> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // defpackage.fi
    public void b(zh zhVar) {
        SavedStateHandleController.h(zhVar, this.e, this.d);
    }

    @Override // defpackage.di
    public <T extends zh> T c(String str, Class<T> cls) {
        Constructor constructor;
        T t;
        boolean isAssignableFrom = lg.class.isAssignableFrom(cls);
        if (!isAssignableFrom || this.f3928a == null) {
            constructor = d(cls, g);
        } else {
            constructor = d(cls, f);
        }
        if (constructor == null) {
            return (T) this.b.a(cls);
        }
        SavedStateHandleController j = SavedStateHandleController.j(this.e, this.d, str, this.c);
        if (isAssignableFrom) {
            try {
                Application application = this.f3928a;
                if (application != null) {
                    t = (T) ((zh) constructor.newInstance(application, j.h));
                    t.c("androidx.lifecycle.savedstate.vm.tag", j);
                    return t;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        t = (T) ((zh) constructor.newInstance(j.h));
        t.c("androidx.lifecycle.savedstate.vm.tag", j);
        return t;
    }
}
