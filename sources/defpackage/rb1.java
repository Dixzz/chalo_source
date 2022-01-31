package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: rb1  reason: default package */
/* compiled from: ReportProblemItemView.kt */
public final class rb1 extends LinearLayout {
    public final Context f;
    public final String g;
    public final boolean h;
    public LinearLayout i;
    public TextView j;
    public TextView k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rb1(Context context, String str, boolean z) {
        super(context);
        n86.e(context, "_context");
        n86.e(str, "_copy");
        this.f = context;
        this.g = str;
        this.h = z;
        LayoutInflater.from(getContext()).inflate(R.layout.report_problem_item, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.problem_text);
        n86.d(findViewById, "findViewById(R.id.problem_text)");
        set_problemText((TextView) findViewById);
        View findViewById2 = findViewById(R.id.problem_category_title);
        n86.d(findViewById2, "findViewById(R.id.problem_category_title)");
        set_titleText((TextView) findViewById2);
        View findViewById3 = findViewById(R.id.problem_layout);
        n86.d(findViewById3, "findViewById(R.id.problem_layout)");
        set_problemLayout((LinearLayout) findViewById3);
        if (!z) {
            get_problemText().setVisibility(0);
            get_titleText().setVisibility(8);
            get_problemText().setText(str);
            return;
        }
        get_titleText().setVisibility(0);
        get_problemText().setVisibility(8);
        get_titleText().setText(str);
    }

    public final Context get_context() {
        return this.f;
    }

    public final LinearLayout get_problemLayout() {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            return linearLayout;
        }
        n86.l("_problemLayout");
        throw null;
    }

    public final TextView get_problemText() {
        TextView textView = this.j;
        if (textView != null) {
            return textView;
        }
        n86.l("_problemText");
        throw null;
    }

    public final TextView get_titleText() {
        TextView textView = this.k;
        if (textView != null) {
            return textView;
        }
        n86.l("_titleText");
        throw null;
    }

    public final void set_problemLayout(LinearLayout linearLayout) {
        n86.e(linearLayout, "<set-?>");
        this.i = linearLayout;
    }

    public final void set_problemText(TextView textView) {
        n86.e(textView, "<set-?>");
        this.j = textView;
    }

    public final void set_titleText(TextView textView) {
        n86.e(textView, "<set-?>");
        this.k = textView;
    }
}
