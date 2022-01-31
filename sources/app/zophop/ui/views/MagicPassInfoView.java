package app.zophop.ui.views;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.products.ProductSelectionActivity;
import butterknife.InjectView;
import java.util.Objects;

public class MagicPassInfoView extends RelativeLayout {
    public static final /* synthetic */ int h = 0;
    @InjectView(R.id.mpass_history_action_btn)
    public FrameLayout _actionBtn;
    @InjectView(R.id.category_details)
    public TextView _categoryDetails;
    @InjectView(R.id.pass_extension_magic_pass_info_view)
    public LinearLayout _passExtensionBanner;
    public RideDetails f;
    public ci1<BookingItem> g;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MagicPassInfoView magicPassInfoView = MagicPassInfoView.this;
            int i = MagicPassInfoView.h;
            Objects.requireNonNull(magicPassInfoView);
            Objects.requireNonNull(MagicPassInfoView.this);
            new Intent((Context) null, ProductSelectionActivity.class).putExtra("src", "profile rejected card");
            Objects.requireNonNull(MagicPassInfoView.this);
            throw null;
        }
    }

    public enum b {
        NO_RECLAIM,
        APP_RECLAIM,
        BACKEND_RECLIAM
    }

    private String getActionBtnText() {
        throw null;
    }

    private boolean getPassExpiryStatus() {
        System.currentTimeMillis();
        return false;
    }

    private String getReclaimType() {
        b.NO_RECLAIM.name();
        throw null;
    }

    private void setPaymentDeadlineUpcomingAlert(long j) {
        String str;
        String valueOf = String.valueOf((((j / 1000) / 60) / 60) / 24);
        if (valueOf.equalsIgnoreCase("0")) {
            str = getResources().getString(R.string.proof_validation_expiry_last_day);
        } else if (valueOf.equalsIgnoreCase("1")) {
            str = String.format(getResources().getString(R.string.proof_validation_expiry_day), valueOf);
        } else {
            str = String.format(getResources().getString(R.string.proof_validation_expiry_days), valueOf);
        }
        this._passExtensionBanner.setVisibility(0);
        ((TextView) this._passExtensionBanner.findViewById(R.id.pass_extension_textview)).setText(str);
    }

    private void setupActionButtonClickListener(String str) {
        if (str == null) {
            this._actionBtn.setVisibility(8);
        } else if (str.equalsIgnoreCase("Activate") || str.equalsIgnoreCase("View Pass") || str.equalsIgnoreCase("Make Payment") || str.equals("View Summary")) {
            ci1<BookingItem> ci1 = this.g;
            this._actionBtn.setVisibility(8);
        } else if (str.equalsIgnoreCase("Reapply")) {
            this._actionBtn.setOnClickListener(new a());
        } else if (str.equalsIgnoreCase("Renew")) {
            this._actionBtn.setVisibility(8);
        }
    }

    private void setupCategoryView(boolean z) {
        throw null;
    }

    public void setActionBtnClickListener(ci1<BookingItem> ci1) {
        this.g = ci1;
    }

    public void setRideDetails(RideDetails rideDetails) {
        this.f = rideDetails;
    }
}
