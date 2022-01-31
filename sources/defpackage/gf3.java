package defpackage;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzi;
import com.google.android.gms.internal.icing.zzk;
import com.google.android.gms.internal.icing.zzm;
import com.google.android.gms.internal.icing.zzt;
import com.google.android.gms.internal.icing.zzw;
import com.rabbitmq.client.StringRpcServer;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

/* renamed from: gf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class gf3 implements rz1 {

    /* renamed from: gf3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static abstract class a<T extends f32> extends l32<T, ef3> {
        public a(a32 a32) {
            super(yi3.c, a32);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
        @Override // defpackage.l32
        public void l(ef3 ef3) throws RemoteException {
            ff3 ff3 = (ff3) this;
            ((ze3) ef3.getService()).v2(new b(ff3), null, ff3.q);
        }
    }

    /* renamed from: gf3$b */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class b extends cf3<Status> {
        public b(m32<Status> m32) {
            super(m32);
        }
    }

    /* renamed from: gf3$c */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static abstract class c<T extends f32> extends a<Status> {
        public c(a32 a32) {
            super(a32);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ f32 d(Status status) {
            return status;
        }
    }

    public static boolean b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    public final b32<Status> a(a32 a32, pz1 pz1) {
        Intent intent;
        Account account;
        int i;
        boolean z;
        String string;
        String packageName = a32.l().getPackageName();
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putAll(pz1.f3281a);
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string2 = bundle2.getString("name");
        String string3 = bundle2.getString("type");
        Uri parse2 = Uri.parse(bundle2.getString("url"));
        if (b(parse2)) {
            if (parse2.getHost().isEmpty()) {
                String valueOf = String.valueOf(parse2);
                throw new IllegalArgumentException(hj1.x(valueOf.length() + 98, "AppIndex: The web URL must have a host (follow the format http(s)://<host>/<path>). Provided URI: ", valueOf));
            }
        } else if (!"android-app".equals(parse2.getScheme())) {
            String valueOf2 = String.valueOf(parse2);
            throw new IllegalArgumentException(hj1.x(valueOf2.length() + 176, "AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/<host_path>'. Provided URI: ", valueOf2));
        } else if (packageName == null || packageName.equals(parse2.getHost())) {
            List<String> pathSegments = parse2.getPathSegments();
            if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
                String valueOf3 = String.valueOf(parse2);
                throw new IllegalArgumentException(hj1.x(valueOf3.length() + 128, "AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/<host_path>). Provided URI: ", valueOf3));
            }
        } else {
            String valueOf4 = String.valueOf(parse2);
            throw new IllegalArgumentException(hj1.x(valueOf4.length() + 150, "AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/<host_path>. Provided URI: ", valueOf4));
        }
        if (b(parse2)) {
            intent = new Intent("android.intent.action.VIEW", parse2);
        } else if ("android-app".equals(parse2.getScheme())) {
            List<String> pathSegments2 = parse2.getPathSegments();
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(pathSegments2.get(0));
            if (pathSegments2.size() > 1) {
                builder.authority(pathSegments2.get(1));
                for (int i2 = 2; i2 < pathSegments2.size(); i2++) {
                    builder.appendPath(pathSegments2.get(i2));
                }
            } else {
                String.valueOf(parse2).length();
            }
            builder.encodedQuery(parse2.getEncodedQuery());
            builder.encodedFragment(parse2.getEncodedFragment());
            intent = new Intent("android.intent.action.VIEW", builder.build());
        } else {
            String valueOf5 = String.valueOf(parse2);
            throw new RuntimeException(hj1.x(valueOf5.length() + 70, "appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: ", valueOf5));
        }
        ArrayList arrayList = new ArrayList();
        zzk zzk = new zzk(string2, new zzt(ProductPromotionsObject.KEY_TITLE, null, false, 1, true, null, (zzm[]) arrayList.toArray(new zzm[arrayList.size()]), "name", null), "text1");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zzk);
        if (parse != null) {
            String uri = parse.toString();
            ArrayList arrayList3 = new ArrayList();
            arrayList2.add(new zzk(uri, new zzt("web_url", null, true, 1, false, null, (zzm[]) arrayList3.toArray(new zzm[arrayList3.size()]), "url", null), zzk.j, null));
        }
        String action = intent.getAction();
        if (action != null) {
            arrayList2.add(zzw.l1("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            arrayList2.add(zzw.l1("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            arrayList2.add(zzw.l1("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (!(extras == null || (string = extras.getString("intent_extra_data_key")) == null)) {
            arrayList2.add(zzw.l1("intent_extra_data", string));
        }
        if (bundle.containsKey(".private:ssbContext")) {
            arrayList2.add(new zzk(null, zzk.k, zzk.j, bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            account = new Account(bundle.getString(".private:accountName"), "com.google");
            bundle.remove(".private:accountName");
        } else {
            account = null;
        }
        if (!bundle.containsKey(".private:isContextOnly") || !bundle.getBoolean(".private:isContextOnly")) {
            i = 0;
        } else {
            bundle.remove(".private:isContextOnly");
            i = 4;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            boolean z2 = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
            z = z2;
        } else {
            z = false;
        }
        jl3 w3 = hd3.w3(bundle);
        ArrayList arrayList4 = new ArrayList();
        arrayList2.add(new zzk(null, new zzt(".private:action", "blob", true, 1, false, null, (zzm[]) arrayList4.toArray(new zzm[arrayList4.size()]), ".private:action", null), zzk.j, w3.b()));
        String uri2 = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri2.getBytes(StringRpcServer.STRING_ENCODING));
            return a32.i(new ff3(a32, new zzw[]{new zzw(new zzi(packageName, "", Long.toHexString(crc32.getValue())), currentTimeMillis, i, null, new zzh(string3, true, account, (zzk[]) arrayList2.toArray(new zzk[arrayList2.size()])), z, -1, 1, null)}));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
