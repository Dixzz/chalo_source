package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductActiveStatus;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.appindexing.builders.TimerBuilder;
import com.razorpay.AnalyticsConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.jk;
import java.util.List;

/* renamed from: dl0  reason: default package */
/* compiled from: YourPlansAdapter.kt */
public final class dl0 extends ok<BookingItem, c> {
    public static final a g = new a(null);
    public final Context c;
    public final h76<s56> d;
    public final boolean e;
    public final String f;

    /* renamed from: dl0$a */
    /* compiled from: YourPlansAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: dl0$b */
    /* compiled from: YourPlansAdapter.kt */
    public static final class b extends jk.e<BookingItem> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(BookingItem bookingItem, BookingItem bookingItem2) {
            BookingItem bookingItem3 = bookingItem;
            BookingItem bookingItem4 = bookingItem2;
            n86.e(bookingItem3, "oldItem");
            n86.e(bookingItem4, "newItem");
            return bookingItem3.getBookingItemType() == bookingItem4.getBookingItemType() && n86.a(bookingItem3.getBookingStatus(), bookingItem4.getBookingStatus());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(BookingItem bookingItem, BookingItem bookingItem2) {
            BookingItem bookingItem3 = bookingItem;
            BookingItem bookingItem4 = bookingItem2;
            n86.e(bookingItem3, "oldItem");
            n86.e(bookingItem4, "newItem");
            return n86.a(bookingItem3.getBookingId(), bookingItem4.getBookingId());
        }
    }

    /* renamed from: dl0$c */
    /* compiled from: YourPlansAdapter.kt */
    public final class c extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final qz f852a;
        public final j56 b;
        public final /* synthetic */ dl0 c;

