package app.zophop.models;

public class RouteLevelAvailability {
    private final String cta;
    private final String ctaAction;
    private final boolean ctaVisbility;
    private final String imageUrl;
    private int isDisruption;
    private final boolean isImageVisible;
    private final boolean isSticky;
    private final boolean isVisible;
    private final RouteDialogInfo routeDialogInfo;
    private final int style;
    private final String title;

    public RouteLevelAvailability(boolean z, boolean z2, boolean z3, String str, String str2, boolean z4, String str3, int i, String str4, RouteDialogInfo routeDialogInfo2) {
        this.title = str;
        this.isSticky = z2;
        this.cta = str2;
        this.ctaVisbility = z4;
        this.imageUrl = str3;
        this.style = i;
        this.ctaAction = str4;
        this.isVisible = z;
        this.isImageVisible = z3;
        this.routeDialogInfo = routeDialogInfo2;
    }

    public String getCta() {
        return this.cta;
    }

    public String getCtaAction() {
        return this.ctaAction;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public RouteDialogInfo getRouteDialogInfo() {
        return this.routeDialogInfo;
    }

    public int getStyle() {
        return this.style;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCtaVisbility() {
        return this.ctaVisbility;
    }

    public int isDisruption() {
        return this.isDisruption;
    }

    public boolean isImageVisible() {
        return this.isImageVisible;
    }

    public boolean isSticky() {
        return this.isSticky;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setIsDisruption(int i) {
        this.isDisruption = i;
    }
}
