package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.pb5;
import defpackage.wa5;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: bb5  reason: default package */
/* compiled from: Draft */
public abstract class bb5 {
    public static final byte[] c = zb5.b("<policy-file-request/>\u0000");

    /* renamed from: a  reason: collision with root package name */
    public wa5.b f406a = null;
    public pb5.a b = null;

    /* renamed from: bb5$a */
    /* compiled from: Draft */
    public enum a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* renamed from: bb5$b */
    /* compiled from: Draft */
    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public static String j(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                byteBuffer.position(byteBuffer.position() - allocate.position());
                allocate = null;
                break;
            }
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                break;
            }
            b2 = b3;
        }
        if (allocate == null) {
            return null;
        }
        byte[] array = allocate.array();
        int limit = allocate.limit();
        CodingErrorAction codingErrorAction = zb5.f4153a;
        try {
            return new String(array, 0, limit, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v6, resolved type: ub5 */
    /* JADX WARN: Multi-variable type inference failed */
    public static sb5 n(ByteBuffer byteBuffer, wa5.b bVar) throws jb5, gb5 {
        tb5 tb5;
        String j = j(byteBuffer);
        if (j != null) {
            String[] split = j.split(" ", 3);
            if (split.length == 3) {
                if (bVar == wa5.b.CLIENT) {
                    ub5 ub5 = new ub5();
                    Short.parseShort(split[1]);
                    ub5.c = split[2];
                    tb5 = ub5;
                } else {
                    tb5 tb52 = new tb5();
                    String str = split[1];
                    if (str != null) {
                        tb52.c = str;
                        tb5 = tb52;
                    } else {
                        throw new IllegalArgumentException("http resource descriptor must not be null");
                    }
                }
                String j2 = j(byteBuffer);
                while (j2 != null && j2.length() > 0) {
                    String[] split2 = j2.split(ProductDiscountsObject.KEY_DELIMITER, 2);
                    if (split2.length == 2) {
                        tb5.b.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        j2 = j(byteBuffer);
                    } else {
                        throw new jb5("not an http header");
                    }
                }
                if (j2 != null) {
                    return tb5;
                }
                throw new gb5();
            }
            throw new jb5();
        }
        throw new gb5(byteBuffer.capacity() + 128);
    }

    public abstract b a(rb5 rb5, xb5 xb5) throws jb5;

    public abstract b b(rb5 rb5) throws jb5;

    public boolean c(vb5 vb5) {
        return vb5.f("Upgrade").equalsIgnoreCase("websocket") && vb5.f("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public int d(int i) throws kb5, hb5 {
        if (i >= 0) {
            return i;
        }
        throw new hb5(1002, "Negative count");
    }

    public abstract bb5 e();

    public abstract ByteBuffer f(pb5 pb5);

    public List<ByteBuffer> g(vb5 vb5, wa5.b bVar) {
        int i;
        StringBuilder sb = new StringBuilder(100);
        if (vb5 instanceof rb5) {
            sb.append("GET ");
            sb.append(((rb5) vb5).a());
            sb.append(" HTTP/1.1");
        } else if (vb5 instanceof xb5) {
            StringBuilder i0 = hj1.i0("HTTP/1.1 101 ");
            i0.append(((xb5) vb5).c());
            sb.append(i0.toString());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> b2 = vb5.b();
        while (b2.hasNext()) {
            String next = b2.next();
            String f = vb5.f(next);
            sb.append(next);
            sb.append(": ");
            sb.append(f);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        String sb2 = sb.toString();
        CodingErrorAction codingErrorAction = zb5.f4153a;
        try {
            byte[] bytes = sb2.getBytes("ASCII");
            byte[] d = vb5.d();
            if (d == null) {
                i = 0;
            } else {
                i = d.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i + bytes.length);
            allocate.put(bytes);
            if (d != null) {
                allocate.put(d);
            }
            allocate.flip();
            return Collections.singletonList(allocate);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract a h();

    public abstract tb5 i(tb5 tb5) throws jb5;

    public abstract void k();

    public abstract List<pb5> l(ByteBuffer byteBuffer) throws hb5;

    public vb5 m(ByteBuffer byteBuffer) throws jb5 {
        return n(byteBuffer, this.f406a);
    }
}
