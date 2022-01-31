package defpackage;

/* renamed from: xd  reason: default package */
/* compiled from: UninitializedMessageException */
public class xd extends RuntimeException {
    public xd() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
