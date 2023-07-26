package net.exsource.open.ui;

/**
 * Interface which let {@link Class} implements resize functions.
 * Note that this interface is used by {@link AbstractWindow} and {@link Component} class.
 * If you build your own components or window system than make sure you use this interface
 * because its can help.
 * @since 1.0.0
 * @author Daniel Ramke
 */
public interface ResizeAble {

    /**
     * Function to change the current state of resizeable ability of a component.
     * @param resizeable the state of resizeable.
     */
    void setResizeable(boolean resizeable);

    /**
     * @return {@link Boolean} - true if the object resizable.
     */
    boolean isResizeAble();

}
