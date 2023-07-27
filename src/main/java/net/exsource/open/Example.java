package net.exsource.open;

import net.exsource.open.ui.component.shapes.Rectangle;
import net.exsource.open.ui.style.generic.Background;
import net.exsource.open.ui.windows.Window;
import net.exsource.openlogger.Logger;
import net.exsource.openutils.enums.Colors;
import net.exsource.openutils.tools.Color;

public class Example {

    private static final Logger logger = Logger.getLogger();

    public static void main(String[] args) {
        OpenUI.launch(args);
        Window window = UIFactory.createWindow(Window.class);
        Rectangle rectangle = new Rectangle(null);
        rectangle.getStyle().setBackground(Background.get(Color.named(Colors.AQUA)));
        window.addComponent(rectangle);
    }

}
