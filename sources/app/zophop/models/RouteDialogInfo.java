package app.zophop.models;

public class RouteDialogInfo {
    private final String cta;
    private final String ctaTitle;
    private final String imageUrl;
    private final boolean isVisible;
    private final String subtitle;
    private final String title;

    public RouteDialogInfo(boolean z, String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.subtitle = str2;
        this.ctaTitle = str3;
        this.cta = str4;
        this.imageUrl = str5;
        this.isVisible = z;
    }

    public String getCta() {
        return this.cta;
    }

    public String getCtaTitle() {
        return this.ctaTitle;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isVisible() {
        return this.isVisible;
    }
}
