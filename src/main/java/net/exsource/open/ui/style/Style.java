package net.exsource.open.ui.style;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.exsource.open.ui.style.generic.Background;
import net.exsource.openutils.enums.Colors;
import net.exsource.openutils.math.Insets;
import net.exsource.openutils.tools.Color;

@Getter
@Setter
@Builder
public class Style {

    @Builder.Default
    private int zIndex = 0;

    @Builder.Default
    private Background background = Background.get(Color.named(Colors.AQUA));

    @Builder.Default
    private Color forgroundColor = Color.named(Colors.BLACK);

    @Builder.Default
    private Insets padding = new Insets(0);

    @Builder.Default
    private Insets margin = new Insets(0);

    @Builder.Default
    private String position = "relative";

}
