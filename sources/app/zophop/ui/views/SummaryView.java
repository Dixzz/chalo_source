package app.zophop.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.flexbox.FlexboxLayout;
import defpackage.ii1;

public class SummaryView extends LinearLayout {
    @InjectView(R.id.book_button)
    public TextView _bookButton;
    @InjectView(R.id.number_of_changes)
    public TextView _changes;
    @InjectView(R.id.cheapest)
    public TextView _cheapestView;
    @InjectView(R.id.duration)
    public TextView _durationText;
    @InjectView(R.id.eta_stopbased_tripplanner_results_single_leg)
    public TextView _etaStopBasedTripPlannerResultsSingleLeg;
    @InjectView(R.id.fare_duration_tags_layout)
    public LinearLayout _fareDurationTagsLayout;
    @InjectView(R.id.fare_range)
    public TextView _fareText;
    @InjectView(R.id.fastest)
    public TextView _fastestView;
    @InjectView(R.id.from)
    public TextView _fromView;
    @InjectView(R.id.mode_info_container)
    public View _modeInfoContainer;
    @InjectView(R.id.mode_sequence_container)
    public FlexboxLayout _modeSequenceContainer;
    @InjectView(R.id.mode_sequence)
    public TextView _modeSequenceText;
    @InjectView(R.id.more_details_text_view)
    public TextView _moreDetailsView;
    @InjectView(R.id.summary_real_time)
    public TextView _realTime;
    @InjectView(R.id.seat_occupancy_icon_tripplanner_results)
    public ImageView _seatOccupancyIcon;
    @InjectView(R.id.seat_occupancy_icon_stopbased_tripplanner_results_single_leg)
    public ImageView _seatOccupancyIconStopBasedTripPlannerResultsSingleLeg;
    @InjectView(R.id.via)
    public TextView _via;
    public a f;

    public interface a {
        void a(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ii1.a aVar, int i);

        void b();

        void c(FlexboxLayout flexboxLayout);

        void d(TextView textView);

        void e(TextView textView);

        void f(TextView textView);

        View.OnClickListener g();

        void h(TextView textView, ii1.a aVar, int i);

        void i(TextView textView, View view);

        void j(TextView textView);

        void k(TextView textView);

        void l(LinearLayout linearLayout);

        void m(TextView textView);

        void n(TextView textView);

        boolean o();

        void p(TextView textView);
    }

    public SummaryView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.trip_summary_view, (ViewGroup) this, true);
        ButterKnife.inject(this, this);
    }

    public void a(a aVar) {
        this.f = aVar;
        aVar.m(this._durationText);
        aVar.k(this._fareText);
        aVar.a(this._fromView, this._etaStopBasedTripPlannerResultsSingleLeg, this._seatOccupancyIcon, this._seatOccupancyIconStopBasedTripPlannerResultsSingleLeg, null, -1);
        aVar.h(this._modeSequenceText, null, -1);
        aVar.c(this._modeSequenceContainer);
        aVar.n(this._via);
        setOnClickListener(aVar.g());
        aVar.e(this._realTime);
        aVar.f(this._changes);
        aVar.i(this._bookButton, this._modeInfoContainer);
        aVar.j(this._moreDetailsView);
        aVar.p(this._cheapestView);
        aVar.d(this._fastestView);
        aVar.l(this._fareDurationTagsLayout);
    }

    public a getTripSummaryRenderer() {
        return this.f;
    }
}
