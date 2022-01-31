package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

/* renamed from: m80  reason: default package */
/* compiled from: TTSProvider */
public class m80 implements i80 {

    /* renamed from: a  reason: collision with root package name */
    public TextToSpeech f2336a;
    public boolean b = false;

    /* renamed from: m80$a */
    /* compiled from: TTSProvider */
    public class a implements TextToSpeech.OnInitListener {
        public a() {
        }

        public void onInit(int i) {
            if (i == 0) {
                try {
                    m80 m80 = m80.this;
                    m80.b = true;
                    m80.f2336a.setLanguage(new Locale("hi", "IN"));
                    m80.this.f2336a.setSpeechRate(0.8f);
                } catch (Exception unused) {
                    b00 b00 = b00.f358a;
                    b00.a().b(new Exception("ttsprovider not connected"));
                    m80.this.b = false;
                }
            }
        }
    }

    public m80(Context context) {
        this.f2336a = new TextToSpeech(context, new a());
    }

    @Override // defpackage.i80
    public void a(String str) {
        if (this.b) {
            Bundle bundle = new Bundle();
            bundle.putFloat("volume", 1.0f);
            this.f2336a.speak(str, 1, bundle, "1");
        }
    }

    @Override // defpackage.i80
    public boolean isConnected() {
        return this.b;
    }
}
