package defpackage;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.ip1;
import java.io.File;
import java.io.InputStream;

/* renamed from: pp1  reason: default package */
/* compiled from: StringLoader */
public class pp1<Data> implements ip1<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final ip1<Uri, Data> f2837a;

    /* renamed from: pp1$a */
    /* compiled from: StringLoader */
    public static class a implements jp1<String, ParcelFileDescriptor> {
        @Override // defpackage.jp1
        public ip1<String, ParcelFileDescriptor> b(mp1 mp1) {
            return new pp1(mp1.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* renamed from: pp1$b */
    /* compiled from: StringLoader */
    public static class b implements jp1<String, InputStream> {
        @Override // defpackage.jp1
        public ip1<String, InputStream> b(mp1 mp1) {
            return new pp1(mp1.b(Uri.class, InputStream.class));
        }
    }

    public pp1(ip1<Uri, Data> ip1) {
        this.f2837a = ip1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(String str) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(String str, int i, int i2, fm1 fm1) {
        Uri uri;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            uri = null;
        } else if (str2.startsWith(ConnectionFactory.DEFAULT_VHOST)) {
            uri = Uri.fromFile(new File(str2));
        } else {
            Uri parse = Uri.parse(str2);
            uri = parse.getScheme() == null ? Uri.fromFile(new File(str2)) : parse;
        }
        if (uri == null) {
            return null;
        }
        return this.f2837a.b(uri, i, i2, fm1);
    }
}
