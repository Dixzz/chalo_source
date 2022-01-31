package defpackage;

import butterknife.internal.ButterKnifeProcessor;
import dalvik.system.PathClassLoader;

/* renamed from: uc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class uc2 extends PathClassLoader {
    public uc2(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith(ButterKnifeProcessor.JAVA_PREFIX) && !str.startsWith(ButterKnifeProcessor.ANDROID_PREFIX)) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z);
    }
}
