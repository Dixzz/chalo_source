package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: p9  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class p9 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f;

    public /* synthetic */ p9(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f;
        contentLoadingProgressBar.f = -1;
        contentLoadingProgressBar.i = false;
        contentLoadingProgressBar.removeCallbacks(contentLoadingProgressBar.j);
        contentLoadingProgressBar.g = false;
        if (!contentLoadingProgressBar.h) {
            contentLoadingProgressBar.postDelayed(contentLoadingProgressBar.k, 500);
            contentLoadingProgressBar.h = true;
        }
    }
}
