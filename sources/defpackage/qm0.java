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
import app.zophop.models.CtaAction;
import app.zophop.models.NpsSurvey;
import app.zophop.models.NpsSurveyQuestion;
import app.zophop.models.NpsSurveyRatingQuestion;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.q30;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;

/* renamed from: qm0  reason: default package */
/* compiled from: NpsSurveyDialog */
public class qm0 extends sn0 {
    public static final String H = qm0.class.getName();
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public final Context g;
    public final String h;
    public final String i;
    public final g j;
    public final NpsSurveyQuestion k;
    public final NpsSurveyRatingQuestion l;
    public int m;
    public TextView n;
    public TextView o;
    public FlexboxLayout p;
    public EditText q;
    public TextInputLayout r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* renamed from: qm0$a */
    /* compiled from: NpsSurveyDialog */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            pb1 pb1;
            String obj = qm0.this.q.getText().toString();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < qm0.this.p.getChildCount(); i++) {
                if ((qm0.this.p.getChildAt(i) instanceof pb1) && (pb1 = (pb1) qm0.this.p.getChildAt(i)) != null && pb1.a()) {
                    jSONArray.put(pb1.getName());
                }
            }
            qm0 qm0 = qm0.this;
            try {
                vn.E0(qm0.q, qm0.g);
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
            qm0 qm02 = qm0.this;
            if (!(qm02.j == null || qm02.k.getPositiveCtaAction() == null)) {
                qm0 qm03 = qm0.this;
                g gVar = qm03.j;
                CtaAction positiveCtaAction = qm03.k.getPositiveCtaAction();
                String jSONArray2 = jSONArray.toString();
                q30.c cVar = (q30.c) gVar;
                Objects.requireNonNull(cVar);
                long Q = ui1.Q();
                xt.t1 t1Var = xt.f3961a;
                t1Var.l().put("keyLastNpsSubmittedTime", String.valueOf(Q));
                HashMap hashMap = new HashMap();
                hashMap.put("NPS tags selected", jSONArray2);
                hashMap.put("NPS response text submitted", obj);
                hashMap.put("NPS Last submitted", String.valueOf(Q));
                String optString = t1Var.l().h.optString("keyLastNpsScoreSubmitted", null);
                if (optString != null) {
                    hashMap.put("NPS score value selected", optString);
                }
                q30.a("NPS survey submitted", hashMap);
                q30.b(q30.this, positiveCtaAction, cVar.c, cVar.b);
            }
            qm0.this.dismiss();
        }
    }

    /* renamed from: qm0$b */
    /* compiled from: NpsSurveyDialog */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            qm0 qm0 = qm0.this;
            g gVar = qm0.j;
            if (gVar != null) {
                CtaAction positiveCtaAction = qm0.k.getPositiveCtaAction();
                q30.c cVar = (q30.c) gVar;
                if (cVar.f2891a && q30.j != null) {
                    xt.f3961a.o().a(q30.j, true);
                }
                if ("PLAYSTORE_REVIEW".equalsIgnoreCase(positiveCtaAction.getCtaType())) {
                    q30.a("NPS rate on playstore clicked", null);
                }
                q30.b(q30.this, positiveCtaAction, null, cVar.b);
            }
            qm0.this.dismiss();
        }
    }

    /* renamed from: qm0$c */
    /* compiled from: NpsSurveyDialog */
    public class c implements View.OnClickListener {
        public c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r7) {
            /*
            // Method dump skipped, instructions count: 138
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.qm0.c.onClick(android.view.View):void");
        }
    }

    /* renamed from: qm0$d */
    /* compiled from: NpsSurveyDialog */
    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            qm0 qm0 = qm0.this;
            g gVar = qm0.j;
            if (gVar != null) {
                ((q30.c) gVar).a(qm0.k.getNegativeCtaAction(), qm0.this.i);
            }
            qm0.this.dismiss();
        }
    }

    /* renamed from: qm0$e */
    /* compiled from: NpsSurveyDialog */
    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            g gVar = qm0.this.j;
            if (gVar != null) {
                ((q30.c) gVar).a(new CtaAction("DISMISS", null, null), qm0.this.i);
            }
            qm0.this.dismiss();
        }
    }

    /* renamed from: qm0$f */
    /* compiled from: NpsSurveyDialog */
    public interface f {
        void a();
    }

    /* renamed from: qm0$g */
    /* compiled from: NpsSurveyDialog */
    public interface g {
    }

    public qm0(Context context, NpsSurveyQuestion npsSurveyQuestion, g gVar, String str) {
        super(str);
        this.g = context;
        this.h = npsSurveyQuestion.getQuestionType();
        this.i = npsSurveyQuestion.getQuestionId();
        if ("RATING".equalsIgnoreCase(npsSurveyQuestion.getQuestionType())) {
            this.k = null;
            this.l = (NpsSurveyRatingQuestion) npsSurveyQuestion;
        } else {
            this.k = npsSurveyQuestion;
            this.l = null;
        }
        this.j = gVar;
    }

    public final View.OnClickListener a() {
        if ("TEXT".equalsIgnoreCase(this.h) || "THANK_YOU".equalsIgnoreCase(this.h)) {
            return new d();
        }
        return new e();
    }

    public final View.OnClickListener b(String str) {
        if ("TEXT".equalsIgnoreCase(str)) {
            return new a();
        }
        if ("THANK_YOU".equalsIgnoreCase(str)) {
            return new b();
        }
        if ("RATING".equalsIgnoreCase(str)) {
            return new c();
        }
        return null;
    }

    public final void c(boolean z2) {
        if (z2) {
            this.o.setText(this.l.getQuestionText());
        } else {
            this.o.setText(this.k.getQuestionText());
        }
    }

    public final void d() {
        CtaAction negativeCtaAction = this.k.getNegativeCtaAction();
        if (negativeCtaAction == null || TextUtils.isEmpty(negativeCtaAction.getCtaText())) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(negativeCtaAction.getCtaText());
        }
    }

    public final void e() {
        CtaAction positiveCtaAction = this.k.getPositiveCtaAction();
        if (positiveCtaAction != null && !TextUtils.isEmpty(positiveCtaAction.getCtaText())) {
            if ("TEXT".equalsIgnoreCase(this.k.getQuestionType())) {
                this.s.setText(positiveCtaAction.getCtaText());
            } else if ("THANK_YOU".equalsIgnoreCase(this.k.getQuestionType())) {
                this.s.setText(positiveCtaAction.getCtaText());
                if ("PLAYSTORE_REVIEW".equalsIgnoreCase(positiveCtaAction.getCtaType())) {
                    this.s.setBackgroundResource(R.drawable.orange_rounded_button);
                    hj1.v0(this.g, R.color.white, this.s);
                    return;
                }
                this.s.setBackgroundResource(R.drawable.drawer_item_selector);
                hj1.v0(this.g, R.color.chalo_primary, this.s);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if ("RATING".equalsIgnoreCase(this.h)) {
            view = layoutInflater.inflate(R.layout.nps_survey_dialog_type1, viewGroup, false);
        } else if ("TEXT".equalsIgnoreCase(this.h)) {
            view = layoutInflater.inflate(R.layout.nps_survey_dialog_type2, viewGroup, false);
        } else {
            view = "THANK_YOU".equalsIgnoreCase(this.h) ? layoutInflater.inflate(R.layout.nps_survey_dialog_type3, viewGroup, false) : null;
        }
        if (view == null) {
            return null;
        }
        if ("RATING".equalsIgnoreCase(this.h)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.nps_survey_dialog_layout);
            this.o = (TextView) view.findViewById(R.id.nps_dialog_type1_title);
            this.u = (TextView) view.findViewById(R.id.nps_low_rating_text);
            this.v = (TextView) view.findViewById(R.id.nps_high_rating_text);
            this.t = (TextView) view.findViewById(R.id.btn_negative_action);
            this.s = (TextView) view.findViewById(R.id.btn_positive_action);
            this.w = (TextView) view.findViewById(R.id.rating_zero);
            this.x = (TextView) view.findViewById(R.id.rating_one);
            this.y = (TextView) view.findViewById(R.id.rating_two);
            this.z = (TextView) view.findViewById(R.id.rating_three);
            this.A = (TextView) view.findViewById(R.id.rating_four);
            this.B = (TextView) view.findViewById(R.id.rating_five);
            this.C = (TextView) view.findViewById(R.id.rating_six);
            this.D = (TextView) view.findViewById(R.id.rating_seven);
            this.E = (TextView) view.findViewById(R.id.rating_eight);
            this.F = (TextView) view.findViewById(R.id.rating_nine);
            this.G = (TextView) view.findViewById(R.id.rating_ten);
        } else if ("TEXT".equalsIgnoreCase(this.h)) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.nps_survey_dialog_layout);
            this.o = (TextView) view.findViewById(R.id.nps_dialog_type2_title);
            this.p = (FlexboxLayout) view.findViewById(R.id.suggested_nps_survey_tags);
            this.r = (TextInputLayout) view.findViewById(R.id.nps_dialog_type2_text_input_layout);
            this.q = (EditText) view.findViewById(R.id.nps_dialog_type2_comments);
            this.s = (TextView) view.findViewById(R.id.btn_positive_action);
            this.t = (TextView) view.findViewById(R.id.btn_negative_action);
        } else if ("THANK_YOU".equalsIgnoreCase(this.h)) {
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.nps_survey_dialog_layout);
            this.n = (TextView) view.findViewById(R.id.nps_question_title);
            this.o = (TextView) view.findViewById(R.id.nps_question_text);
            this.s = (TextView) view.findViewById(R.id.btn_positive_action);
            this.t = (TextView) view.findViewById(R.id.btn_negative_action);
        }
        if ("RATING".equalsIgnoreCase(this.h)) {
            c(true);
            if (!TextUtils.isEmpty(this.l.getLowestRatingText())) {
                this.u.setText(this.l.getLowestRatingText());
            } else {
                this.u.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.l.getHighestRatingText())) {
                this.v.setText(this.l.getHighestRatingText());
            } else {
                this.v.setVisibility(8);
            }
        } else if ("TEXT".equalsIgnoreCase(this.h)) {
            c(false);
            this.p.removeAllViews();
            List<String> suggestedTagsList = this.k.getSuggestedTagsList();
            if (suggestedTagsList == null || suggestedTagsList.size() <= 0) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
                for (String str : suggestedTagsList) {
                    pb1 pb1 = new pb1(getActivity());
                    pb1.setTagId(str);
                    pb1.setName(str);
                    this.p.addView(pb1);
                }
            }
            if (!TextUtils.isEmpty(this.k.getQuestionHint())) {
                this.r.setHint(this.k.getQuestionHint());
            }
            e();
            d();
        } else if ("THANK_YOU".equalsIgnoreCase(this.h)) {
            if (!TextUtils.isEmpty(this.k.getQuestionTitle())) {
                this.n.setText(this.k.getQuestionTitle());
            }
            c(false);
            e();
            d();
        }
        if ("RATING".equalsIgnoreCase(this.h)) {
            TextView textView = this.w;
            textView.setOnClickListener(new rm0(this, 0, textView));
            TextView textView2 = this.x;
            textView2.setOnClickListener(new rm0(this, 1, textView2));
            TextView textView3 = this.y;
            textView3.setOnClickListener(new rm0(this, 2, textView3));
            TextView textView4 = this.z;
            textView4.setOnClickListener(new rm0(this, 3, textView4));
            TextView textView5 = this.A;
            textView5.setOnClickListener(new rm0(this, 4, textView5));
            TextView textView6 = this.B;
            textView6.setOnClickListener(new rm0(this, 5, textView6));
            TextView textView7 = this.C;
            textView7.setOnClickListener(new rm0(this, 6, textView7));
            TextView textView8 = this.D;
            textView8.setOnClickListener(new rm0(this, 7, textView8));
            TextView textView9 = this.E;
            textView9.setOnClickListener(new rm0(this, 8, textView9));
            TextView textView10 = this.F;
            textView10.setOnClickListener(new rm0(this, 9, textView10));
            TextView textView11 = this.G;
            textView11.setOnClickListener(new rm0(this, 10, textView11));
            this.t.setOnClickListener(a());
            this.s.setOnClickListener(b(this.h));
        } else if ("TEXT".equalsIgnoreCase(this.h)) {
            this.s.setOnClickListener(b("TEXT"));
            this.t.setOnClickListener(a());
            this.q.addTextChangedListener(new pm0(this));
        } else if ("THANK_YOU".equalsIgnoreCase(this.h)) {
            this.s.setOnClickListener(b("THANK_YOU"));
            this.t.setOnClickListener(a());
        }
        g gVar = this.j;
        if (gVar != null) {
            q30.c cVar = (q30.c) gVar;
            if (cVar.f2891a) {
                q30.this.f2889a.put("keyNpsSurveyRendered", String.valueOf(true));
                long Q = ui1.Q();
                xt.f3961a.l().put("keyLastNpsRenderedTime", String.valueOf(Q));
                HashMap hashMap = new HashMap();
                hashMap.put("NPS Last rendered", String.valueOf(Q));
                if (cVar.b) {
                    StringBuilder i0 = hj1.i0("NPS survey screen id ");
                    i0.append(q30.this.e);
                    hashMap.put("NPS survey rendered on back pressed", i0.toString());
                } else {
                    StringBuilder i02 = hj1.i0("NPS survey screen id ");
                    i02.append(q30.this.e);
                    hashMap.put("NPS survey rendered after time out", i02.toString());
                }
                hashMap.put("NPS rating dialog type", "NPS single line rating dialog");
                q30 q30 = q30.this;
                NpsSurvey f2 = q30.f(q30.e);
                if (f2 != null) {
                    hashMap.put("NPS survey id ", f2.getSurveyId());
                }
                q30.a("NPS survey rendered", hashMap);
            }
        }
        if ("RATING".equalsIgnoreCase(this.h)) {
            this.s.setAlpha(0.4f);
            this.s.setClickable(false);
        }
        return view;
    }
}
