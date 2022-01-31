package defpackage;

/* renamed from: qn0  reason: default package */
/* compiled from: ZophopOrderedBottomSheetFragment.kt */
public class qn0 extends hl4 {
    public boolean f;
    public String g;

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.g != null) {
            xt.f3961a.o().a(this.g, !this.f);
        }
    }
}
