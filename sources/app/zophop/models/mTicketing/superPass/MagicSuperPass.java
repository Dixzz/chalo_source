package app.zophop.models.mTicketing.superPass;

/* compiled from: MagicSuperPass.kt */
public final class MagicSuperPass extends SuperPass {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagicSuperPass(SuperPassProperties superPassProperties, SuperPassValidationProperties superPassValidationProperties, SuperPassUIProperties superPassUIProperties, SuperPassRepurchaseProperties superPassRepurchaseProperties, SuperPassTransactionDetails superPassTransactionDetails) {
        super(superPassProperties, superPassValidationProperties, superPassUIProperties, superPassRepurchaseProperties, superPassTransactionDetails);
        n86.e(superPassProperties, "superPassProperties");
        n86.e(superPassValidationProperties, "superPassValidationProperties");
        n86.e(superPassUIProperties, "superPassUIProperties");
        n86.e(superPassRepurchaseProperties, "superPassRepurchaseProperties");
        n86.e(superPassTransactionDetails, "superPassTransactionDetails");
    }
}
