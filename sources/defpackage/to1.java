package defpackage;

import com.google.firebase.appindexing.Indexable;
import defpackage.st1;
import defpackage.vt1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: to1  reason: default package */
/* compiled from: SafeKeyGenerator */
public class to1 {

    /* renamed from: a  reason: collision with root package name */
    public final ot1<dm1, String> f3383a = new ot1<>(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
    public final v7<b> b = new st1.c(new x7(10), new a(this), st1.f3253a);

    /* renamed from: to1$a */
    /* compiled from: SafeKeyGenerator */
    public class a implements st1.b<b> {
        public a(to1 to1) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.st1.b
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: to1$b */
    /* compiled from: SafeKeyGenerator */
    public static final class b implements st1.d {
        public final MessageDigest f;
        public final vt1 g = new vt1.b();

        public b(MessageDigest messageDigest) {
            this.f = messageDigest;
        }

        @Override // defpackage.st1.d
        public vt1 g() {
            return this.g;
        }
    }

    public String a(dm1 dm1) {
        String a2;
        synchronized (this.f3383a) {
            a2 = this.f3383a.a(dm1);
        }
        if (a2 == null) {
            b b2 = this.b.b();
            try {
                dm1.a(b2.f);
                byte[] digest = b2.f.digest();
                char[] cArr = rt1.b;
                synchronized (cArr) {
                    for (int i = 0; i < digest.length; i++) {
                        int i2 = digest[i] & 255;
                        int i3 = i * 2;
                        char[] cArr2 = rt1.f3126a;
                        cArr[i3] = cArr2[i2 >>> 4];
                        cArr[i3 + 1] = cArr2[i2 & 15];
                    }
                    a2 = new String(cArr);
                }
            } finally {
                this.b.a(b2);
            }
        }
        synchronized (this.f3383a) {
            this.f3383a.d(dm1, a2);
        }
        return a2;
    }
}
