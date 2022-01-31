package com.urbanairship.messagecenter;

import android.content.Context;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.messagecenter.MessageCenterModuleFactory;
import java.util.Collections;

public class MessageCenterModuleFactoryImpl implements MessageCenterModuleFactory {
    @Override // com.urbanairship.modules.messagecenter.MessageCenterModuleFactory
    public Module build(Context context, hk5 hk5, ik5 ik5, kp5 kp5, vv5 vv5) {
        yu5 yu5 = new yu5(context, hk5, ik5, kp5, vv5);
        return new Module(Collections.singleton(yu5), R.xml.ua_message_center_actions);
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getAirshipVersion() {
        return "14.6.0";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getPackageVersion() {
        return "!SDK-VERSION-STRING!:com.urbanairship.android:urbanairship-message-center:14.6.0";
    }
}
