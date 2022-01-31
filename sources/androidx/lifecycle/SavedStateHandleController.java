package androidx.lifecycle;

import android.os.Bundle;
import defpackage.km;
import defpackage.zg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class SavedStateHandleController implements dh {
    public final String f;
    public boolean g = false;
    public final wh h;

    public static final class a implements km.a {
        @Override // defpackage.km.a
        public void a(mm mmVar) {
            if (mmVar instanceof hi) {
                gi viewModelStore = ((hi) mmVar).getViewModelStore();
                km savedStateRegistry = mmVar.getSavedStateRegistry();
                Objects.requireNonNull(viewModelStore);
                Iterator it = new HashSet(viewModelStore.f1264a.keySet()).iterator();
                while (it.hasNext()) {
                    SavedStateHandleController.h(viewModelStore.f1264a.get((String) it.next()), savedStateRegistry, mmVar.getLifecycle());
                }
                if (!new HashSet(viewModelStore.f1264a.keySet()).isEmpty()) {
                    savedStateRegistry.c(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, wh whVar) {
        this.f = str;
        this.h = whVar;
    }

    public static void h(zh zhVar, km kmVar, zg zgVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) zhVar.a("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.g) {
            savedStateHandleController.i(kmVar, zgVar);
            k(kmVar, zgVar);
        }
    }

    public static SavedStateHandleController j(km kmVar, zg zgVar, String str, Bundle bundle) {
        wh whVar;
        Bundle a2 = kmVar.a(str);
        Class[] clsArr = wh.e;
        if (a2 == null && bundle == null) {
            whVar = new wh();
        } else {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    hashMap.put(str2, bundle.get(str2));
                }
            }
            if (a2 == null) {
                whVar = new wh(hashMap);
            } else {
                ArrayList parcelableArrayList = a2.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = a2.getParcelableArrayList("values");
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state");
                }
                for (int i = 0; i < parcelableArrayList.size(); i++) {
                    hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
                }
                whVar = new wh(hashMap);
            }
        }
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, whVar);
        savedStateHandleController.i(kmVar, zgVar);
        k(kmVar, zgVar);
        return savedStateHandleController;
    }

    public static void k(final km kmVar, final zg zgVar) {
        zg.b bVar = ((gh) zgVar).c;
        if (bVar == zg.b.INITIALIZED || bVar.isAtLeast(zg.b.STARTED)) {
            kmVar.c(a.class);
        } else {
            zgVar.a(new dh() {
                /* class androidx.lifecycle.SavedStateHandleController.AnonymousClass1 */

                @Override // defpackage.dh
                public void c(fh fhVar, zg.a aVar) {
                    if (aVar == zg.a.ON_START) {
                        gh ghVar = (gh) zg.this;
                        ghVar.d("removeObserver");
                        ghVar.b.n(this);
                        kmVar.c(a.class);
                    }
                }
            });
        }
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        if (aVar == zg.a.ON_DESTROY) {
            this.g = false;
            gh ghVar = (gh) fhVar.getLifecycle();
            ghVar.d("removeObserver");
            ghVar.b.n(this);
        }
    }

    public void i(km kmVar, zg zgVar) {
        if (!this.g) {
            this.g = true;
            zgVar.a(this);
            kmVar.b(this.f, this.h.d);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
}
