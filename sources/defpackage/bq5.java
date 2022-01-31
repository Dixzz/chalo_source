package defpackage;

import com.urbanairship.json.JsonValue;

/* renamed from: bq5  reason: default package */
/* compiled from: PendingTagGroupMutationStore */
public class bq5 extends wy5<jq5> {

    /* renamed from: bq5$a */
    /* compiled from: PendingTagGroupMutationStore */
    public class a implements h2<jq5, cu5> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.h2
        public cu5 apply(jq5 jq5) {
            return jq5;
        }
    }

    /* renamed from: bq5$b */
    /* compiled from: PendingTagGroupMutationStore */
    public class b implements h2<JsonValue, jq5> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.h2
        public jq5 apply(JsonValue jsonValue) {
            zt5 n = jsonValue.n();
            return new jq5(hd3.T(n.u("add")), hd3.T(n.u("remove")), hd3.T(n.u("set")));
        }
    }

    public bq5(hk5 hk5, String str) {
        super(hk5, str, new a(), new b());
    }
}
