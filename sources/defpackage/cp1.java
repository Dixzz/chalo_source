package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Objects;

/* renamed from: cp1  reason: default package */
/* compiled from: GlideUrl */
public class cp1 implements dm1 {
    public final dp1 b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public cp1(URL url) {
        dp1 dp1 = dp1.f874a;
        Objects.requireNonNull(url, "Argument must not be null");
        this.c = url;
        this.d = null;
        Objects.requireNonNull(dp1, "Argument must not be null");
        this.b = dp1;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = c().getBytes(dm1.f856a);
        }
        messageDigest.update(this.g);
    }

    public String c() {
        String str = this.d;
        return str != null ? str : this.c.toString();
    }

    public URL d() throws MalformedURLException {
        if (this.f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String str = this.d;
                if (TextUtils.isEmpty(str)) {
                    str = this.c.toString();
                }
                this.e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
            }
            this.f = new URL(this.e);
        }
        return this.f;
    }

    @Override // defpackage.dm1
    public boolean equals(Object obj) {
        if (!(obj instanceof cp1)) {
            return false;
        }
        cp1 cp1 = (cp1) obj;
        if (!c().equals(cp1.c()) || !this.b.equals(cp1.b)) {
            return false;
        }
        return true;
    }

    @Override // defpackage.dm1
    public int hashCode() {
        if (this.h == 0) {
            int hashCode = c().hashCode();
            this.h = hashCode;
            this.h = this.b.hashCode() + (hashCode * 31);
        }
        return this.h;
    }

    public String toString() {
        return c();
    }

    public cp1(String str) {
        dp1 dp1 = dp1.f874a;
        this.c = null;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            Objects.requireNonNull(dp1, "Argument must not be null");
            this.b = dp1;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
