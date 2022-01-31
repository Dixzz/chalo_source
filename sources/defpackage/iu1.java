package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: iu1  reason: default package */
/* compiled from: CCTDestination */
public final class iu1 implements ev1 {
    public static final String c = gj1.T("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
    public static final String d;
    public static final String e;
    public static final Set<zt1> f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zt1("proto"), new zt1("json"))));
    public static final iu1 g;

    /* renamed from: a  reason: collision with root package name */
    public final String f1573a;
    public final String b;

    static {
        String T = gj1.T("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        d = T;
        String T2 = gj1.T("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        e = T2;
        g = new iu1(T, T2);
    }

    public iu1(String str, String str2) {
        this.f1573a = str;
        this.b = str2;
    }

    public static iu1 a(byte[] bArr) {
        String str = new String(bArr, Charset.forName(StringRpcServer.STRING_ENCODING));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new iu1(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public byte[] b() {
        String str = this.b;
        if (str == null && this.f1573a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f1573a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(StringRpcServer.STRING_ENCODING));
    }
}
