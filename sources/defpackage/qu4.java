package defpackage;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import java.util.Objects;

/* renamed from: qu4  reason: default package */
public final class qu4 implements nw4<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f2992a;
    public final nw4 b;
    public final /* synthetic */ int c = 0;

    public qu4(nw4<ku4> nw4, nw4<Context> nw42) {
        this.f2992a = nw4;
        this.b = nw42;
    }

    public qu4(nw4<Context> nw4, nw4<bs4> nw42, byte[] bArr) {
        this.b = nw4;
        this.f2992a = nw42;
    }

    public qu4(nw4<Context> nw4, nw4<ss4> nw42, char[] cArr) {
        this.f2992a = nw4;
        this.b = nw42;
    }

    public qu4(nw4<bs4> nw4, nw4<vu4> nw42, int[] iArr) {
        this.b = nw4;
        this.f2992a = nw42;
    }

    public qu4(nw4<Context> nw4, nw4<xt4> nw42, short[] sArr) {
        this.f2992a = nw4;
        this.b = nw42;
    }

    @Override // defpackage.nw4
    public final Object a() {
        int i = this.c;
        if (i == 0) {
            Object a2 = this.f2992a.a();
            Context b2 = ((ru4) this.b).a();
            ku4 ku4 = (ku4) a2;
            hd3.w1(b2.getPackageManager(), new ComponentName(b2.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
            hd3.w1(b2.getPackageManager(), new ComponentName(b2.getPackageName(), "com.google.android.play.core.assetpacks.ExtractionForegroundService"), 4);
            int i2 = PlayCoreDialogWrapperActivity.g;
            hd3.w1(b2.getPackageManager(), new ComponentName(b2.getPackageName(), "com.google.android.play.core.common.PlayCoreDialogWrapperActivity"), 1);
            Objects.requireNonNull(ku4, "Cannot return null from a non-@Nullable @Provides method");
            return ku4;
        } else if (i == 1) {
            return new gs4(((ru4) this.b).a(), (bs4) this.f2992a.a());
        } else {
            if (i == 2) {
                return new ur4(((ru4) this.f2992a).a(), (ss4) this.b.a());
            }
            if (i == 3) {
                return new bs4(((ru4) this.f2992a).a(), (xt4) this.b.a());
            }
            return new zt4((bs4) this.b.a(), mw4.b(this.f2992a));
        }
    }
}
