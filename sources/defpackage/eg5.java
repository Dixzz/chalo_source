package defpackage;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.io.IOException;
import java.text.ParseException;
import org.json.JSONException;

/* renamed from: eg5  reason: default package */
/* compiled from: TrillSDK */
public class eg5 {

    /* renamed from: a  reason: collision with root package name */
    public bg5 f970a;
    public int b;
    public Context c;
    public cg5 d;
    public boolean e;
    public fg5 f;
    public kg5 g;
    public int h = -1;
    public int i = -1;

    public eg5(Context context, String str, String str2) {
        bg5 bg5 = new bg5(context, false);
        this.f970a = bg5;
        this.f = new fg5(context, bg5);
        this.g = new kg5(context, this.b, this.f970a);
        this.c = context;
        context.getSharedPreferences("trill_sdk_data_3stream", 0);
        this.b = 19;
        try {
            this.i = 1;
        } catch (ParseException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public boolean a() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            AudioDeviceInfo[] devices = audioManager.getDevices(2);
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                    return true;
                }
            }
            return false;
        } else if (audioManager.isWiredHeadsetOn() || audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn()) {
            return true;
        } else {
            return false;
        }
    }
}
