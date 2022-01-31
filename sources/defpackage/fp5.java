package defpackage;

import com.urbanairship.json.JsonValue;

/* renamed from: fp5  reason: default package */
/* compiled from: TagGroupLookupResponseCache */
public class fp5 {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f1157a;

    public fp5(hk5 hk5, hy5 hy5) {
        this.f1157a = hk5;
    }

    public gp5 a() {
        JsonValue d = this.f1157a.d("com.urbanairship.iam.tags.TAG_CACHE_RESPONSE");
        if (d.l()) {
            return null;
        }
        zt5 n = d.n();
        return new gp5(n.u("status").e(0), hd3.t2(n.u("tag_groups")), n.u("last_modified").i());
    }
}
