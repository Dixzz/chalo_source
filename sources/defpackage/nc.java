package defpackage;

import java.io.IOException;

/* renamed from: nc  reason: default package */
/* compiled from: InvalidProtocolBufferException */
public class nc extends IOException {

    /* renamed from: nc$a */
    /* compiled from: InvalidProtocolBufferException */
    public static class a extends nc {
        public a(String str) {
            super(str);
        }
    }

    public nc(String str) {
        super(str);
    }

    public static nc a() {
        return new nc("Protocol message end-group tag did not match expected tag.");
    }

    public static nc b() {
        return new nc("Protocol message had invalid UTF-8.");
    }

    public static a c() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static nc d() {
        return new nc("CodedInputStream encountered a malformed varint.");
    }

    public static nc e() {
        return new nc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static nc f() {
        return new nc("Failed to parse the message.");
    }

    public static nc g() {
        return new nc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
