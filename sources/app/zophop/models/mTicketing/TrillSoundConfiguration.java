package app.zophop.models.mTicketing;

import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* compiled from: TrillSoundConfiguration.kt */
public final class TrillSoundConfiguration {
    private final boolean isTwoWay;
    private final String sdkVersion;

    public TrillSoundConfiguration() {
        this(null, false, 3, null);
    }

    public TrillSoundConfiguration(String str, boolean z) {
        n86.e(str, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        this.sdkVersion = str;
        this.isTwoWay = z;
    }

    public static /* synthetic */ TrillSoundConfiguration copy$default(TrillSoundConfiguration trillSoundConfiguration, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trillSoundConfiguration.sdkVersion;
        }
        if ((i & 2) != 0) {
            z = trillSoundConfiguration.isTwoWay;
        }
        return trillSoundConfiguration.copy(str, z);
    }

    public final String component1() {
        return this.sdkVersion;
    }

    public final boolean component2() {
        return this.isTwoWay;
    }

    public final TrillSoundConfiguration copy(String str, boolean z) {
        n86.e(str, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        return new TrillSoundConfiguration(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrillSoundConfiguration)) {
            return false;
        }
        TrillSoundConfiguration trillSoundConfiguration = (TrillSoundConfiguration) obj;
        return n86.a(this.sdkVersion, trillSoundConfiguration.sdkVersion) && this.isTwoWay == trillSoundConfiguration.isTwoWay;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public int hashCode() {
        int hashCode = this.sdkVersion.hashCode() * 31;
        boolean z = this.isTwoWay;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public final boolean isTwoWay() {
        return this.isTwoWay;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TrillSoundConfiguration(sdkVersion=");
        i0.append(this.sdkVersion);
        i0.append(", isTwoWay=");
        i0.append(this.isTwoWay);
        i0.append(')');
        return i0.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrillSoundConfiguration(String str, boolean z, int i, j86 j86) {
        this((i & 1) != 0 ? "3.6" : str, (i & 2) != 0 ? false : z);
    }
}
