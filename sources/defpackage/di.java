package defpackage;

/* renamed from: di  reason: default package */
/* compiled from: ViewModelProvider */
public abstract class di extends fi implements ci {
    @Override // defpackage.ci
    public <T extends zh> T a(Class<T> cls) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    public abstract <T extends zh> T c(String str, Class<T> cls);
}
