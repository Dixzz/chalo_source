package defpackage;

import java.io.IOException;
import java.util.Objects;

/* renamed from: hl  reason: default package */
/* compiled from: AutoClosingRoomOpenHelper */
public final class hl implements pm, ol {
    public final pm f;
    public final a g;

    /* renamed from: hl$a */
    /* compiled from: AutoClosingRoomOpenHelper */
    public static final class a implements om {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw null;
        }
    }

    @Override // defpackage.ol
    public pm a() {
        return this.f;
    }

    @Override // java.io.Closeable, defpackage.pm, java.lang.AutoCloseable
    public void close() {
        try {
            this.g.close();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // defpackage.pm
    public String getDatabaseName() {
        return this.f.getDatabaseName();
    }

    @Override // defpackage.pm
    public om l0() {
        Objects.requireNonNull(this.g);
        throw null;
    }

    @Override // defpackage.pm
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f.setWriteAheadLoggingEnabled(z);
    }
}
