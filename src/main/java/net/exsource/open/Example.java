package net.exsource.open;

import net.exsource.open.ui.windows.Window;

public class Example {

    public static void main(String[] args) {
        OpenUI.launch(args);
        Window window = UIFactory.createWindow(Window.class);
    }

}
