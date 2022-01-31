package com.urbanairship.automation;

import android.content.Context;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.automation.AutomationModuleFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AutomationModuleFactoryImpl implements AutomationModuleFactory {
    @Override // com.urbanairship.modules.automation.AutomationModuleFactory
    public Module build(Context context, hk5 hk5, kq5 kq5, ik5 ik5, kp5 kp5, vv5 vv5, fl5 fl5, wx5 wx5, up5 up5) {
        dn5 dn5 = new dn5(context, hk5, kq5, ik5, fl5, wx5, kp5, up5);
        List asList = Arrays.asList(dn5, new tr5(context, hk5, dn5, fl5, vv5));
        return new Module(new HashSet(asList), R.xml.ua_automation_actions);
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getAirshipVersion() {
        return "14.6.0";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getPackageVersion() {
        return "!SDK-VERSION-STRING!:com.urbanairship.android:urbanairship-automation:14.6.0";
    }
}
