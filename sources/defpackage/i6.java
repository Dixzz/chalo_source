package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: i6  reason: default package */
/* compiled from: TypefaceCompatApi29Impl */
public class i6 extends k6 {
    @Override // defpackage.k6
    public Typeface a(Context context, u5 u5Var, Resources resources, int i) {
        try {
            v5[] v5VarArr = u5Var.f3453a;
            int length = v5VarArr.length;
            int i2 = 0;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                v5 v5Var = v5VarArr[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, v5Var.f).setWeight(v5Var.b);
                    if (!v5Var.c) {
                        i4 = 0;
                    }
                    Font build = weight.setSlant(i4).setTtcIndex(v5Var.e).setFontVariationSettings(v5Var.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            int i5 = (i & 1) != 0 ? Constants.FROZEN_FRAME_TIME : 400;
            if ((i & 2) != 0) {
                i2 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // defpackage.k6
    public Typeface b(Context context, CancellationSignal cancellationSignal, k7[] k7VarArr, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = k7VarArr.length;
            int i2 = 0;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                k7 k7Var = k7VarArr[i3];
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(k7Var.f2031a, "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        try {
                            Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(k7Var.c);
                            if (!k7Var.d) {
                                i4 = 0;
                            }
                            Font build = weight.setSlant(i4).setTtcIndex(k7Var.b).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(build);
                            } else {
                                builder.addFont(build);
                            }
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    } else if (openFileDescriptor == null) {
                        i3++;
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            int i5 = (i & 1) != 0 ? Constants.FROZEN_FRAME_TIME : 400;
            if ((i & 2) != 0) {
                i2 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
            throw th;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // defpackage.k6
    public Typeface c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // defpackage.k6
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
