package defpackage;

import java.io.IOException;

/* renamed from: ma3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class ma3 extends IOException {
    public static final /* synthetic */ int f = 0;

    public ma3(String str) {
        super(str);
    }

    public static ma3 a() {
        return new ma3("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static ma3 b() {
        return new ma3("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static ma3 c() {
        return new ma3("CodedInputStream encountered a malformed varint.");
    }

    public static ma3 d() {
        return new ma3("Protocol message contained an invalid tag (zero).");
    }

    public static ma3 e() {
        return new ma3("Protocol message end-group tag did not match expected tag.");
    }

    public static ma3 f() {
        return new ma3("Failed to parse the message.");
    }

    public static ma3 g() {
        return new ma3("Protocol message had invalid UTF-8.");
    }
}
