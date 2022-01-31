package defpackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.MiniInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.Constants;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
/* renamed from: gc5  reason: default package */
/* compiled from: InAppFragment */
public class gc5 extends Fragment {
    public nc5 f;
    public Activity g;
    public GestureDetector h;
    public Handler i;
    public int j;
    public UpdateDisplayState.DisplayState.InAppNotificationState k;
    public Runnable l;
    public Runnable m;
    public View n;
    public AtomicBoolean o = new AtomicBoolean();

    /* renamed from: gc5$a */
    /* compiled from: InAppFragment */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            gc5.a(gc5.this);
        }
    }

    /* renamed from: gc5$b */
    /* compiled from: InAppFragment */
    public class b implements Runnable {

        /* renamed from: gc5$b$a */
        /* compiled from: InAppFragment */
        public class a implements View.OnTouchListener {
            public a() {
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gc5.this.h.onTouchEvent(motionEvent);
            }
        }

        public b() {
        }

        public void run() {
            gc5.this.n.setVisibility(0);
            gc5.this.n.setOnTouchListener(new a());
            float applyDimension = TypedValue.applyDimension(1, 65.0f, gc5.this.g.getResources().getDisplayMetrics());
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, applyDimension, 0.0f);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            translateAnimation.setDuration(200);
            gc5.this.n.startAnimation(translateAnimation);
            float f2 = applyDimension / 2.0f;
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, f2, f2);
            scaleAnimation.setInterpolator(new d(gc5.this));
            scaleAnimation.setDuration(400);
            scaleAnimation.setStartOffset(200);
            ((ImageView) gc5.this.n.findViewById(R.id.com_mixpanel_android_notification_image)).startAnimation(scaleAnimation);
        }
    }

    /* renamed from: gc5$c */
    /* compiled from: InAppFragment */
    public class c implements GestureDetector.OnGestureListener {
        public c() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (f3 <= 0.0f) {
                return true;
            }
            gc5.a(gc5.this);
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            JSONObject jSONObject;
            MiniInAppNotification miniInAppNotification = (MiniInAppNotification) gc5.this.k.f;
            String str = miniInAppNotification.q;
            if (str != null && str.length() > 0) {
                try {
                    Uri parse = Uri.parse(str);
                    try {
                        gc5.this.g.startActivity(new Intent("android.intent.action.VIEW", parse));
                    } catch (ActivityNotFoundException unused) {
                        String str2 = "User doesn't have an activity for notification URI " + parse;
                    }
                    try {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                        } catch (JSONException unused2) {
                        }
                    } catch (JSONException unused3) {
                    }
                    gc5.this.f.e.k("$campaign_open", miniInAppNotification, jSONObject);
                    gc5.a(gc5.this);
                    return true;
                } catch (IllegalArgumentException unused4) {
                    return true;
                }
            }
            jSONObject = null;
            gc5.this.f.e.k("$campaign_open", miniInAppNotification, jSONObject);
            gc5.a(gc5.this);
            return true;
        }
    }

    /* renamed from: gc5$d */
    /* compiled from: InAppFragment */
    public class d implements Interpolator {
        public d(gc5 gc5) {
        }

        public float getInterpolation(float f) {
            return ((float) (-(Math.cos((double) (f * 12.0f)) * Math.pow(2.718281828459045d, (double) (-8.0f * f))))) + 1.0f;
        }
    }

    public static void a(gc5 gc5) {
        boolean isDestroyed = gc5.g.isDestroyed();
        Activity activity = gc5.g;
        if (activity != null && !activity.isFinishing() && !isDestroyed && !gc5.o.get()) {
            gc5.i.removeCallbacks(gc5.l);
            gc5.i.removeCallbacks(gc5.m);
            FragmentManager fragmentManager = gc5.g.getFragmentManager();
            try {
                fragmentManager.beginTransaction().setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down).remove(gc5).commit();
            } catch (IllegalStateException unused) {
                fragmentManager.beginTransaction().setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down).remove(gc5).commitAllowingStateLoss();
            }
            UpdateDisplayState.c(gc5.j);
            gc5.o.set(true);
        }
    }

    public final void b() {
        if (!this.o.get()) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeCallbacks(this.l);
                this.i.removeCallbacks(this.m);
            }
            UpdateDisplayState.c(this.j);
            FragmentManager fragmentManager = this.g.getFragmentManager();
            try {
                fragmentManager.beginTransaction().remove(this).commit();
            } catch (IllegalStateException unused) {
                fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
            }
        }
        this.o.set(true);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = activity;
        if (this.k == null) {
            b();
            return;
        }
        this.i = new Handler();
        this.l = new a();
        this.m = new b();
        this.h = new GestureDetector(activity, new c());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o.set(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.k == null) {
            b();
        } else {
            View inflate = layoutInflater.inflate(R.layout.com_mixpanel_android_activity_notification_mini, viewGroup, false);
            this.n = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.com_mixpanel_android_notification_title);
            ImageView imageView = (ImageView) this.n.findViewById(R.id.com_mixpanel_android_notification_image);
            MiniInAppNotification miniInAppNotification = (MiniInAppNotification) this.k.f;
            textView.setText(miniInAppNotification.k);
            textView.setTextColor(miniInAppNotification.l);
            imageView.setImageBitmap(miniInAppNotification.o);
            this.i.postDelayed(this.l, Constants.THRESHOLD_TIMESTAMP);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(miniInAppNotification.j);
            gradientDrawable.setCornerRadius(hd3.J0(7.0f, getActivity()));
            gradientDrawable.setStroke((int) hd3.J0(2.0f, getActivity()), miniInAppNotification.s);
            this.n.setBackground(gradientDrawable);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.k.f.o);
            bitmapDrawable.setColorFilter(miniInAppNotification.r, PorterDuff.Mode.SRC_ATOP);
            imageView.setImageDrawable(bitmapDrawable);
        }
        return this.n;
    }

    public void onPause() {
        super.onPause();
        b();
    }

    public void onResume() {
        super.onResume();
        this.i.postDelayed(this.m, 500);
    }

    public void onStart() {
        super.onStart();
        if (this.o.get()) {
            this.g.getFragmentManager().beginTransaction().remove(this).commit();
        }
    }
}
