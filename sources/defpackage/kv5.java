package defpackage;

import com.rabbitmq.client.StringRpcServer;
import defpackage.hk5;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: kv5  reason: default package */
/* compiled from: User */
public class kv5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f2125a = new CopyOnWriteArrayList();
    public final hk5 b;
    public final kp5 c;

    /* renamed from: kv5$a */
    /* compiled from: User */
    public interface a {
        void a(boolean z);
    }

    public kv5(hk5 hk5, kp5 kp5) {
        boolean z;
        this.b = hk5;
        this.c = kp5;
        String g = hk5.g("com.urbanairship.user.PASSWORD", null);
        if (!hd3.G1(g)) {
            String a2 = a(g, hk5.g("com.urbanairship.user.ID", null));
            hk5.a f = hk5.f("com.urbanairship.user.USER_TOKEN");
            synchronized (f) {
                if (f.d(a2)) {
                    f.c(a2);
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                hk5.l("com.urbanairship.user.PASSWORD");
            }
        }
    }

    public static String a(String str, String str2) {
        if (hd3.G1(str) || hd3.G1(str2)) {
            return null;
        }
        byte[] f = f(str.getBytes(), str2.getBytes());
        StringBuilder sb = new StringBuilder();
        int length = f.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(f[i])));
        }
        return sb.toString();
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    public String b() {
        if (this.b.g("com.urbanairship.user.USER_TOKEN", null) != null) {
            return this.b.g("com.urbanairship.user.ID", null);
        }
        return null;
    }

    public String c() {
        if (this.b.g("com.urbanairship.user.ID", null) == null) {
            return null;
        }
        String g = this.b.g("com.urbanairship.user.USER_TOKEN", null);
        String b2 = b();
        if (hd3.G1(g) || hd3.G1(b2)) {
            return null;
        }
        int length = g.length();
        if (length % 2 != 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[(length / 2)];
            int i = 0;
            while (i < length) {
                int i2 = i + 2;
                bArr[i / 2] = Byte.parseByte(g.substring(i, i2), 16);
                i = i2;
            }
            return new String(f(bArr, b2.getBytes()), StringRpcServer.STRING_ENCODING);
        } catch (UnsupportedEncodingException e) {
            yj5.e(e, "RichPushUser - Unable to decode string.", new Object[0]);
            return null;
        } catch (NumberFormatException e2) {
            yj5.e(e2, "RichPushUser - String contains invalid hex numbers.", new Object[0]);
            return null;
        }
    }

    public boolean d() {
        return !hd3.G1(b()) && !hd3.G1(c());
    }

    public void e(String str, String str2, String str3) {
        hk5 hk5 = this.b;
        if (str3 == null) {
            hk5.l("com.urbanairship.user.REGISTERED_CHANNEL_ID");
        } else {
            hk5.f("com.urbanairship.user.REGISTERED_CHANNEL_ID").b(str3);
        }
        yj5.a("Setting Rich Push user: %s", str);
        hk5 hk52 = this.b;
        if (str == null) {
            hk52.l("com.urbanairship.user.ID");
        } else {
            hk52.f("com.urbanairship.user.ID").b(str);
        }
        hk5 hk53 = this.b;
        String a2 = a(str2, str);
        if (a2 == null) {
            hk53.l("com.urbanairship.user.USER_TOKEN");
        } else {
            hk53.f("com.urbanairship.user.USER_TOKEN").b(a2);
        }
    }
}
