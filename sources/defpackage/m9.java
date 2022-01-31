package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: m9  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m9 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f;

    public /* synthetic */ m9(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f;
        contentLoadingProgressBar.g = false;
        contentLoadingProgressBar.f = -1;
        contentLoadingProgressBar.setVisibility(8);
    }
}
