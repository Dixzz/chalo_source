package com.razorpay;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashMap;

public class AppSelectorFragment extends Fragment {
    private View.OnClickListener appListElementOnClickListener = new Q_$2$(this);
    public HashMap<String, ApplicationDetails> filteredUpiPackageToAppDetails;
    public ArrayList<String> finalOthersApps;
    public OnAppSelectedListener onAppSelectedListener;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new D$_X_(this);
    public ArrayList<String> otherAppsOrder;
    public ArrayList<String> preferredAppsOrder;
    public ArrayList<String> remainingApps;
    public View rootView;
    public String urlData;

    private ArrayList<ApplicationDetails> getAppDetailsListFromPackageName(ArrayList<String> arrayList) {
        int size = arrayList.size();
        ArrayList<ApplicationDetails> arrayList2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ApplicationDetails applicationDetails = this.filteredUpiPackageToAppDetails.get(arrayList.get(i));
            if (applicationDetails != null) {
                String appName = applicationDetails.getAppName();
                String iconBase64 = applicationDetails.getIconBase64();
                if (!(appName == null || iconBase64 == null)) {
                    arrayList2.add(applicationDetails);
                }
            }
        }
        return arrayList2;
    }

    private View handleNoAppsInListCase() {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.upi_intent_no_apps_found, (ViewGroup) null);
        ((Button) inflate.findViewById(R.id.btn_go_back)).setOnClickListener(new E$_j$(this));
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.onAppSelectedListener = (OnAppSelectedListener) getActivity();
        } catch (Exception unused) {
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.urlData = arguments.getString("url_data");
            this.preferredAppsOrder = arguments.getStringArrayList("merchant_preferred_upi_apps_order");
            this.otherAppsOrder = arguments.getStringArrayList("merchant_other_upi_apps_order");
            this.remainingApps = arguments.getStringArrayList("list_remaining_apps");
            this.filteredUpiPackageToAppDetails = (HashMap) arguments.getSerializable("upi_package_to_app_details");
        }
        if (this.preferredAppsOrder == null) {
            this.preferredAppsOrder = new ArrayList<>();
        }
        if (this.otherAppsOrder == null) {
            this.otherAppsOrder = new ArrayList<>();
        }
        if (this.remainingApps == null) {
            this.remainingApps = new ArrayList<>();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.AppSelectorFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void setAppSelectListener(OnAppSelectedListener onAppSelectedListener2) {
        this.onAppSelectedListener = onAppSelectedListener2;
    }
}
