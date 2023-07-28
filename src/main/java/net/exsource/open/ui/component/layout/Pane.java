package net.exsource.open.ui.component.layout;

import net.exsource.open.ui.style.generic.Background;
import net.exsource.openutils.enums.Colors;
import net.exsource.openutils.tools.Color;

/**
 * @since 1.0.0
 * @author Daniel Ramke
 */
public class Pane extends Layout {

    public Pane() {
        this(null);
    }

    public Pane(String localizedName) {
        super(localizedName);
        this.setSize(200, 200);
        getStyle().setBackground(Background.get(Color.named(Colors.LIGHTGRAY)));
    }

    @Override
    protected void logic() {

    }
}
