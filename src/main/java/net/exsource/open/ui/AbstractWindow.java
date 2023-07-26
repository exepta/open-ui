package net.exsource.open.ui;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public abstract class AbstractWindow extends UIWindow {

    public AbstractWindow() {
        super(null);
    }

    public AbstractWindow(String identifier) {
        super(identifier);
    }

    @Override
    protected void initialize() {
        build();
        defaultConfigure();
    }

    @Override
    protected void loop() {
        while (!willClose()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            GL11.glClearColor(background.getPercentRed(), background.getPercentGreen(), background.getPercentBlue(), background.getPercentAlpha());
            calculateViewPort();

            GLFW.glfwSwapBuffers(getOpenglID());
            GLFW.glfwPollEvents();
        }
    }

}
