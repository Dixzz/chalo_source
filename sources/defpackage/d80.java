package defpackage;

import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.BookingItemType;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: d80  reason: default package */
/* compiled from: IBookingsRecentStore */
public interface d80 {
    void a(BookingItemType bookingItemType, String str, String str2, String str3, String str4, String str5, List<SPECIAL_FEATURE> list, List<String> list2, boolean z);

    void b(BookingItemType bookingItemType, String str);

    List<RouteInfo> c(BookingItemType bookingItemType);
}
