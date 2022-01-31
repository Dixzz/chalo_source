package defpackage;

import android.content.Context;
import com.squareup.picasso.Picasso;
import defpackage.je;
import defpackage.lf5;
import java.io.IOException;

/* renamed from: we5  reason: default package */
/* compiled from: FileRequestHandler */
public class we5 extends re5 {
    public we5(Context context) {
        super(context);
    }

    @Override // defpackage.re5, defpackage.lf5
    public boolean c(jf5 jf5) {
        return "file".equals(jf5.c.getScheme());
    }

    @Override // defpackage.re5, defpackage.lf5
    public lf5.a f(jf5 jf5, int i) throws IOException {
        qn6 y = ec6.y(this.f3074a.getContentResolver().openInputStream(jf5.c));
        Picasso.d dVar = Picasso.d.DISK;
        je jeVar = new je(jf5.c.getPath());
        je.b d = jeVar.d("Orientation");
        int i2 = 1;
        if (d != null) {
            try {
                i2 = d.f(jeVar.f);
            } catch (NumberFormatException unused) {
            }
        }
        return new lf5.a(null, y, dVar, i2);
    }
}
