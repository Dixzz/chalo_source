package defpackage;

import defpackage.cp5;
import java.util.List;
import java.util.Objects;

/* renamed from: bp5  reason: default package */
/* compiled from: AudienceHistorian */
public class bp5 implements pp5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cp5 f465a;

    public bp5(cp5 cp5) {
        this.f465a = cp5;
    }

    @Override // defpackage.pp5
    public void a(String str, List<qp5> list) {
        Objects.requireNonNull(this.f465a.f742a);
        long currentTimeMillis = System.currentTimeMillis();
        for (qp5 qp5 : list) {
            cp5 cp5 = this.f465a;
            cp5.a<qp5> aVar = new cp5.a<>(1, str, currentTimeMillis, qp5);
            synchronized (cp5.e) {
                cp5.e.add(aVar);
            }
        }
    }
}
