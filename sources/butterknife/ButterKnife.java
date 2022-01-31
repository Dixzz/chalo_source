package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Property;
import android.view.View;
import butterknife.internal.ButterKnifeProcessor;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife {
    public static final Map<Class<?>, Method> INJECTORS = new LinkedHashMap();
    public static final Method NO_OP = null;
    public static final Map<Class<?>, Method> RESETTERS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    public interface Action<T extends View> {
        void apply(T t, int i);
    }

    public enum Finder {
        VIEW {
            @Override // butterknife.ButterKnife.Finder
            public View findOptionalView(Object obj, int i) {
                return ((View) obj).findViewById(i);
            }

            @Override // butterknife.ButterKnife.Finder
            public Context getContext(Object obj) {
                return ((View) obj).getContext();
            }
        },
        ACTIVITY {
            @Override // butterknife.ButterKnife.Finder
            public View findOptionalView(Object obj, int i) {
                return ((Activity) obj).findViewById(i);
            }

            @Override // butterknife.ButterKnife.Finder
            public Context getContext(Object obj) {
                return (Activity) obj;
            }
        },
        DIALOG {
            @Override // butterknife.ButterKnife.Finder
            public View findOptionalView(Object obj, int i) {
                return ((Dialog) obj).findViewById(i);
            }

            @Override // butterknife.ButterKnife.Finder
            public Context getContext(Object obj) {
                return ((Dialog) obj).getContext();
            }
        };

        public static <T extends View> T[] arrayOf(T... tArr) {
            return tArr;
        }

        public static <T extends View> List<T> listOf(T... tArr) {
            return new ImmutableViewList(tArr);
        }

        public abstract View findOptionalView(Object obj, int i);

        public View findRequiredView(Object obj, int i, String str) {
            View findOptionalView = findOptionalView(obj, i);
            if (findOptionalView != null) {
                return findOptionalView;
            }
            String resourceEntryName = getContext(obj).getResources().getResourceEntryName(i);
            StringBuilder sb = new StringBuilder();
            sb.append("Required view '");
            sb.append(resourceEntryName);
            sb.append("' with ID ");
            sb.append(i);
            sb.append(" for ");
            throw new IllegalStateException(hj1.a0(sb, str, " was not found. If this view is optional add '@Optional' annotation."));
        }

        public abstract Context getContext(Object obj);
    }

    public interface Setter<T extends View, V> {
        void set(T t, V v, int i);
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static <T extends View> void apply(List<T> list, Action<? super T> action) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.apply(list.get(i), i);
        }
    }

    public static <T extends View> T findById(View view, int i) {
        return (T) view.findViewById(i);
    }

    private static Method findInjectorForClass(Class<?> cls) throws NoSuchMethodException {
        Method method;
        Method method2 = INJECTORS.get(cls);
        if (method2 != null) {
            boolean z = debug;
            return method2;
        }
        String name = cls.getName();
        if (name.startsWith(ButterKnifeProcessor.ANDROID_PREFIX) || name.startsWith(ButterKnifeProcessor.JAVA_PREFIX)) {
            boolean z2 = debug;
            return NO_OP;
        }
        try {
            method = Class.forName(name + ButterKnifeProcessor.SUFFIX).getMethod("inject", Finder.class, cls, Object.class);
            boolean z3 = debug;
        } catch (ClassNotFoundException unused) {
            if (debug) {
                cls.getSuperclass().getName();
            }
            method = findInjectorForClass(cls.getSuperclass());
        }
        INJECTORS.put(cls, method);
        return method;
    }

    private static Method findResettersForClass(Class<?> cls) throws NoSuchMethodException {
        Method method;
        Method method2 = RESETTERS.get(cls);
        if (method2 != null) {
            boolean z = debug;
            return method2;
        }
        String name = cls.getName();
        if (name.startsWith(ButterKnifeProcessor.ANDROID_PREFIX) || name.startsWith(ButterKnifeProcessor.JAVA_PREFIX)) {
            boolean z2 = debug;
            return NO_OP;
        }
        try {
            method = Class.forName(name + ButterKnifeProcessor.SUFFIX).getMethod(AnalyticsConstants.RESET, cls);
            boolean z3 = debug;
        } catch (ClassNotFoundException unused) {
            if (debug) {
                cls.getSuperclass().getName();
            }
            method = findResettersForClass(cls.getSuperclass());
        }
        RESETTERS.put(cls, method);
        return method;
    }

    public static void inject(Activity activity) {
        inject(activity, activity, Finder.ACTIVITY);
    }

    public static void reset(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            if (debug) {
                cls.getName();
            }
            Method findResettersForClass = findResettersForClass(cls);
            if (findResettersForClass != null) {
                findResettersForClass.invoke(null, obj);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            if (e instanceof InvocationTargetException) {
                e = e.getCause();
            }
            throw new RuntimeException("Unable to reset views for " + obj, e);
        }
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static <T extends View> T findById(Activity activity, int i) {
        return (T) activity.findViewById(i);
    }

    public static void inject(View view) {
        inject(view, view, Finder.VIEW);
    }

    public static <T extends View, V> void apply(List<T> list, Setter<? super T, V> setter, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            setter.set(list.get(i), v, i);
        }
    }

    public static <T extends View> T findById(Dialog dialog, int i) {
        return (T) dialog.findViewById(i);
    }

    public static void inject(Dialog dialog) {
        inject(dialog, dialog, Finder.DIALOG);
    }

    public static void inject(Object obj, Activity activity) {
        inject(obj, activity, Finder.ACTIVITY);
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(List<T> list, Property<? super T, V> property, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            property.set(list.get(i), v);
        }
    }

    public static void inject(Object obj, View view) {
        inject(obj, view, Finder.VIEW);
    }

    public static void inject(Object obj, Dialog dialog) {
        inject(obj, dialog, Finder.DIALOG);
    }

    public static void inject(Object obj, Object obj2, Finder finder) {
        Class<?> cls = obj.getClass();
        try {
            if (debug) {
                cls.getName();
            }
            Method findInjectorForClass = findInjectorForClass(cls);
            if (findInjectorForClass != null) {
                findInjectorForClass.invoke(null, finder, obj, obj2);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            if (e instanceof InvocationTargetException) {
                e = e.getCause();
            }
            throw new RuntimeException("Unable to inject views for " + obj, e);
        }
    }
}