        /* renamed from: dl0$c$a */
        /* compiled from: YourPlansAdapter.kt */
        public static final class a extends o86 implements h76<s76<? super String, ? extends s56>> {
            public final /* synthetic */ dl0 f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(dl0 dl0) {
                super(0);
                this.f = dl0;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.h76
            public s76<? super String, ? extends s56> invoke() {
                return new fl0(this.f);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(dl0 dl0, qz qzVar) {
            super(qzVar.f3012a);
            n86.e(dl0, "this$0");
            n86.e(qzVar, "viewBinding");
            this.c = dl0;
            this.f852a = qzVar;
            this.b = hd3.a2(new a(dl0));
            qzVar.f3012a.setOnClickListener(new qi0(this, dl0));
        }

        public final s76<String, s56> a() {
            return (s76) this.b.getValue();
        }

        public final String b() {
            String str = this.c.f;
            if (n86.a(str, "Home Screen")) {
                return "sourceHomeScreenYourPlansCard";
            }
            return n86.a(str, "History screen") ? "sourceHistoryScreenYourPlansCard" : "sourceYourPlansCard";
        }

        public final void c(MPass mPass) {
            Intent intent = new Intent(this.c.c, BookingSummaryMagicPassActivity.class);
            intent.putExtra("magic_pass_info", mPass);
            intent.putExtra("src", this.c.f);
            this.c.c.startActivity(intent);
            dl0 dl0 = this.c;
            Context context = dl0.c;
            BookingSummaryMagicPassActivity.p = dl0.f;
        }

        public final boolean d(MPass mPass) {
            ProductConfiguration m0 = vn.m0(mPass.getConfigId());
            if (m0 == null) {
                s76<String, s56> a2 = a();
                String string = this.c.c.getResources().getString(R.string.recent_products_not_available_dialog_copy);
                n86.d(string, "context.resources.getStr…ot_available_dialog_copy)");
                a2.invoke(string);
                return true;
            }
            ProductActiveStatus h = vn.h(mPass, m0);
            if (h.getIsActive()) {
                return false;
            }
            String inactiveReason = h.getInactiveReason();
            if (inactiveReason == null) {
                inactiveReason = this.c.c.getResources().getString(R.string.recent_products_disabled_dialog_copy);
            }
            s76<String, s56> a3 = a();
            n86.d(inactiveReason, "lInactiveReason");
            a3.invoke(inactiveReason);
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dl0(Context context, h76<s56> h76, boolean z, String str) {
        super(new b());
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(h76, "listChangeListener");
        n86.e(str, "source");
        this.c = context;
        this.d = h76;
        this.e = z;
        this.f = str;
    }

    @Override // defpackage.ok
    public void c(List<BookingItem> list, List<BookingItem> list2) {
        n86.e(list, "previousList");
        n86.e(list2, "currentList");
        this.d.invoke();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        c cVar = (c) a0Var;
        n86.e(cVar, "holder");
        cVar.itemView.setLayoutParams(new ViewGroup.LayoutParams((getItemCount() == 1 || n86.a(this.f, "History screen")) ? -1 : (int) (((float) this.c.getResources().getDisplayMetrics().widthPixels) * 0.6f), -2));
        T t = this.f2701a.f.get(i);
        int ordinal = t.getBookingItemType().ordinal();
        if (ordinal == 0) {
            MPass magicPass = t.getMagicPass();
            n86.c(magicPass);
            CircleImageView circleImageView = cVar.f852a.d;
            n86.d(circleImageView, "holder.viewBinding.profilePicIcon");
            circleImageView.setVisibility(0);
            ml1<Drawable> p = gl1.f(this.c).p(magicPass.getUserProfile().getProfilePhoto());
            p.a(new rs1().j(R.drawable.home_screen_profile_icon).q(50000));
            p.e(cVar.f852a.d);
            ProductConfiguration m0 = vn.m0(magicPass.getConfigId());
            String string = this.c.getString(R.string.pass);
            if (m0 != null) {
                string = m0.getProductName();
            }
            qz qzVar = cVar.f852a;
            qzVar.b.setText(string);
            if (this.e) {
                String status = magicPass.getStatus();
                if (status != null) {
                    switch (status.hashCode()) {
                        case -1211756856:
                            if (status.equals("VERIFIED")) {
                                qzVar.c.setText(this.c.getString(R.string.payment_pending));
                                return;
                            }
                            break;
                        case 16937057:
                            if (status.equals("UNVERIFIED")) {
                                qzVar.c.setText(this.c.getString(R.string.verification_pending));
                                return;
                            }
                            break;
                        case 35394935:
                            if (status.equals("PENDING")) {
                                qzVar.c.setText(this.c.getString(R.string.processing));
                                return;
                            }
                            break;
                        case 174130302:
                            if (status.equals("REJECTED")) {
                                qzVar.c.setText(this.c.getString(R.string.application_rejected));
                                return;
                            }
                            break;
                        case 1862415390:
                            if (status.equals("PAYMENT_PENDING")) {
                                qzVar.c.setText(this.c.getString(R.string.payment_pending));
                                return;
                            }
                            break;
                    }
                }
                if (xt.f3961a.c().E(magicPass.getStartingTime())) {
                    qzVar.c.setText(n86.j("Expires on ", jh1.d(magicPass.getExpiryTime())));
                } else {
                    qzVar.c.setText(n86.j("Starts from ", jh1.d(magicPass.getStartingTime())));
                }
            } else if (magicPass.isPassExpired() || magicPass.getExpiryTime() < ui1.Q()) {
                qzVar.c.setText(TimerBuilder.EXPIRED);
            } else if (magicPass.getOrderId() != null && n86.a("FAILED", magicPass.getStatus())) {
                qzVar.c.setText(this.c.getString(R.string.failed));
            } else if (xt.f3961a.c().E(magicPass.getStartingTime())) {
                qzVar.c.setText(n86.j("Expires on ", jh1.d(magicPass.getExpiryTime())));
            } else {
                qzVar.c.setText(n86.j("Starts from ", jh1.d(magicPass.getStartingTime())));
            }
        } else if (ordinal == 1) {
            qz qzVar2 = cVar.f852a;
            CircleImageView circleImageView2 = qzVar2.d;
            n86.d(circleImageView2, "profilePicIcon");
            circleImageView2.setVisibility(8);
            qzVar2.b.setText(this.c.getString(R.string.one_way_ticket));
            if (this.e) {
                MTicket mTicket = t.getMTicket();
                n86.c(mTicket);
                if (n86.a("PENDING", mTicket.getStatus())) {
                    qzVar2.c.setText(this.c.getString(R.string.processing));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.c.getString(R.string.mticket_booking_valid_till));
                sb.append(' ');
                MTicket mTicket2 = t.getMTicket();
                n86.c(mTicket2);
                sb.append((Object) jh1.d(mTicket2.getMTicketExpirationTime()));
                qzVar2.c.setText(ea6.x(sb.toString(), ",", "on", false, 4));
                return;
            }
            MTicket mTicket3 = t.getMTicket();
            n86.c(mTicket3);
            if (n86.a("FAILED", mTicket3.getStatus())) {
                qzVar2.c.setText(this.c.getString(R.string.failed));
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.c.getResources().getString(R.string.mticket_booking_expired_on));
            sb2.append(' ');
            MTicket mTicket4 = t.getMTicket();
            n86.c(mTicket4);
            sb2.append((Object) jh1.d(mTicket4.getMTicketUsedTime()));
            qzVar2.c.setText(ea6.x(sb2.toString(), ",", "on", false, 4));
        } else if (ordinal == 3) {
            qz qzVar3 = cVar.f852a;
            CircleImageView circleImageView3 = qzVar3.d;
            n86.d(circleImageView3, "profilePicIcon");
            circleImageView3.setVisibility(8);
            qzVar3.b.setText(this.c.getString(R.string.one_way_ticket));
            if (this.e) {
                ScanPayTicket scanPayTicket = t.getScanPayTicket();
                n86.c(scanPayTicket);
                if (n86.a("PENDING", scanPayTicket.get_status())) {
                    qzVar3.c.setText(this.c.getString(R.string.processing));
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.c.getString(R.string.mticket_booking_valid_till));
                sb3.append(' ');
                ScanPayTicket scanPayTicket2 = t.getScanPayTicket();
                n86.c(scanPayTicket2);
                sb3.append((Object) jh1.d(scanPayTicket2.get_expirationTime()));
                qzVar3.c.setText(ea6.x(sb3.toString(), ",", "on", false, 4));
                return;
            }
            ScanPayTicket scanPayTicket3 = t.getScanPayTicket();
            n86.c(scanPayTicket3);
            if (n86.a("FAILED", scanPayTicket3.get_status())) {
                qzVar3.c.setText(this.c.getString(R.string.failed));
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.c.getResources().getString(R.string.mticket_booking_expired_on));
            sb4.append(' ');
            ScanPayTicket scanPayTicket4 = t.getScanPayTicket();
            n86.c(scanPayTicket4);
            sb4.append((Object) jh1.d(scanPayTicket4.get_expirationTime()));
            qzVar3.c.setText(ea6.x(sb4.toString(), ",", "on", false, 4));
        } else if (ordinal == 4) {
            SuperPassApplication superPassApplication = t.getSuperPassApplication();
            n86.c(superPassApplication);
            CircleImageView circleImageView4 = cVar.f852a.d;
            n86.d(circleImageView4, "holder.viewBinding.profilePicIcon");
            circleImageView4.setVisibility(0);
            ml1<Drawable> p2 = gl1.f(this.c).p(superPassApplication.getProfilePhotoUrl());
            p2.a(new rs1().j(R.drawable.home_screen_profile_icon).q(50000));
            p2.e(cVar.f852a.d);
            qz qzVar4 = cVar.f852a;
            qzVar4.b.setText(superPassApplication.getPassName());
            int ordinal2 = superPassApplication.getSuperPassApplicationStatus().ordinal();
            if (ordinal2 == 0) {
                qzVar4.c.setText(this.c.getString(R.string.verification_pending));
            } else if (ordinal2 == 1) {
                qzVar4.c.setText(this.c.getString(R.string.payment_pending));
            } else if (ordinal2 == 2) {
                qzVar4.c.setText(this.c.getString(R.string.application_rejected));
            } else if (ordinal2 == 3) {
                qzVar4.c.setText(this.c.getString(R.string.payment_pending));
            }
        } else if (ordinal == 5 || ordinal == 6) {
            SuperPass applicableSuperPass = t.getApplicableSuperPass();
            CircleImageView circleImageView5 = cVar.f852a.d;
            n86.d(circleImageView5, "holder.viewBinding.profilePicIcon");
            circleImageView5.setVisibility(0);
            ml1<Drawable> p3 = gl1.f(this.c).p(applicableSuperPass.getProfilePhotoUrl());
            p3.a(new rs1().j(R.drawable.home_screen_profile_icon).q(50000));
            p3.e(cVar.f852a.d);
            qz qzVar5 = cVar.f852a;
            qzVar5.b.setText(applicableSuperPass.getSuperPassUIProperties().getPassName());
            if (!this.e) {
                qzVar5.c.setText(TimerBuilder.EXPIRED);
            } else if (!applicableSuperPass.isNotYetActive()) {
                qzVar5.c.setText(n86.j("Expires on ", jh1.d(applicableSuperPass.getSuperPassValidationProperties().getExpiryTime())));
            } else {
                qzVar5.c.setText(n86.j("Starts from ", jh1.d(applicableSuperPass.getSuperPassValidationProperties().getStartTime())));
            }
        } else if (ordinal == 7) {
            PendingSuperPass pendingSuperPass = t.getPendingSuperPass();
            n86.c(pendingSuperPass);
            ml1<Drawable> p4 = gl1.f(this.c).p(pendingSuperPass.getPendingSuperPassUIProperties().getSuperPassUserDetails().getProfilePhoto());
            p4.a(new rs1().j(R.drawable.home_screen_profile_icon).q(50000));
            p4.e(cVar.f852a.d);
            qz qzVar6 = cVar.f852a;
            qzVar6.b.setText(pendingSuperPass.getPendingSuperPassUIProperties().getPassName());
            int ordinal3 = pendingSuperPass.getPendingSuperPassProperties().getStatus().ordinal();
            if (ordinal3 == 0) {
                qzVar6.c.setText(this.c.getString(R.string.failed));
            } else if (ordinal3 == 1) {
                qzVar6.c.setText(this.c.getString(R.string.processing));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.c).inflate(R.layout.your_plans_card_home, (ViewGroup) null, false);
        int i2 = R.id.product_name;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.product_name);
        if (materialTextView != null) {
            i2 = R.id.product_status;
            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.product_status);
            if (materialTextView2 != null) {
                i2 = R.id.profile_pic_icon;
                CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.profile_pic_icon);
                if (circleImageView != null) {
                    qz qzVar = new qz((MaterialCardView) inflate, materialTextView, materialTextView2, circleImageView);
                    n86.d(qzVar, "inflate(LayoutInflater.from(context))");
                    return new c(this, qzVar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
