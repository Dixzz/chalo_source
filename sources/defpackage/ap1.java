package defpackage;

import android.util.Base64;
import defpackage.ip1;
import defpackage.km1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* renamed from: ap1  reason: default package */
/* compiled from: DataUrlLoader */
public final class ap1<Data> implements ip1<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Data> f273a;

    /* renamed from: ap1$a */
    /* compiled from: DataUrlLoader */
    public interface a<Data> {
    }

    /* renamed from: ap1$b */
    /* compiled from: DataUrlLoader */
    public static final class b<Data> implements km1<Data> {
        public final String f;
        public final a<Data> g;
        public Data h;

        public b(String str, a<Data> aVar) {
            this.f = str;
            this.g = aVar;
        }

        @Override // defpackage.km1
        public Class<Data> a() {
            Objects.requireNonNull((c.a) this.g);
            return InputStream.class;
        }

        @Override // defpackage.km1
        public void b() {
            try {
                a<Data> aVar = this.g;
                Data data = this.h;
                Objects.requireNonNull((c.a) aVar);
                data.close();
            } catch (IOException unused) {
            }
        }

        @Override // defpackage.km1
        public void cancel() {
        }

        @Override // defpackage.km1
        public xl1 d() {
            return xl1.LOCAL;
        }

        @Override // defpackage.km1
        public void e(kl1 kl1, km1.a<? super Data> aVar) {
            try {
                Data data = (Data) ((c.a) this.g).a(this.f);
                this.h = data;
                aVar.g(data);
            } catch (IllegalArgumentException e) {
                aVar.c(e);
            }
        }
    }

    /* renamed from: ap1$c */
    /* compiled from: DataUrlLoader */
    public static final class c implements jp1<String, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final a<InputStream> f274a = new a(this);

        /* renamed from: ap1$c$a */
        /* compiled from: DataUrlLoader */
        public class a implements a<InputStream> {
            public a(c cVar) {
            }

            public Object a(String str) throws IllegalArgumentException {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        @Override // defpackage.jp1
        public final ip1<String, InputStream> b(mp1 mp1) {
            return new ap1(this.f274a);
        }
    }

    public ap1(a<Data> aVar) {
        this.f273a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(String str) {
        return str.startsWith("data:image");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(String str, int i, int i2, fm1 fm1) {
        String str2 = str;
        return new ip1.a(new jt1(str2), new b(str2, this.f273a));
    }
}
