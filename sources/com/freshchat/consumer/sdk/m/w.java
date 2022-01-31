package com.freshchat.consumer.sdk.m;

import android.view.View;
import androidx.fragment.app.FragmentManager;

public class w implements View.OnClickListener {
    public final /* synthetic */ t pp;

    public w(t tVar) {
        this.pp = tVar;
    }

    public void onClick(View view) {
        FragmentManager fragmentManager = this.pp.getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.A(new FragmentManager.m(null, -1, 0), false);
        }
    }
}
