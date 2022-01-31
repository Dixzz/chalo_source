package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.urbanairship.automation.R;
import com.urbanairship.iam.assets.Assets;
import com.urbanairship.iam.banner.BannerDismissLayout;
import com.urbanairship.iam.view.InAppButtonLayout;
import com.urbanairship.iam.view.MediaView;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: is5  reason: default package */
/* compiled from: BannerView */
public class is5 extends FrameLayout implements InAppButtonLayout.ButtonClickListener, View.OnClickListener, BannerDismissLayout.Listener {
    public static final /* synthetic */ int o = 0;
    public final Assets f;
    public final hs5 g;
    public final js5 h;
    public int i;
    public int j;
    public boolean k = false;
    public boolean l = false;
    public View m;
    public d n;

    /* renamed from: is5$a */
    /* compiled from: BannerView */
    public class a extends js5 {
        public a(long j) {
            super(j);
        }
    }

    /* renamed from: is5$b */
    /* compiled from: BannerView */
    public class b implements m8 {
        public b() {
        }

        @Override // defpackage.m8
        public c9 a(View view, c9 c9Var) {
            for (int i = 0; i < is5.this.getChildCount(); i++) {
                r8.e(is5.this.getChildAt(i), new c9(c9Var));
            }
            return c9Var;
        }
    }

