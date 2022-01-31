package app.zophop.models.mTicketing.superPass;

/* compiled from: SuperPassRepurchaseProperties.kt */
public final class SuperPassRepurchaseProperties {
    private final String categoryId;
    private final String configId;
    private final int fareMappingId;
    private final boolean isRenewable;
    private final long verificationExpiryTime;
    private final boolean verificationFlag;

    public SuperPassRepurchaseProperties(String str, String str2, int i, long j, boolean z, boolean z2) {
        n86.e(str, "configId");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_ID);
        this.configId = str;
        this.categoryId = str2;
        this.fareMappingId = i;
        this.verificationExpiryTime = j;
        this.verificationFlag = z;
        this.isRenewable = z2;
    }

    public static /* synthetic */ SuperPassRepurchaseProperties copy$default(SuperPassRepurchaseProperties superPassRepurchaseProperties, String str, String str2, int i, long j, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = superPassRepurchaseProperties.configId;
        }
        if ((i2 & 2) != 0) {
            str2 = superPassRepurchaseProperties.categoryId;
        }
        if ((i2 & 4) != 0) {
            i = superPassRepurchaseProperties.fareMappingId;
        }
        if ((i2 & 8) != 0) {
            j = superPassRepurchaseProperties.verificationExpiryTime;
        }
        if ((i2 & 16) != 0) {
            z = superPassRepurchaseProperties.verificationFlag;
        }
        if ((i2 & 32) != 0) {
            z2 = superPassRepurchaseProperties.isRenewable;
        }
        return superPassRepurchaseProperties.copy(str, str2, i, j, z, z2);
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
        return this.verificationExpiryTime;
    }

    public final boolean component5() {
        return this.verificationFlag;
    }

    public final boolean component6() {
        return this.isRenewable;
    }

    public final SuperPassRepurchaseProperties copy(String str, String str2, int i, long j, boolean z, boolean z2) {
        n86.e(str, "configId");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_ID);
        return new SuperPassRepurchaseProperties(str, str2, i, j, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassRepurchaseProperties)) {
            return false;
        }
        SuperPassRepurchaseProperties superPassRepurchaseProperties = (SuperPassRepurchaseProperties) obj;
        return n86.a(this.configId, superPassRepurchaseProperties.configId) && n86.a(this.categoryId, superPassRepurchaseProperties.categoryId) && this.fareMappingId == superPassRepurchaseProperties.fareMappingId && this.verificationExpiryTime == superPassRepurchaseProperties.verificationExpiryTime && this.verificationFlag == superPassRepurchaseProperties.verificationFlag && this.isRenewable == superPassRepurchaseProperties.isRenewable;
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

    public final long getVerificationExpiryTime() {
        return this.verificationExpiryTime;
    }

    public final boolean getVerificationFlag() {
        return this.verificationFlag;
    }

    public int hashCode() {
        String str = this.categoryId;
        int a2 = (d.a(this.verificationExpiryTime) + ((hj1.r0(str, this.configId.hashCode() * 31, 31) + this.fareMappingId) * 31)) * 31;
        boolean z = this.verificationFlag;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (a2 + i2) * 31;
        boolean z2 = this.isRenewable;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        return i5 + i;
    }

    public final boolean isRenewable() {
        return this.isRenewable;
    }

    public final boolean isVerificationExpired() {
        if (!this.verificationFlag) {
            return false;
        }
        long j = this.verificationExpiryTime;
        if (j == -1 || j > ui1.Q()) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassRepurchaseProperties(configId=");
        i0.append(this.configId);
        i0.append(", categoryId=");
        i0.append(this.categoryId);
        i0.append(", fareMappingId=");
        i0.append(this.fareMappingId);
        i0.append(", verificationExpiryTime=");
        i0.append(this.verificationExpiryTime);
        i0.append(", verificationFlag=");
        i0.append(this.verificationFlag);
        i0.append(", isRenewable=");
        i0.append(this.isRenewable);
        i0.append(')');
        return i0.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassRepurchaseProperties(String str, String str2, int i, long j, boolean z, boolean z2, int i2, j86 j86) {
        this(str, (i2 & 2) != 0 ? new String() : str2, (i2 & 4) != 0 ? -1 : i, j, z, z2);
    }
}
