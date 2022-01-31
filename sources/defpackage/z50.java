package defpackage;

import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import defpackage.n00;
import java.util.List;
import java.util.Objects;

/* renamed from: z50  reason: default package */
/* compiled from: VisualValidationFeature.kt */
public final class z50 implements n00.y0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y50 f4129a;
    public final /* synthetic */ List<VisualValidationActivationDetails> b;
    public final /* synthetic */ List<VisualValidationActivationDetails> c;

    public z50(y50 y50, List<VisualValidationActivationDetails> list, List<VisualValidationActivationDetails> list2) {
        this.f4129a = y50;
        this.b = list;
        this.c = list2;
    }

    @Override // defpackage.n00.y0
    public void a(String str) {
        n86.e(str, "errorReason");
        Objects.requireNonNull(this.f4129a);
        ed1 ed1 = new ed1("visual validation ride punch sync failed", Long.MIN_VALUE);
        ed1.a("error message", str);
        ui1.m0(ed1);
    }

    @Override // defpackage.n00.y0
    public void execute() {
        y50.d(this.f4129a, this.b, this.c);
    }
}
