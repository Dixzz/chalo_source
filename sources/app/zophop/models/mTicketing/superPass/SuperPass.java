package app.zophop.models.mTicketing.superPass;

/* compiled from: SuperPass.kt */
public class SuperPass {
    public static final Companion Companion = new Companion(null);
    public static final String PASS_SUB_TYPE_MAGIC_PASS = "magicPass";
    public static final String PASS_SUB_TYPE_RIDE_PASS = "magicPass";
    public static final String PASS_SUB_TYPE_ROUTE_PASS = "magicPass";
    public static final String PASS_SUB_TYPE_SUPER_SAVER_PASS = "magicPass";
    private final SuperPassProperties superPassProperties;
    private final SuperPassRepurchaseProperties superPassRepurchaseProperties;
    private final SuperPassTransactionDetails superPassTransactionDetails;
    private final SuperPassUIProperties superPassUIProperties;
    private final SuperPassValidationProperties superPassValidationProperties;

    /* compiled from: SuperPass.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }
    }

    public SuperPass(SuperPassProperties superPassProperties2, SuperPassValidationProperties superPassValidationProperties2, SuperPassUIProperties superPassUIProperties2, SuperPassRepurchaseProperties superPassRepurchaseProperties2, SuperPassTransactionDetails superPassTransactionDetails2) {
        n86.e(superPassProperties2, "superPassProperties");
        n86.e(superPassValidationProperties2, "superPassValidationProperties");
        n86.e(superPassUIProperties2, "superPassUIProperties");
        n86.e(superPassRepurchaseProperties2, "superPassRepurchaseProperties");
        n86.e(superPassTransactionDetails2, "superPassTransactionDetails");
        this.superPassProperties = superPassProperties2;
        this.superPassValidationProperties = superPassValidationProperties2;
        this.superPassUIProperties = superPassUIProperties2;
        this.superPassRepurchaseProperties = superPassRepurchaseProperties2;
        this.superPassTransactionDetails = superPassTransactionDetails2;
    }

    public final boolean canActivate() {
        return !isNotYetActive() && !isExpired();
    }

    public final long getLastActivationTimeStamp() {
        String str = (String) xt.f3961a.d0().get(this.superPassProperties.getPassId());
        if (str == null) {
            return -1;
        }
        return Long.parseLong(str);
    }

    public final String getProfilePhotoUrl() {
        return getSuperPassUIProperties().getSuperPassUserDetails().getProfilePhoto();
    }

    public final SuperPassProperties getSuperPassProperties() {
        return this.superPassProperties;
    }

    public final SuperPassRepurchaseProperties getSuperPassRepurchaseProperties() {
        return this.superPassRepurchaseProperties;
    }

    public final SuperPassTransactionDetails getSuperPassTransactionDetails() {
        return this.superPassTransactionDetails;
    }

    public SuperPassUIProperties getSuperPassUIProperties() {
        return this.superPassUIProperties;
    }

    public SuperPassValidationProperties getSuperPassValidationProperties() {
        return this.superPassValidationProperties;
    }

    public final boolean isExpired() {
        return getSuperPassValidationProperties().getStatus() == SuperPassStatus.EXPIRED || ui1.Q() > getSuperPassValidationProperties().getExpiryTime();
    }

    public final boolean isNotYetActive() {
        return ui1.Q() < getSuperPassValidationProperties().getStartTime();
    }

    public final boolean isSuperPassActivationValid() {
        if (getLastActivationTimeStamp() != -1 && getSuperPassValidationProperties().getSuperPassRideDetails().getLastPunchTimeStamp() <= getLastActivationTimeStamp() && ui1.Q() - getLastActivationTimeStamp() < getSuperPassValidationProperties().getActiveDuration()) {
            return true;
        }
        return false;
    }

    public final void saveActivationTimeStamp(long j) {
        xt.f3961a.d0().put(this.superPassProperties.getPassId(), String.valueOf(j));
    }
}
