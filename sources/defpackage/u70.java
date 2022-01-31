package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.products.ProductSelectionActivity;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: u70  reason: default package */
/* compiled from: ProductSelectionActivity */
public class u70 implements Comparator<BookingItem>, j$.util.Comparator {
    public u70(ProductSelectionActivity productSelectionActivity) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(BookingItem bookingItem, BookingItem bookingItem2) {
        long j;
        long j2;
        BookingItem bookingItem3 = bookingItem;
        BookingItem bookingItem4 = bookingItem2;
        if (bookingItem3 == null || bookingItem4 == null) {
            return 0;
        }
        BookingItemType bookingItemType = bookingItem3.getBookingItemType();
        BookingItemType bookingItemType2 = BookingItemType.MAGIC_PASS;
        if (bookingItemType.equals(bookingItemType2)) {
            j = bookingItem3.getMagicPass().getBookingTime();
        } else {
            j = bookingItem3.getBookingItemType().equals(BookingItemType.MTICKET) ? bookingItem3.getMTicket().getBookingTime() : 0;
        }
        if (bookingItem4.getBookingItemType().equals(bookingItemType2)) {
            j2 = bookingItem4.getMagicPass().getBookingTime();
        } else {
            j2 = bookingItem4.getBookingItemType().equals(BookingItemType.MTICKET) ? bookingItem4.getMTicket().getBookingTime() : 0;
        }
        return Long.compare(j2 - j, 0);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<BookingItem> reversed() {
        return Comparator.CC.$default$reversed(this);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing(this, function);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ java.util.Comparator<BookingItem> thenComparing(java.util.Comparator<? super BookingItem> comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }
}
