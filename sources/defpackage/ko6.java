package defpackage;

/* renamed from: ko6  reason: default package */
/* compiled from: SystemLibraryLoader */
public final class ko6 implements go6 {
    public String a(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return System.mapLibraryName(str);
        }
        return str;
    }
}
