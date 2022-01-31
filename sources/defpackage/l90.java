package defpackage;

import app.zophop.R;

/* renamed from: l90  reason: default package */
/* compiled from: ResultTabItem */
public enum l90 {
    RECOMMENDED(R.string.recommended),
    TRAIN(R.string.train),
    BUS(R.string.bus),
    OTHER(R.string.other),
    CAB(R.string.cab),
    FERRY(R.string.ferry),
    CAB_AUTO(R.string.cab_auto),
    ALL_TRANSIT(R.string.all_transit),
    DIRECT_BUSES(R.string.direct_buses),
    CONNECTING(R.string.connecting);
    
    private final int _resId;

    private l90(int i) {
        this._resId = i;
    }

    public int get_resId() {
        return this._resId;
    }
}
