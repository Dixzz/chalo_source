package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.autoCabBooking.BookingDetails;
import java.util.List;

/* renamed from: ui0  reason: default package */
/* compiled from: CabHistoryAdapter */
public class ui0 extends BaseAdapter {
    public final Context f;
    public List<BookingDetails> g;

    public ui0(Context context, List<BookingDetails> list) {
        this.f = context;
        this.g = list;
    }

    public int getCount() {
        return this.g.size();
    }

    public Object getItem(int i) {
        return this.g.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.cab_history_item, viewGroup, false);
        BookingDetails bookingDetails = this.g.get(i);
        TextView textView = (TextView) inflate.findViewById(R.id.to_location);
        TextView textView2 = (TextView) inflate.findViewById(R.id.status);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cab_icon);
        TextView textView3 = (TextView) inflate.findViewById(R.id.time);
        ((TextView) inflate.findViewById(R.id.from_location)).setText(bookingDetails.getFromLocation().c);
        if (bookingDetails.getToLocation() != null) {
            textView.setVisibility(0);
            textView.setText(bookingDetails.getToLocation().c);
        } else {
            textView.setVisibility(8);
        }
        if (t00.d(bookingDetails.getCode())) {
            textView2.setVisibility(0);
            textView2.setText(this.f.getString(R.string.in_progress));
            textView3.setVisibility(8);
        } else {
            textView2.setVisibility(8);
            textView3.setVisibility(0);
            textView3.setText(String.format(this.f.getString(R.string.cab_ended_at_time), jh1.m(bookingDetails.getLastUpdatedTime())));
        }
        imageView.setImageResource(bookingDetails.getProvider().equalsIgnoreCase("Uber") ? R.drawable.ic_uber_history : R.drawable.ic_ola);
        return inflate;
    }
}
