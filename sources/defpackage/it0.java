package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: it0  reason: default package */
/* compiled from: BoostRatingsBottomSheet.kt */
public final class it0 extends qn0 {
    public static final it0 k = null;
    public static final String l;
    public final a h;
    public TextView i;
    public TextView j;

    /* renamed from: it0$a */
    /* compiled from: BoostRatingsBottomSheet.kt */
    public interface a {
        void a();

        void b();

        void c();
    }

    static {
        String name = it0.class.getName();
        n86.d(name, "BoostRatingsBottomSheet::class.java.name");
        l = name;
    }

    public it0(Context context, a aVar, String str) {
        n86.e(context, "_context");
        n86.e(aVar, "_listener");
        n86.e(str, "_dialogGroupKey");
        this.g = str;
        this.h = aVar;
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.ratings_bottomsheet, viewGroup, false);
        n86.d(inflate, "view");
        View findViewById = inflate.findViewById(R.id.rate_btn);
        n86.d(findViewById, "view.findViewById(R.id.rate_btn)");
        this.i = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.remind_btn);
        n86.d(findViewById2, "view.findViewById(R.id.remind_btn)");
        this.j = (TextView) findViewById2;
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnClickListener(new io0(this));
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setOnClickListener(new jo0(this));
                this.h.a();
                return inflate;
            }
            n86.l("_remindBtn");
            throw null;
        }
        n86.l("_rateBtn");
        throw null;
    }
}
