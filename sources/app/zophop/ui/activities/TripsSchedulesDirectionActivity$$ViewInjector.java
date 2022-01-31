package app.zophop.ui.activities;

import app.zophop.R;
import app.zophop.ui.SkeletonLoader;
import butterknife.ButterKnife;

public class TripsSchedulesDirectionActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity, Object obj) {
        tripsSchedulesDirectionActivity._skeletonLoader = (SkeletonLoader) finder.findRequiredView(obj, R.id.skeleton_loader, "field '_skeletonLoader'");
    }

    public static void reset(TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity) {
        tripsSchedulesDirectionActivity._skeletonLoader = null;
    }
}
