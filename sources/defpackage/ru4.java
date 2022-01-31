package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: ru4  reason: default package */
public final class ru4 implements nw4<Context> {

    /* renamed from: a  reason: collision with root package name */
    public final nu4 f3135a;

    public ru4(nu4 nu4) {
        this.f3135a = nu4;
    }

    /* renamed from: b */
    public final Context a() {
        Context context = this.f3135a.f2606a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }
}
