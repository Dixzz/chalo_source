package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: zp5  reason: default package */
/* compiled from: PendingAttributeMutationStore */
public class zp5 extends wy5<List<qp5>> {

    /* renamed from: zp5$a */
    /* compiled from: PendingAttributeMutationStore */
    public class a implements h2<List<qp5>, cu5> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.h2
        public cu5 apply(List<qp5> list) {
            return JsonValue.x(list);
        }
    }

    /* renamed from: zp5$b */
    /* compiled from: PendingAttributeMutationStore */
    public class b implements h2<JsonValue, List<qp5>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.h2
        public List<qp5> apply(JsonValue jsonValue) {
            yt5 m = jsonValue.m();
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = m.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(qp5.c(it.next()));
                } catch (xt5 e) {
                    yj5.e(e, "Invalid attribute.", new Object[0]);
                }
            }
            return arrayList;
        }
    }

    public zp5(hk5 hk5, String str) {
        super(hk5, str, new a(), new b());
    }
}
