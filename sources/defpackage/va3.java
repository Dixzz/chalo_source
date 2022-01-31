package defpackage;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* renamed from: va3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class va3 implements ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3624a = false;
    public boolean b = false;
    public FieldDescriptor c;
    public final ra3 d;

    public va3(ra3 ra3) {
        this.d = ra3;
    }

    public final void a() {
        if (!this.f3624a) {
            this.f3624a = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(double d2) throws IOException {
        a();
        this.d.b(this.c, d2, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(float f) throws IOException {
        a();
        this.d.c(this.c, f, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(int i) throws IOException {
        a();
        this.d.d(this.c, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(long j) throws IOException {
        a();
        this.d.e(this.c, j, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) throws IOException {
        a();
        this.d.a(this.c, str, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) throws IOException {
        a();
        this.d.d(this.c, z ? 1 : 0, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(byte[] bArr) throws IOException {
        a();
        this.d.a(this.c, bArr, this.b);
        return this;
    }
}
