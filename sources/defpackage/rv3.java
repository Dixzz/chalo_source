package defpackage;

/* renamed from: rv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class rv3 implements zv3 {

    /* renamed from: a  reason: collision with root package name */
    public zv3[] f3137a;

    public rv3(zv3... zv3Arr) {
        this.f3137a = zv3Arr;
    }

    @Override // defpackage.zv3
    public final aw3 a(Class<?> cls) {
        zv3[] zv3Arr = this.f3137a;
        for (zv3 zv3 : zv3Arr) {
            if (zv3.b(cls)) {
                return zv3.a(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // defpackage.zv3
    public final boolean b(Class<?> cls) {
        for (zv3 zv3 : this.f3137a) {
            if (zv3.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
