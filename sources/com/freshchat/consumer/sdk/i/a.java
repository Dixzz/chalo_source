package com.freshchat.consumer.sdk.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.freshchat.consumer.sdk.activity.PictureAttachmentActivity;
import com.freshchat.consumer.sdk.j.a.d;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class a extends AsyncTask<Uri, Void, Bitmap> {
    private static String TAG = a.class.getName();
    private final Context context;
    private final WeakReference<ImageView> gS;
    private final WeakReference<PictureAttachmentActivity.a> gT;
    private final int gU;
    private final WeakReference<com.freshchat.consumer.sdk.f.a> lm;

    public a(Context context2, ImageView imageView, int i, PictureAttachmentActivity.a aVar, com.freshchat.consumer.sdk.f.a aVar2) {
        this.gS = new WeakReference<>(imageView);
        this.gU = i;
        this.context = context2.getApplicationContext();
        this.gT = new WeakReference<>(aVar);
        this.lm = new WeakReference<>(aVar2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(android.net.Uri r9) {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.i.a.a(android.net.Uri):int");
    }

    private com.freshchat.consumer.sdk.f.a fu() {
        WeakReference<com.freshchat.consumer.sdk.f.a> weakReference = this.lm;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public InputStream b(Uri uri) {
        return this.gU == 126 ? ad.aE(uri.getPath()) : ad.d(this.context, uri);
    }

    public Bitmap doInBackground(Uri... uriArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        Exception e;
        FileOutputStream fileOutputStream3 = null;
        if (uriArr == null || uriArr.length == 0) {
            return null;
        }
        Uri uri = uriArr[0];
        InputStream b = b(uri);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = a(uri);
            int aG = af.aG(uri.getPath());
            Matrix matrix = new Matrix();
            if (aG != 0) {
                matrix.postRotate((float) aG);
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(b, null, options);
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            File y = d.y(this.context, "freshchat");
            long nanoTime = System.nanoTime();
            File file = new File(y, nanoTime + ".img");
            File file2 = new File(y, nanoTime + ".img.t");
            fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    q.a(e);
                    ad.a(b, fileOutputStream2, fileOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream3 = fileOutputStream2;
                    ad.a(b, fileOutputStream3, fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileOutputStream3 = fileOutputStream2;
                ad.a(b, fileOutputStream3, fileOutputStream);
                throw th;
            }
            try {
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream2);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream);
                ai.d(TAG, "Pic saved to " + file.getAbsolutePath());
                PictureAttachmentActivity.a aVar = this.gT.get();
                if (aVar != null) {
                    aVar.l(file.getAbsolutePath());
                    aVar.k(file2.getAbsolutePath());
                    aVar.setHeight(createBitmap.getHeight());
                    aVar.setWidth(createBitmap.getWidth());
                }
                x.bs(uri.toString());
                ad.a(b, fileOutputStream2, fileOutputStream);
                return createBitmap;
            } catch (Exception e3) {
                e = e3;
                q.a(e);
                ad.a(b, fileOutputStream2, fileOutputStream);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = null;
            fileOutputStream = null;
            q.a(e);
            ad.a(b, fileOutputStream2, fileOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            ad.a(b, fileOutputStream3, fileOutputStream);
            throw th;
        }
    }

    public void onPostExecute(Bitmap bitmap) {
        WeakReference<ImageView> weakReference = this.gS;
        if (weakReference == null || bitmap == null) {
            ai.e("FRESHCHAT_WARNING", " image view not present or bitmap is null");
            if (fu() != null) {
                fu().aI();
                return;
            }
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        if (fu() != null) {
            fu().aH();
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
        if (fu() != null) {
            fu().aG();
        }
    }
}
