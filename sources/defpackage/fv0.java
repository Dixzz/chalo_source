package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.summary_card.LoaderView;

/* renamed from: fv0  reason: default package */
/* compiled from: LoaderFragment */
public class fv0 extends DialogFragment {
    public TextView f;

    /* renamed from: fv0$a */
    /* compiled from: LoaderFragment */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (fv0.this.getActivity() instanceof c) {
                ((c) fv0.this.getActivity()).t();
                fv0.this.dismiss();
            }
        }
    }

    /* renamed from: fv0$b */
    /* compiled from: LoaderFragment */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            if (fv0.this.getActivity() instanceof c) {
                ((c) fv0.this.getActivity()).t();
                fv0.this.dismiss();
            }
        }
    }

    /* renamed from: fv0$c */
    /* compiled from: LoaderFragment */
    public interface c {
        void t();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string = getArguments().getString("loader_message");
        String string2 = getArguments().getString("loader_title");
        String string3 = getArguments().getString("loader_positive_title");
        String string4 = getArguments().getString("loader_negative_title");
        boolean z = getArguments().getBoolean("loader_title_visibility");
        boolean z2 = getArguments().containsKey("show_positive_button") && getArguments().getBoolean("show_positive_button");
        boolean z3 = getArguments().containsKey("show_negative_button") && getArguments().getBoolean("show_negative_button");
        View inflate = layoutInflater.inflate(R.layout.loader_fragment_layout, viewGroup, true);
        ((TextView) inflate.findViewById(R.id.dialog_text)).setText(string);
        this.f = (TextView) inflate.findViewById(R.id.loader_title);
        View findViewById = inflate.findViewById(R.id.loader_container);
        if (z) {
            this.f.setVisibility(0);
            this.f.setText(string2);
        } else {
            findViewById.setPadding(getResources().getDimensionPixelSize(R.dimen.loader_container_top_padding), 0, 0, getResources().getDimensionPixelSize(R.dimen.loader_container_bottom_padding_no_title));
            this.f.setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.action_loader_dialog);
        TextView textView2 = (TextView) inflate.findViewById(R.id.positiveHandler);
        if (z2) {
            textView2.setText(string3);
            textView2.setVisibility(0);
            textView2.setOnClickListener(new a());
        } else {
            textView2.setVisibility(8);
        }
        if (z3) {
            textView.setText(string4);
            textView.setVisibility(0);
            textView.setOnClickListener(new b());
        } else {
            textView.setVisibility(8);
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.dialog_loader).setVisibility(0);
        ((LoaderView) view.findViewById(R.id.dialog_loader)).d();
    }
}
