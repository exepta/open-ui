package net.exsource.open.enums;

import org.jetbrains.annotations.NotNull;

public enum Logic {

    THREADED,
    SINGLE,
    MULTI_RENDERERS,
    POOLS;

    public static Logic get(@NotNull String name) {
        Logic logic = THREADED;
        for(Logic value : values()) {
            if(value.name().equalsIgnoreCase(name)) {
                logic = value;
                break;
            }
        }
        return logic;
    }
}
