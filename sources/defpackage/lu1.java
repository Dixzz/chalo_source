package defpackage;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;

/* renamed from: lu1  reason: default package */
/* compiled from: AutoBatchedLogRequestEncoder */
public final class lu1 implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f2272a = new lu1();

    /* renamed from: lu1$a */
    /* compiled from: AutoBatchedLogRequestEncoder */
    public static final class a implements ObjectEncoder<ku1> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f2273a = new a();
        public static final FieldDescriptor b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        public static final FieldDescriptor c = FieldDescriptor.of("model");
        public static final FieldDescriptor d = FieldDescriptor.of("hardware");
        public static final FieldDescriptor e = FieldDescriptor.of(AnalyticsConstants.DEVICE);
        public static final FieldDescriptor f = FieldDescriptor.of("product");
        public static final FieldDescriptor g = FieldDescriptor.of("osBuild");
        public static final FieldDescriptor h = FieldDescriptor.of("manufacturer");
        public static final FieldDescriptor i = FieldDescriptor.of("fingerprint");
        public static final FieldDescriptor j = FieldDescriptor.of(AnalyticsConstants.LOCALE);
        public static final FieldDescriptor k = FieldDescriptor.of("country");
        public static final FieldDescriptor l = FieldDescriptor.of("mccMnc");
        public static final FieldDescriptor m = FieldDescriptor.of("applicationBuild");

        /* renamed from: a */
        public void encode(ku1 ku1, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, ku1.l());
            objectEncoderContext.add(c, ku1.i());
            objectEncoderContext.add(d, ku1.e());
            objectEncoderContext.add(e, ku1.c());
            objectEncoderContext.add(f, ku1.k());
            objectEncoderContext.add(g, ku1.j());
            objectEncoderContext.add(h, ku1.g());
            objectEncoderContext.add(i, ku1.d());
            objectEncoderContext.add(j, ku1.f());
            objectEncoderContext.add(k, ku1.b());
            objectEncoderContext.add(l, ku1.h());
            objectEncoderContext.add(m, ku1.a());
        }
    }

    /* renamed from: lu1$b */
    /* compiled from: AutoBatchedLogRequestEncoder */
    public static final class b implements ObjectEncoder<tu1> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f2274a = new b();
        public static final FieldDescriptor b = FieldDescriptor.of("logRequest");

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, ((tu1) obj).a());
        }
    }

    /* renamed from: lu1$c */
    /* compiled from: AutoBatchedLogRequestEncoder */
    public static final class c implements ObjectEncoder<uu1> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f2275a = new c();
        public static final FieldDescriptor b = FieldDescriptor.of("clientType");
        public static final FieldDescriptor c = FieldDescriptor.of("androidClientInfo");

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            uu1 uu1 = (uu1) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(b, uu1.b());
            objectEncoderContext2.add(c, uu1.a());
        }
    }

    /* renamed from: lu1$d */
    /* compiled from: AutoBatchedLogRequestEncoder */
    public static final class d implements ObjectEncoder<vu1> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f2276a = new d();
        public static final FieldDescriptor b = FieldDescriptor.of("eventTimeMs");
        public static final FieldDescriptor c = FieldDescriptor.of("eventCode");
        public static final FieldDescriptor d = FieldDescriptor.of("eventUptimeMs");
        public static final FieldDescriptor e = FieldDescriptor.of("sourceExtension");
        public static final FieldDescriptor f = FieldDescriptor.of("sourceExtensionJsonProto3");
        public static final FieldDescriptor g = FieldDescriptor.of("timezoneOffsetSeconds");
        public static final FieldDescriptor h = FieldDescriptor.of("networkConnectionInfo");

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            vu1 vu1 = (vu1) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(b, vu1.b());
            objectEncoderContext2.add(c, vu1.a());
            objectEncoderContext2.add(d, vu1.c());
            objectEncoderContext2.add(e, vu1.e());
            objectEncoderContext2.add(f, vu1.f());
            objectEncoderContext2.add(g, vu1.g());
            objectEncoderContext2.add(h, vu1.d());
        }
    }

    /* renamed from: lu1$e */
    /* compiled from: AutoBatchedLogRequestEncoder */
    public static final class e implements ObjectEncoder<wu1> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f2277a = new e();
        public static final FieldDescriptor b = FieldDescriptor.of("requestTimeMs");
        public static final FieldDescriptor c = FieldDescriptor.of("requestUptimeMs");
        public static final FieldDescriptor d = FieldDescriptor.of("clientInfo");
        public static final FieldDescriptor e = FieldDescriptor.of("logSource");
        public static final FieldDescriptor f = FieldDescriptor.of("logSourceName");
        public static final FieldDescriptor g = FieldDescriptor.of("logEvent");
        public static final FieldDescriptor h = FieldDescriptor.of("qosTier");

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            wu1 wu1 = (wu1) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(b, wu1.f());
            objectEncoderContext2.add(c, wu1.g());
            objectEncoderContext2.add(d, wu1.a());
            objectEncoderContext2.add(e, wu1.c());
            objectEncoderContext2.add(f, wu1.d());
            objectEncoderContext2.add(g, wu1.b());
            objectEncoderContext2.add(h, wu1.e());
        }
    }

    /* renamed from: lu1$f */
    /* compiled from: AutoBatchedLogRequestEncoder */
    public static final class f implements ObjectEncoder<yu1> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f2278a = new f();
        public static final FieldDescriptor b = FieldDescriptor.of("networkType");
        public static final FieldDescriptor c = FieldDescriptor.of("mobileSubtype");

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            yu1 yu1 = (yu1) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(b, yu1.b());
            objectEncoderContext2.add(c, yu1.a());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        b bVar = b.f2274a;
        encoderConfig.registerEncoder(tu1.class, bVar);
        encoderConfig.registerEncoder(nu1.class, bVar);
        e eVar = e.f2277a;
        encoderConfig.registerEncoder(wu1.class, eVar);
        encoderConfig.registerEncoder(qu1.class, eVar);
        c cVar = c.f2275a;
        encoderConfig.registerEncoder(uu1.class, cVar);
        encoderConfig.registerEncoder(ou1.class, cVar);
        a aVar = a.f2273a;
        encoderConfig.registerEncoder(ku1.class, aVar);
        encoderConfig.registerEncoder(mu1.class, aVar);
        d dVar = d.f2276a;
        encoderConfig.registerEncoder(vu1.class, dVar);
        encoderConfig.registerEncoder(pu1.class, dVar);
        f fVar = f.f2278a;
        encoderConfig.registerEncoder(yu1.class, fVar);
        encoderConfig.registerEncoder(su1.class, fVar);
    }
}
