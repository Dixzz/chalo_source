package defpackage;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: xm6  reason: default package */
/* compiled from: BufferedSink.kt */
public interface xm6 extends on6, WritableByteChannel {
    xm6 B() throws IOException;

    xm6 C(int i) throws IOException;

    xm6 H(int i) throws IOException;

    xm6 N0(byte[] bArr) throws IOException;

    xm6 P0(zm6 zm6) throws IOException;

    xm6 S(int i) throws IOException;

    vm6 b();

    xm6 b0() throws IOException;

    xm6 f1(long j) throws IOException;

    @Override // defpackage.on6, java.io.Flushable
    void flush() throws IOException;

    xm6 k0(String str) throws IOException;

    xm6 r0(byte[] bArr, int i, int i2) throws IOException;

    long t0(qn6 qn6) throws IOException;

    xm6 u0(long j) throws IOException;
}
