package defpackage;

import com.rabbitmq.client.ConnectionFactory;

/* renamed from: ce5  reason: default package */
/* compiled from: PropertyDescription */
public class ce5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f558a;
    public final Class<?> b;
    public final vd5 c;
    public final String d;

    public ce5(String str, Class<?> cls, vd5 vd5, String str2) {
        this.f558a = str;
        this.b = cls;
        this.c = vd5;
        this.d = str2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("[PropertyDescription ");
        i0.append(this.f558a);
        i0.append(",");
        i0.append(this.b);
        i0.append(", ");
        i0.append(this.c);
        i0.append(ConnectionFactory.DEFAULT_VHOST);
        return hj1.a0(i0, this.d, "]");
    }
}
