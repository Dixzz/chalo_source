package app.zophop.models.mTicketing;

import java.util.HashMap;
import java.util.Map;

public class DocumentProofMap {
    public Map<String, Map<String, String>> documentProofMap = new HashMap();

    public Map<String, Map<String, String>> getDocumentProofMap() {
        return this.documentProofMap;
    }

    public void setDocumentProofMap(Map<String, Map<String, String>> map) {
        this.documentProofMap = map;
    }
}
