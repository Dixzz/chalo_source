package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: aq5  reason: default package */
/* compiled from: PendingAttributeMutationStore */
public class aq5 implements h2<List<List<qp5>>, List<List<qp5>>> {
    public aq5(zp5 zp5) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.h2
    public List<List<qp5>> apply(List<List<qp5>> list) {
        ArrayList arrayList = new ArrayList();
        for (List<qp5> list2 : list) {
            arrayList.addAll(list2);
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(qp5.a(arrayList));
    }
}
