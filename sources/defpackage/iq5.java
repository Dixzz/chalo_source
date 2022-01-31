package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: iq5  reason: default package */
/* compiled from: TagGroupsEditor */
public class iq5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<jq5> f1561a = new ArrayList();

    public iq5 a(String str, Set<String> set) {
        String trim = str.trim();
        if (hd3.G1(trim)) {
            yj5.c("The tag group ID string cannot be null.", new Object[0]);
            return this;
        } else if (!b(trim)) {
            return this;
        } else {
            Set<String> l2 = hd3.l2(set);
            if (((HashSet) l2).isEmpty()) {
                return this;
            }
            List<jq5> list = this.f1561a;
            HashMap hashMap = new HashMap();
            hashMap.put(trim, new HashSet(l2));
            list.add(new jq5(hashMap, null, null));
            return this;
        }
    }

    public boolean b(String str) {
        return true;
    }

    public void c() {
        d(jq5.a(this.f1561a));
    }

    public void d(List<jq5> list) {
        throw null;
    }

    public iq5 e(String str, Set<String> set) {
        String trim = str.trim();
        if (hd3.G1(trim)) {
            yj5.c("The tag group ID string cannot be null.", new Object[0]);
            return this;
        } else if (!b(trim)) {
            return this;
        } else {
            Set<String> l2 = hd3.l2(set);
            if (((HashSet) l2).isEmpty()) {
                return this;
            }
            List<jq5> list = this.f1561a;
            HashMap hashMap = new HashMap();
            hashMap.put(trim, new HashSet(l2));
            list.add(new jq5(null, hashMap, null));
            return this;
        }
    }
}
