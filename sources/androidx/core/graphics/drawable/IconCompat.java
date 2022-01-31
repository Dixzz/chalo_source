package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f204a = -1;
    public Object b;
    public byte[] c = null;
    public Parcelable d = null;
    public int e = 0;
    public int f = 0;
    public ColorStateList g = null;
    public PorterDuff.Mode h = k;
    public String i = null;
    public String j;

    public IconCompat() {
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i2) {
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.e = i2;
            iconCompat.b = str;
            iconCompat.j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public int c() {
        int i2;
        int i3 = this.f204a;
        if (i3 == -1 && (i2 = Build.VERSION.SDK_INT) >= 23) {
            Icon icon = (Icon) this.b;
            if (i2 >= 28) {
                return icon.getResId();
            }
            try {
                return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        } else if (i3 == 2) {
            return this.e;
        } else {
            throw new IllegalStateException("called getResId() on " + this);
        }
    }

    public int d() {
        int i2;
        int i3 = this.f204a;
        if (i3 != -1 || (i2 = Build.VERSION.SDK_INT) < 23) {
            return i3;
        }
        Icon icon = (Icon) this.b;
        if (i2 >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            String str = "Unable to get icon type " + icon;
            return -1;
        } catch (InvocationTargetException unused2) {
            String str2 = "Unable to get icon type " + icon;
            return -1;
        } catch (NoSuchMethodException unused3) {
            String str3 = "Unable to get icon type " + icon;
            return -1;
        }
    }

    public Uri e() {
        int i2;
        int i3 = this.f204a;
        if (i3 == -1 && (i2 = Build.VERSION.SDK_INT) >= 23) {
            Icon icon = (Icon) this.b;
            if (i2 >= 28) {
                return icon.getUri();
            }
            try {
                return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        } else if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.b);
        } else {
            throw new IllegalStateException("called getUri() on " + this);
        }
    }

    @Deprecated
    public Icon f() {
        return g(null);
    }

    public Icon g(Context context) {
        Icon icon;
        int i2 = Build.VERSION.SDK_INT;
        int i3 = this.f204a;
        String str = null;
        r3 = null;
        InputStream inputStream = null;
        switch (i3) {
            case -1:
                return (Icon) this.b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.b);
                break;
            case 2:
                if (i3 == -1 && i2 >= 23) {
                    Icon icon2 = (Icon) this.b;
                    if (i2 >= 28) {
                        str = icon2.getResPackage();
                    } else {
                        try {
                            str = (String) icon2.getClass().getMethod("getResPackage", new Class[0]).invoke(icon2, new Object[0]);
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        }
                    }
                } else if (i3 != 2) {
                    throw new IllegalStateException("called getResPackage() on " + this);
                } else if (TextUtils.isEmpty(this.j)) {
                    str = ((String) this.b).split(ProductDiscountsObject.KEY_DELIMITER, -1)[0];
                } else {
                    str = this.j;
                }
                icon = Icon.createWithResource(str, this.e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.b, this.e, this.f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.b);
                break;
            case 5:
                if (i2 < 26) {
                    icon = Icon.createWithBitmap(a((Bitmap) this.b, false));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.b);
                    break;
                }
            case 6:
                if (i2 >= 30) {
                    icon = Icon.createWithAdaptiveBitmapContentUri(e());
                    break;
                } else if (context != null) {
                    Uri e2 = e();
                    String scheme = e2.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            inputStream = context.getContentResolver().openInputStream(e2);
                        } catch (Exception unused2) {
                            String str2 = "Unable to load image from URI: " + e2;
                        }
                    } else {
                        try {
                            inputStream = new FileInputStream(new File((String) this.b));
                        } catch (FileNotFoundException unused3) {
                            String str3 = "Unable to load image from path: " + e2;
                        }
                    }
                    if (inputStream != null) {
                        if (i2 < 26) {
                            icon = Icon.createWithBitmap(a(BitmapFactory.decodeStream(inputStream), false));
                            break;
                        } else {
                            icon = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStream));
                            break;
                        }
                    } else {
                        StringBuilder i0 = hj1.i0("Cannot load adaptive icon from uri: ");
                        i0.append(e());
                        throw new IllegalStateException(i0.toString());
                    }
                } else {
                    StringBuilder i02 = hj1.i0("Context is required to resolve the file uri of the icon: ");
                    i02.append(e());
                    throw new IllegalArgumentException(i02.toString());
                }
                break;
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.h;
        if (mode != k) {
            icon.setTintMode(mode);
        }
        return icon;
    }

    public String toString() {
        String str;
        if (this.f204a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f204a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f204a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i2) {
        this.f204a = i2;
    }
}
