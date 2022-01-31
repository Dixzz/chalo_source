package defpackage;

import android.app.PendingIntent;
import java.util.Objects;

/* renamed from: fr4  reason: default package */
public final class fr4 extends nq4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1165a;
    public final int b;
    public final int c;
    public final int d;
    public final Integer e;
    public final int f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final PendingIntent k;
    public final PendingIntent l;
    public final PendingIntent m;
    public final PendingIntent n;

    public fr4(String str, int i2, int i3, int i4, Integer num, int i5, long j2, long j3, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        Objects.requireNonNull(str, "Null packageName");
        this.f1165a = str;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = num;
        this.f = i5;
        this.g = j2;
        this.h = j3;
        this.i = j4;
        this.j = j5;
        this.k = pendingIntent;
        this.l = pendingIntent2;
        this.m = pendingIntent3;
        this.n = pendingIntent4;
    }

    @Override // defpackage.nq4
    public final int a() {
        return this.b;
    }

    @Override // defpackage.nq4
    public final long b() {
        return this.i;
    }

    @Override // defpackage.nq4
    public final long c() {
        return this.g;
    }

    @Override // defpackage.nq4
    public final long d() {
        return this.j;
    }

    @Override // defpackage.nq4
    public final Integer e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof nq4) {
            nq4 nq4 = (nq4) obj;
            if (this.f1165a.equals(nq4.m()) && this.b == nq4.a() && this.c == nq4.o() && this.d == nq4.l() && ((num = this.e) != null ? num.equals(nq4.e()) : nq4.e() == null) && this.f == nq4.p() && this.g == nq4.c() && this.h == nq4.n() && this.i == nq4.b() && this.j == nq4.d() && ((pendingIntent = this.k) != null ? pendingIntent.equals(nq4.f()) : nq4.f() == null) && ((pendingIntent2 = this.l) != null ? pendingIntent2.equals(nq4.g()) : nq4.g() == null) && ((pendingIntent3 = this.m) != null ? pendingIntent3.equals(nq4.h()) : nq4.h() == null)) {
                PendingIntent pendingIntent4 = this.n;
                PendingIntent i2 = nq4.i();
                if (pendingIntent4 != null ? pendingIntent4.equals(i2) : i2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.nq4
    public final PendingIntent f() {
        return this.k;
    }

    @Override // defpackage.nq4
    public final PendingIntent g() {
        return this.l;
    }

    @Override // defpackage.nq4
    public final PendingIntent h() {
        return this.m;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f1165a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        Integer num = this.e;
        int i2 = 0;
        int hashCode2 = num == null ? 0 : num.hashCode();
        int i3 = this.f;
        long j2 = this.g;
        long j3 = this.h;
        long j4 = this.i;
        long j5 = this.j;
        int i4 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        PendingIntent pendingIntent = this.k;
        int hashCode3 = (i4 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 == null ? 0 : pendingIntent2.hashCode())) * 1000003;
        PendingIntent pendingIntent3 = this.m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 == null ? 0 : pendingIntent3.hashCode())) * 1000003;
        PendingIntent pendingIntent4 = this.n;
        if (pendingIntent4 != null) {
            i2 = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i2;
    }

    @Override // defpackage.nq4
    public final PendingIntent i() {
        return this.n;
    }

    @Override // defpackage.nq4
    public final int l() {
        return this.d;
    }

    @Override // defpackage.nq4
    public final String m() {
        return this.f1165a;
    }

    @Override // defpackage.nq4
    public final long n() {
        return this.h;
    }

    @Override // defpackage.nq4
    public final int o() {
        return this.c;
    }

    @Override // defpackage.nq4
    public final int p() {
        return this.f;
    }

    public final String toString() {
        String str = this.f1165a;
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        String valueOf = String.valueOf(this.e);
        int i5 = this.f;
        long j2 = this.g;
        long j3 = this.h;
        long j4 = this.i;
        long j5 = this.j;
        String valueOf2 = String.valueOf(this.k);
        String valueOf3 = String.valueOf(this.l);
        String valueOf4 = String.valueOf(this.m);
        String valueOf5 = String.valueOf(this.n);
        int length = str.length();
        int length2 = valueOf.length();
        int length3 = valueOf2.length();
        int length4 = valueOf3.length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + valueOf4.length() + valueOf5.length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i2);
        sb.append(", updateAvailability=");
        sb.append(i3);
        sb.append(", installStatus=");
        sb.append(i4);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i5);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", additionalSpaceRequired=");
        sb.append(j4);
        sb.append(", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        hj1.V0(sb, ", flexibleUpdateIntent=", valueOf3, ", immediateDestructiveUpdateIntent=", valueOf4);
        return hj1.b0(sb, ", flexibleDestructiveUpdateIntent=", valueOf5, "}");
    }
}
