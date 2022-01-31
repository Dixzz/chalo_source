package defpackage;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import defpackage.ip1;
import java.io.InputStream;

/* renamed from: wo1  reason: default package */
/* compiled from: AssetUriLoader */
public class wo1<Data> implements ip1<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f3813a;
    public final a<Data> b;

    /* renamed from: wo1$a */
    /* compiled from: AssetUriLoader */
    public interface a<Data> {
        km1<Data> a(AssetManager assetManager, String str);
    }

    /* renamed from: wo1$b */
    /* compiled from: AssetUriLoader */
    public static class b implements jp1<Uri, ParcelFileDescriptor>, a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f3814a;

        public b(AssetManager assetManager) {
            this.f3814a = assetManager;
        }

        @Override // defpackage.wo1.a
        public km1<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new om1(assetManager, str);
        }

        @Override // defpackage.jp1
        public ip1<Uri, ParcelFileDescriptor> b(mp1 mp1) {
            return new wo1(this.f3814a, this);
        }
    }

    /* renamed from: wo1$c */
    /* compiled from: AssetUriLoader */
    public static class c implements jp1<Uri, InputStream>, a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f3815a;

        public c(AssetManager assetManager) {
            this.f3815a = assetManager;
        }

        @Override // defpackage.wo1.a
        public km1<InputStream> a(AssetManager assetManager, String str) {
            return new tm1(assetManager, str);
        }

        @Override // defpackage.jp1
        public ip1<Uri, InputStream> b(mp1 mp1) {
            return new wo1(this.f3815a, this);
        }
    }

    public wo1(AssetManager assetManager, a<Data> aVar) {
        this.f3813a = assetManager;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(Uri uri) {
        Uri uri2 = uri;
        if (!"file".equals(uri2.getScheme()) || uri2.getPathSegments().isEmpty() || !"android_asset".equals(uri2.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(Uri uri, int i, int i2, fm1 fm1) {
        Uri uri2 = uri;
        return new ip1.a(new jt1(uri2), this.b.a(this.f3813a, uri2.toString().substring(22)));
    }
}
