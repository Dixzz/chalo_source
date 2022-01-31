package defpackage;

import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.R;
import defpackage.r8;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: e8  reason: default package */
/* compiled from: KeyEventDispatcher */
public class e8 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f939a = false;
    public static Method b = null;
    public static boolean c = false;
    public static Field d;

    /* renamed from: e8$a */
    /* compiled from: KeyEventDispatcher */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        int indexOfKey;
        AtomicInteger atomicInteger = r8.f3055a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList<WeakReference<View>> arrayList = r8.d.d;
            int i = R.id.tag_unhandled_key_event_manager;
            r8.d dVar = (r8.d) view.getTag(i);
            if (dVar == null) {
                dVar = new r8.d();
                view.setTag(i, dVar);
            }
            WeakReference<KeyEvent> weakReference = dVar.c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                dVar.c = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                if (dVar.b == null) {
                    dVar.b = new SparseArray<>();
                }
                SparseArray<WeakReference<View>> sparseArray = dVar.b;
                if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view2 = weakReference2.get();
                    if (view2 == null || !view2.isAttachedToWindow()) {
                        return true;
                    }
                    dVar.b(view2, keyEvent);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(defpackage.e8.a r7, android.view.View r8, android.view.Window.Callback r9, android.view.KeyEvent r10) {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e8.b(e8$a, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }
}
