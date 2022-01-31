package app.zophop.models.mTicketing.superPass.pendingSuperPass;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;

/* compiled from: PendingSuperPassRepurchaseProperties.kt */
public final class PendingSuperPassRepurchaseProperties {
    private final String categoryId;
    private final String configId;
    private final int fareMappingId;
    private final long startTime;
    private final long verificationExpiryTime;
    private final boolean verificationFlag;

    public PendingSuperPassRepurchaseProperties(String str, String str2, int i, long j, long j2, boolean z) {
        n86.e(str, "configId");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_ID);
        this.configId = str;
        this.categoryId = str2;
        this.fareMappingId = i;
        this.startTime = j;
        this.verificationExpiryTime = j2;
        this.verificationFlag = z;
    }

    public static /* synthetic */ PendingSuperPassRepurchaseProperties copy$default(PendingSuperPassRepurchaseProperties pendingSuperPassRepurchaseProperties, String str, String str2, int i, long j, long j2, boolean z, int i2, Object obj) {
        return pendingSuperPassRepurchaseProperties.copy((i2 & 1) != 0 ? pendingSuperPassRepurchaseProperties.configId : str, (i2 & 2) != 0 ? pendingSuperPassRepurchaseProperties.categoryId : str2, (i2 & 4) != 0 ? pendingSuperPassRepurchaseProperties.fareMappingId : i, (i2 & 8) != 0 ? pendingSuperPassRepurchaseProperties.startTime : j, (i2 & 16) != 0 ? pendingSuperPassRepurchaseProperties.verificationExpiryTime : j2, (i2 & 32) != 0 ? pendingSuperPassRepurchaseProperties.verificationFlag : z);
    }

    public final String component1() {
        return this.configId;
    }

    public final String component2() {
        return this.categoryId;
    }

    public final int component3() {
        return this.fareMappingId;
    }

    public final long component4() {
        return this.startTime;
    }

    public final long component5() {
        return this.verificationExpiryTime;
    }

    public final boolean component6() {
        return this.verificationFlag;
    }

    public final PendingSuperPassRepurchaseProperties copy(String str, String str2, int i, long j, long j2, boolean z) {
        n86.e(str, "configId");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_ID);
        return new PendingSuperPassRepurchaseProperties(str, str2, i, j, j2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingSuperPassRepurchaseProperties)) {
            return false;
        }
        PendingSuperPassRepurchaseProperties pendingSuperPassRepurchaseProperties = (PendingSuperPassRepurchaseProperties) obj;
        return n86.a(this.configId, pendingSuperPassRepurchaseProperties.configId) && n86.a(this.categoryId, pendingSuperPassRepurchaseProperties.categoryId) && this.fareMappingId == pendingSuperPassRepurchaseProperties.fareMappingId && this.startTime == pendingSuperPassRepurchaseProperties.startTime && this.verificationExpiryTime == pendingSuperPassRepurchaseProperties.verificationExpiryTime && this.verificationFlag == pendingSuperPassRepurchaseProperties.verificationFlag;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final int getFareMappingId() {
        return this.fareMappingId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getVerificationExpiryTime() {
        return this.verificationExpiryTime;
    }

    public final boolean getVerificationFlag() {
        return this.verificationFlag;
    }

    public int hashCode() {
        String str = this.categoryId;
        int a2 = d.a(this.startTime);
        int a3 = (d.a(this.verificationExpiryTime) + ((a2 + ((hj1.r0(str, this.configId.hashCode() * 31, 31) + this.fareMappingId) * 31)) * 31)) * 31;
        boolean z = this.verificationFlag;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return a3 + i;
    }

    public final boolean isVerificationExpired() {
        if (this.verificationFlag && this.verificationExpiryTime > ui1.Q()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("PendingSuperPassRepurchaseProperties(configId=");
        i0.append(this.configId);
        i0.append(", categoryId=");
        i0.append(this.categoryId);
        i0.append(", fareMappingId=");
        i0.append(this.fareMappingId);
        i0.append(", startTime=");
        i0.append(this.startTime);
        i0.append(", verificationExpiryTime=");
        i0.append(this.verificationExpiryTime);
        i0.append(", verificationFlag=");
        i0.append(this.verificationFlag);
        i0.append(')');
        return i0.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PendingSuperPassRepurchaseProperties(String str, String str2, int i, long j, long j2, boolean z, int i2, j86 j86) {
        this(str, (i2 & 2) != 0 ? new String() : str2, (i2 & 4) != 0 ? -1 : i, j, j2, z);
    }
}
