package defpackage;

import java.io.File;
import java.io.IOException;

/* renamed from: ar1  reason: default package */
/* compiled from: GifDrawableEncoder */
public class ar1 implements hm1<zq1> {
    @Override // defpackage.am1
    public boolean a(Object obj, File file, fm1 fm1) {
        try {
            kt1.b(((zq1) ((rn1) obj).get()).f.b.f881a.e().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // defpackage.hm1
    public zl1 b(fm1 fm1) {
        return zl1.SOURCE;
    }
}
