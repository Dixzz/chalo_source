package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import app.zophop.R;
import app.zophop.models.SPDialogItem;
import app.zophop.ui.views.ScanPayDialogItemView;

/* renamed from: jn0  reason: default package */
/* compiled from: ScanPayGuidelinesDialog */
public class jn0 extends ue {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sp_info_dialog, viewGroup, false);
        SPDialogItem sPDialogItem = new SPDialogItem(R.drawable.steps_scan, getResources().getString(R.string.step_1_header), getResources().getString(R.string.step_1_desc));
        SPDialogItem sPDialogItem2 = new SPDialogItem(R.drawable.steps_amount, getResources().getString(R.string.step_2_header), getResources().getString(R.string.step_2_desc));
        SPDialogItem sPDialogItem3 = new SPDialogItem(R.drawable.steps_pay, getResources().getString(R.string.step_3_header), getResources().getString(R.string.step_3_desc));
        SPDialogItem sPDialogItem4 = new SPDialogItem(R.drawable.steps_show, getResources().getString(R.string.step_4_header), getResources().getString(R.string.step_4_desc));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sp_details);
        ScanPayDialogItemView scanPayDialogItemView = new ScanPayDialogItemView(c(), sPDialogItem);
        ScanPayDialogItemView scanPayDialogItemView2 = new ScanPayDialogItemView(c(), sPDialogItem2);
        ScanPayDialogItemView scanPayDialogItemView3 = new ScanPayDialogItemView(c(), sPDialogItem3);
        ScanPayDialogItemView scanPayDialogItemView4 = new ScanPayDialogItemView(c(), sPDialogItem4);
        linearLayout.addView(scanPayDialogItemView);
        linearLayout.addView(scanPayDialogItemView2);
        linearLayout.addView(scanPayDialogItemView3);
        linearLayout.addView(scanPayDialogItemView4);
        inflate.findViewById(R.id.sp_btn).setOnClickListener(new in0(this));
        return inflate;
    }
}
