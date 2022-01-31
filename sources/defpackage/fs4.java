package defpackage;

import com.google.android.play.core.assetpacks.AssetPackState;
import java.util.Objects;

/* renamed from: fs4  reason: default package */
public final class fs4 extends AssetPackState {

    /* renamed from: a  reason: collision with root package name */
    public final String f1168a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    public final int f;
    public final int g;

    public fs4(String str, int i, int i2, long j, long j2, int i3, int i4) {
        Objects.requireNonNull(str, "Null name");
        this.f1168a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.f = i3;
        this.g = i4;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int a() {
        return this.g;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long c() {
        return this.d;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f1168a.equals(assetPackState.f()) && this.b == assetPackState.g() && this.c == assetPackState.e() && this.d == assetPackState.c() && this.e == assetPackState.h() && this.f == assetPackState.i() && this.g == assetPackState.a();
        }
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String f() {
        return this.f1168a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int g() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long h() {
        return this.e;
    }

    public final int hashCode() {
        int hashCode = this.f1168a.hashCode();
        int i = this.b;
        int i2 = this.c;
        long j = this.d;
        long j2 = this.e;
        return ((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f) * 1000003) ^ this.g;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int i() {
        return this.f;
    }

    public final String toString() {
        String str = this.f1168a;
        int i = this.b;
        int i2 = this.c;
        long j = this.d;
        long j2 = this.e;
        int i3 = this.f;
        int i4 = this.g;
        StringBuilder sb = new StringBuilder(str.length() + 217);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }
}
