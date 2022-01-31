package defpackage;

import defpackage.cp5;
import java.util.Objects;

/* renamed from: yo5  reason: default package */
/* compiled from: AudienceHistorian */
public class yo5 implements gq5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cp5 f4077a;

    public yo5(cp5 cp5) {
        this.f4077a = cp5;
    }

    @Override // defpackage.gq5
    public void a(String str, jq5 jq5) {
        cp5 cp5 = this.f4077a;
        Objects.requireNonNull(cp5.f742a);
        cp5.a<jq5> aVar = new cp5.a<>(0, str, System.currentTimeMillis(), jq5);
        synchronized (cp5.d) {
            cp5.d.add(aVar);
        }
    }
}
