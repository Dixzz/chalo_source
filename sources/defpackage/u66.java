package defpackage;

import com.google.firebase.messaging.Constants;
import defpackage.z66;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: u66  reason: default package */
/* compiled from: ContinuationImpl.kt */
public abstract class u66 implements k66<Object>, x66, Serializable {
    private final k66<Object> completion;

    public u66(k66<Object> k66) {
        this.completion = k66;
    }

    public k66<s56> create(k66<?> k66) {
        n86.e(k66, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // defpackage.x66
    public x66 getCallerFrame() {
        k66<Object> k66 = this.completion;
        if (!(k66 instanceof x66)) {
            k66 = null;
        }
        return (x66) k66;
    }

    public final k66<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        n86.e(this, "$this$getStackTraceElementImpl");
        y66 y66 = (y66) getClass().getAnnotation(y66.class);
        String str2 = null;
        if (y66 == null) {
            return null;
        }
        int v = y66.v();
        if (v <= 1) {
            int i2 = -1;
            try {
                Field declaredField = getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
                n86.d(declaredField, "field");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                Integer num = (Integer) obj;
                i = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                i = -1;
            }
            if (i >= 0) {
                i2 = y66.l()[i];
            }
            z66.a aVar = z66.f4139a;
            n86.e(this, "continuation");
            z66.a aVar2 = z66.b;
            if (aVar2 == null) {
                try {
                    z66.a aVar3 = new z66.a(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                    z66.b = aVar3;
                    aVar2 = aVar3;
                } catch (Exception unused2) {
                    z66.b = aVar;
                    aVar2 = aVar;
                }
            }
            if (!(aVar2 == aVar || (method = aVar2.f4140a) == null || (invoke = method.invoke(getClass(), new Object[0])) == null || (method2 = aVar2.b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null)) {
                Method method3 = aVar2.c;
                Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
                if (invoke3 instanceof String) {
                    str2 = invoke3;
                }
                str2 = str2;
            }
            if (str2 == null) {
                str = y66.c();
            } else {
                str = str2 + '/' + y66.c();
            }
            return new StackTraceElement(str, y66.m(), y66.f(), i2);
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + 1 + ", got " + v + ". Please update the Kotlin standard library.").toString());
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // defpackage.k66
    public final void resumeWith(Object obj) {
        u66 u66 = this;
        while (true) {
            n86.e(u66, "frame");
            k66<Object> k66 = u66.completion;
            n86.c(k66);
            try {
                obj = u66.invokeSuspend(obj);
                if (obj == p66.COROUTINE_SUSPENDED) {
                    return;
                }
            } catch (Throwable th) {
                obj = hd3.Z(th);
            }
            u66.releaseIntercepted();
            if (k66 instanceof u66) {
                u66 = (u66) k66;
            } else {
                k66.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        i0.append(stackTraceElement);
        return i0.toString();
    }

    public k66<s56> create(Object obj, k66<?> k66) {
        n86.e(k66, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
