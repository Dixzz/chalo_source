package defpackage;

/* renamed from: l05  reason: default package */
/* compiled from: ExtensionSchemas */
public final class l05 {

    /* renamed from: a  reason: collision with root package name */
    public static final j05<?> f2147a = new k05();
    public static final j05<?> b;

    static {
        j05<?> j05;
        try {
            j05 = (j05) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            j05 = null;
        }
        b = j05;
    }
}
