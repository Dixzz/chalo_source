package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import java.util.List;

public class CompoundBarcodeView extends FrameLayout {
    public BarcodeView f;
    public ViewfinderView g;
    public TextView h;
    public a i;

    public interface a {
        void a();

        void b();
    }

    public class b implements r95 {

        /* renamed from: a  reason: collision with root package name */
        public r95 f665a;

        public b(r95 r95) {
            this.f665a = r95;
        }

        @Override // defpackage.r95
        public void a(List<g35> list) {
            for (g35 g35 : list) {
                List<g35> list2 = CompoundBarcodeView.this.g.l;
                list2.add(g35);
                int size = list2.size();
                if (size > 20) {
                    list2.subList(0, size - 10).clear();
                }
            }
            this.f665a.a(list);
        }

        @Override // defpackage.r95
        public void b(s95 s95) {
            this.f665a.b(s95);
        }
    }

    public CompoundBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        FrameLayout.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R.id.zxing_barcode_surface);
        this.f = barcodeView;
        if (barcodeView != null) {
            barcodeView.c(attributeSet);
            ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
            this.g = viewfinderView;
            if (viewfinderView != null) {
                viewfinderView.setCameraPreview(this.f);
                this.h = (TextView) findViewById(R.id.zxing_status_view);
                return;
            }
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R.id.zxing_barcode_surface);
    }

    public TextView getStatusView() {
        return this.h;
    }

    public ViewfinderView getViewFinder() {
        return this.g;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            this.f.setTorch(true);
            a aVar = this.i;
            if (aVar != null) {
                aVar.b();
            }
            return true;
        } else if (i2 == 25) {
            this.f.setTorch(false);
            a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            return true;
        } else if (i2 == 27 || i2 == 80) {
            return true;
        } else {
            return super.onKeyDown(i2, keyEvent);
        }
    }

    public void setStatusText(String str) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
        this.i = aVar;
    }
}
