package defpackage;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: tm1  reason: default package */
/* compiled from: StreamAssetPathFetcher */
public class tm1 extends jm1<InputStream> {
    public tm1(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.km1
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.jm1
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.jm1
    public InputStream f(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
