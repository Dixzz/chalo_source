package defpackage;

import android.net.Uri;
import defpackage.ip1;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: sp1  reason: default package */
/* compiled from: UrlUriLoader */
public class sp1<Data> implements ip1<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    public final ip1<cp1, Data> f3240a;

    /* renamed from: sp1$a */
    /* compiled from: UrlUriLoader */
    public static class a implements jp1<Uri, InputStream> {
        @Override // defpackage.jp1
        public ip1<Uri, InputStream> b(mp1 mp1) {
            return new sp1(mp1.b(cp1.class, InputStream.class));
        }
    }

    public sp1(ip1<cp1, Data> ip1) {
        this.f3240a = ip1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(Uri uri, int i, int i2, fm1 fm1) {
        return this.f3240a.b(new cp1(uri.toString()), i, i2, fm1);
    }
}
