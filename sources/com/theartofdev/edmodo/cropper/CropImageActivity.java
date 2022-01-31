package com.theartofdev.edmodo.cropper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.theartofdev.edmodo.cropper.CropImageView;
import defpackage.q5;
import java.io.File;
import java.io.IOException;

public class CropImageActivity extends f0 implements CropImageView.i, CropImageView.e {
    public CropImageView f;
    public Uri g;
    public CropImageOptions h;

    public void d0() {
        setResult(0);
        finish();
    }

    public void e(Uri uri, Exception exc, int i) {
        int i2 = exc == null ? -1 : 204;
        CropImage$ActivityResult cropImage$ActivityResult = new CropImage$ActivityResult(this.f.getImageUri(), uri, exc, this.f.getCropPoints(), this.f.getCropRect(), this.f.getRotatedDegrees(), this.f.getWholeImageRect(), i);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", cropImage$ActivityResult);
        setResult(i2, intent);
        finish();
    }

    public final void e0(Menu menu, int i, int i2) {
        Drawable icon;
        MenuItem findItem = menu.findItem(i);
        if (findItem != null && (icon = findItem.getIcon()) != null) {
            try {
                icon.mutate();
                icon.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        String action;
        if (i == 200) {
            if (i2 == 0) {
                d0();
            }
            if (i2 == -1) {
                boolean z = true;
                if (!(intent == null || intent.getData() == null || ((action = intent.getAction()) != null && action.equals("android.media.action.IMAGE_CAPTURE")))) {
                    z = false;
                }
                Uri c1 = (z || intent.getData() == null) ? hd3.c1(this) : intent.getData();
                this.g = c1;
                if (hd3.P1(this, c1)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f.setImageUriAsync(this.g);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        d0();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        super.onCreate(bundle);
        setContentView(R.layout.crop_image_activity);
        this.f = (CropImageView) findViewById(R.id.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.g = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.h = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            Uri uri = this.g;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (hd3.H1(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    hd3.V2(this);
                }
            } else if (hd3.P1(this, this.g)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f.setImageUriAsync(this.g);
            }
        }
        x supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            CropImageOptions cropImageOptions = this.h;
            if (cropImageOptions == null || (charSequence2 = cropImageOptions.I) == null || charSequence2.length() <= 0) {
                charSequence = getResources().getString(R.string.crop_image_activity_title);
            } else {
                charSequence = this.h.I;
            }
            supportActionBar.z(charSequence);
            supportActionBar.o(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crop_image_menu, menu);
        CropImageOptions cropImageOptions = this.h;
        if (!cropImageOptions.T) {
            menu.removeItem(R.id.crop_image_menu_rotate_left);
            menu.removeItem(R.id.crop_image_menu_rotate_right);
        } else if (cropImageOptions.V) {
            menu.findItem(R.id.crop_image_menu_rotate_left).setVisible(true);
        }
        if (!this.h.U) {
            menu.removeItem(R.id.crop_image_menu_flip);
        }
        if (this.h.Z != null) {
            menu.findItem(R.id.crop_image_menu_crop).setTitle(this.h.Z);
        }
        Drawable drawable = null;
        try {
            int i = this.h.a0;
            if (i != 0) {
                Object obj = q5.f2896a;
                drawable = q5.c.b(this, i);
                menu.findItem(R.id.crop_image_menu_crop).setIcon(drawable);
            }
        } catch (Exception unused) {
        }
        int i2 = this.h.J;
        if (i2 != 0) {
            e0(menu, R.id.crop_image_menu_rotate_left, i2);
            e0(menu, R.id.crop_image_menu_rotate_right, this.h.J);
            e0(menu, R.id.crop_image_menu_flip, this.h.J);
            if (drawable != null) {
                e0(menu, R.id.crop_image_menu_crop, this.h.J);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.crop_image_menu_crop) {
            CropImageOptions cropImageOptions = this.h;
            if (cropImageOptions.Q) {
                e(null, null, 1);
            } else {
                Uri uri = cropImageOptions.K;
                if (uri == null || uri.equals(Uri.EMPTY)) {
                    try {
                        Bitmap.CompressFormat compressFormat = this.h.L;
                        uri = Uri.fromFile(File.createTempFile("cropped", compressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp", getCacheDir()));
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to create temp file for output image", e);
                    }
                }
                CropImageView cropImageView = this.f;
                CropImageOptions cropImageOptions2 = this.h;
                Bitmap.CompressFormat compressFormat2 = cropImageOptions2.L;
                int i = cropImageOptions2.M;
                int i2 = cropImageOptions2.N;
                int i3 = cropImageOptions2.O;
                CropImageView.j jVar = cropImageOptions2.P;
                if (cropImageView.F != null) {
                    cropImageView.i(i2, i3, jVar, uri, compressFormat2, i);
                } else {
                    throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
                }
            }
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_left) {
            this.f.e(-this.h.W);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_right) {
            this.f.e(this.h.W);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_horizontally) {
            CropImageView cropImageView2 = this.f;
            cropImageView2.q = !cropImageView2.q;
            cropImageView2.a((float) cropImageView2.getWidth(), (float) cropImageView2.getHeight(), true, false);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_vertically) {
            CropImageView cropImageView3 = this.f;
            cropImageView3.r = !cropImageView3.r;
            cropImageView3.a((float) cropImageView3.getWidth(), (float) cropImageView3.getHeight(), true, false);
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            d0();
            return true;
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 201) {
            Uri uri = this.g;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, R.string.crop_image_activity_no_permissions, 1).show();
                d0();
            } else {
                this.f.setImageUriAsync(uri);
            }
        }
        if (i == 2011) {
            hd3.V2(this);
        }
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        this.f.setOnSetImageUriCompleteListener(this);
        this.f.setOnCropImageCompleteListener(this);
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        super.onStop();
        this.f.setOnSetImageUriCompleteListener(null);
        this.f.setOnCropImageCompleteListener(null);
    }
}
