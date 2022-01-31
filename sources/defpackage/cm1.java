package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: cm1  reason: default package */
/* compiled from: ImageHeaderParser */
public interface cm1 {

    /* renamed from: cm1$a */
    /* compiled from: ImageHeaderParser */
    public enum a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        private a(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    a a(ByteBuffer byteBuffer) throws IOException;

    a b(InputStream inputStream) throws IOException;

    int c(InputStream inputStream, xn1 xn1) throws IOException;
}
