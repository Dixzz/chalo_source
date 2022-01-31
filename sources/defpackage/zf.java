package defpackage;

import androidx.fragment.app.Fragment;

/* renamed from: zf  reason: default package */
/* compiled from: FragmentViewModelLazy.kt */
public final class zf extends o86 implements h76<ci> {
    public final /* synthetic */ Fragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zf(Fragment fragment) {
        super(0);
        this.f = fragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public ci invoke() {
        return this.f.getDefaultViewModelProviderFactory();
    }
}
