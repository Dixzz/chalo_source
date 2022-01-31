package defpackage;

import java.security.cert.Certificate;
import java.util.List;

/* renamed from: ai6  reason: default package */
/* compiled from: Handshake.kt */
public final class ai6 extends o86 implements h76<List<? extends Certificate>> {
    public final /* synthetic */ List f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ai6(List list) {
        super(0);
        this.f = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public List<? extends Certificate> invoke() {
        return this.f;
    }
}
