package app.zophop.pubsub.eventbus.events;

import android.content.Intent;

public class ResultActivityToFragment {
    private final Intent _intent;
    private final int _requestCode;
    private final int _resultCode;

    public ResultActivityToFragment(int i, int i2, Intent intent) {
        this._requestCode = i;
        this._resultCode = i2;
        this._intent = intent;
    }

    public Intent getIntent() {
        return this._intent;
    }

    public int getRequestCode() {
        return this._requestCode;
    }

    public int getResultCode() {
        return this._resultCode;
    }
}
