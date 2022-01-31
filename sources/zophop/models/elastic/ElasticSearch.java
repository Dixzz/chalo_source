package zophop.models.elastic;

import java.util.HashMap;
import java.util.Map;

public class ElasticSearch {
    private Map<String, String> _headers;
    private Index _index;
    private String _type;

    public enum Index {
        point_added,
        universal_search
    }

    public ElasticSearch(Index index, String str) {
        HashMap hashMap = new HashMap();
        this._headers = hashMap;
        hashMap.put("authorization", "Basic ZWxhc3RpYzppVmtGcW16WDdkWjJEUHp5bGdlTmNiTEI=");
        this._index = index;
        this._type = str;
    }
}
