package defpackage;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import defpackage.g9;

/* renamed from: fl4  reason: default package */
/* compiled from: BottomSheetBehavior */
public class fl4 implements g9 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1138a;
    public final /* synthetic */ BottomSheetBehavior b;

    public fl4(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.b = bottomSheetBehavior;
        this.f1138a = i;
    }

    @Override // defpackage.g9
    public boolean a(View view, g9.a aVar) {
        this.b.M(this.f1138a);
        return true;
    }
}
