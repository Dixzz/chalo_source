package app.zophop.ui.views;

import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;

public class ScanPayDialogItemView$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ScanPayDialogItemView scanPayDialogItemView, Object obj) {
        scanPayDialogItemView._spIcon = (ImageView) finder.findRequiredView(obj, R.id.sp_item_icon, "field '_spIcon'");
        scanPayDialogItemView._spHeader = (TextView) finder.findRequiredView(obj, R.id.sp_item_header, "field '_spHeader'");
        scanPayDialogItemView._spDesc = (TextView) finder.findRequiredView(obj, R.id.sp_item_desc, "field '_spDesc'");
    }

    public static void reset(ScanPayDialogItemView scanPayDialogItemView) {
        scanPayDialogItemView._spIcon = null;
        scanPayDialogItemView._spHeader = null;
        scanPayDialogItemView._spDesc = null;
    }
}
