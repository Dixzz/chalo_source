package defpackage;

import android.graphics.Bitmap;
import android.widget.ProgressBar;

/* renamed from: aa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class aa0 implements Runnable {
    public final /* synthetic */ pz f;
    public final /* synthetic */ Bitmap g;

    public /* synthetic */ aa0(pz pzVar, Bitmap bitmap) {
        this.f = pzVar;
        this.g = bitmap;
    }

    public final void run() {
        pz pzVar = this.f;
        Bitmap bitmap = this.g;
        n86.e(pzVar, "$this_apply");
        n86.e(bitmap, "$resource");
        ProgressBar progressBar = pzVar.d;
        n86.d(progressBar, "passProfilePicProgressbar");
        progressBar.setVisibility(8);
        pzVar.e.setImageBitmap(bitmap);
    }
}
