package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.ReportProblemMetadata;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.mt0;
import defpackage.xt;
import java.util.List;
import java.util.Objects;

/* renamed from: gn0  reason: default package */
/* compiled from: ReportProblemDialog */
public class gn0 extends sn0 {
    public static final String t = gn0.class.getName();
    public final Context g;
    public LinearLayout h;
    public LinearLayout i;
    public TextView j;
    public FlexboxLayout k;
    public TextInputLayout l;
    public EditText m;
    public TextView n;
    public TextView o;
    public ReportProblemMetadata p;
    public final a q;
    public TextView r;
    public final String s;

    /* renamed from: gn0$a */
    /* compiled from: ReportProblemDialog */
    public interface a {
    }

    /* renamed from: gn0$b */
    /* compiled from: ReportProblemDialog */
    public interface b {
    }

    public gn0(Context context, String str, a aVar, String str2) {
        super(str2);
        this.g = context;
        this.s = str;
        this.q = aVar;
    }

    public final void a() {
        pb1 pb1;
        boolean z = !TextUtils.isEmpty(this.m.getText().toString());
        if (!z) {
            int i2 = 0;
            while (true) {
                if (i2 < this.k.getChildCount()) {
                    if ((this.k.getChildAt(i2) instanceof pb1) && (pb1 = (pb1) this.k.getChildAt(i2)) != null && pb1.a()) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        if (z) {
            hj1.v0(this.g, R.color.chalo_primary, this.n);
            this.n.setClickable(true);
            return;
        }
        hj1.v0(this.g, R.color.black_20, this.n);
        this.n.setClickable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.report_problem_dialog, viewGroup, false);
        xt.t1 t1Var = xt.f3961a;
        this.p = t1Var.Q().getReportProblemMetadata(this.s, t1Var.k().d().getName());
        this.h = (LinearLayout) inflate.findViewById(R.id.report_container);
        this.i = (LinearLayout) inflate.findViewById(R.id.report_ack_container);
        this.j = (TextView) inflate.findViewById(R.id.rating_container_title);
        this.k = (FlexboxLayout) inflate.findViewById(R.id.rating_tags_container);
        this.l = (TextInputLayout) inflate.findViewById(R.id.rating_text_input_layout);
        this.m = (EditText) inflate.findViewById(R.id.feedback_comments);
        this.n = (TextView) inflate.findViewById(R.id.btn_action_submit);
        this.o = (TextView) inflate.findViewById(R.id.btn_action_cancel);
        this.r = (TextView) inflate.findViewById(R.id.btn_action_ack);
        if (this.p.getTitle() != null) {
            this.j.setText(this.p.getTitle());
        } else {
            this.j.setVisibility(8);
        }
        this.k.removeAllViews();
        if (this.p.getTagDetailsMap() != null) {
            List<String> tagList = this.p.getTagList();
            if (tagList != null) {
                for (String str : tagList) {
                    if (this.p.getTagDetailsMap().containsKey(str)) {
                        pb1 pb1 = new pb1(getActivity());
                        pb1.setTagId(str);
                        pb1.setName(this.p.getTagDetailsMap().get(str));
                        pb1.setTagStatusListener(new fn0(this));
                        this.k.addView(pb1);
                    } else {
                        b00 b00 = b00.f358a;
                        b00.a().b(new Throwable(hj1.b0(hj1.i0("TagId does not exist for reporting problem of type: "), this.s, ", tagId: ", str)));
                    }
                }
            } else {
                b00 b002 = b00.f358a;
                c00 a2 = b00.a();
                StringBuilder i0 = hj1.i0("No tag list present for reporting problems of type: ");
                i0.append(this.s);
                a2.b(new Throwable(i0.toString()));
            }
        } else {
            b00 b003 = b00.f358a;
            hj1.Q0("No tag mappings present for reporting problems", b00.a());
        }
        if (this.p.getHint() != null) {
            this.l.setHint(this.p.getHint());
        }
        this.n.setOnClickListener(new bn0(this));
        this.o.setOnClickListener(new en0(this));
        this.r.setOnClickListener(new dn0(this));
        this.m.addTextChangedListener(new cn0(this));
        a aVar = this.q;
        if (aVar != null) {
            Objects.requireNonNull((mt0.d) aVar);
        }
        a();
        return inflate;
    }
}
