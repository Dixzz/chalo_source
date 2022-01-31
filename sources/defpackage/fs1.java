package defpackage;

/* renamed from: fs1  reason: default package */
/* compiled from: ManifestParser */
public final class fs1 {
    public static es1 a(String str) {
        Object obj;
        Object obj2;
        try {
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof es1) {
                    return (es1) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (InstantiationException e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + obj, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + obj2, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}
