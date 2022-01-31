package defpackage;

import android.net.Uri;

/* renamed from: qa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class qa2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f2917a;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        f2917a = parse;
        parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
