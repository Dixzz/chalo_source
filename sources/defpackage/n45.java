package defpackage;

import java.nio.charset.Charset;

/* renamed from: n45  reason: default package */
/* compiled from: StringUtils */
public final class n45 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2514a;
    public static final boolean b;

    static {
        String name = Charset.defaultCharset().name();
        f2514a = name;
        b = "SJIS".equalsIgnoreCase(name) || "EUC_JP".equalsIgnoreCase(name);
    }
}
