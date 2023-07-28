package net.exsource.open.ui.component.layout;

import net.exsource.open.logic.renderer.UIRenderer;
import net.exsource.open.ui.UIWindow;
import net.exsource.open.ui.component.Component;

/**
 * Class for default layout functions and indicate as {@link Layout} for the {@link UIRenderer}.
 * This class is really helpful to mark a class as {@link Layout} for the render pipeline.
 * If you need help by creating an own layout so see the docs of our official website.
 * @since 1.0.0
 * @author Daniel Ramke
 */
public abstract class Layout extends Component {

    protected boolean useDefaultLogic;

    /**
     * Constructor to initialize a new {@link Layout} for the extended class.
     * This is a super constructor for your own class to create a new {@link Layout}.
     * @param localizedName the localizedName of your {@link Layout}
     */
    public Layout(String localizedName) {
        super(localizedName);
        this.useDefaultLogic = true;
    }

    /**
     * Function which call your logic in a loop. Note that you not
     * initialize thinks in this function because it is calling in
     * {@link #update()} which is called at {@link UIRenderer#render(UIWindow)} all time.
     */
    protected abstract void logic();

    /**
     * Function for updating the current {@link Layout}.
     * Please don't call this method by your self. This function
     * is already called at {@link UIRenderer#render(UIWindow)} all time.
     */
    public void update() {
        defaultLogic();
        logic();
    }

    /**
     * @return {@link Boolean} - current state if the layout used defaults or not.
     */
    public boolean isUseDefaultLogic() {
        return useDefaultLogic;
    }

    /**
     * Private function to calculate a simple row system as default {@link Layout} func.
     */
    private void defaultLogic() {
        if(useDefaultLogic) {

        }
    }
}
