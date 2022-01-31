package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: k30  reason: default package */
/* compiled from: MatchingSorter */
public class k30<T> {

    /* renamed from: k30$a */
    /* compiled from: MatchingSorter */
    public interface a<T> {
        String a(T t);
    }

    public List<T> a(String str, List<T> list, a<T> aVar) {
        String lowerCase = str.toLowerCase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : list) {
            String lowerCase2 = aVar.a(t).toLowerCase();
            if (lowerCase2.startsWith(lowerCase)) {
                arrayList.add(t);
            } else if (lowerCase2.contains(lowerCase)) {
                arrayList2.add(t);
            }
        }
        Collections.sort(arrayList, new j30(this, aVar));
        Collections.sort(arrayList2, new j30(this, aVar));
        arrayList.addAll(arrayList2);
        return arrayList;
    }
}
