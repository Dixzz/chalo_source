package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* renamed from: n26  reason: default package */
/* compiled from: -ReflectiveFallbackViewCreator.kt */
public final class n26 implements e26 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<? extends Object>[] f2508a = {Context.class};
    public static final Class<? extends Object>[] b = {Context.class, AttributeSet.class};

    @Override // defpackage.e26
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Object[] objArr;
        Constructor<? extends U> constructor;
        n86.f(str, "name");
        n86.f(context, AnalyticsConstants.CONTEXT);
        try {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(View.class);
            try {
                Class<? extends Object>[] clsArr = b;
                constructor = asSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                n86.b(constructor, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_2)");
                objArr = new Object[]{context, attributeSet};
            } catch (NoSuchMethodException unused) {
                Class<? extends Object>[] clsArr2 = f2508a;
                constructor = asSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                n86.b(constructor, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_1)");
                objArr = new Context[]{context};
            }
            constructor.setAccessible(true);
            return (View) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                e.printStackTrace();
                return null;
            } else if (e instanceof NoSuchMethodException) {
                e.printStackTrace();
                return null;
            } else if (e instanceof IllegalAccessException) {
                e.printStackTrace();
                return null;
            } else if (e instanceof InstantiationException) {
                e.printStackTrace();
                return null;
            } else if (e instanceof InvocationTargetException) {
                e.printStackTrace();
                return null;
            } else {
                throw e;
            }
        }
    }
}
