package defpackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.ReportProblemCollection;
import app.zophop.models.ReportProblemFeatureProblem;
import app.zophop.ui.activities.ReportProblemActivity;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: fa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fa0 implements View.OnClickListener {
    public final /* synthetic */ ReportProblemActivity f;
    public final /* synthetic */ ReportProblemFeatureProblem g;

    public /* synthetic */ fa0(ReportProblemActivity reportProblemActivity, ReportProblemFeatureProblem reportProblemFeatureProblem) {
        this.f = reportProblemActivity;
        this.g = reportProblemFeatureProblem;
    }

    public final void onClick(View view) {
        ReportProblemActivity reportProblemActivity = this.f;
        ReportProblemFeatureProblem reportProblemFeatureProblem = this.g;
        ReportProblemActivity.a aVar = ReportProblemActivity.r;
        n86.e(reportProblemActivity, "this$0");
        n86.e(reportProblemFeatureProblem, "$problem");
        boolean z = !TextUtils.isEmpty(reportProblemFeatureProblem.getChatGroupTag());
        String chatGroupTag = reportProblemFeatureProblem.getChatGroupTag();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(chatGroupTag)) {
            hashMap.put("chatGroupTag", chatGroupTag);
        }
        Map<String, String> map = ReportProblemActivity.t;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            Freshchat.getInstance(reportProblemActivity).setUserProperties(hashMap);
            if (ea6.f(reportProblemFeatureProblem.getCtaType(), "article", true)) {
                FaqOptions faqOptions = new FaqOptions();
                List<String> ctaTagList = reportProblemFeatureProblem.getCtaTagList();
                ReportProblemCollection reportProblemCollection = ReportProblemActivity.s;
                if (reportProblemCollection != null) {
                    FaqOptions showFaqCategoriesAsGrid = faqOptions.filterByTags(ctaTagList, reportProblemCollection.getTitle(), FaqOptions.FilterType.ARTICLE).showFaqCategoriesAsGrid(false);
                    if (!z) {
                        showFaqCategoriesAsGrid.showContactUsOnFaqNotHelpful(false).showContactUsOnAppBar(false).showContactUsOnFaqScreens(false);
                    }
                    Freshchat.showFAQs(reportProblemActivity, showFaqCategoriesAsGrid);
                } else {
                    n86.l("_problemCollection");
                    throw null;
                }
            } else if (ea6.f(reportProblemFeatureProblem.getCtaType(), "category", true)) {
                FaqOptions faqOptions2 = new FaqOptions();
                List<String> ctaTagList2 = reportProblemFeatureProblem.getCtaTagList();
                ReportProblemCollection reportProblemCollection2 = ReportProblemActivity.s;
                if (reportProblemCollection2 != null) {
                    FaqOptions showFaqCategoriesAsGrid2 = faqOptions2.filterByTags(ctaTagList2, reportProblemCollection2.getTitle(), FaqOptions.FilterType.CATEGORY).showFaqCategoriesAsGrid(false);
                    if (!z) {
                        showFaqCategoriesAsGrid2.showContactUsOnFaqNotHelpful(false).showContactUsOnAppBar(false).showContactUsOnFaqScreens(false);
                    }
                    Freshchat.showFAQs(reportProblemActivity, showFaqCategoriesAsGrid2);
                } else {
                    n86.l("_problemCollection");
                    throw null;
                }
            } else if (ea6.f(reportProblemFeatureProblem.getCtaType(), "chat", true)) {
                Freshchat.showConversations(reportProblemActivity, new ConversationOptions());
            } else if (ea6.f(reportProblemFeatureProblem.getCtaType(), "reclaimPasses", true)) {
                jz5.b().g(new ed1("reclaim pass", Long.MIN_VALUE));
                lm0 a2 = lm0.a(reportProblemActivity.getFragmentManager(), null, reportProblemActivity.getString(R.string.dialog_message_confirm_reclaim_pass), reportProblemActivity.getResources().getString(R.string.yes), reportProblemActivity.getResources().getString(R.string.no));
                ha0 ha0 = new ha0(a2, reportProblemActivity);
                TextView textView = a2.i;
                if (textView != null) {
                    textView.setOnClickListener(ha0);
                } else {
                    a2.q = ha0;
                }
                ga0 ga0 = new ga0(a2);
                TextView textView2 = a2.j;
                if (textView2 != null) {
                    textView2.setOnClickListener(ga0);
                } else {
                    a2.r = ga0;
                }
            }
            String problemId = reportProblemFeatureProblem.getProblemId();
            String problemCopy = reportProblemFeatureProblem.getProblemCopy();
            String ctaType = reportProblemFeatureProblem.getCtaType();
            n86.e(problemId, "problemId");
            n86.e(problemCopy, "problemCopy");
            n86.e(ctaType, "problemCtaType");
            ed1 ed1 = new ed1("report problem feature problem clicked", Long.MIN_VALUE);
            City d = xt.f3961a.k().d();
            if (d != null) {
                ed1.a("cityName", d.getName());
            }
            ed1.a("problem Id", problemId);
            hj1.p(ed1, "problem copy", problemCopy, "problem cta type", ctaType).g(ed1);
            return;
        }
        n86.l("_userPropertiesMap");
        throw null;
    }
}
