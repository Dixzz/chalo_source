package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.GZIPInputStream;

/* renamed from: zt4  reason: default package */
public final class zt4 {
    public static final nv4 c = new nv4("PatchSliceTaskHandler");

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f4210a;
    public final kw4<vu4> b;

    public zt4(bs4 bs4, kw4<vu4> kw4) {
        this.f4210a = bs4;
        this.b = kw4;
    }

    public final void a(yt4 yt4) {
        File j = this.f4210a.j(yt4.b, yt4.c, yt4.d);
        bs4 bs4 = this.f4210a;
        String str = yt4.b;
        int i = yt4.c;
        long j2 = yt4.d;
        String str2 = yt4.h;
        Objects.requireNonNull(bs4);
        File file = new File(new File(bs4.j(str, i, j2), "_metadata"), str2);
        try {
            InputStream inputStream = yt4.j;
            if (yt4.g == 2) {
                inputStream = new GZIPInputStream(inputStream, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            }
            try {
                ds4 ds4 = new ds4(j, file);
                File k = this.f4210a.k(yt4.b, yt4.e, yt4.f, yt4.h);
                if (!k.exists()) {
                    k.mkdirs();
                }
                bu4 bu4 = new bu4(this.f4210a, yt4.b, yt4.e, yt4.f, yt4.h);
                hd3.W1(ds4, inputStream, new rs4(k, bu4), yt4.i);
                bu4.d(0);
                inputStream.close();
                c.b(4, "Patching and extraction finished for slice %s of pack %s.", new Object[]{yt4.h, yt4.b});
                this.b.a().b(yt4.f1171a, yt4.b, yt4.h, 0);
                try {
                    yt4.j.close();
                    return;
                } catch (IOException unused) {
                    c.b(5, "Could not close file for slice %s of pack %s.", new Object[]{yt4.h, yt4.b});
                    return;
                }
            } catch (Throwable th) {
                jw4.f1988a.a(th, th);
            }
            throw th;
        } catch (IOException e) {
            c.b(6, "IOException during patching %s.", new Object[]{e.getMessage()});
            throw new os4(String.format("Error patching slice %s of pack %s.", yt4.h, yt4.b), e, yt4.f1171a);
        }
    }
}
