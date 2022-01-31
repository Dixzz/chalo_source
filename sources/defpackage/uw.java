package defpackage;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: uw  reason: default package */
/* compiled from: CitySelectionFragmentBinding */
public final class uw implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final CoordinatorLayout f3558a;
    public final RecyclerView b;
    public final EditText c;
    public final ky d;
    public final TextView e;
    public final CardView f;
    public final ImageView g;
    public final Toolbar h;
    public final AppBarLayout i;

    public uw(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, EditText editText, ky kyVar, TextView textView, CardView cardView, ImageView imageView, Toolbar toolbar, AppBarLayout appBarLayout) {
        this.f3558a = coordinatorLayout;
        this.b = recyclerView;
        this.c = editText;
        this.d = kyVar;
        this.e = textView;
        this.f = cardView;
        this.g = imageView;
        this.h = toolbar;
        this.i = appBarLayout;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3558a;
    }
}
