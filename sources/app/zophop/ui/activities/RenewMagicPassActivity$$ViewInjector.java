package app.zophop.ui.activities;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import app.zophop.R;
import butterknife.ButterKnife;

public class RenewMagicPassActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, RenewMagicPassActivity renewMagicPassActivity, Object obj) {
        renewMagicPassActivity._renewContainer = (LinearLayout) finder.findRequiredView(obj, R.id.renew_pass_container, "field '_renewContainer'");
        renewMagicPassActivity._renewProceed = (Button) finder.findRequiredView(obj, R.id.renew_proceed, "field '_renewProceed'");
        renewMagicPassActivity._singleLogo = (ImageView) finder.findRequiredView(obj, R.id.single_logo, "field '_singleLogo'");
        renewMagicPassActivity._dualLogo = (RelativeLayout) finder.findRequiredView(obj, R.id.dual_logo, "field '_dualLogo'");
    }

    public static void reset(RenewMagicPassActivity renewMagicPassActivity) {
        renewMagicPassActivity._renewContainer = null;
        renewMagicPassActivity._renewProceed = null;
        renewMagicPassActivity._singleLogo = null;
        renewMagicPassActivity._dualLogo = null;
    }
}
