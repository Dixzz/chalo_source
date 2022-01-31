package app.zophop.ui.views.collapse_on_scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import app.zophop.models.Agency;
import app.zophop.models.mTicketing.PassengerType;
import app.zophop.models.mTicketing.UserProfile;

public class ProfileVerificationStateView extends TextView {
    public ProfileVerificationStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(UserProfile userProfile, Agency agency, String str) {
        if (!PassengerType.ADULT.equals(str)) {
            ui1.v0(userProfile, agency, str, getContext(), this);
        } else {
            setVisibility(8);
        }
    }
}