    /* renamed from: is5$c */
    /* compiled from: BannerView */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            is5 is5 = is5.this;
            int i = is5.o;
            is5.e();
        }
    }

    /* renamed from: is5$d */
    /* compiled from: BannerView */
    public interface d {
    }

    public is5(Context context, hs5 hs5, Assets assets) {
        super(context);
        this.g = hs5;
        this.f = assets;
        this.h = new a(hs5.m);
        r8.w(this, new b());
    }

    private int getContentLayout() {
        String str = this.g.l;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 4266497) {
            if (hashCode == 1939617666 && str.equals("media_left")) {
                c2 = 1;
            }
        } else if (str.equals("media_right")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return R.layout.ua_iam_banner_content_left_media;
        }
        return R.layout.ua_iam_banner_content_right_media;
    }

    private int getLayout() {
        String str = this.g.k;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1383228885) {
            if (hashCode == 115029 && str.equals("top")) {
                c2 = 0;
            }
        } else if (str.equals("bottom")) {
            c2 = 1;
        }
        if (c2 != 0) {
            return R.layout.ua_iam_banner_bottom;
        }
        return R.layout.ua_iam_banner_top;
    }

    @Override // com.urbanairship.iam.banner.BannerDismissLayout.Listener
    public void a(View view) {
        d dVar = this.n;
        if (dVar != null) {
            fs5 fs5 = (fs5) dVar;
            fs5.f1169a.i.a(xr5.c(), getTimer().a());
            fs5.f1169a.i(getContext());
        }
        d(false);
    }

    @Override // com.urbanairship.iam.view.InAppButtonLayout.ButtonClickListener
    public void b(View view, xq5 xq5) {
        d dVar = this.n;
        if (dVar != null) {
            fs5 fs5 = (fs5) dVar;
            hd3.J2(xq5);
            fs5.f1169a.i.a(xr5.a(xq5), getTimer().a());
            fs5.f1169a.i(getContext());
        }
        d(true);
    }

    @Override // com.urbanairship.iam.banner.BannerDismissLayout.Listener
    public void c(View view, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                getTimer().c();
            }
        } else if (this.l) {
            getTimer().b();
        }
    }

    public void d(boolean z) {
        this.k = true;
        getTimer().c();
        if (!z || this.m == null || this.j == 0) {
            e();
            return;
        }
        clearAnimation();
        Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), this.j);
        loadAnimator.setTarget(this.m);
        loadAnimator.addListener(new c());
        loadAnimator.start();
    }

    public final void e() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
            this.m = null;
        }
    }

    public hs5 getDisplayContent() {
        return this.g;
    }

    public js5 getTimer() {
        return this.h;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AtomicInteger atomicInteger = r8.f3055a;
        requestApplyInsets();
    }

    public void onClick(View view) {
        d dVar = this.n;
        if (dVar != null) {
            fs5 fs5 = (fs5) dVar;
            if (!fs5.f1169a.d.q.isEmpty()) {
                hd3.K2(fs5.f1169a.d.q, null);
                fs5.f1169a.i.a(new xr5("message_click"), getTimer().a());
            }
            fs5.f1169a.i(getContext());
        }
        d(true);
    }

    public void onWindowVisibilityChanged(int i2) {
        if (i2 == 0 && !this.k && this.m == null) {
            BannerDismissLayout bannerDismissLayout = (BannerDismissLayout) LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) this, false);
            bannerDismissLayout.setPlacement(this.g.k);
            bannerDismissLayout.setListener(this);
            ViewStub viewStub = (ViewStub) bannerDismissLayout.findViewById(R.id.banner_content);
            viewStub.setLayoutResource(getContentLayout());
            viewStub.inflate();
            LinearLayout linearLayout = (LinearLayout) bannerDismissLayout.findViewById(R.id.banner);
            int i3 = this.g.o;
            int c2 = a6.c(i3, Math.round(((float) Color.alpha(i3)) * 0.2f));
            int i4 = 12;
            int i5 = "top".equals(this.g.k) ? 12 : 3;
            xs5 xs5 = new xs5(getContext());
            xs5.f3960a = this.g.n;
            xs5.c = Integer.valueOf(c2);
            float f2 = this.g.p;
            xs5.f = i5;
            xs5.e = f2;
            Drawable a2 = xs5.a();
            AtomicInteger atomicInteger = r8.f3055a;
            linearLayout.setBackground(a2);
            hs5 hs5 = this.g;
            if (hs5.p > 0.0f) {
                if (!"top".equals(hs5.k)) {
                    i4 = 3;
                }
                hd3.n(linearLayout, this.g.p, i4);
            }
            if (!this.g.q.isEmpty()) {
                linearLayout.setClickable(true);
                linearLayout.setOnClickListener(this);
            }
            TextView textView = (TextView) bannerDismissLayout.findViewById(R.id.heading);
            yr5 yr5 = this.g.f;
            if (yr5 != null) {
                hd3.q(textView, yr5);
            } else {
                textView.setVisibility(8);
            }
            TextView textView2 = (TextView) bannerDismissLayout.findViewById(R.id.body);
            yr5 yr52 = this.g.g;
            if (yr52 != null) {
                hd3.q(textView2, yr52);
            } else {
                textView2.setVisibility(8);
            }
            MediaView mediaView = (MediaView) bannerDismissLayout.findViewById(R.id.media);
            vr5 vr5 = this.g.h;
            if (vr5 != null) {
                hd3.d2(mediaView, vr5, this.f);
            } else {
                mediaView.setVisibility(8);
            }
            InAppButtonLayout inAppButtonLayout = (InAppButtonLayout) bannerDismissLayout.findViewById(R.id.buttons);
            if (this.g.i.isEmpty()) {
                inAppButtonLayout.setVisibility(8);
            } else {
                hs5 hs52 = this.g;
                inAppButtonLayout.a(hs52.j, hs52.i);
                inAppButtonLayout.setButtonClickListener(this);
            }
            View findViewById = bannerDismissLayout.findViewById(R.id.banner_pull);
            Drawable mutate = h.H0(findViewById.getBackground()).mutate();
            mutate.setTint(this.g.o);
            findViewById.setBackground(mutate);
            this.m = bannerDismissLayout;
            addView(bannerDismissLayout);
            if (this.i != 0) {
                Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), this.i);
                loadAnimator.setTarget(this.m);
                loadAnimator.start();
            }
            this.l = true;
            if (!this.k) {
                getTimer().b();
            }
        }
    }

    public void setListener(d dVar) {
        this.n = dVar;
    }
}
