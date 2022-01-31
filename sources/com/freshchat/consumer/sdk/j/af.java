package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.b.c;
import defpackage.q5;
import java.text.SimpleDateFormat;
import java.util.Locale;
import server.zophop.logicLayer.CsLogic;

public class af {
    private static final SimpleDateFormat iy = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US);
    private static FreshchatImageLoader kZ;

    private static Bitmap a(Context context, VectorDrawable vectorDrawable, int i) {
        if (vectorDrawable == null) {
            return null;
        }
        try {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            int width = (bitmap.getWidth() - min) / 2;
            int height = (bitmap.getHeight() - min) / 2;
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            bitmap2 = Bitmap.createBitmap(min, min, config);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            if (!(width == 0 && height == 0)) {
                Matrix matrix = new Matrix();
                matrix.setTranslate((float) (-width), (float) (-height));
                bitmapShader.setLocalMatrix(matrix);
            }
            paint.setShader(bitmapShader);
            paint.setAntiAlias(true);
            float f = ((float) min) / 2.0f;
            canvas.drawCircle(f, f, f, paint);
        } catch (Exception e) {
            ai.e("FRESHCHAT", c.ERROR_WHILE_CROPPING.toString());
            q.a(e);
        }
        return bitmap2;
    }

    public static void a(FreshchatImageLoader freshchatImageLoader) {
        kZ = freshchatImageLoader;
    }

    public static int aG(String str) {
        ac acVar;
        try {
            acVar = new ac(str);
        } catch (Exception e) {
            ai.e("FRESHCHAT_WARNING", e.toString());
            acVar = null;
        }
        if (acVar == null) {
            return 0;
        }
        int attributeInt = acVar.getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return CsLogic.ETA_FORCE_UPDATE_REDIS_TTL;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    public static Bitmap b(Context context, int i, int i2) {
        try {
            Object obj = q5.f2896a;
            Drawable b = q5.c.b(context, i);
            if (aw.eZ() && (b instanceof VectorDrawable)) {
                return a(context, (VectorDrawable) b, i2);
            }
            if (!(b instanceof BitmapDrawable)) {
                return null;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            return Bitmap.createScaledBitmap(((BitmapDrawable) b).getBitmap(), dimensionPixelSize, dimensionPixelSize, false);
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    public static FreshchatImageLoader eK() {
        if (kZ == null) {
            kZ = t.eL();
        }
        return kZ;
    }

    public static boolean fW() {
        return kZ != null;
    }

    public static int h(Context context, int i) {
        if (context == null || i <= 0) {
            return 0;
        }
        return (int) (((double) (((float) i) * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int i(Context context, int i) {
        if (context == null || i <= 0) {
            return 0;
        }
        return Math.round(((float) i) / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
