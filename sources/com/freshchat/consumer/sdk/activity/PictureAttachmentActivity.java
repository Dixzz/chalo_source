package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.a.c;
import com.freshchat.consumer.sdk.j.a.g;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.p;

public class PictureAttachmentActivity extends b {
    private View aD;
    private View aE;
    private TextWatcher aV = new TextWatcher() {
        /* class com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
            if (editable != null && p.aD(PictureAttachmentActivity.this.getContext())) {
                i.a(PictureAttachmentActivity.this.getContext(), PictureAttachmentActivity.this.bV);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private g bQ;
    private boolean bR = false;
    private View bS;
    private View bT;
    private ImageView bU;
    private EditText bV;
    private a bW;
    private ProgressBar bX;
    private View.OnClickListener bY = new View.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.AnonymousClass2 */

        public void onClick(View view) {
            PictureAttachmentActivity.this.bW.m(PictureAttachmentActivity.this.bV.getText().toString());
            PictureAttachmentActivity.this.setResult(-1, PictureAttachmentActivity.this.bW.aM());
            PictureAttachmentActivity.this.finish();
        }
    };
    private com.freshchat.consumer.sdk.f.a bZ = new com.freshchat.consumer.sdk.f.a() {
        /* class com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.AnonymousClass3 */

        @Override // com.freshchat.consumer.sdk.f.a
        public void aG() {
            i.a(PictureAttachmentActivity.this.getContext(), PictureAttachmentActivity.this.bU, PictureAttachmentActivity.this.bX);
        }

        @Override // com.freshchat.consumer.sdk.f.a
        public void aH() {
            PictureAttachmentActivity.this.aE.setAlpha(1.0f);
            i.a(PictureAttachmentActivity.this.getContext(), PictureAttachmentActivity.this.bX, PictureAttachmentActivity.this.bU);
            PictureAttachmentActivity.this.aE.setEnabled(true);
        }

        @Override // com.freshchat.consumer.sdk.f.a
        public void aI() {
            i.a(PictureAttachmentActivity.this.getContext(), c.PICTURE_ATTACHMENT_PREVIEW_ERROR);
            PictureAttachmentActivity.this.finish();
        }
    };

    public static class a {
        private String cb;
        private String cc;
        private String cd;
        private int height;
        private int width;

        public String aK() {
            return this.cc;
        }

        public String aL() {
            return this.cd;
        }

        public Intent aM() {
            Intent intent = new Intent();
            intent.putExtra("PIC_URL", this.cc);
            intent.putExtra("PIC_THUMB_URL", this.cb);
            intent.putExtra("PICTURE_WIDTH", this.width);
            intent.putExtra("PICTURE_HEIGHT", this.height);
            intent.putExtra("IMAGE_CAPTION", this.cd);
            return intent;
        }

        public a d(Intent intent) {
            this.cc = intent.getStringExtra("PIC_URL");
            this.cb = intent.getStringExtra("PIC_THUMB_URL");
            this.width = intent.getIntExtra("PICTURE_WIDTH", 100);
            this.height = intent.getIntExtra("PICTURE_HEIGHT", 100);
            this.cd = intent.getStringExtra("IMAGE_CAPTION");
            return this;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public void k(String str) {
            this.cb = str;
        }

        public void l(String str) {
            this.cc = str;
        }

        public void m(String str) {
            this.cd = str;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public void setWidth(int i) {
            this.width = i;
        }
    }

    public static Intent a(Context context, Uri uri, int i, String str) {
        Intent intent = new Intent(context, PictureAttachmentActivity.class);
        intent.putExtra("PICTURE_URL", uri);
        intent.putExtra("REQUEST_CODE", i);
        intent.putExtra("ATTACHMENT_CREATION_MODE", true);
        intent.putExtra("IMAGE_CAPTION", str);
        return intent;
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, PictureAttachmentActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("PICTURE_URL", str);
        return intent;
    }

    private void b(Uri uri, int i) {
        new com.freshchat.consumer.sdk.i.a(getApplicationContext(), this.bU, i, this.bW, this.bZ).execute(uri);
    }

    private void j(String str) {
        String aF = ad.aF(str);
        Context applicationContext = getApplicationContext();
        c.a aVar = new c.a(applicationContext, "cache");
        aVar.a(applicationContext, 0.05f);
        g gVar = new g(applicationContext, Math.min(1080, p.ar(getContext())));
        this.bQ = gVar;
        gVar.c(aVar);
        this.bQ.a(aF, this.bU, this.bZ);
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout"};
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().o(true);
        }
        this.bW = new a();
        setContentView(R.layout.freshchat_activity_picture_attachment);
        this.bU = (ImageView) findViewById(R.id.freshchat_picture_attachment_imageview);
        this.bT = findViewById(R.id.freshchat_conv_detail_text_reply_layout);
        this.bX = (ProgressBar) findViewById(R.id.freshchat_picture_attachment_progress_bar);
        this.bV = (EditText) findViewById(R.id.freshchat_conv_detail_reply_text);
        this.bS = findViewById(R.id.freshchat_conv_detail_attach_image);
        this.aD = findViewById(R.id.freshchat_conv_detail_record_voice_reply_button);
        this.aE = findViewById(R.id.freshchat_conv_detail_send_reply_button);
        this.bS.setVisibility(8);
        this.aD.setVisibility(8);
        this.aE.setVisibility(0);
        this.aE.setEnabled(false);
        this.aE.setOnClickListener(this.bY);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("IMAGE_CAPTION");
        if (as.a(stringExtra)) {
            this.bV.setText(stringExtra);
        }
        if (intent.hasExtra("PICTURE_URL")) {
            boolean booleanExtra = intent.getBooleanExtra("ATTACHMENT_CREATION_MODE", false);
            this.bR = booleanExtra;
            if (booleanExtra) {
                b((Uri) intent.getParcelableExtra("PICTURE_URL"), intent.getIntExtra("REQUEST_CODE", 0));
            } else {
                j(intent.getStringExtra("PICTURE_URL"));
                i.c(this.bT);
            }
        }
        EditText editText = this.bV;
        if (editText != null) {
            editText.addTextChangedListener(this.aV);
        }
    }
}
