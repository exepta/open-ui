package net.exsource.open.ui;

import net.exsource.open.ErrorHandler;
import net.exsource.open.OpenUI;
import net.exsource.openlogger.Logger;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.nanovg.NanoVGGL2;
import org.lwjgl.nanovg.NanoVGGL3;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLCapabilities;

import java.util.concurrent.CountDownLatch;

import static org.lwjgl.system.MemoryUtil.NULL;

public abstract class AbstractWindow {

    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

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

    /*
     * ===============================================
     *                   Properties
     * ===============================================
     */
    protected String title;
    protected int width;
    protected int height;

    /*
     * ===============================================
     *                    Checks
     * ===============================================
     */
    protected boolean created;
    protected boolean primary;
    protected boolean resizeable;
    protected boolean vsync;

    public AbstractWindow() {
        this(null);
    }

    public AbstractWindow(String uid) {
        this.await = new CountDownLatch(1);
        this.uid = uid; //FIXME: Let the utils UID.class generate this
        this.title = getClass().getSimpleName();
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.vsync = false;
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

    protected void generate() {
        logger.info("Generate window " + uid + "...");
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
        long openglID = GLFW.glfwCreateWindow(width, height, title, NULL, NULL);
        if(openglID == NULL) {
            logger.fatal("There was a window [ " + uid + " ] which broke the generation...");
            ErrorHandler.handle(ErrorHandler.Code.WINDOW_GENERATION_FAILED);
            return;
        }

        //Todo: callbacks, renderers.
        GLFW.glfwMakeContextCurrent(openglID);
        GLFW.glfwSwapInterval(vsync ? 1 : 0);
        logger.info("Step creation was successfully completed!");
        this.created = true;
        this.await.countDown();
        logger.info("Next step Opengl injection...");

        GLCapabilities capabilities = GL.createCapabilities();
        long nvg;
        if(OpenUI.getOptions().getNanoVGVersion() == 3) {
            nvg = NanoVGGL3.nvgCreate(NanoVGGL3.NVG_STENCIL_STROKES | NanoVGGL3.NVG_ANTIALIAS);
        } else {
            nvg = NanoVGGL2.nvgCreate(NanoVGGL2.NVG_STENCIL_STROKES | NanoVGGL2.NVG_ANTIALIAS);
        }

        this.context = new Context(openglID, nvg, capabilities);
        logger.info("Step Opengl injection successfully completed!");
        //Todo: print graphics information
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_SCISSOR_TEST);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    private record Context(long id, long nvg, GLCapabilities capabilities) { }

}
