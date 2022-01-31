package defpackage;

/* renamed from: p05  reason: default package */
/* compiled from: GeneratedMessageInfoFactory */
public class p05 implements i15 {

    /* renamed from: a  reason: collision with root package name */
    public static final p05 f2754a = new p05();

    @Override // defpackage.i15
    public h15 a(Class<?> cls) {
        if (q05.class.isAssignableFrom(cls)) {
            try {
                return (h15) q05.getDefaultInstance(cls.asSubclass(q05.class)).buildMessageInfo();
            } catch (Exception e) {
                StringBuilder i0 = hj1.i0("Unable to get message info for ");
                i0.append(cls.getName());
                throw new RuntimeException(i0.toString(), e);
            }
        } else {
            StringBuilder i02 = hj1.i0("Unsupported message type: ");
            i02.append(cls.getName());
            throw new IllegalArgumentException(i02.toString());
        }
    }

    @Override // defpackage.i15
    public boolean b(Class<?> cls) {
        return q05.class.isAssignableFrom(cls);
    }
}
