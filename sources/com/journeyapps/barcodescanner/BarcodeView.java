package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.client.android.R;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BarcodeView extends u95 {
    public b G = b.NONE;
    public r95 H = null;
    public aa5 I;
    public y95 J;
    public Handler K;
    public final Handler.Callback L = new a();

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            BarcodeView barcodeView;
            r95 r95;
            b bVar;
            int i = message.what;
            if (i == R.id.zxing_decode_succeeded) {
                s95 s95 = (s95) message.obj;
                if (!(s95 == null || (r95 = (barcodeView = BarcodeView.this).H) == null || barcodeView.G == (bVar = b.NONE))) {
                    r95.b(s95);
                    BarcodeView barcodeView2 = BarcodeView.this;
                    if (barcodeView2.G == b.SINGLE) {
                        Objects.requireNonNull(barcodeView2);
                        barcodeView2.G = bVar;
                        barcodeView2.H = null;
                        barcodeView2.l();
                    }
                }
                return true;
            } else if (i == R.id.zxing_decode_failed) {
                return true;
            } else {
                if (i != R.id.zxing_possible_result_points) {
                    return false;
                }
                List<g35> list = (List) message.obj;
                BarcodeView barcodeView3 = BarcodeView.this;
                r95 r952 = barcodeView3.H;
                if (!(r952 == null || barcodeView3.G == b.NONE)) {
                    r952.a(list);
                }
                return true;
            }
        }
    }

    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    @Override // defpackage.u95
    public void d() {
        l();
        super.d();
    }

    @Override // defpackage.u95
    public void e() {
        k();
    }

    public y95 getDecoderFactory() {
        return this.J;
    }

    public final x95 i() {
        if (this.J == null) {
            this.J = new ba5();
        }
        z95 z95 = new z95();
        HashMap hashMap = new HashMap();
        hashMap.put(s25.NEED_RESULT_POINT_CALLBACK, z95);
        ba5 ba5 = (ba5) this.J;
        Objects.requireNonNull(ba5);
        EnumMap enumMap = new EnumMap(s25.class);
        enumMap.putAll(hashMap);
        Map<s25, ?> map = ba5.b;
        if (map != null) {
            enumMap.putAll(map);
        }
        Collection<o25> collection = ba5.f401a;
        if (collection != null) {
            enumMap.put((Object) s25.POSSIBLE_FORMATS, (Object) collection);
        }
        String str = ba5.c;
        if (str != null) {
            enumMap.put((Object) s25.CHARACTER_SET, (Object) str);
        }
        y25 y25 = new y25();
        y25.e(enumMap);
        x95 x95 = new x95(y25);
        z95.f4149a = x95;
        return x95;
    }

    public final void j() {
        this.J = new ba5();
        this.K = new Handler(this.L);
    }

    public final void k() {
        l();
        if (this.G != b.NONE && this.l) {
            aa5 aa5 = new aa5(getCameraInstance(), i(), this.K);
            this.I = aa5;
            aa5.f = getPreviewFramingRect();
            aa5 aa52 = this.I;
            Objects.requireNonNull(aa52);
            hd3.g3();
            HandlerThread handlerThread = new HandlerThread(aa5.k);
            aa52.b = handlerThread;
            handlerThread.start();
            aa52.c = new Handler(aa52.b.getLooper(), aa52.i);
            aa52.g = true;
            ka5 ka5 = aa52.f141a;
            if (ka5.f) {
                ta5 ta5 = aa52.j;
                ka5.b();
                ka5.f2040a.b(new ja5(ka5, ta5));
            }
        }
    }

    public final void l() {
        aa5 aa5 = this.I;
        if (aa5 != null) {
            Objects.requireNonNull(aa5);
            hd3.g3();
            synchronized (aa5.h) {
                aa5.g = false;
                aa5.c.removeCallbacksAndMessages(null);
                aa5.b.quit();
            }
            this.I = null;
        }
    }

    public void setDecoderFactory(y95 y95) {
        hd3.g3();
        this.J = y95;
        aa5 aa5 = this.I;
        if (aa5 != null) {
            aa5.d = i();
        }
    }
}
