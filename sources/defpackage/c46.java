package defpackage;

import defpackage.m36;
import defpackage.u36;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/* renamed from: c46  reason: default package */
/* compiled from: Socket */
public class c46 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u36 f518a;

    public c46(u36 u36, u36 u362) {
        this.f518a = u362;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        u36 u36 = this.f518a;
        s46 s46 = objArr.length > 0 ? (s46) objArr[0] : null;
        u36.e eVar = u36.y;
        if (eVar == u36.e.OPENING || eVar == u36.e.OPEN || eVar == u36.e.CLOSING) {
            Logger logger = u36.B;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("socket received: type '%s', data '%s'", s46.f3185a, s46.b));
            }
            u36.a("packet", s46);
            u36.a("heartbeat", new Object[0]);
            if ("open".equals(s46.f3185a)) {
                try {
                    u36.k(new o36(s46.b));
                } catch (JSONException e) {
                    u36.a("error", new n36(e));
                }
            } else if ("pong".equals(s46.f3185a)) {
                u36.m();
                u36.a("pong", new Object[0]);
            } else if ("error".equals(s46.f3185a)) {
                n36 n36 = new n36("server error");
                n36.f = s46.b;
                u36.j(n36);
            } else if ("message".equals(s46.f3185a)) {
                u36.a("data", s46.b);
                u36.a("message", s46.b);
            }
        } else {
            Logger logger2 = u36.B;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(String.format("packet received with socket readyState '%s'", u36.y));
            }
        }
    }
}
