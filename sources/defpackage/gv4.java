package defpackage;

import com.google.android.play.core.install.InstallState;
import java.util.Objects;

/* renamed from: gv4  reason: default package */
public final class gv4 extends InstallState {

    /* renamed from: a  reason: collision with root package name */
    public final int f1306a;
    public final long b;
    public final long c;
    public final int d;
    public final String e;

    public gv4(int i, long j, long j2, int i2, String str) {
        this.f1306a = i;
        this.b = j;
        this.c = j2;
        this.d = i2;
        Objects.requireNonNull(str, "Null packageName");
        this.e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.f1306a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            return this.f1306a == installState.c() && this.b == installState.a() && this.c == installState.e() && this.d == installState.b() && this.e.equals(installState.d());
        }
    }

    public final int hashCode() {
        int i = this.f1306a;
        long j = this.b;
        long j2 = this.c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        int i = this.f1306a;
        long j = this.b;
        long j2 = this.c;
        int i2 = this.d;
        String str = this.e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
