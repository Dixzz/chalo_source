package app.zophop.ui.dialogs;

import android.view.View;
import app.zophop.R;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;

public class CommuteSummaryFragment$$ViewInjector {

    /* compiled from: CommuteSummaryFragment$$ViewInjector */
    public class a extends DebouncingOnClickListener {
        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            throw null;
        }
    }

    public static void inject(ButterKnife.Finder finder, CommuteSummaryFragment commuteSummaryFragment, Object obj) {
        finder.findRequiredView(obj, R.id.later, "method 'onLaterClicked'").setOnClickListener(new a());
    }

    public static void reset(CommuteSummaryFragment commuteSummaryFragment) {
    }
}
