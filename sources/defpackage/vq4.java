package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: vq4  reason: default package */
public final class vq4 implements nw4<Context> {

    /* renamed from: a  reason: collision with root package name */
    public final tq4 f3675a;

    public vq4(tq4 tq4) {
        this.f3675a = tq4;
    }

    /* renamed from: b */
    public final Context a() {
        Context context = this.f3675a.f3394a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }
}
