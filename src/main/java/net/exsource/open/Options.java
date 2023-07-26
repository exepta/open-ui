package net.exsource.open;

import net.exsource.open.enums.Logic;
import org.jetbrains.annotations.NotNull;

public final class Options {

    private Logic logic;
    private String openglVersion;
    private int nanoVGVersion;

    public Options() {
        this.logic = Logic.THREADED;
        this.openglVersion = "4.6";
        this.nanoVGVersion = 3;
    }

    public void setLogic(@NotNull String logic) {
        this.setLogic(Logic.get(logic));
    }

    public void setLogic(@NotNull Logic logic) {
        this.logic = logic;
    }

    public void setOpenglVersion(String openglVersion) {
        this.openglVersion = openglVersion;
    }

    public void setNanoVGVersion(int nanoVGVersion) {
        this.nanoVGVersion = nanoVGVersion;
    }

    public Logic getLogic() {
        return logic;
    }

    public String getOpenglVersion() {
        return openglVersion;
    }

    public int getNanoVGVersion() {
        return nanoVGVersion;
    }
}
