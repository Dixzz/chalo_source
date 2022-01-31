package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* renamed from: wb5  reason: default package */
/* compiled from: HandshakedataImpl1 */
public class wb5 implements sb5 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3757a;
    public TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // defpackage.vb5
    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override // defpackage.vb5
    public byte[] d() {
        return this.f3757a;
    }

    @Override // defpackage.vb5
    public boolean e(String str) {
        return this.b.containsKey(str);
    }

    @Override // defpackage.vb5
    public String f(String str) {
        String str2 = this.b.get(str);
        return str2 == null ? "" : str2;
    }
}
