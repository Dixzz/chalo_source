package defpackage;

import defpackage.cp5;
import java.util.Objects;

/* renamed from: ap5  reason: default package */
/* compiled from: AudienceHistorian */
public class ap5 implements gq5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cp5 f277a;

    public ap5(cp5 cp5) {
        this.f277a = cp5;
    }

    @Override // defpackage.gq5
    public void a(String str, jq5 jq5) {
        cp5 cp5 = this.f277a;
        Objects.requireNonNull(cp5.f742a);
        cp5.a<jq5> aVar = new cp5.a<>(1, str, System.currentTimeMillis(), jq5);
        synchronized (cp5.d) {
            cp5.d.add(aVar);
        }
    }
}
