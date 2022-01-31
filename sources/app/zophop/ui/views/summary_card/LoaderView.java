package app.zophop.ui.views.summary_card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoaderView extends RelativeLayout {
    @InjectView(R.id.alert_icon)
    public ImageView _alertIcon;
    @InjectView(R.id.connection_error_layout)
    public LinearLayout _connection_error_layout;
    @InjectView(R.id.loading_spinner)
    public View _loadingSpinner;
    @InjectView(R.id.retry)
    public View _retry;

    public LoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.loader_view, (ViewGroup) this, true);
        ButterKnife.inject(this);
        this._loadingSpinner.setVisibility(8);
    }

    public void a() {
        setVisibility(0);
        this._loadingSpinner.setVisibility(8);
        this._connection_error_layout.setVisibility(0);
    }

    public void b(int i, String str) {
        setVisibility(0);
        this._loadingSpinner.setVisibility(8);
        this._connection_error_layout.setVisibility(0);
        if (i != 0) {
            this._alertIcon.setImageResource(i);
        }
        findViewById(R.id.connection_error_textview).setVisibility(8);
        ((TextView) findViewById(R.id.empty_view_text)).setText(str);
    }

    public void c(boolean z) {
        if (z) {
            this._retry.setVisibility(8);
        } else {
            this._retry.setVisibility(0);
        }
    }

    public void d() {
        setVisibility(0);
        this._connection_error_layout.setVisibility(8);
        this._loadingSpinner.setVisibility(0);
    }

    public void setRetryHandler(View.OnClickListener onClickListener) {
        this._retry.setOnClickListener(onClickListener);
    }
}
