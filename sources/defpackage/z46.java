package defpackage;

import com.rabbitmq.client.ConnectionFactory;
import defpackage.b56;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: z46  reason: default package */
/* compiled from: IOParser */
public final class z46 implements b56 {
    public static final Logger b = Logger.getLogger(z46.class.getName());

    /* renamed from: z46$a */
    /* compiled from: IOParser */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public a56 f4126a;
        public List<byte[]> b = new ArrayList();

        public a(a56 a56) {
            this.f4126a = a56;
        }
    }

    /* renamed from: z46$b */
    /* compiled from: IOParser */
    public static final class b implements b56.a {

        /* renamed from: a  reason: collision with root package name */
        public a f4127a = null;
        public b56.a.AbstractC0004a b;
    }

    /* renamed from: z46$c */
    /* compiled from: IOParser */
    public static final class c implements b56.b {
        public final String a(a56 a56) {
            StringBuilder i0 = hj1.i0("");
            i0.append(a56.f123a);
            StringBuilder sb = new StringBuilder(i0.toString());
            int i = a56.f123a;
            if (5 == i || 6 == i) {
                sb.append(a56.e);
                sb.append("-");
            }
            String str = a56.c;
            if (!(str == null || str.length() == 0 || ConnectionFactory.DEFAULT_VHOST.equals(a56.c))) {
                sb.append(a56.c);
                sb.append(",");
            }
            int i2 = a56.b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            T t = a56.d;
            if (t != null) {
                sb.append((Object) t);
            }
            Logger logger = z46.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("encoded %s as %s", a56, sb));
            }
            return sb.toString();
        }
    }

    public static a56 a() {
        return new a56(4, "parser error");
    }
}
