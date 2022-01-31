package defpackage;

import defpackage.kc;

/* renamed from: jc  reason: default package */
/* compiled from: GeneratedMessageInfoFactory */
public class jc implements cd {

    /* renamed from: a  reason: collision with root package name */
    public static final jc f1902a = new jc();

    @Override // defpackage.cd
    public bd a(Class<?> cls) {
        if (kc.class.isAssignableFrom(cls)) {
            try {
                return (bd) kc.h(cls.asSubclass(kc.class)).f(kc.f.BUILD_MESSAGE_INFO);
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

    @Override // defpackage.cd
    public boolean b(Class<?> cls) {
        return kc.class.isAssignableFrom(cls);
    }
}
