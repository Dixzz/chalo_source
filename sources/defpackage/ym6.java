package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: ym6  reason: default package */
/* compiled from: BufferedSource.kt */
public interface ym6 extends qn6, ReadableByteChannel {
    String G0() throws IOException;

    byte[] I0(long j) throws IOException;

    byte[] O() throws IOException;

    boolean R() throws IOException;

    long X0(on6 on6) throws IOException;

    void Y(vm6 vm6, long j) throws IOException;

    vm6 b();

    String c0(long j) throws IOException;

    void d(long j) throws IOException;

    void e1(long j) throws IOException;

    long h1() throws IOException;

    InputStream j1();

    int k1(hn6 hn6) throws IOException;

    String p0(Charset charset) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    zm6 v(long j) throws IOException;

    zm6 v0() throws IOException;
}
