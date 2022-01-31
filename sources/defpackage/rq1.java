package defpackage;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import defpackage.em1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Objects;

/* renamed from: rq1  reason: default package */
/* compiled from: VideoBitmapDecoder */
public class rq1 implements gm1<ParcelFileDescriptor, Bitmap> {
    public static final em1<Long> c = new em1<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final em1<Integer> d = new em1<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", null, new b());
    public static final c e = new c();

    /* renamed from: a  reason: collision with root package name */
    public final zn1 f3115a;
    public final c b;

    /* renamed from: rq1$a */
    /* compiled from: VideoBitmapDecoder */
    public static class a implements em1.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f3116a = ByteBuffer.allocate(8);

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [byte[], java.lang.Object, java.security.MessageDigest] */
        @Override // defpackage.em1.b
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.f3116a) {
                this.f3116a.position(0);
                messageDigest.update(this.f3116a.putLong(l2.longValue()).array());
            }
        }
    }

    /* renamed from: rq1$b */
    /* compiled from: VideoBitmapDecoder */
    public static class b implements em1.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f3117a = ByteBuffer.allocate(4);

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [byte[], java.lang.Object, java.security.MessageDigest] */
        @Override // defpackage.em1.b
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 != null) {
                messageDigest.update(bArr);
                synchronized (this.f3117a) {
                    this.f3117a.position(0);
                    messageDigest.update(this.f3117a.putInt(num2.intValue()).array());
                }
            }
        }
    }

    /* renamed from: rq1$c */
    /* compiled from: VideoBitmapDecoder */
    public static class c {
    }

    public rq1(zn1 zn1) {
        c cVar = e;
        this.f3115a = zn1;
        this.b = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, fm1 fm1) throws IOException {
        boolean z;
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        Objects.requireNonNull(this.b);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor2.getFileDescriptor());
            z = true;
        } catch (RuntimeException unused) {
            z = false;
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return z;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    /* JADX INFO: finally extract failed */
    @Override // defpackage.gm1
    public rn1<Bitmap> b(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, fm1 fm1) throws IOException {
        Bitmap bitmap;
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        long longValue = ((Long) fm1.c(c)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) fm1.c(d);
            Objects.requireNonNull(this.b);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(parcelFileDescriptor2.getFileDescriptor());
                if (longValue == -1) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime();
                } else if (num == null) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue);
                } else {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue, num.intValue());
                }
                mediaMetadataRetriever.release();
                parcelFileDescriptor2.close();
                return dq1.d(bitmap, this.f3115a);
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException(hj1.M("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", longValue));
        }
    }
}
