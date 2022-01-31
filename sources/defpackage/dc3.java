package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: dc3  reason: default package */
public final class dc3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f819a;
    public final String b;
    public final boolean c;
    public long d;
    public final Map<String, String> e;

    /* JADX WARN: Incorrect args count in method signature: (JLjava/lang/String;Ljava/lang/String;ZJLjava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public dc3(String str, String str2, boolean z, long j, Map map) {
        gj1.j(str);
        gj1.j(str2);
        this.f819a = str;
        this.b = str2;
        this.c = z;
        this.d = j;
        this.e = new HashMap(map);
    }
}
