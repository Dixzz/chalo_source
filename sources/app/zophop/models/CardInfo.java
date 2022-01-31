package app.zophop.models;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import java.util.List;

public class CardInfo {
    public static final String KEY_CARD_ID = "id";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DISMISS_CONDITIONS = "dismissConditions";
    public static final String KEY_DISPLAY_THRESHOLD = "displayThreshold";
    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_HEADER = "header";
    public static final String KEY_HEADER_TEXT = "text";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_HOOK_CTA = "hookCta";
    public static final String KEY_HOOK_TEXT = "hook";
    public static final String KEY_POS = "pos";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    public static final String KEY_WIDTH = "width";
    private String cardId;
    private List<ProductPromotionsObject> contentList;
    private DismissConditions dismissConditions;
    private boolean enabled;
    private HeaderObj headerObj;
    private int height;
    private int position;
    private String type;
    private int version;
    private int width;

    public String getCardId() {
        return this.cardId;
    }

    public List<ProductPromotionsObject> getContentList() {
        return this.contentList;
    }

    public DismissConditions getDismissConditions() {
        return this.dismissConditions;
    }

    public HeaderObj getHeaderObj() {
        return this.headerObj;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPosition() {
        return this.position;
    }

    public String getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public void setContentList(List<ProductPromotionsObject> list) {
        this.contentList = list;
    }

    public void setDismissConditions(DismissConditions dismissConditions2) {
        this.dismissConditions = dismissConditions2;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setHeaderObj(HeaderObj headerObj2) {
        this.headerObj = headerObj2;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
