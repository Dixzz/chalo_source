package defpackage;

/* renamed from: d25  reason: default package */
/* compiled from: UninitializedMessageException */
public class d25 extends RuntimeException {
    public d25() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
