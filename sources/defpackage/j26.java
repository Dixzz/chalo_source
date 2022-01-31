package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.Objects;

/* renamed from: j26  reason: default package */
/* compiled from: ViewPumpContextWrapper.kt */
public final class j26 extends ContextWrapper {
    public static final /* synthetic */ s96[] b;
    public static final a c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final j56 f1866a;

    /* renamed from: j26$a */
    /* compiled from: ViewPumpContextWrapper.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final ContextWrapper a(Context context) {
            n86.f(context, "base");
            return new j26(context, null);
        }
    }

    static {
        r86 r86 = new r86(z86.a(j26.class), "inflater", "getInflater()Lio/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater;");
        Objects.requireNonNull(z86.f4146a);
        b = new s96[]{r86};
    }

    public j26(Context context, j86 j86) {
        super(context);
        k56 k56 = k56.NONE;
        k26 k26 = new k26(this);
        n86.e(k56, "mode");
        n86.e(k26, "initializer");
        this.f1866a = new t56(k26);
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        n86.f(str, "name");
        if (!n86.a("layout_inflater", str)) {
            return super.getSystemService(str);
        }
        j56 j56 = this.f1866a;
        s96 s96 = b[0];
        return (o26) j56.getValue();
    }
}
