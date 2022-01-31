package defpackage;

import defpackage.ip1;
import java.io.InputStream;
import java.net.URL;

/* renamed from: xp1  reason: default package */
/* compiled from: UrlLoader */
public class xp1 implements ip1<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final ip1<cp1, InputStream> f3950a;

    /* renamed from: xp1$a */
    /* compiled from: UrlLoader */
    public static class a implements jp1<URL, InputStream> {
        @Override // defpackage.jp1
        public ip1<URL, InputStream> b(mp1 mp1) {
            return new xp1(mp1.b(cp1.class, InputStream.class));
        }
    }

    public xp1(ip1<cp1, InputStream> ip1) {
        this.f3950a = ip1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(URL url) {
        return true;
    }

    /* Return type fixed from 'ip1$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a<InputStream> b(URL url, int i, int i2, fm1 fm1) {
        return this.f3950a.b(new cp1(url), i, i2, fm1);
    }
}
