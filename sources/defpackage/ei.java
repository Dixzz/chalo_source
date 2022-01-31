package defpackage;

/* renamed from: ei  reason: default package */
/* compiled from: ViewModelProvider */
public class ei implements ci {

    /* renamed from: a  reason: collision with root package name */
    public static ei f975a;

    @Override // defpackage.ci
    public <T extends zh> T a(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        }
    }
}
