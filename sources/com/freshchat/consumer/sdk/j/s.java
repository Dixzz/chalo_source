package com.freshchat.consumer.sdk.j;

import android.graphics.Bitmap;

public class s implements pf5 {
    @Override // defpackage.pf5
    public String key() {
        return "circularly_cropped_bitmap";
    }

    @Override // defpackage.pf5
    public Bitmap transform(Bitmap bitmap) {
        Bitmap bitmap2;
        boolean z;
        try {
            Bitmap a2 = af.a(bitmap);
            if (a2 == null) {
                z = false;
                bitmap2 = bitmap;
            } else {
                bitmap2 = a2;
                z = true;
            }
            if (!z) {
                return bitmap2;
            }
            bitmap.recycle();
            return bitmap2;
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }
}
