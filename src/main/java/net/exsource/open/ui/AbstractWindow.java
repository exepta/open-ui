package net.exsource.open.ui;

import net.exsource.openlogger.Logger;
import org.lwjgl.opengl.GLCapabilities;

import java.util.concurrent.CountDownLatch;

public abstract class AbstractWindow {

    private final Logger logger = Logger.getLogger();

    /*
     * ===============================================
     *                    System
     * ===============================================
     */
    private final CountDownLatch await;
    private final Thread thread;
    private final String uid;
    protected Context context;

    public AbstractWindow() {
        this(null);
    }

    public AbstractWindow(String uid) {
        this.await = new CountDownLatch(1);
        this.uid = uid; //FIXME: Let the utils UID.class generate this
        //Todo: call the handler if the thread limit is reached.
        this.thread = new Thread(this::run, uid);
        thread.start();
    }

    public String getUid() {
        return uid;
    }

    public Thread getThread() {
        return thread;
    }

    public Context getContext() {
        return context;
    }

    protected void _await() {
        try {
            await.wait();
        } catch (InterruptedException ignored) { }
    }

    protected void run() {

    }

    private record Context(long id, long nvg, GLCapabilities capabilities) { }

}
