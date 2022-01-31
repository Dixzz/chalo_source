package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CardRechargeFareInfo.kt */
public final class CardRechargeFareInfo implements Parcelable {
    public static final Parcelable.Creator<CardRechargeFareInfo> CREATOR = new Creator();
    private final long minAmount;
    private final long multiplesAllowed;
    private final List<Long> suggestedAmounts;

    /* compiled from: CardRechargeFareInfo.kt */
    public static final class Creator implements Parcelable.Creator<CardRechargeFareInfo> {
        @Override // android.os.Parcelable.Creator
        public final CardRechargeFareInfo createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            return new CardRechargeFareInfo(readLong, readLong2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final CardRechargeFareInfo[] newArray(int i) {
            return new CardRechargeFareInfo[i];
        }
    }

    public CardRechargeFareInfo(long j, long j2, List<Long> list) {
        n86.e(list, "suggestedAmounts");
        this.minAmount = j;
        this.multiplesAllowed = j2;
        this.suggestedAmounts = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: app.zophop.models.mTicketing.CardRechargeFareInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardRechargeFareInfo copy$default(CardRechargeFareInfo cardRechargeFareInfo, long j, long j2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cardRechargeFareInfo.minAmount;
        }
        if ((i & 2) != 0) {
            j2 = cardRechargeFareInfo.multiplesAllowed;
        }
        if ((i & 4) != 0) {
            list = cardRechargeFareInfo.suggestedAmounts;
        }
        return cardRechargeFareInfo.copy(j, j2, list);
    }

    public final long component1() {
        return this.minAmount;
    }

    public final long component2() {
        return this.multiplesAllowed;
    }

    public final List<Long> component3() {
        return this.suggestedAmounts;
    }

    public final CardRechargeFareInfo copy(long j, long j2, List<Long> list) {
        n86.e(list, "suggestedAmounts");
        return new CardRechargeFareInfo(j, j2, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardRechargeFareInfo)) {
            return false;
        }
        CardRechargeFareInfo cardRechargeFareInfo = (CardRechargeFareInfo) obj;
        return this.minAmount == cardRechargeFareInfo.minAmount && this.multiplesAllowed == cardRechargeFareInfo.multiplesAllowed && n86.a(this.suggestedAmounts, cardRechargeFareInfo.suggestedAmounts);
    }

    public final long getMinAmount() {
        return this.minAmount;
    }

    public final long getMultiplesAllowed() {
        return this.multiplesAllowed;
    }

    public final List<Long> getSuggestedAmounts() {
        return this.suggestedAmounts;
    }

    public int hashCode() {
        return this.suggestedAmounts.hashCode() + (((d.a(this.minAmount) * 31) + d.a(this.multiplesAllowed)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardRechargeFareInfo(minAmount=");
        i0.append(this.minAmount);
        i0.append(", multiplesAllowed=");
        i0.append(this.multiplesAllowed);
        i0.append(", suggestedAmounts=");
        i0.append(this.suggestedAmounts);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeLong(this.minAmount);
        parcel.writeLong(this.multiplesAllowed);
        List<Long> list = this.suggestedAmounts;
        parcel.writeInt(list.size());
        for (Long l : list) {
            parcel.writeLong(l.longValue());
        }
    }
}
