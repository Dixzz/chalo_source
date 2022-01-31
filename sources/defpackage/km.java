package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;

@SuppressLint({"RestrictedApi"})
/* renamed from: km  reason: default package */
/* compiled from: SavedStateRegistry */
public final class km {

    /* renamed from: a  reason: collision with root package name */
    public g2<String, b> f2077a = new g2<>();
    public Bundle b;
    public boolean c;
    public Recreator.a d;
    public boolean e = true;

    /* renamed from: km$a */
    /* compiled from: SavedStateRegistry */
    public interface a {
        void a(mm mmVar);
    }

    /* renamed from: km$b */
    /* compiled from: SavedStateRegistry */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.c) {
            Bundle bundle = this.b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.b.remove(str);
            if (this.b.isEmpty()) {
                this.b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(String str, b bVar) {
        if (this.f2077a.k(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void c(Class<? extends a> cls) {
        if (this.e) {
            if (this.d == null) {
                this.d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.d;
                aVar.f249a.add(cls.getName());
            } catch (NoSuchMethodException e2) {
                StringBuilder i0 = hj1.i0("Class");
                i0.append(cls.getSimpleName());
                i0.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(i0.toString(), e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
