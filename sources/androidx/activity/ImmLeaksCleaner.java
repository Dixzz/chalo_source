package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import defpackage.zg;
import java.lang.reflect.Field;

public final class ImmLeaksCleaner implements dh {
    public static int g;
    public static Field h;
    public static Field i;
    public static Field j;
    public Activity f;

    public ImmLeaksCleaner(Activity activity) {
        this.f = activity;
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        if (aVar == zg.a.ON_DESTROY) {
            if (g == 0) {
                try {
                    g = 2;
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    i = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    j = declaredField2;
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    h = declaredField3;
                    declaredField3.setAccessible(true);
                    g = 1;
                } catch (NoSuchFieldException unused) {
                }
            }
            if (g == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f.getSystemService("input_method");
                try {
                    Object obj = h.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                View view = (View) i.get(inputMethodManager);
                                if (view != null) {
                                    if (!view.isAttachedToWindow()) {
                                        try {
                                            j.set(inputMethodManager, null);
                                            inputMethodManager.isActive();
                                        } catch (IllegalAccessException unused2) {
                                        }
                                    }
                                }
                            } catch (IllegalAccessException unused3) {
                            } catch (ClassCastException unused4) {
                            }
                        }
                    }
                } catch (IllegalAccessException unused5) {
                }
            }
        }
    }
}
