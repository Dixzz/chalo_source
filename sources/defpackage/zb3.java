package defpackage;

import com.google.firebase.appindexing.Indexable;

/* renamed from: zb3  reason: default package */
public final class zb3 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4152a;
    public static final String b;

    static {
        String replaceAll = String.valueOf(r22.f3028a / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        f4152a = replaceAll;
        String valueOf = String.valueOf(replaceAll);
        b = valueOf.length() != 0 ? "ma".concat(valueOf) : new String("ma");
    }
}
