package defpackage;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.ip1;
import defpackage.km1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: bp1  reason: default package */
/* compiled from: FileLoader */
public class bp1<Data> implements ip1<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final d<Data> f461a;

    /* renamed from: bp1$a */
    /* compiled from: FileLoader */
    public static class a<Data> implements jp1<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final d<Data> f462a;

        public a(d<Data> dVar) {
            this.f462a = dVar;
        }

        @Override // defpackage.jp1
        public final ip1<File, Data> b(mp1 mp1) {
            return new bp1(this.f462a);
        }
    }

    /* renamed from: bp1$b */
    /* compiled from: FileLoader */
    public static class b extends a<ParcelFileDescriptor> {

        /* renamed from: bp1$b$a */
        /* compiled from: FileLoader */
        public class a implements d<ParcelFileDescriptor> {
            @Override // defpackage.bp1.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.bp1.d
            public ParcelFileDescriptor b(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.bp1.d
            public void c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }
        }

        public b() {
            super(new a());
        }
    }

    /* renamed from: bp1$c */
    /* compiled from: FileLoader */
    public static class c<Data> implements km1<Data> {
        public final File f;
        public final d<Data> g;
        public Data h;

        public c(File file, d<Data> dVar) {
            this.f = file;
            this.g = dVar;
        }

        @Override // defpackage.km1
        public Class<Data> a() {
            return this.g.a();
        }

        @Override // defpackage.km1
        public void b() {
            Data data = this.h;
            if (data != null) {
                try {
                    this.g.c(data);
                } catch (IOException unused) {
                }
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
                Data b = this.g.b(this.f);
                this.h = b;
                aVar.g(b);
            } catch (FileNotFoundException e) {
                Log.isLoggable("FileLoader", 3);
                aVar.c(e);
            }
        }
    }

    /* renamed from: bp1$d */
    /* compiled from: FileLoader */
    public interface d<Data> {
        Class<Data> a();

        Data b(File file) throws FileNotFoundException;

        void c(Data data) throws IOException;
    }

    /* renamed from: bp1$e */
    /* compiled from: FileLoader */
    public static class e extends a<InputStream> {

        /* renamed from: bp1$e$a */
        /* compiled from: FileLoader */
        public class a implements d<InputStream> {
            @Override // defpackage.bp1.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.bp1.d
            public InputStream b(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.bp1.d
            public void c(InputStream inputStream) throws IOException {
                inputStream.close();
            }
        }

        public e() {
            super(new a());
        }
    }

    public bp1(d<Data> dVar) {
        this.f461a = dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(File file) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(File file, int i, int i2, fm1 fm1) {
        File file2 = file;
        return new ip1.a(new jt1(file2), new c(file2, this.f461a));
    }
}
