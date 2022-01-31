package defpackage;

import android.net.Uri;
import android.os.Bundle;
import java.util.Objects;

@Deprecated
/* renamed from: pz1  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class pz1 extends sz1 {
    public pz1(Bundle bundle, tz1 tz1) {
        super(bundle);
    }

    public static pz1 a(String str, String str2, Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        Bundle bundle2 = new Bundle();
        Objects.requireNonNull(str2, "null reference");
        bundle2.putString("name", str2);
        Objects.requireNonNull(uri, "null reference");
        String uri2 = uri.toString();
        if (uri2 != null) {
            bundle2.putString("url", uri2);
        }
        bundle.putParcelable("object", bundle2);
        gj1.l(bundle.get("object"), "setObject is required before calling build().");
        gj1.l(bundle.get("type"), "setType is required before calling build().");
        Bundle bundle3 = (Bundle) bundle.getParcelable("object");
        gj1.l(bundle3.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
        gj1.l(bundle3.get("url"), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
        return new pz1(bundle, null);
    }
}
