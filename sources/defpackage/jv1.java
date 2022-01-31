package defpackage;

import android.util.Base64;
import com.google.auto.value.AutoValue;
import defpackage.cv1;

@AutoValue
/* renamed from: jv1  reason: default package */
/* compiled from: TransportContext */
public abstract class jv1 {

    @AutoValue.Builder
    /* renamed from: jv1$a */
    /* compiled from: TransportContext */
    public static abstract class a {
        public abstract jv1 a();

        public abstract a b(String str);

        public abstract a c(bu1 bu1);
    }

    public static a a() {
        cv1.b bVar = new cv1.b();
        bVar.c(bu1.DEFAULT);
        return bVar;
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract bu1 d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
