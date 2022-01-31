package app.zophop.models.mTicketing.superPass.pendingSuperPass;

/* compiled from: PendingSuperPass.kt */
public final class PendingSuperPass {
    private final PendingSuperPassProperties pendingSuperPassProperties;
    private final PendingSuperPassRepurchaseProperties pendingSuperPassRepurchaseProperties;
    private final PendingSuperPassTransactionDetails pendingSuperPassTransactionDetails;
    private final PendingSuperPassUIProperties pendingSuperPassUIProperties;

    public PendingSuperPass(PendingSuperPassProperties pendingSuperPassProperties2, PendingSuperPassUIProperties pendingSuperPassUIProperties2, PendingSuperPassRepurchaseProperties pendingSuperPassRepurchaseProperties2, PendingSuperPassTransactionDetails pendingSuperPassTransactionDetails2) {
        n86.e(pendingSuperPassProperties2, "pendingSuperPassProperties");
        n86.e(pendingSuperPassUIProperties2, "pendingSuperPassUIProperties");
        n86.e(pendingSuperPassRepurchaseProperties2, "pendingSuperPassRepurchaseProperties");
        n86.e(pendingSuperPassTransactionDetails2, "pendingSuperPassTransactionDetails");
        this.pendingSuperPassProperties = pendingSuperPassProperties2;
        this.pendingSuperPassUIProperties = pendingSuperPassUIProperties2;
        this.pendingSuperPassRepurchaseProperties = pendingSuperPassRepurchaseProperties2;
        this.pendingSuperPassTransactionDetails = pendingSuperPassTransactionDetails2;
    }

    public final PendingSuperPassProperties getPendingSuperPassProperties() {
        return this.pendingSuperPassProperties;
    }

    public final PendingSuperPassRepurchaseProperties getPendingSuperPassRepurchaseProperties() {
        return this.pendingSuperPassRepurchaseProperties;
    }

    public final PendingSuperPassTransactionDetails getPendingSuperPassTransactionDetails() {
        return this.pendingSuperPassTransactionDetails;
    }

    public final PendingSuperPassUIProperties getPendingSuperPassUIProperties() {
        return this.pendingSuperPassUIProperties;
    }
}
