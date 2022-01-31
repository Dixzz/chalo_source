package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Route;

/* renamed from: gm0  reason: default package */
/* compiled from: AutoSubscriptionDialog */
public class gm0 extends DialogFragment {
    public static final String g = gm0.class.getName();
    public final Route f;

    /* renamed from: gm0$a */
    /* compiled from: AutoSubscriptionDialog */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            gm0 gm0 = gm0.this;
            ed1 ed1 = new ed1("auto subscribe dialog dismissed", Long.MIN_VALUE);
            ed1.a("route id", gm0.f.getRouteId());
            jz5.b().g(ed1);
            gm0.this.dismiss();
        }
    }

    /* renamed from: gm0$b */
    /* compiled from: AutoSubscriptionDialog */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            gm0.this.dismiss();
            if (gm0.this.getActivity() instanceof c) {
                ((c) gm0.this.getActivity()).a0();
            }
        }
    }

    /* renamed from: gm0$c */
    /* compiled from: AutoSubscriptionDialog */
    public interface c {
        void a0();
    }

    public gm0(Route route) {
        this.f = route;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.autosubscribe_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.autosubscribe_dialog_title)).setText(String.format(getString(R.string.autosubscribe_dialog_title), this.f.getRouteName()));
        ((TextView) inflate.findViewById(R.id.cancel)).setOnClickListener(new a());
        ((TextView) inflate.findViewById(R.id.done)).setOnClickListener(new b());
        return inflate;
    }
}
