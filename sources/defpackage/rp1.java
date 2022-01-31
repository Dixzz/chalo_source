package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import defpackage.ip1;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: rp1  reason: default package */
/* compiled from: UriLoader */
public class rp1<Data> implements ip1<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a  reason: collision with root package name */
    public final b<Data> f3109a;

    /* renamed from: rp1$a */
    /* compiled from: UriLoader */
    public static class a implements jp1<Uri, ParcelFileDescriptor>, b<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f3110a;

        public a(ContentResolver contentResolver) {
            this.f3110a = contentResolver;
        }

        @Override // defpackage.rp1.b
        public km1<ParcelFileDescriptor> a(Uri uri) {
            return new pm1(this.f3110a, uri);
        }

        @Override // defpackage.jp1
        public ip1<Uri, ParcelFileDescriptor> b(mp1 mp1) {
            return new rp1(this);
        }
    }

    /* renamed from: rp1$b */
    /* compiled from: UriLoader */
    public interface b<Data> {
        km1<Data> a(Uri uri);
    }

    /* renamed from: rp1$c */
    /* compiled from: UriLoader */
    public static class c implements jp1<Uri, InputStream>, b<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f3111a;

        public c(ContentResolver contentResolver) {
            this.f3111a = contentResolver;
        }

        @Override // defpackage.rp1.b
        public km1<InputStream> a(Uri uri) {
            return new um1(this.f3111a, uri);
        }

        @Override // defpackage.jp1
        public ip1<Uri, InputStream> b(mp1 mp1) {
            return new rp1(this);
        }
    }

    public rp1(b<Data> bVar) {
        this.f3109a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(Uri uri, int i, int i2, fm1 fm1) {
        Uri uri2 = uri;
        return new ip1.a(new jt1(uri2), this.f3109a.a(uri2));
    }
}
