package defpackage;

import android.content.Context;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* renamed from: yy1  reason: default package */
public class yy1 {

    /* renamed from: a  reason: collision with root package name */
    public final TreeSet<String> f4099a;

    public yy1(Context context, Collection<String> collection) {
        TreeSet<String> treeSet = new TreeSet<>();
        this.f4099a = treeSet;
        treeSet.clear();
        HashSet hashSet = new HashSet();
        hashSet.addAll(collection);
        hashSet.add(context.getApplicationContext().getPackageName());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            boolean z = true;
            Iterator<String> it2 = this.f4099a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (str.startsWith(next)) {
                    z = false;
                } else if (next.startsWith(str)) {
                    this.f4099a.remove(next);
                }
            }
            if (z) {
                this.f4099a.add(str);
            }
        }
    }
}
