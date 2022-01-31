package app.zophop.ui.fragments;

import android.view.View;
import android.widget.LinearLayout;
import app.zophop.R;
import app.zophop.ui.views.summary_card.LoaderView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;

public class ResultFragment$$ViewInjector {

    /* compiled from: ResultFragment$$ViewInjector */
    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ResultFragment f;

        public a(ResultFragment resultFragment) {
            this.f = resultFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            ResultFragment resultFragment = this.f;
            tn0.b(resultFragment.getFragmentManager(), resultFragment.getArguments().getString("extra:request"), resultFragment.getClass().getSimpleName());
        }
    }

    public static void inject(ButterKnife.Finder finder, ResultFragment resultFragment, Object obj) {
        resultFragment._resultContainer = finder.findRequiredView(obj, R.id.result_container, "field '_resultContainer'");
        resultFragment._results = (LinearLayout) finder.findRequiredView(obj, R.id.results, "field '_results'");
        resultFragment._loader = (LoaderView) finder.findRequiredView(obj, R.id.loader, "field '_loader'");
        finder.findRequiredView(obj, R.id.report_hook, "method 'onReportViewClicked'").setOnClickListener(new a(resultFragment));
    }

    public static void reset(ResultFragment resultFragment) {
        resultFragment._resultContainer = null;
        resultFragment._results = null;
        resultFragment._loader = null;
    }
}
