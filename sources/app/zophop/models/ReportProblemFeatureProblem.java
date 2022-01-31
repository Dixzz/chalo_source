package app.zophop.models;

import java.util.List;

/* compiled from: ReportProblemFeatureProblem.kt */
public final class ReportProblemFeatureProblem {
    private final String chatGroupTag;
    private final List<String> ctaTagList;
    private final String ctaType;
    private final String problemCopy;
    private final String problemId;

    public ReportProblemFeatureProblem(String str, String str2, List<String> list, String str3, String str4) {
        n86.e(str, "problemId");
        n86.e(str2, "problemCopy");
        n86.e(list, "ctaTagList");
        n86.e(str3, "chatGroupTag");
        n86.e(str4, "ctaType");
        this.problemId = str;
        this.problemCopy = str2;
        this.ctaTagList = list;
        this.chatGroupTag = str3;
        this.ctaType = str4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: app.zophop.models.ReportProblemFeatureProblem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReportProblemFeatureProblem copy$default(ReportProblemFeatureProblem reportProblemFeatureProblem, String str, String str2, List list, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reportProblemFeatureProblem.problemId;
        }
        if ((i & 2) != 0) {
            str2 = reportProblemFeatureProblem.problemCopy;
        }
        if ((i & 4) != 0) {
            list = reportProblemFeatureProblem.ctaTagList;
        }
        if ((i & 8) != 0) {
            str3 = reportProblemFeatureProblem.chatGroupTag;
        }
        if ((i & 16) != 0) {
            str4 = reportProblemFeatureProblem.ctaType;
        }
        return reportProblemFeatureProblem.copy(str, str2, list, str3, str4);
    }

    public final String component1() {
        return this.problemId;
    }

    public final String component2() {
        return this.problemCopy;
    }

    public final List<String> component3() {
        return this.ctaTagList;
    }

    public final String component4() {
        return this.chatGroupTag;
    }

    public final String component5() {
        return this.ctaType;
    }

    public final ReportProblemFeatureProblem copy(String str, String str2, List<String> list, String str3, String str4) {
        n86.e(str, "problemId");
        n86.e(str2, "problemCopy");
        n86.e(list, "ctaTagList");
        n86.e(str3, "chatGroupTag");
        n86.e(str4, "ctaType");
        return new ReportProblemFeatureProblem(str, str2, list, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportProblemFeatureProblem)) {
            return false;
        }
        ReportProblemFeatureProblem reportProblemFeatureProblem = (ReportProblemFeatureProblem) obj;
        return n86.a(this.problemId, reportProblemFeatureProblem.problemId) && n86.a(this.problemCopy, reportProblemFeatureProblem.problemCopy) && n86.a(this.ctaTagList, reportProblemFeatureProblem.ctaTagList) && n86.a(this.chatGroupTag, reportProblemFeatureProblem.chatGroupTag) && n86.a(this.ctaType, reportProblemFeatureProblem.ctaType);
    }

    public final String getChatGroupTag() {
        return this.chatGroupTag;
    }

    public final List<String> getCtaTagList() {
        return this.ctaTagList;
    }

    public final String getCtaType() {
        return this.ctaType;
    }

    public final String getProblemCopy() {
        return this.problemCopy;
    }

    public final String getProblemId() {
        return this.problemId;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.problemCopy, this.problemId.hashCode() * 31, 31);
        return this.ctaType.hashCode() + hj1.r0(this.chatGroupTag, (this.ctaTagList.hashCode() + r0) * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ReportProblemFeatureProblem(problemId=");
        i0.append(this.problemId);
        i0.append(", problemCopy=");
        i0.append(this.problemCopy);
        i0.append(", ctaTagList=");
        i0.append(this.ctaTagList);
        i0.append(", chatGroupTag=");
        i0.append(this.chatGroupTag);
        i0.append(", ctaType=");
        return hj1.Z(i0, this.ctaType, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReportProblemFeatureProblem(String str, String str2, List list, String str3, String str4, int i, j86 j86) {
        this(str, str2, list, (i & 8) != 0 ? "" : str3, str4);
    }
}
