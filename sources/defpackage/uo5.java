package defpackage;

import defpackage.vo5;
import java.util.List;

/* renamed from: uo5  reason: default package */
/* compiled from: LegacyDataMigrator */
public class uo5 implements vo5.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ oo5 f3535a;

    public uo5(vo5 vo5, oo5 oo5) {
        this.f3535a = oo5;
    }

    @Override // defpackage.vo5.b
    public void a(wo5 wo5, List<xo5> list) {
        wo5.k = "actions";
        yj5.h("Saving migrated action schedule: %s triggers: %s", wo5, list);
        this.f3535a.n(wo5, list);
    }
}
