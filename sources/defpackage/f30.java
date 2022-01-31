package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.ui.activities.SplashScreen;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: f30  reason: default package */
/* compiled from: ImageNotification */
public class f30 extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1067a;
    public final ue1 b;

    public f30(Context context, ue1 ue1) {
        this.b = ue1;
        this.f1067a = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(String[] strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.b.b).openConnection()));
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        PendingIntent pendingIntent;
        Bitmap bitmap2 = bitmap;
        int i = Build.VERSION.SDK_INT;
        super.onPostExecute(bitmap2);
        ue1 ue1 = this.b;
        Context context = this.f1067a;
        d5 d5Var = new d5();
        Notification notification = null;
        if (bitmap2 != null) {
            d5Var.e = bitmap2;
            d5Var.b = f5.d(ue1.e);
            d5Var.e(ue1.f);
            int b2 = q5.b(context, R.color.chalo_primary);
            f5 f5Var = new f5(context, null);
            f5Var.v.icon = R.drawable.logo_notification;
            f5Var.g(ue1.c);
            f5Var.f(ue1.d);
            f5Var.i(16, true);
            f5Var.l(d5Var);
            f5Var.q = b2;
            if (i >= 26) {
                f5Var.t = ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT;
            }
            if (ue1.g != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(ue1.g));
                pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
            } else {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, SplashScreen.class), 134217728);
            }
            f5Var.g = pendingIntent;
            notification = f5Var.b();
        }
        if (notification != null) {
            NotificationManager notificationManager = (NotificationManager) this.f1067a.getSystemService("notification");
            if (i >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
                int i2 = jc5.b(this.f1067a).w;
                if (i2 == 2 || i2 == -1) {
                    notificationChannel.enableVibration(true);
                }
                if (i2 == 4 || i2 == -1) {
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-1);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(0, notification);
            ed1 ed1 = new ed1("image notification displayed", Long.MIN_VALUE);
            hj1.K0(ed1, "notificationId", this.b.f3491a, ed1);
        }
    }
}
