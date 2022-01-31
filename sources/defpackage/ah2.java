package defpackage;

import java.io.IOException;

/* renamed from: ah2  reason: default package */
public class ah2 extends IOException {
    public static final /* synthetic */ int f = 0;

    public ah2(String str) {
        super(str);
    }

    public static ah2 a() {
        return new ah2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static ah2 b() {
        return new ah2("Protocol message contained an invalid tag (zero).");
    }

    public static ah2 c() {
        return new ah2("Failed to parse the message.");
    }

    public static ah2 d() {
        return new ah2("Protocol message had invalid UTF-8.");
    }
}
