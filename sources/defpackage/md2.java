package defpackage;

import com.google.android.gms.common.Feature;

/* renamed from: md2  reason: default package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
public final class md2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Feature f2357a;
    public static final Feature b;
    public static final Feature c;
    public static final Feature[] d;

    static {
        Feature feature = new Feature("sms_code_autofill", 2);
        f2357a = feature;
        Feature feature2 = new Feature("sms_retrieve", 1);
        b = feature2;
        Feature feature3 = new Feature("user_consent", 3);
        c = feature3;
        d = new Feature[]{feature, feature2, feature3};
    }
}
