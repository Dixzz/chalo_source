package defpackage;

import java.io.IOException;

/* renamed from: cv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class cv3 extends IOException {
    public static final /* synthetic */ int f = 0;

    public cv3(String str) {
        super(str);
    }

    public static cv3 a() {
        return new cv3("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static cv3 b() {
        return new cv3("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static cv3 c() {
        return new cv3("Protocol message contained an invalid tag (zero).");
    }

    public static cv3 d() {
        return new cv3("Failed to parse the message.");
    }

    public static cv3 e() {
        return new cv3("Protocol message had invalid UTF-8.");
    }
}
