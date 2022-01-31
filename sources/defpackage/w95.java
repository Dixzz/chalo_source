package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import defpackage.u95;
import java.util.List;

/* renamed from: w95  reason: default package */
/* compiled from: CaptureManager */
public class w95 {
    public static final String l = "w95";

    /* renamed from: a  reason: collision with root package name */
    public Activity f3748a;
    public CompoundBarcodeView b;
    public int c = -1;
    public boolean d = false;
    public boolean e = false;
    public b45 f;
    public y35 g;
    public Handler h;
    public r95 i = new a();
    public final u95.e j;
    public boolean k;

    /* renamed from: w95$a */
    /* compiled from: CaptureManager */
    public class a implements r95 {

        /* renamed from: w95$a$a  reason: collision with other inner class name */
        /* compiled from: CaptureManager */
        public class RunnableC0065a implements Runnable {
            public final /* synthetic */ s95 f;

            public RunnableC0065a(s95 s95) {
                this.f = s95;
            }

            /* JADX WARNING: Removed duplicated region for block: B:24:0x00db  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0144  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                // Method dump skipped, instructions count: 341
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.w95.a.RunnableC0065a.run():void");
            }
        }

        public a() {
        }

        @Override // defpackage.r95
        public void a(List<g35> list) {
        }

        @Override // defpackage.r95
        public void b(s95 s95) {
            MediaPlayer mediaPlayer;
            w95.this.b.f.d();
            y35 y35 = w95.this.g;
            synchronized (y35) {
                if (y35.h && (mediaPlayer = y35.g) != null) {
                    mediaPlayer.start();
                }
            }
            w95.this.h.postDelayed(new RunnableC0065a(s95), 150);
        }
    }

    /* renamed from: w95$b */
    /* compiled from: CaptureManager */
    public class b implements u95.e {
        public b() {
        }

        @Override // defpackage.u95.e
        public void a() {
        }

        @Override // defpackage.u95.e
        public void b(Exception exc) {
            w95.this.a();
        }

        @Override // defpackage.u95.e
        public void c() {
        }

        @Override // defpackage.u95.e
        public void d() {
        }
    }

    /* renamed from: w95$c */
    /* compiled from: CaptureManager */
    public class c implements Runnable {
        public c() {
        }

        public void run() {
            String str = w95.l;
            w95.this.f3748a.finish();
        }
    }

    /* renamed from: w95$d */
    /* compiled from: CaptureManager */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w95.this.f3748a.finish();
        }
    }

    /* renamed from: w95$e */
    /* compiled from: CaptureManager */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            w95.this.f3748a.finish();
        }
    }

    public w95(Activity activity, CompoundBarcodeView compoundBarcodeView) {
        b bVar = new b();
        this.j = bVar;
        this.k = false;
        this.f3748a = activity;
        this.b = compoundBarcodeView;
        compoundBarcodeView.getBarcodeView().o.add(bVar);
        this.h = new Handler();
        this.f = new b45(activity, new c());
        this.g = new y35(activity);
    }

    public void a() {
        if (!this.f3748a.isFinishing() && !this.e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f3748a);
            builder.setTitle(this.f3748a.getString(R.string.zxing_app_name));
            builder.setMessage(this.f3748a.getString(R.string.zxing_msg_camera_framework_bug));
            builder.setPositiveButton(R.string.zxing_button_ok, new d());
            builder.setOnCancelListener(new e());
            builder.show();
        }
    }
}
