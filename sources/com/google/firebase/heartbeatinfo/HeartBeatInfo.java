package com.google.firebase.heartbeatinfo;

import java.util.List;

public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        private HeartBeat(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    yi4<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo();

    HeartBeat getHeartBeatCode(String str);

    yi4<Void> storeHeartBeatInfo(String str);
}
