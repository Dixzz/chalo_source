package com.freshchat.consumer.sdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.i;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.m;
import com.freshchat.consumer.sdk.ui.NonScrollableGridView;
import com.freshchat.consumer.sdk.ui.f;
import java.util.List;

public class l extends RecyclerView.e<RecyclerView.a0> implements f {
    private final List<b> oC;
    private final int oD = R.layout.freshchat_calendar_day_header;
    private int oE;
    private final i.a ox;

    public static class a extends b {
        public static final Parcelable.Creator<a> CREATOR = new n();
        private final String oF;

        private a(Parcel parcel) {
            super(parcel);
            this.oF = parcel.readString();
        }

        public a(String str) {
            super(0);
            this.oF = str;
        }

        public int describeContents() {
            return 0;
        }

        public String hw() {
            return this.oF;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.b(parcel);
            parcel.writeString(this.oF);
        }
    }

    public static abstract class b implements Parcelable {
        private final int oG;

        public b(int i) {
            this.oG = i;
        }

        public b(Parcel parcel) {
            this.oG = parcel.readInt();
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.oG);
        }

        public int hx() {
            return this.oG;
        }
    }

    public static class c extends b {
        public static final Parcelable.Creator<c> CREATOR = new o();
        private final CalendarDay.PartOfDay oH;
        private final List<CalendarDay.TimeSlot> oI;

        private c(Parcel parcel) {
            super(parcel);
            this.oH = CalendarDay.PartOfDay.values()[parcel.readInt()];
            this.oI = parcel.createTypedArrayList(CalendarDay.TimeSlot.CREATOR);
        }

        public c(CalendarDay.PartOfDay partOfDay, List<CalendarDay.TimeSlot> list) {
            super(1);
            this.oH = partOfDay;
            this.oI = list;
        }

        public int describeContents() {
            return 0;
        }

        public CalendarDay.PartOfDay hy() {
            return this.oH;
        }

        public List<CalendarDay.TimeSlot> hz() {
            return this.oI;
        }

        public void writeToParcel(Parcel parcel, int i) {
            b(parcel);
            parcel.writeInt(this.oH.ordinal());
            parcel.writeTypedList(this.oI);
        }
    }

    public class d extends RecyclerView.a0 {
        private final TextView oJ;

        private d(View view) {
            super(view);
            this.oJ = (TextView) view;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(m mVar) {
            this.oJ.setText(mVar.ib());
        }
    }

    public class e extends RecyclerView.a0 {
        private final NonScrollableGridView oL;
        private final TextView oM;

        private e(View view) {
            super(view);
            this.oM = (TextView) view.findViewById(R.id.freshchat_calendar_part_of_day_header);
            this.oL = (NonScrollableGridView) view.findViewById(R.id.freshchat_calendar_timeslots_grid_view);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(m mVar) {
            this.oM.setText(mVar.ic());
            this.oL.setNumColumns(l.this.oE);
            this.oL.setAdapter((ListAdapter) new i(mVar.id(), l.this.ox));
        }
    }

    public l(List<b> list, i.a aVar) {
        this.ox = aVar;
        this.oC = list;
    }

    private b L(int i) {
        if (k.isEmpty(this.oC)) {
            return null;
        }
        return this.oC.get(i);
    }

    public void K(int i) {
        this.oE = i;
    }

    @Override // com.freshchat.consumer.sdk.ui.f
    public int M(int i) {
        while (i > 0) {
            if (O(i)) {
                return i;
            }
            i--;
        }
        return 0;
    }

    @Override // com.freshchat.consumer.sdk.ui.f
    public int N(int i) {
        return this.oD;
    }

    @Override // com.freshchat.consumer.sdk.ui.f
    public boolean O(int i) {
        b bVar = this.oC.get(i);
        return bVar != null && bVar.hx() == 0;
    }

    @Override // com.freshchat.consumer.sdk.ui.f
    public void c(View view, int i) {
        b L = L(i);
        if (L != null) {
            m mVar = new m(view.getContext());
            mVar.a(L);
            ((TextView) view).setText(mVar.ib());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return k.b(this.oC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemViewType(int i) {
        b bVar = this.oC.get(i);
        if (bVar != null) {
            return bVar.hx();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        try {
            b L = L(i);
            if (L != null) {
                m mVar = new m(a0Var.itemView.getContext());
                mVar.a(L);
                if (a0Var instanceof d) {
                    ((d) a0Var).a(mVar);
                } else if (a0Var instanceof e) {
                    ((e) a0Var).a(mVar);
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(this.oD, viewGroup, false)) : new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_calendar_part_of_day_item, viewGroup, false));
    }
}
