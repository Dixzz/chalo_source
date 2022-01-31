package defpackage;

import android.util.Log;
import android.util.SparseArray;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a32;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: s62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class s62 extends x62 {
    public final SparseArray<r62> k = new SparseArray<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s62(s32 s32) {
        super(s32, q22.d);
        Object obj = q22.c;
        this.f.a("AutoManageHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.k.size(); i++) {
            r62 o = o(i);
            if (o != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(o.f);
                printWriter.println(ProductDiscountsObject.KEY_DELIMITER);
                o.g.h(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        this.g = true;
        String.valueOf(this.k).length();
        if (this.h.get() == null) {
            for (int i = 0; i < this.k.size(); i++) {
                r62 o = o(i);
                if (o != null) {
                    o.g.f();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i() {
        this.g = false;
        for (int i = 0; i < this.k.size(); i++) {
            r62 o = o(i);
            if (o != null) {
                o.g.g();
            }
        }
    }

    @Override // defpackage.x62
    public final void l(ConnectionResult connectionResult, int i) {
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        r62 r62 = this.k.get(i);
        if (r62 != null) {
            r62 r622 = this.k.get(i);
            this.k.remove(i);
            if (r622 != null) {
                r622.g.t(r622);
                r622.g.g();
            }
            a32.c cVar = r62.h;
            if (cVar != null) {
                cVar.F(connectionResult);
            }
        }
    }

    @Override // defpackage.x62
    public final void m() {
        for (int i = 0; i < this.k.size(); i++) {
            r62 o = o(i);
            if (o != null) {
                o.g.f();
            }
        }
    }

    public final r62 o(int i) {
        if (this.k.size() <= i) {
            return null;
        }
        SparseArray<r62> sparseArray = this.k;
        return sparseArray.get(sparseArray.keyAt(i));
    }
}
