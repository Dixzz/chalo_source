package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.nio.charset.Charset;

/* renamed from: yo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class yo2 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f4076a = 0;

    static {
        Charset.forName(StringRpcServer.STRING_ENCODING);
    }

    public static pv2 a(kv2 kv2) {
        mv2 t = pv2.t();
        int s = kv2.s();
        if (t.h) {
            t.a();
            t.h = false;
        }
        ((pv2) t.g).zzb = s;
        for (jv2 jv2 : kv2.t()) {
            nv2 t2 = ov2.t();
            String s2 = jv2.t().s();
            if (t2.h) {
                t2.a();
                t2.h = false;
            }
            ov2.v((ov2) t2.g, s2);
            zu2 u = jv2.u();
            if (t2.h) {
                t2.a();
                t2.h = false;
            }
            ov2.w((ov2) t2.g, u);
            bw2 w = jv2.w();
            if (t2.h) {
                t2.a();
                t2.h = false;
            }
            ov2.y((ov2) t2.g, w);
            int v = jv2.v();
            if (t2.h) {
                t2.a();
                t2.h = false;
            }
            ov2.x((ov2) t2.g, v);
            ov2 ov2 = (ov2) t2.c();
            if (t.h) {
                t.a();
                t.h = false;
            }
            pv2.w((pv2) t.g, ov2);
        }
        return (pv2) t.c();
    }
}
