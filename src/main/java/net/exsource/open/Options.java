package net.exsource.open;

public final class Options {

    private String openglVersion;
    private int nanoVGVersion;

    public Options() {
        this.openglVersion = "4.6";
        this.nanoVGVersion = 3;
    }

    public void setOpenglVersion(String openglVersion) {
        this.openglVersion = openglVersion;
    }

    public void setNanoVGVersion(int nanoVGVersion) {
        this.nanoVGVersion = nanoVGVersion;
    }

    public String getOpenglVersion() {
        return openglVersion;
    }

    public int getNanoVGVersion() {
        return nanoVGVersion;
    }
}
