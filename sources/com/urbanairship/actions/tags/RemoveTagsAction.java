package com.urbanairship.actions.tags;

import com.urbanairship.UAirship;
import defpackage.qk5;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RemoveTagsAction extends bl5 {

    public static class RemoveTagsPredicate implements qk5.b {
        @Override // defpackage.qk5.b
        public boolean a(ok5 ok5) {
            return 1 != ok5.f2706a;
        }
    }

    @Override // defpackage.bl5
    public void g(Map<String, Set<String>> map) {
        yj5.f("RemoveTagsAction - Removing channel tag groups: %s", map);
        kp5 j = j();
        Objects.requireNonNull(j);
        lp5 lp5 = new lp5(j);
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            lp5.e(entry.getKey(), entry.getValue());
        }
        lp5.c();
    }

    @Override // defpackage.bl5
    public void h(Set<String> set) {
        yj5.f("RemoveTagsAction - Removing tags: %s", set);
        kp5 j = j();
        Objects.requireNonNull(j);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.removeAll(set);
        hashSet2.addAll(set);
        synchronized (j.l) {
            if (!j.i.d(32)) {
                yj5.i("AirshipChannel - Unable to apply tag group edits when opted out of tags and attributes.", new Object[0]);
                return;
            }
            Set<String> o = j.o();
            o.addAll(hashSet);
            o.removeAll(hashSet2);
            j.r(o);
        }
    }

    @Override // defpackage.bl5
    public void i(Map<String, Set<String>> map) {
        yj5.f("RemoveTagsAction - Removing named user tag groups: %s", map);
        up5 up5 = UAirship.l().o;
        Objects.requireNonNull(up5);
        vp5 vp5 = new vp5(up5);
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            vp5.e(entry.getKey(), entry.getValue());
        }
        vp5.c();
    }
}
