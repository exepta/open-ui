package net.exsource.open;

import net.exsource.open.enums.Errors;
import net.exsource.openlogger.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.0.0
 * @author Daniel Ramke
 */
public final class ErrorHandler {

    private static final Logger logger = Logger.getLogger();

    /**
     * Function called the {@link #handle(Errors)} function and give the id as converted {@link Enum} code.
     * @param code the id of the error this means an {@link Integer} value.
     * @see Errors
     */
    public static void handle(int code) {
        handle(Errors.get(code));
    }

    /**
     * Function to handle errors, if the error need
     * to stop the execution of the program then call this function.
     * This will call {@link System#exit(int)} and give the current program status.
     * The status is {@link Errors#getId()} which is display by the exit command.
     * @param code the code as {@link Enum} from {@link Errors} enum.
     */
    public static void handle(@NotNull Errors code) {
        if(code.isNeedStop()) {
            System.exit(code.getId());
            return;
        }

        logger.error("Correct handle of error " + code.getId());
        logger.error("Description of " + code.getId() + " - " + code.getDescription());
    }

}
