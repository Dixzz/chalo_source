package defpackage;

import android.net.Uri;
import defpackage.ip1;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: up1  reason: default package */
/* compiled from: HttpUriLoader */
public class up1 implements ip1<Uri, InputStream> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    public final ip1<cp1, InputStream> f3536a;

    /* renamed from: up1$a */
    /* compiled from: HttpUriLoader */
    public static class a implements jp1<Uri, InputStream> {
        @Override // defpackage.jp1
        public ip1<Uri, InputStream> b(mp1 mp1) {
            return new up1(mp1.b(cp1.class, InputStream.class));
        }
    }

    public up1(ip1<cp1, InputStream> ip1) {
        this.f3536a = ip1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }

    /* Return type fixed from 'ip1$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a<InputStream> b(Uri uri, int i, int i2, fm1 fm1) {
        return this.f3536a.b(new cp1(uri.toString()), i, i2, fm1);
    }
}
