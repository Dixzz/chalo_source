package defpackage;

import defpackage.xy1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: xy1  reason: default package */
public class xy1<T extends xy1> {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f3979a = new HashMap();
    public Map<String, List<az1>> b = new HashMap();
    public List<bz1> c = new ArrayList();
    public List<az1> d = new ArrayList();

    public final T a(String str, String str2) {
        this.f3979a.put(str, str2);
        return this;
    }
}
