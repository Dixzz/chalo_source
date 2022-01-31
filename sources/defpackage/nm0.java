package defpackage;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Guidelines;
import app.zophop.ui.views.OrderedGuidelines;

/* renamed from: nm0  reason: default package */
/* compiled from: GuidelinesDialog */
public class nm0 extends DialogFragment {
    public static final String h = nm0.class.getName();
    public final b f;
    public final Guidelines g;

    /* renamed from: nm0$a */
    /* compiled from: GuidelinesDialog */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            nm0.this.dismiss();
            nm0.this.f.a();
        }
    }

    /* renamed from: nm0$b */
    /* compiled from: GuidelinesDialog */
    public interface b {
        void a();
    }

    public nm0(Guidelines guidelines, b bVar) {
        this.g = guidelines;
        this.f = bVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_guidelines, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.btn_accept)).setOnClickListener(new a());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image_logo);
        ((TextView) inflate.findViewById(R.id.tv_dialog_title)).setText(this.g.getTitle());
        if (TextUtils.isEmpty(this.g.getUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            ml1<Drawable> p = gl1.d(getActivity()).p(this.g.getUrl());
            p.a(new rs1().j(R.drawable.nearby_click));
            p.e(imageView);
        }
        OrderedGuidelines orderedGuidelines = (OrderedGuidelines) inflate.findViewById(R.id.list);
        orderedGuidelines.setIsTextHTMLMarkup(true);
        orderedGuidelines.setData(this.g);
        return inflate;
    }
}
