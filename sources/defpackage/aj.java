package defpackage;

import android.content.Context;
import android.os.Bundle;
import defpackage.zg;
import java.util.UUID;

/* renamed from: aj  reason: default package */
/* compiled from: NavBackStackEntry */
public final class aj implements fh, hi, mm {
    public final ej f;
    public Bundle g;
    public final gh h;
    public final lm i;
    public final UUID j;
    public zg.b k;
    public zg.b l;
    public bj m;

    public aj(Context context, ej ejVar, Bundle bundle, fh fhVar, bj bjVar) {
        this(context, ejVar, bundle, fhVar, bjVar, UUID.randomUUID(), null);
    }

    public void a() {
        if (this.k.ordinal() < this.l.ordinal()) {
            this.h.i(this.k);
        } else {
            this.h.i(this.l);
        }
    }

    @Override // defpackage.fh
    public zg getLifecycle() {
        return this.h;
    }

    @Override // defpackage.mm
    public km getSavedStateRegistry() {
        return this.i.b;
    }

    @Override // defpackage.hi
    public gi getViewModelStore() {
        bj bjVar = this.m;
        if (bjVar != null) {
            UUID uuid = this.j;
            gi giVar = bjVar.c.get(uuid);
            if (giVar != null) {
                return giVar;
            }
            gi giVar2 = new gi();
            bjVar.c.put(uuid, giVar2);
            return giVar2;
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public aj(Context context, ej ejVar, Bundle bundle, fh fhVar, bj bjVar, UUID uuid, Bundle bundle2) {
        this.h = new gh(this);
        lm lmVar = new lm(this);
        this.i = lmVar;
        this.k = zg.b.CREATED;
        this.l = zg.b.RESUMED;
        this.j = uuid;
        this.f = ejVar;
        this.g = bundle;
        this.m = bjVar;
        lmVar.a(bundle2);
        if (fhVar != null) {
            this.k = ((gh) fhVar.getLifecycle()).c;
        }
    }
}
