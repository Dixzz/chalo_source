package defpackage;

import android.os.Bundle;
import defpackage.ej;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* renamed from: mj  reason: default package */
/* compiled from: Navigator */
public abstract class mj<D extends ej> {

    /* renamed from: mj$a */
    /* compiled from: Navigator */
    public interface a {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: mj$b */
    /* compiled from: Navigator */
    public @interface b {
        String value();
    }

    public abstract D a();

    public abstract ej b(D d, Bundle bundle, kj kjVar, a aVar);

    public void c(Bundle bundle) {
    }

    public Bundle d() {
        return null;
    }

    public abstract boolean e();
}
