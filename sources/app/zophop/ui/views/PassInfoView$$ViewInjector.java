package app.zophop.ui.views;

import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;
import java.util.Objects;

public class PassInfoView$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, PassInfoView passInfoView, Object obj) {
        TextView textView = (TextView) finder.findRequiredView(obj, R.id.booking_time, "field '_bookingTimeTextView'");
        Objects.requireNonNull(passInfoView);
        TextView textView2 = (TextView) finder.findRequiredView(obj, R.id.agency_name, "field '_agencyNameTextView'");
        TextView textView3 = (TextView) finder.findRequiredView(obj, R.id.pass_footer, "field '_passFooter'");
        TextView textView4 = (TextView) finder.findRequiredView(obj, R.id.from_to, "field '_passFromTo'");
        ImageView imageView = (ImageView) finder.findRequiredView(obj, R.id.current_pass_status, "field '_passStatus'");
        TextView textView5 = (TextView) finder.findRequiredView(obj, R.id.expiry_time, "field '_expiryTextView'");
        TextView textView6 = (TextView) finder.findRequiredView(obj, R.id.pass_type, "field '_passTypeView'");
    }

    public static void reset(PassInfoView passInfoView) {
        Objects.requireNonNull(passInfoView);
    }
}
