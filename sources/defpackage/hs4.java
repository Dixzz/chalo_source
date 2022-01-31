package defpackage;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* renamed from: hs4  reason: default package */
public final class hs4 {

    /* renamed from: a  reason: collision with root package name */
    public final kw4<vu4> f1421a;

    public hs4(kw4<vu4> kw4) {
        this.f1421a = kw4;
    }

    public final InputStream a(int i, String str, String str2, int i2) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) hd3.w(this.f1421a.a().d(i, str, str2, i2));
            if (parcelFileDescriptor != null && parcelFileDescriptor.getFileDescriptor() != null) {
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            }
            throw new os4(String.format("Corrupted ParcelFileDescriptor, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2)), i);
        } catch (ExecutionException e) {
            throw new os4(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2)), e, i);
        } catch (InterruptedException e2) {
            throw new os4("Extractor was interrupted while waiting for chunk file.", e2, i);
        }
    }
}
