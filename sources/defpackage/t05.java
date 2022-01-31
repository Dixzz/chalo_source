package defpackage;

import java.io.IOException;

/* renamed from: t05  reason: default package */
/* compiled from: InvalidProtocolBufferException */
public class t05 extends IOException {

    /* renamed from: t05$a */
    /* compiled from: InvalidProtocolBufferException */
    public static class a extends t05 {
        public a(String str) {
            super(str);
        }
    }

    public t05(String str) {
        super(str);
    }

    public static t05 a() {
        return new t05("Protocol message end-group tag did not match expected tag.");
    }

    public static t05 b() {
        return new t05("Protocol message contained an invalid tag (zero).");
    }

    public static t05 c() {
        return new t05("Protocol message had invalid UTF-8.");
    }

    public static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static t05 e() {
        return new t05("CodedInputStream encountered a malformed varint.");
    }

    public static t05 f() {
        return new t05("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static t05 g() {
        return new t05("Failed to parse the message.");
    }

    public static t05 h() {
        return new t05("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
