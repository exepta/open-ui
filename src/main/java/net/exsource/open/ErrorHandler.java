package net.exsource.open;

import net.exsource.openlogger.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.0.0
 * @author Daniel Ramke
 */
public final class ErrorHandler {

    private static final Logger logger = Logger.getLogger();

    /**
     * Function called the {@link #handle(Code)} function and give the id as converted {@link Enum} code.
     * @param code the id of the error this means an {@link Integer} value.
     * @see Code
     */
    public static void handle(int code) {
        handle(Code.get(code));
    }

    /**
     * Function to handle errors, if the error need
     * to stop the execution of the program then call this function.
     * This will call {@link System#exit(int)} and give the current program status.
     * The status is {@link Code#getId()} which is display by the exit command.
     * @param code the code as {@link Enum} from {@link Code} enum.
     */
    public static void handle(@NotNull Code code) {
        if(code.isNeedStop()) {
            System.exit(code.getId());
            return;
        }

        logger.error("Correct handle of error " + code.getId());
        logger.error("Description of " + code.getId() + " - " + code.getDescription());
    }

    /**
     * {@link Enum} to handle error codes easily and human-readable.
     */
    public enum Code {
        UNKNOWN(-1, false, "There was an unexpected error!"),
        NO_MAIN(14136, true, "There was no main located by execution try of OpenUI!"),
        WINDOW_GENERATION_FAILED(2376, true, "There was a generation error by try to generate a new window!"),
        GLFW_INIT(739, true, "There was no glfw context in the current thread or it can't be initialize glfw!");

        private final int id;
        private final boolean needStop;
        private final String description;

        Code(int id, boolean needStop, String description) {
            this.id = id;
            this.needStop = needStop;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public boolean isNeedStop() {
            return needStop;
        }

        public String getDescription() {
            return description;
        }

        public static Code get(int id) {
            Code code = UNKNOWN;
            for(Code codes : values()) {
                if(codes.getId() == id) {
                    code = codes;
                    break;
                }
            }
            return code;
        }
    }

}
