package defpackage;

/* renamed from: fc  reason: default package */
/* compiled from: ExtensionSchemas */
public final class fc {

    /* renamed from: a  reason: collision with root package name */
    public static final dc<?> f1111a = new ec();
    public static final dc<?> b;

    static {
        dc<?> dcVar;
        try {
            dcVar = (dc) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            dcVar = null;
        }
        b = dcVar;
    }
}
