package net.exsource.open.ui.component.layout;

import net.exsource.open.ui.component.Component;

/**
 * @since 1.0.0
 * @author Daniel Ramke
 */
public abstract class Layout extends Component {

    protected boolean updated;

    public Layout(String localizedName) {
        super(localizedName);
        this.updated = false;
    }

    protected abstract void logic();

    public void update() {
        logic();
        updated = true;
    }

    public boolean isUpdated() {
        return updated;
    }
}
