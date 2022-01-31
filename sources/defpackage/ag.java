package defpackage;

import java.io.Writer;

/* renamed from: ag  reason: default package */
/* compiled from: LogWriter */
public final class ag extends Writer {
    public final String f;
    public StringBuilder g = new StringBuilder(128);

    public ag(String str) {
        this.f = str;
    }

    public final void a() {
        if (this.g.length() > 0) {
            this.g.toString();
            StringBuilder sb = this.g;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.g.append(c);
            }
        }
    }
}
