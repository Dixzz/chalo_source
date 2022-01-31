package app.zophop.models;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.util.List;

/* compiled from: ReportProblemFeatureCategory.kt */
public final class ReportProblemFeatureCategory {
    private final String categoryId;
    private final String categoryName;
    private final List<ReportProblemFeatureProblem> problemList;

    public ReportProblemFeatureCategory(String str, String str2, List<ReportProblemFeatureProblem> list) {
        n86.e(str, SuperPassJsonKeys.CATEGORY_ID);
        n86.e(str2, SuperPassJsonKeys.CATEGORY_NAME);
        n86.e(list, "problemList");
        this.categoryId = str;
        this.categoryName = str2;
        this.problemList = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: app.zophop.models.ReportProblemFeatureCategory */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReportProblemFeatureCategory copy$default(ReportProblemFeatureCategory reportProblemFeatureCategory, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reportProblemFeatureCategory.categoryId;
        }
        if ((i & 2) != 0) {
            str2 = reportProblemFeatureCategory.categoryName;
        }
        if ((i & 4) != 0) {
            list = reportProblemFeatureCategory.problemList;
        }
        return reportProblemFeatureCategory.copy(str, str2, list);
    }

    public final String component1() {
        return this.categoryId;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final List<ReportProblemFeatureProblem> component3() {
        return this.problemList;
    }

    public final ReportProblemFeatureCategory copy(String str, String str2, List<ReportProblemFeatureProblem> list) {
        n86.e(str, SuperPassJsonKeys.CATEGORY_ID);
        n86.e(str2, SuperPassJsonKeys.CATEGORY_NAME);
        n86.e(list, "problemList");
        return new ReportProblemFeatureCategory(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportProblemFeatureCategory)) {
            return false;
        }
        ReportProblemFeatureCategory reportProblemFeatureCategory = (ReportProblemFeatureCategory) obj;
        return n86.a(this.categoryId, reportProblemFeatureCategory.categoryId) && n86.a(this.categoryName, reportProblemFeatureCategory.categoryName) && n86.a(this.problemList, reportProblemFeatureCategory.problemList);
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final List<ReportProblemFeatureProblem> getProblemList() {
        return this.problemList;
    }

    public int hashCode() {
        return this.problemList.hashCode() + hj1.r0(this.categoryName, this.categoryId.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ReportProblemFeatureCategory(categoryId=");
        i0.append(this.categoryId);
        i0.append(", categoryName=");
        i0.append(this.categoryName);
        i0.append(", problemList=");
        i0.append(this.problemList);
        i0.append(')');
        return i0.toString();
    }
}
