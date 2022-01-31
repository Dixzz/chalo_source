package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.t46;

/* renamed from: u46  reason: default package */
/* compiled from: Parser */
public final class u46 implements t46.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StringBuilder f3452a;

    public u46(StringBuilder sb) {
        this.f3452a = sb;
    }

    @Override // defpackage.t46.b
    public void a(Object obj) {
        StringBuilder sb = this.f3452a;
        String str = (String) obj;
        sb.append(str.length() + ProductDiscountsObject.KEY_DELIMITER + str);
    }
}
