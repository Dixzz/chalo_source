package defpackage;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.ip1;
import java.io.InputStream;

/* renamed from: np1  reason: default package */
/* compiled from: ResourceLoader */
public class np1<Data> implements ip1<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final ip1<Uri, Data> f2587a;
    public final Resources b;

    /* renamed from: np1$a */
    /* compiled from: ResourceLoader */
    public static class a implements jp1<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f2588a;

        public a(Resources resources) {
            this.f2588a = resources;
        }

        @Override // defpackage.jp1
        public ip1<Integer, ParcelFileDescriptor> b(mp1 mp1) {
            return new np1(this.f2588a, mp1.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: np1$b */
    /* compiled from: ResourceLoader */
    public static class b implements jp1<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f2589a;

        public b(Resources resources) {
            this.f2589a = resources;
        }

        @Override // defpackage.jp1
        public ip1<Integer, InputStream> b(mp1 mp1) {
            return new np1(this.f2589a, mp1.b(Uri.class, InputStream.class));
        }
    }

    public np1(Resources resources, ip1<Uri, Data> ip1) {
        this.b = resources;
        this.f2587a = ip1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(Integer num) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(Integer num, int i, int i2, fm1 fm1) {
        Uri uri;
        Integer num2 = num;
        try {
            uri = Uri.parse("android.resource://" + this.b.getResourcePackageName(num2.intValue()) + '/' + this.b.getResourceTypeName(num2.intValue()) + '/' + this.b.getResourceEntryName(num2.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                String str = "Received invalid resource id: " + num2;
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.f2587a.b(uri, i, i2, fm1);
    }
}
