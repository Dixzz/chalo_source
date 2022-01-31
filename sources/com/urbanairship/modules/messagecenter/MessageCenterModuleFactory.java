package com.urbanairship.modules.messagecenter;

import android.content.Context;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.modules.Module;

public interface MessageCenterModuleFactory extends AirshipVersionInfo {
    Module build(Context context, hk5 hk5, ik5 ik5, kp5 kp5, vv5 vv5);
}
