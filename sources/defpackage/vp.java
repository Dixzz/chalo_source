package defpackage;

import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import defpackage.bq;

/* renamed from: vp  reason: default package */
/* compiled from: OneTimeWorkRequest */
public final class vp extends bq {

    /* renamed from: vp$a */
    /* compiled from: OneTimeWorkRequest */
    public static final class a extends bq.a<a, vp> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.b.d = OverwritingInputMerger.class.getName();
        }
    }

    public vp(a aVar) {
        super(aVar.f467a, aVar.b, aVar.c);
    }
}
