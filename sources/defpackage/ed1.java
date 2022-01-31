package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ed1  reason: default package */
/* compiled from: AnalyticsEvent */
public class ed1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f961a;
    public Map<String, Object> b;
    public long c;

    public ed1(String str, long j) {
        this.f961a = str;
        this.c = j;
    }

    public void a(String str, Object obj) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, obj);
    }

    public ed1(String str, long j, Map<String, Object> map) {
        this.f961a = str;
        this.c = j;
        this.b = map;
    }
}
