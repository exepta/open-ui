package net.exsource.open;

import net.exsource.open.ui.component.layout.Pane;
import net.exsource.open.ui.component.shapes.Rectangle;
import net.exsource.open.ui.windows.Window;
import net.exsource.openlogger.Logger;
public class Example {

    private static final Logger logger = Logger.getLogger();

    public static void main(String[] args) {
        Logger.enableDebug(true);
        OpenUI.launch(args);
        Window window = UIFactory.createWindow(Window.class);

        Pane pane = new Pane();
        window.addComponent(pane);

        Rectangle rectangle = new Rectangle(null);
        rectangle.setSize(50);
        pane.addChild(rectangle);
    }

}
