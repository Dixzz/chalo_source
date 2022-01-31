package com.freshchat.consumer.sdk.ui;

import android.view.View;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;

public class c implements View.OnClickListener {
    public final /* synthetic */ CarouselCardView nP;

    public c(CarouselCardView carouselCardView) {
        this.nP = carouselCardView;
    }

    public void onClick(View view) {
        CarouselCardDefaultFragment hn = this.nP.nO.hn();
        if (this.nP.lR != null && hn != null) {
            this.nP.lR.a(hn);
        }
    }
}
