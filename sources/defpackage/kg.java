package defpackage;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;

/* renamed from: kg  reason: default package */
/* compiled from: AbstractSavedStateViewModelFactory */
public abstract class kg extends di {

    /* renamed from: a  reason: collision with root package name */
    public final km f2053a;
    public final zg b;
    public final Bundle c;

    public kg(mm mmVar, Bundle bundle) {
        this.f2053a = mmVar.getSavedStateRegistry();
        this.b = mmVar.getLifecycle();
        this.c = bundle;
    }

    @Override // defpackage.di, defpackage.ci
    public final <T extends zh> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // defpackage.fi
    public void b(zh zhVar) {
        SavedStateHandleController.h(zhVar, this.f2053a, this.b);
    }

    @Override // defpackage.di
    public final <T extends zh> T c(String str, Class<T> cls) {
        SavedStateHandleController j = SavedStateHandleController.j(this.f2053a, this.b, str, this.c);
        T t = (T) d(str, cls, j.h);
        t.c("androidx.lifecycle.savedstate.vm.tag", j);
        return t;
    }

    public abstract <T extends zh> T d(String str, Class<T> cls, wh whVar);
}
