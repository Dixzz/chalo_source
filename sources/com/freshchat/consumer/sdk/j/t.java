package com.freshchat.consumer.sdk.j;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.b.c;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.squareup.picasso.Picasso;
import defpackage.jf5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class t implements FreshchatImageLoader {
    private final Picasso la;

    public t() {
        Picasso picasso;
        c cVar;
        try {
            picasso = Picasso.get();
        } catch (Exception unused) {
            cVar = c.PICASSO_INIT_ERROR;
        } catch (NoSuchMethodError unused2) {
            cVar = c.PICASSO_NO_SUCH_METHOD_ERROR;
        }
        this.la = picasso;
        ai.e("FRESHCHAT", cVar.toString());
        picasso = null;
        this.la = picasso;
    }

    private void a(FreshchatImageLoaderRequest freshchatImageLoaderRequest, String str) {
        if (freshchatImageLoaderRequest == null) {
            throw new IllegalArgumentException(hj1.S("FreshchatImageLoaderRequest instance must not be null in ", str));
        }
    }

    public static t eL() {
        if (!ba.fZ()) {
            return new t();
        }
        ai.e("FRESHCHAT_WARNING", c.DEFAULT_IMAGE_LOADER_MISSING.toString());
        return null;
    }

    @Override // com.freshchat.consumer.sdk.FreshchatImageLoader
    public void fetch(FreshchatImageLoaderRequest freshchatImageLoaderRequest) {
        a(freshchatImageLoaderRequest, RemoteConfigComponent.FETCH_FILE_NAME);
        Picasso picasso = this.la;
        if (picasso == null) {
            ai.e("FRESHCHAT", c.PICASSO_INSTANCE_MISSING.toString());
            return;
        }
        kf5 d = picasso.d(freshchatImageLoaderRequest.getUri());
        long nanoTime = System.nanoTime();
        if (d.b.a()) {
            jf5.b bVar = d.b;
            Picasso.e eVar = bVar.h;
            if (!(eVar != null)) {
                Picasso.e eVar2 = Picasso.e.LOW;
                if (eVar2 == null) {
                    throw new IllegalArgumentException("Priority invalid.");
                } else if (eVar == null) {
                    bVar.h = eVar2;
                } else {
                    throw new IllegalStateException("Priority already set.");
                }
            }
            jf5 a2 = d.a(nanoTime);
            String a3 = rf5.a(a2, new StringBuilder());
            if (!df5.shouldReadFromMemoryCache(0) || d.f2052a.e(a3) == null) {
                ve5 ve5 = new ve5(d.f2052a, a2, 0, 0, null, a3, null);
                Handler handler = d.f2052a.f.i;
                handler.sendMessage(handler.obtainMessage(1, ve5));
            } else if (d.f2052a.n) {
                String d2 = a2.d();
                StringBuilder i0 = hj1.i0("from ");
                i0.append(Picasso.d.MEMORY);
                rf5.f("Main", "completed", d2, i0.toString());
            }
        }
    }

    @Override // com.freshchat.consumer.sdk.FreshchatImageLoader
    public Bitmap get(FreshchatImageLoaderRequest freshchatImageLoaderRequest) {
        a(freshchatImageLoaderRequest, "get");
        Picasso picasso = this.la;
        if (picasso == null) {
            ai.e("FRESHCHAT", c.PICASSO_INSTANCE_MISSING.toString());
            return null;
        }
        try {
            return picasso.d(freshchatImageLoaderRequest.getUri()).b();
        } catch (IOException e) {
            q.a(e);
            return null;
        }
    }

    @Override // com.freshchat.consumer.sdk.FreshchatImageLoader
    public void load(FreshchatImageLoaderRequest freshchatImageLoaderRequest, ImageView imageView) {
        if (imageView != null) {
            a(freshchatImageLoaderRequest, "load");
            Picasso picasso = this.la;
            if (picasso == null) {
                ai.e("FRESHCHAT", c.PICASSO_INSTANCE_MISSING.toString());
                return;
            }
            kf5 d = picasso.d(freshchatImageLoaderRequest.getUri());
            if (!(freshchatImageLoaderRequest.getTargetHeight() == 0 && freshchatImageLoaderRequest.getTargetWidth() == 0)) {
                d.b.b(freshchatImageLoaderRequest.getTargetWidth(), freshchatImageLoaderRequest.getTargetHeight());
                if (freshchatImageLoaderRequest.shouldMaintainAspectRatio()) {
                    d.b.e = true;
                }
            }
            if (freshchatImageLoaderRequest.getTransformToApply() == FreshchatImageLoaderRequest.TransformType.CIRCULAR) {
                s sVar = new s();
                jf5.b bVar = d.b;
                Objects.requireNonNull(bVar);
                if (sVar.key() != null) {
                    if (bVar.f == null) {
                        bVar.f = new ArrayList(2);
                    }
                    bVar.f.add(sVar);
                } else {
                    throw new IllegalArgumentException("Transformation key must not be null.");
                }
            }
            int placeholderResId = freshchatImageLoaderRequest.getPlaceholderResId();
            if (placeholderResId > 0) {
                if (placeholderResId != 0) {
                    d.c = placeholderResId;
                } else {
                    throw new IllegalArgumentException("Placeholder image resource invalid.");
                }
            }
            int errorResId = freshchatImageLoaderRequest.getErrorResId();
            if (errorResId > 0) {
                if (errorResId != 0) {
                    d.d = errorResId;
                } else {
                    throw new IllegalArgumentException("Error image resource invalid.");
                }
            }
            d.d(imageView, null);
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }
}
