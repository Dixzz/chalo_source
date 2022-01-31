package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

/* renamed from: ra3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class ra3 implements ObjectEncoderContext {
    public static final Charset f = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final FieldDescriptor g = FieldDescriptor.builder(AnalyticsConstants.KEY).withProperty(new kb3(1, nb3.DEFAULT)).build();
    public static final FieldDescriptor h = FieldDescriptor.builder(FirebaseAnalytics.Param.VALUE).withProperty(new kb3(2, nb3.DEFAULT)).build();
    public static final ObjectEncoder<Map.Entry<Object, Object>> i = qa3.f2918a;

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f3065a;
    public final Map<Class<?>, ObjectEncoder<?>> b;
    public final Map<Class<?>, ValueEncoder<?>> c;
    public final ObjectEncoder<Object> d;
    public final va3 e = new va3(this);

    public ra3(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f3065a = outputStream;
        this.b = map;
        this.c = map2;
        this.d = objectEncoder;
    }

    public static ByteBuffer h(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int i(FieldDescriptor fieldDescriptor) {
        kb3 kb3 = (kb3) fieldDescriptor.getProperty(kb3.class);
        if (kb3 != null) {
            return kb3.f2044a;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final ObjectEncoderContext a(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            j((i(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            j(bytes.length);
            this.f3065a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                a(fieldDescriptor, obj2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                g(i, fieldDescriptor, entry, false);
            }
            return this;
        } else if (obj instanceof Double) {
            b(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return this;
        } else if (obj instanceof Float) {
            c(fieldDescriptor, ((Float) obj).floatValue(), z);
            return this;
        } else if (obj instanceof Number) {
            e(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        } else if (obj instanceof Boolean) {
            d(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            j((i(fieldDescriptor) << 3) | 2);
            j(bArr.length);
            this.f3065a.write(bArr);
            return this;
        } else {
            ObjectEncoder<?> objectEncoder = this.b.get(obj.getClass());
            if (objectEncoder != null) {
                g(objectEncoder, fieldDescriptor, obj, z);
                return this;
            }
            ValueEncoder<?> valueEncoder = this.c.get(obj.getClass());
            if (valueEncoder != null) {
                va3 va3 = this.e;
                va3.f3624a = false;
                va3.c = fieldDescriptor;
                va3.b = z;
                valueEncoder.encode(obj, va3);
                return this;
            } else if (obj instanceof mb3) {
                d(fieldDescriptor, ((mb3) obj).getNumber(), true);
                return this;
            } else if (obj instanceof Enum) {
                d(fieldDescriptor, ((Enum) obj).ordinal(), true);
                return this;
            } else {
                g(this.d, fieldDescriptor, obj, z);
                return this;
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d2) throws IOException {
        b(fieldDescriptor, d2, true);
        return this;
    }

    public final ObjectEncoderContext b(FieldDescriptor fieldDescriptor, double d2, boolean z) throws IOException {
        if (z && d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return this;
        }
        j((i(fieldDescriptor) << 3) | 1);
        this.f3065a.write(h(8).putDouble(d2).array());
        return this;
    }

    public final ObjectEncoderContext c(FieldDescriptor fieldDescriptor, float f2, boolean z) throws IOException {
        if (z && f2 == 0.0f) {
            return this;
        }
        j((i(fieldDescriptor) << 3) | 5);
        this.f3065a.write(h(4).putFloat(f2).array());
        return this;
    }

    public final ra3 d(FieldDescriptor fieldDescriptor, int i2, boolean z) throws IOException {
        if (z && i2 == 0) {
            return this;
        }
        kb3 kb3 = (kb3) fieldDescriptor.getProperty(kb3.class);
        if (kb3 != null) {
            nb3 nb3 = nb3.DEFAULT;
            int ordinal = kb3.b.ordinal();
            if (ordinal == 0) {
                j(kb3.f2044a << 3);
                j(i2);
            } else if (ordinal == 1) {
                j(kb3.f2044a << 3);
                j((i2 + i2) ^ (i2 >> 31));
            } else if (ordinal == 2) {
                j((kb3.f2044a << 3) | 5);
                this.f3065a.write(h(4).putInt(i2).array());
            }
            return this;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final ra3 e(FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        kb3 kb3 = (kb3) fieldDescriptor.getProperty(kb3.class);
        if (kb3 != null) {
            nb3 nb3 = nb3.DEFAULT;
            int ordinal = kb3.b.ordinal();
            if (ordinal == 0) {
                j(kb3.f2044a << 3);
                k(j);
            } else if (ordinal == 1) {
                j(kb3.f2044a << 3);
                k((j >> 63) ^ (j + j));
            } else if (ordinal == 2) {
                j((kb3.f2044a << 3) | 1);
                this.f3065a.write(h(8).putLong(j).array());
            }
            return this;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final ra3 f(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new EncodingException(hj1.a0(new StringBuilder(valueOf.length() + 15), "No encoder for ", valueOf));
    }

    /* JADX INFO: finally extract failed */
    public final <T> ra3 g(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        lb3 lb3 = new lb3();
        try {
            OutputStream outputStream = this.f3065a;
            this.f3065a = lb3;
            try {
                objectEncoder.encode(t, this);
                this.f3065a = outputStream;
                long j = lb3.f;
                lb3.close();
                if (z && j == 0) {
                    return this;
                }
                j((i(fieldDescriptor) << 3) | 2);
                k(j);
                objectEncoder.encode(t, this);
                return this;
            } catch (Throwable th) {
                this.f3065a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            jb3.f1900a.a(th, th2);
        }
        throw th;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) throws IOException {
        f(obj);
        return this;
    }

    public final void j(int i2) throws IOException {
        while (((long) (i2 & -128)) != 0) {
            this.f3065a.write((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.f3065a.write(i2 & 127);
    }

    public final void k(long j) throws IOException {
        while ((-128 & j) != 0) {
            this.f3065a.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.f3065a.write(((int) j) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f2) throws IOException {
        c(fieldDescriptor, f2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) throws IOException {
        FieldDescriptor.of(str);
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i2) throws IOException {
        d(fieldDescriptor, i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        e(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        a(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        d(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d2) throws IOException {
        b(FieldDescriptor.of(str), d2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i2) throws IOException {
        d(FieldDescriptor.of(str), i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j) throws IOException {
        e(FieldDescriptor.of(str), j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, Object obj) throws IOException {
        a(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z) throws IOException {
        d(FieldDescriptor.of(str), z ? 1 : 0, true);
        return this;
    }
}
