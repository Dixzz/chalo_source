package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.ui.fragments.UserDetailsFragment;

/* renamed from: cx0  reason: default package */
/* compiled from: UserDetailsFragment */
public class cx0 implements View.OnClickListener {
    public final View f;
    public final /* synthetic */ View g;
    public final /* synthetic */ int h;
    public final /* synthetic */ UserDetailsFragment i;

    public cx0(UserDetailsFragment userDetailsFragment, View view, int i2) {
        this.i = userDetailsFragment;
        this.g = view;
        this.h = i2;
        this.f = view;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("remove icon clicked", Long.MIN_VALUE);
        ed1.a("proofPosition", Integer.valueOf(this.h));
        jz5.b().g(ed1);
        UserDetailsFragment userDetailsFragment = this.i;
        View view2 = this.g;
        int i2 = this.h;
        userDetailsFragment.D = view2;
        if (i2 == 0) {
            userDetailsFragment.m = null;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.card_view).findViewById(R.id.add_image_view);
        imageView.setImageDrawable(null);
        ImageView imageView2 = (ImageView) userDetailsFragment.D.findViewById(R.id.remove_icon);
        imageView2.setVisibility(0);
        imageView2.setOnClickListener(new cx0(userDetailsFragment, userDetailsFragment.D, i2));
        imageView.setVisibility(0);
        imageView.setImageBitmap(null);
        userDetailsFragment.h();
        ImageView imageView3 = (ImageView) this.f.findViewById(R.id.card_view).findViewById(R.id.add_image_view);
        imageView3.setVisibility(0);
        imageView3.setImageDrawable(this.i.getResources().getDrawable(R.drawable.add_proof_selection));
        ((ImageView) this.f.findViewById(R.id.remove_icon)).setVisibility(8);
        this.i.A.get(this.h).setUrl(null);
        this.i.h();
    }
}
