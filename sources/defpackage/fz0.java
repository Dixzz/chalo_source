package defpackage;

import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.fragments.superPassHistory.SuperPassApplicationBookingSummaryFragment;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Objects;

/* renamed from: fz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fz0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassApplicationBookingSummaryFragment f1190a;

    public /* synthetic */ fz0(SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment) {
        this.f1190a = superPassApplicationBookingSummaryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment = this.f1190a;
        Boolean bool = (Boolean) obj;
        int i = SuperPassApplicationBookingSummaryFragment.i;
        n86.e(superPassApplicationBookingSummaryFragment, "this$0");
        n86.d(bool, "lIsExpanded");
        if (bool.booleanValue()) {
            T t = superPassApplicationBookingSummaryFragment.f;
            n86.c(t);
            ImageView imageView = ((qx) t).d;
            n86.d(imageView, "viewBinding.btnDocumentsExpansion");
            n86.e(imageView, "lView");
            hj1.y0(imageView, "rotation", new float[]{0.0f, 180.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
            T t2 = superPassApplicationBookingSummaryFragment.f;
            n86.c(t2);
            RecyclerView recyclerView = ((qx) t2).t;
            n86.d(recyclerView, "viewBinding.proofDocumentsList");
            n86.e(recyclerView, "lView");
            ViewParent parent = recyclerView.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
            recyclerView.measure(View.MeasureSpec.makeMeasureSpec(((View) parent).getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = recyclerView.getMeasuredHeight();
            recyclerView.getLayoutParams().height = 1;
            recyclerView.setVisibility(0);
            s61 s61 = new s61(recyclerView, measuredHeight);
            s61.setDuration(200);
            recyclerView.startAnimation(s61);
            return;
        }
        T t3 = superPassApplicationBookingSummaryFragment.f;
        n86.c(t3);
        ImageView imageView2 = ((qx) t3).d;
        n86.d(imageView2, "viewBinding.btnDocumentsExpansion");
        n86.e(imageView2, "lView");
        hj1.y0(imageView2, "rotation", new float[]{180.0f, 0.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
        T t4 = superPassApplicationBookingSummaryFragment.f;
        n86.c(t4);
        RecyclerView recyclerView2 = ((qx) t4).t;
        n86.d(recyclerView2, "viewBinding.proofDocumentsList");
        n86.e(recyclerView2, "lView");
        r61 r61 = new r61(recyclerView2, recyclerView2.getMeasuredHeight());
        r61.setDuration(200);
        recyclerView2.startAnimation(r61);
    }
}
