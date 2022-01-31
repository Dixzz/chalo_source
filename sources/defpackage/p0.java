package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: p0  reason: default package */
/* compiled from: AppCompatViewInflater */
public class p0 {
    public static final Class<?>[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {16843375};
    public static final String[] d = {"android.widget.", "android.view.", "android.webkit."};
    public static final u2<String, Constructor<? extends View>> e = new u2<>();

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f2752a = new Object[2];

    /* renamed from: p0$a */
    /* compiled from: AppCompatViewInflater */
    public static class a implements View.OnClickListener {
        public final View f;
        public final String g;
        public Method h;
        public Context i;

        public a(View view, String str) {
            this.f = view;
            this.g = str;
        }

        public void onClick(View view) {
            String str;
            Method method;
            if (this.h == null) {
                Context context = this.f.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.g, View.class)) != null) {
                            this.h = method;
                            this.i = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f.getId();
                if (id == -1) {
                    str = "";
                } else {
                    StringBuilder i0 = hj1.i0(" with id '");
                    i0.append(this.f.getContext().getResources().getResourceEntryName(id));
                    i0.append("'");
                    str = i0.toString();
                }
                StringBuilder i02 = hj1.i0("Could not find method ");
                i02.append(this.g);
                i02.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                i02.append(this.f.getClass());
                i02.append(str);
                throw new IllegalStateException(i02.toString());
            }
            try {
                this.h.invoke(this.i, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    public AppCompatAutoCompleteTextView a(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public AppCompatCheckBox c(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    public AppCompatRadioButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    public AppCompatTextView e(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public View f() {
        return null;
    }

    public final View g(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        u2<String, Constructor<? extends View>> u2Var = e;
        Constructor<? extends View> orDefault = u2Var.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            u2Var.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return (View) orDefault.newInstance(this.f2752a);
    }

    public final void h(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }
}
