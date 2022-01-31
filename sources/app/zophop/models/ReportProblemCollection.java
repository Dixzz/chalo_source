package app.zophop.models;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import java.util.List;

/* compiled from: ReportProblemCollection.kt */
public final class ReportProblemCollection {
    private List<ReportProblemFeatureCategory> categoryList;
    private final String problemCollectionId;
    private final String title;

    public ReportProblemCollection(String str, String str2, List<ReportProblemFeatureCategory> list) {
        n86.e(str, "problemCollectionId");
        n86.e(str2, ProductPromotionsObject.KEY_TITLE);
        n86.e(list, "categoryList");
        this.problemCollectionId = str;
        this.title = str2;
        this.categoryList = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: app.zophop.models.ReportProblemCollection */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReportProblemCollection copy$default(ReportProblemCollection reportProblemCollection, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reportProblemCollection.problemCollectionId;
        }
        if ((i & 2) != 0) {
            str2 = reportProblemCollection.title;
        }
        if ((i & 4) != 0) {
            list = reportProblemCollection.categoryList;
        }
        return reportProblemCollection.copy(str, str2, list);
    }

    public final String component1() {
        return this.problemCollectionId;
    }

    public final String component2() {
        return this.title;
    }

    public final List<ReportProblemFeatureCategory> component3() {
        return this.categoryList;
    }

    public final ReportProblemCollection copy(String str, String str2, List<ReportProblemFeatureCategory> list) {
        n86.e(str, "problemCollectionId");
        n86.e(str2, ProductPromotionsObject.KEY_TITLE);
        n86.e(list, "categoryList");
        return new ReportProblemCollection(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportProblemCollection)) {
            return false;
        }
        ReportProblemCollection reportProblemCollection = (ReportProblemCollection) obj;
        return n86.a(this.problemCollectionId, reportProblemCollection.problemCollectionId) && n86.a(this.title, reportProblemCollection.title) && n86.a(this.categoryList, reportProblemCollection.categoryList);
    }

    public final List<ReportProblemFeatureCategory> getCategoryList() {
        return this.categoryList;
    }

    public final String getProblemCollectionId() {
        return this.problemCollectionId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.categoryList.hashCode() + hj1.r0(this.title, this.problemCollectionId.hashCode() * 31, 31);
    }

    public final void setCategoryList(List<ReportProblemFeatureCategory> list) {
        n86.e(list, "<set-?>");
        this.categoryList = list;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ReportProblemCollection(problemCollectionId=");
        i0.append(this.problemCollectionId);
        i0.append(", title=");
        i0.append(this.title);
        i0.append(", categoryList=");
        i0.append(this.categoryList);
        i0.append(')');
        return i0.toString();
    }
}
