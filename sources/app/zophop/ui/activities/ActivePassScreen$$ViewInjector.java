package app.zophop.ui.activities;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.LockingScrollView;
import app.zophop.R;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

public class ActivePassScreen$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ActivePassScreen activePassScreen, Object obj) {
        activePassScreen._profilePicView = (ImageView) finder.findRequiredView(obj, R.id.profile_pic, "field '_profilePicView'");
        activePassScreen._profileNameView = (TextView) finder.findRequiredView(obj, R.id.profile_name, "field '_profileNameView'");
        activePassScreen._profileDetailsView = (TextView) finder.findRequiredView(obj, R.id.gender, "field '_profileDetailsView'");
        activePassScreen._profilePictureLoader = (ProgressBar) finder.findRequiredView(obj, R.id.pass_profile_pic_progressbar, "field '_profilePictureLoader'");
        activePassScreen._dobView = (TextView) finder.findRequiredView(obj, R.id.dob, "field '_dobView'");
        GifImageView gifImageView = (GifImageView) finder.findRequiredView(obj, R.id.animation, "field '_animationImageView'");
        LinearLayout linearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.visible_content, "field '_visibleContent'");
        finder.findRequiredView(obj, R.id.margin_placeholder, "field '_marginPlaceholder'");
        activePassScreen._routeContainer = (LinearLayout) finder.findRequiredView(obj, R.id.route_container, "field '_routeContainer'");
        activePassScreen._qrCodeImageView = (ImageView) finder.findRequiredView(obj, R.id.pass_qr_code, "field '_qrCodeImageView'");
        LockingScrollView lockingScrollView = (LockingScrollView) finder.findRequiredView(obj, R.id.main_layout, "field '_mainLayout'");
        activePassScreen._brandingView = (TextView) finder.findRequiredView(obj, R.id.agency_text_id, "field '_brandingView'");
        activePassScreen._tapText = (TextView) finder.findRequiredView(obj, R.id.tap_qr_code, "field '_tapText'");
        activePassScreen._dualLogo = (RelativeLayout) finder.findRequiredView(obj, R.id.dual_logo, "field '_dualLogo'");
        activePassScreen._bottomLayout = (ImageView) finder.findRequiredView(obj, R.id.bottom_layout, "field '_bottomLayout'");
        activePassScreen._passExtensionBanner = (LinearLayout) finder.findRequiredView(obj, R.id.pass_extension_active_pass_screen, "field '_passExtensionBanner'");
    }

    public static void reset(ActivePassScreen activePassScreen) {
        activePassScreen._profilePicView = null;
        activePassScreen._profileNameView = null;
        activePassScreen._profileDetailsView = null;
        activePassScreen._profilePictureLoader = null;
        activePassScreen._dobView = null;
        activePassScreen._routeContainer = null;
        activePassScreen._qrCodeImageView = null;
        activePassScreen._brandingView = null;
        activePassScreen._tapText = null;
        activePassScreen._dualLogo = null;
        activePassScreen._bottomLayout = null;
        activePassScreen._passExtensionBanner = null;
    }
}
