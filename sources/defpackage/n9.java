package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: n9  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n9 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f;

    public /* synthetic */ n9(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f;
        contentLoadingProgressBar.i = true;
        contentLoadingProgressBar.removeCallbacks(contentLoadingProgressBar.k);
        contentLoadingProgressBar.h = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j = contentLoadingProgressBar.f;
        long j2 = currentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            contentLoadingProgressBar.setVisibility(8);
        } else if (!contentLoadingProgressBar.g) {
            contentLoadingProgressBar.postDelayed(contentLoadingProgressBar.j, 500 - j2);
            contentLoadingProgressBar.g = true;
        }
    }
}
