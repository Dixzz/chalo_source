package app.zophop.ui.fragments;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.ui.activities.TripPlanningActivity;
import app.zophop.ui.views.summary_card.LoaderView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import java.util.Objects;

public class SchedulerInputFormFragment$$ViewInjector {

    /* compiled from: SchedulerInputFormFragment$$ViewInjector */
    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SchedulerInputFormFragment f;

        public a(SchedulerInputFormFragment schedulerInputFormFragment) {
            this.f = schedulerInputFormFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f.h(1);
        }
    }

    /* compiled from: SchedulerInputFormFragment$$ViewInjector */
    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SchedulerInputFormFragment f;

        public b(SchedulerInputFormFragment schedulerInputFormFragment) {
            this.f = schedulerInputFormFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f.h(2);
        }
    }

    /* compiled from: SchedulerInputFormFragment$$ViewInjector */
    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ SchedulerInputFormFragment f;

        public c(SchedulerInputFormFragment schedulerInputFormFragment) {
            this.f = schedulerInputFormFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            SchedulerInputFormFragment schedulerInputFormFragment = this.f;
            Objects.requireNonNull(schedulerInputFormFragment);
            new nn0().show(schedulerInputFormFragment.getFragmentManager(), "timePicker");
        }
    }

    /* compiled from: SchedulerInputFormFragment$$ViewInjector */
    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ SchedulerInputFormFragment f;

        public d(SchedulerInputFormFragment schedulerInputFormFragment) {
            this.f = schedulerInputFormFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            TripPlanningActivity.m0(this.f.getActivity(), null, null, false);
            ed1 ed1 = new ed1("best route opened", Long.MIN_VALUE);
            hj1.K0(ed1, "source", "scheduler screen", ed1);
        }
    }

    public static void inject(ButterKnife.Finder finder, SchedulerInputFormFragment schedulerInputFormFragment, Object obj) {
        View findRequiredView = finder.findRequiredView(obj, R.id.input_from, "field '_inputFrom' and method 'onFromClick'");
        schedulerInputFormFragment._inputFrom = findRequiredView;
        findRequiredView.setOnClickListener(new a(schedulerInputFormFragment));
        View findRequiredView2 = finder.findRequiredView(obj, R.id.input_to, "field '_inputTo' and method 'onToClick'");
        schedulerInputFormFragment._inputTo = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(schedulerInputFormFragment));
        View findRequiredView3 = finder.findRequiredView(obj, R.id.scheduler_time, "field '_timeView' and method 'onTimeClick'");
        schedulerInputFormFragment._timeView = (TextView) findRequiredView3;
        findRequiredView3.setOnClickListener(new c(schedulerInputFormFragment));
        schedulerInputFormFragment._resultContainer = (LinearLayout) finder.findRequiredView(obj, R.id.result_container, "field '_resultContainer'");
        schedulerInputFormFragment._loader = (LoaderView) finder.findRequiredView(obj, R.id.loader, "field '_loader'");
        schedulerInputFormFragment._form = finder.findRequiredView(obj, R.id.form, "field '_form'");
        schedulerInputFormFragment._favouriteList = (LinearLayout) finder.findRequiredView(obj, R.id.favorite_list, "field '_favouriteList'");
        schedulerInputFormFragment._favouriteContainer = finder.findRequiredView(obj, R.id.favorite_container, "field '_favouriteContainer'");
        schedulerInputFormFragment._favheader = finder.findRequiredView(obj, R.id.favorite_header, "field '_favheader'");
        schedulerInputFormFragment._busHook = finder.findRequiredView(obj, R.id.bus_hook, "field '_busHook'");
        schedulerInputFormFragment._results = finder.findRequiredView(obj, R.id.results, "field '_results'");
        schedulerInputFormFragment._highlightTripPlanner = finder.findRequiredView(obj, R.id.highlight_trip_planner, "field '_highlightTripPlanner'");
        schedulerInputFormFragment._cardTutView = finder.findRequiredView(obj, R.id.card_tutorial, "field '_cardTutView'");
        schedulerInputFormFragment._recentListContainer = (LinearLayout) finder.findRequiredView(obj, R.id.recent_list_container, "field '_recentListContainer'");
        schedulerInputFormFragment._recentListCard = (CardView) finder.findRequiredView(obj, R.id.recent_list_card, "field '_recentListCard'");
        schedulerInputFormFragment._agencyListContainer = (LinearLayout) finder.findRequiredView(obj, R.id.agency_list_container, "field '_agencyListContainer'");
        schedulerInputFormFragment._schedulerCardContainer = finder.findRequiredView(obj, R.id.scheduler_cards, "field '_schedulerCardContainer'");
        finder.findRequiredView(obj, R.id.trip_planner, "method 'openTripPlanner'").setOnClickListener(new d(schedulerInputFormFragment));
    }

    public static void reset(SchedulerInputFormFragment schedulerInputFormFragment) {
        schedulerInputFormFragment._inputFrom = null;
        schedulerInputFormFragment._inputTo = null;
        schedulerInputFormFragment._timeView = null;
        schedulerInputFormFragment._resultContainer = null;
        schedulerInputFormFragment._loader = null;
        schedulerInputFormFragment._form = null;
        schedulerInputFormFragment._favouriteList = null;
        schedulerInputFormFragment._favouriteContainer = null;
        schedulerInputFormFragment._favheader = null;
        schedulerInputFormFragment._busHook = null;
        schedulerInputFormFragment._results = null;
        schedulerInputFormFragment._highlightTripPlanner = null;
        schedulerInputFormFragment._cardTutView = null;
        schedulerInputFormFragment._recentListContainer = null;
        schedulerInputFormFragment._recentListCard = null;
        schedulerInputFormFragment._agencyListContainer = null;
        schedulerInputFormFragment._schedulerCardContainer = null;
    }
}
