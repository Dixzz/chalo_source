package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: o9  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o9 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f;

    public /* synthetic */ o9(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f;
        contentLoadingProgressBar.h = false;
        if (!contentLoadingProgressBar.i) {
            contentLoadingProgressBar.f = System.currentTimeMillis();
            contentLoadingProgressBar.setVisibility(0);
        }
    }
}
