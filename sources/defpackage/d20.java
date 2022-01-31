package defpackage;

import android.graphics.Bitmap;
import app.zophop.models.Guidelines;
import app.zophop.models.RouteInfo;
import app.zophop.models.RouteLevelAvailability;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.VehicleInfo;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.models.mTicketing.BookingTransaction;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MagicPassesProperties;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.RouteStopsInfo;
import defpackage.n00;
import java.util.List;
import java.util.Map;

/* renamed from: d20  reason: default package */
/* compiled from: IBookingFeature */
public interface d20 {
    @c60
    void A(MPass mPass, String str, String str2, String str3, String str4, ProfileRequestInfo profileRequestInfo);

    @c60
    void B(MTicket mTicket, String str, String str2, ProfileRequestInfo profileRequestInfo);

    void C(String str, int i, boolean z);

    String D(BookingItemType bookingItemType);

    boolean E(long j);

    String F(String str);

    Map<String, RouteLevelAvailability> G();

    @c60
    void H(Bitmap bitmap, String str, String str2, String str3);

    List<ProductConfiguration> I();

    ProofDocumentProps J(String str, String str2, String str3);

    boolean K();

    void L(MPass mPass);

    void M();

    void N(String str, String str2, String str3);

    MPass O();

    void P(String str, String str2, RouteStopsInfo routeStopsInfo, String str3);

    void Q();

    void R(MPass mPass, String str);

    MPass S(MPass mPass, boolean z);

    void T(String str, String str2, String str3);

    void U(MTicket mTicket);

    @c60
    void V(String str, String str2, String str3);

    boolean W(long j, String str);

    void X(List<VehicleInfo> list);

    boolean Y();

    boolean Z(String str);

    @c60
    void a(String str, String str2);

    MagicPassesProperties a0(String str);

    void b(String str, String str2);

    void b0(String str, String str2, RouteInfo routeInfo);

    void c();

    @c60
    void c0(MPass mPass, String str);

    @c60
    void d(String str, String str2);

    void d0(String str, String str2);

    List<BookingTransaction> e();

    MPass e0(String str);

    List<BookingItem> f();

    void f0(String str, String str2, String str3);

    List<MPass> g();

    void g0();

    int h(String str, int i, boolean z);

    ProductConfiguration h0(String str);

    @c60
    void i(Bitmap bitmap, String str, int i);

    String i0();

    void j(boolean z);

    List<ProductConfiguration> j0(String str);

    void k();

    String k0(String str);

    List<MPass> l();

    void l0(MTicket mTicket, long j);

    void m();

    List<ProductDiscountsObject> m0(String str);

    void n(String str);

    void n0(String str);

    String o(String str);

    Map<String, String> o0(String str);

    Map<String, String> p();

    @c60
    void p0(ScanPayTicket scanPayTicket, String str);

    void q(String str, String str2, String str3, List<VehicleInfo> list, int i, int i2);

    @c60
    void r(List<String> list);

    void s();

    ProductPromotionsObject t(String str, String str2, boolean z);

    Guidelines u(String str, String str2, String str3);

    void v(String str);

    @c60
    void w(MPass mPass, String str, String str2, String str3);

    long x(long j, String str);

    void y(String str, String str2, BookingTransaction bookingTransaction, String str3);

    void z(String str, n00.a1 a1Var);
}
