package defpackage;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* renamed from: ll4  reason: default package */
/* compiled from: Chip */
public class ll4 extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f2235a;

    public ll4(Chip chip) {
        this.f2235a = chip;
    }

    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        ml4 ml4 = this.f2235a.f;
        if (ml4 != null) {
            ml4.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
