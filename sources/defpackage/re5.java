package defpackage;

import android.content.Context;
import com.squareup.picasso.Picasso;
import defpackage.lf5;
import java.io.IOException;

/* renamed from: re5  reason: default package */
/* compiled from: ContentStreamRequestHandler */
public class re5 extends lf5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3074a;

    public re5(Context context) {
        this.f3074a = context;
    }

    @Override // defpackage.lf5
    public boolean c(jf5 jf5) {
        return "content".equals(jf5.c.getScheme());
    }

    @Override // defpackage.lf5
    public lf5.a f(jf5 jf5, int i) throws IOException {
        return new lf5.a(ec6.y(this.f3074a.getContentResolver().openInputStream(jf5.c)), Picasso.d.DISK);
    }
}
