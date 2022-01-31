package androidx.savedstate;

import defpackage.zg;

public class SavedStateRegistry$1 implements dh {
    public final /* synthetic */ km f;

    public SavedStateRegistry$1(km kmVar) {
        this.f = kmVar;
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        if (aVar == zg.a.ON_START) {
            this.f.e = true;
        } else if (aVar == zg.a.ON_STOP) {
            this.f.e = false;
        }
    }
}
