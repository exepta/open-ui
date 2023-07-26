package net.exsource.open.logic;

/**
 * @since 1.0.0
 * @author Daniel Ramke
 */
public enum RenderPriority {

    LOWEST(0),
    LOW(1),
    MEDIUM(2),
    MODERATE(3),
    HIGH(4),
    HIGHEST(5);

    private final int rate;

    RenderPriority(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
