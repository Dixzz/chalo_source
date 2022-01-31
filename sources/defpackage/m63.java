package defpackage;

/* renamed from: m63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class m63 implements ui4 {
    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        wa2 wa2 = q63.d;
        String valueOf = String.valueOf(exc.getMessage());
        wa2.b(valueOf.length() != 0 ? "SmsRetrieverClient failed to start: ".concat(valueOf) : new String("SmsRetrieverClient failed to start: "), new Object[0]);
    }
}
