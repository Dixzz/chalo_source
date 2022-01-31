package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import defpackage.km;
import defpackage.zg;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class Recreator implements dh {
    public final mm f;

    public static final class a implements km.b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f249a = new HashSet();

        public a(km kmVar) {
            kmVar.b("androidx.savedstate.Restarter", this);
        }

        @Override // defpackage.km.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f249a));
            return bundle;
        }
    }

    public Recreator(mm mmVar) {
        this.f = mmVar;
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        Class cls;
        if (aVar == zg.a.ON_CREATE) {
            gh ghVar = (gh) fhVar.getLifecycle();
            ghVar.d("removeObserver");
            ghVar.b.n(this);
            Bundle a2 = this.f.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            try {
                                Constructor<? extends U> declaredConstructor = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(km.a.class).getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((km.a) declaredConstructor.newInstance(new Object[0])).a(this.f);
                                } catch (Exception e) {
                                    throw new RuntimeException(hj1.S("Failed to instantiate ", next), e);
                                }
                            } catch (NoSuchMethodException e2) {
                                StringBuilder i0 = hj1.i0("Class");
                                i0.append(cls.getSimpleName());
                                i0.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(i0.toString(), e2);
                            }
                        } catch (ClassNotFoundException e3) {
                            throw new RuntimeException(hj1.T("Class ", next, " wasn't found"), e3);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
