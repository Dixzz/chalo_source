package app.zophop.ui.views;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;
import java.util.Objects;

public class MagicPassInfoView$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, MagicPassInfoView magicPassInfoView, Object obj) {
        ProgressBar progressBar = (ProgressBar) finder.findRequiredView(obj, R.id.pass_profile_pic_progressbar, "field '_progressBar'");
        Objects.requireNonNull(magicPassInfoView);
        ImageView imageView = (ImageView) finder.findRequiredView(obj, R.id.passHolderImage, "field '_passHolder'");
        TextView textView = (TextView) finder.findRequiredView(obj, R.id.expiry_time, "field '_passExpiryView'");
        TextView textView2 = (TextView) finder.findRequiredView(obj, R.id.mpass_history_action_btn_text, "field '_actionBtnText'");
        magicPassInfoView._actionBtn = (FrameLayout) finder.findRequiredView(obj, R.id.mpass_history_action_btn, "field '_actionBtn'");
        TextView textView3 = (TextView) finder.findRequiredView(obj, R.id.pass_type_title, "field '_passTypeView'");
        TextView textView4 = (TextView) finder.findRequiredView(obj, R.id.passActiveStatus, "field '_passActiveStatus'");
        ImageView imageView2 = (ImageView) finder.findRequiredView(obj, R.id.pass_view_settings_menu, "field '_renewPassHook'");
        LinearLayout linearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.route_name_layout, "field '_routeNameLayout'");
        TextView textView5 = (TextView) finder.findRequiredView(obj, R.id.mpass_route_name, "field '_routeName'");
        magicPassInfoView._categoryDetails = (TextView) finder.findRequiredView(obj, R.id.category_details, "field '_categoryDetails'");
        ImageView imageView3 = (ImageView) finder.findRequiredView(obj, R.id.pass_refresh, "field '_passRefresh'");
        magicPassInfoView._passExtensionBanner = (LinearLayout) finder.findRequiredView(obj, R.id.pass_extension_magic_pass_info_view, "field '_passExtensionBanner'");
        LinearLayout linearLayout2 = (LinearLayout) finder.findRequiredView(obj, R.id.pass_details_container, "field '_passLayout'");
        LinearLayout linearLayout3 = (LinearLayout) finder.findRequiredView(obj, R.id.pass_container, "field '_passContainer'");
        TextView textView6 = (TextView) finder.findRequiredView(obj, R.id.trip_details, "field '_tripDetails'");
        TextView textView7 = (TextView) finder.findRequiredView(obj, R.id.route_pass_special_info, "field '_specialInfo'");
    }

    public static void reset(MagicPassInfoView magicPassInfoView) {
        Objects.requireNonNull(magicPassInfoView);
        magicPassInfoView._actionBtn = null;
        magicPassInfoView._categoryDetails = null;
        magicPassInfoView._passExtensionBanner = null;
    }
}
