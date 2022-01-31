package defpackage;

import java.io.File;
import java.io.IOException;

/* renamed from: vq1  reason: default package */
/* compiled from: FileDecoder */
public class vq1 implements gm1<File, File> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public /* bridge */ /* synthetic */ boolean a(File file, fm1 fm1) throws IOException {
        return true;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.gm1
    public rn1<File> b(File file, int i, int i2, fm1 fm1) throws IOException {
        return new wq1(file);
    }
}
