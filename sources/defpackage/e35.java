package defpackage;

import java.util.EnumMap;
import java.util.Map;

/* renamed from: e35  reason: default package */
/* compiled from: Result */
public final class e35 {

    /* renamed from: a  reason: collision with root package name */
    public final String f921a;
    public final byte[] b;
    public g35[] c;
    public final o25 d;
    public Map<f35, Object> e = null;

    public e35(String str, byte[] bArr, g35[] g35Arr, o25 o25) {
        System.currentTimeMillis();
        this.f921a = str;
        this.b = bArr;
        this.c = g35Arr;
        this.d = o25;
    }

    public void a(Map<f35, Object> map) {
        if (map != null) {
            Map<f35, Object> map2 = this.e;
            if (map2 == null) {
                this.e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void b(f35 f35, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(f35.class);
        }
        this.e.put(f35, obj);
    }

    public String toString() {
        return this.f921a;
    }

    public e35(String str, byte[] bArr, int i, g35[] g35Arr, o25 o25, long j) {
        this.f921a = str;
        this.b = bArr;
        this.c = g35Arr;
        this.d = o25;
    }
}
