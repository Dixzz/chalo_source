package app.zophop.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.SPDialogItem;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ScanPayDialogItemView extends RelativeLayout {
    @InjectView(R.id.sp_item_desc)
    public TextView _spDesc;
    @InjectView(R.id.sp_item_header)
    public TextView _spHeader;
    @InjectView(R.id.sp_item_icon)
    public ImageView _spIcon;
    public final LayoutInflater f;
    public final SPDialogItem g;

    public ScanPayDialogItemView(Context context, SPDialogItem sPDialogItem) {
        super(context);
        this.g = sPDialogItem;
        LayoutInflater from = LayoutInflater.from(context);
        this.f = from;
        removeAllViews();
        addView((RelativeLayout) from.inflate(R.layout.sp_detailed_info_item, (ViewGroup) null, false));
        ButterKnife.inject(this);
        this._spIcon.setImageDrawable(getResources().getDrawable(sPDialogItem.getImageDrawable()));
        this._spHeader.setText(sPDialogItem.getHeader());
        this._spDesc.setText(sPDialogItem.getDesc());
    }
}
