package defpackage;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* renamed from: om1  reason: default package */
/* compiled from: FileDescriptorAssetPathFetcher */
public class om1 extends jm1<ParcelFileDescriptor> {
    public om1(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.km1
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.jm1
    public void c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.jm1
    public ParcelFileDescriptor f(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
