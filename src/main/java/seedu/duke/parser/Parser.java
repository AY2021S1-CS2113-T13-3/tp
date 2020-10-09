package seedu.duke.parser;

import seedu.duke.command.AddCommand;
import seedu.duke.command.ByeCommand;
import seedu.duke.command.Command;
//import seedu.duke.command.DeleteCommand;
//import seedu.duke.command.DoneCommand;
//import seedu.duke.command.EventCommand;
//import seedu.duke.command.FindCommand;
//import seedu.duke.command.ListCommand;
import seedu.duke.command.LogInCommand;
import seedu.duke.exception.DukeException;

/**
 * Parses the user's input.
 */
public class Parser {
    //private static final String COMMAND_DEADLINE = "deadline";
    //private static final String COMMAND_EVENT = "event";
    //private static final String COMMAND_LIST = "list";
    //private static final String COMMAND_DONE = "done";
    //private static final String COMMAND_DELETE = "delete";
    //private static final String COMMAND_FIND = "find";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LOGIN = "login";
    private static final String COMMAND_ADD = "add";


    /**
     * Returns a Command object based on user's string input.
     *
     * @param input user's string input.
     * @return a new Command object based on user's input.
     * @throws DukeException if user's input does not match any of the command.
     */
    public static Command parse(String input) throws DukeException {
        String[] parsedInputs = input.split(" ", 2);
        switch (parsedInputs[0]) {
        /*case COMMAND_DEADLINE:
            checkDeadlineValidity(parsedInputs);
            return new DeadlineCommand(parsedInputs[1]);
        case COMMAND_EVENT:
            checkEventValidity(parsedInputs);
            return new EventCommand(parsedInputs[1]);*/
        /*case COMMAND_LIST:
            return new ListCommand();*/
        /*case COMMAND_DONE:
            checkTaskIndexValidity(parsedInputs);
            return new DoneCommand(parsedInputs[1]);*/
        /*case COMMAND_DELETE:
            checkTaskIndexValidity(parsedInputs);
            return new DeleteCommand(parsedInputs[1]);
        case COMMAND_FIND:
            verifyFind(parsedInputs);
            return new FindCommand(parsedInputs[1]);*/
        case COMMAND_LOGIN:
            checkLogInValidity(parsedInputs);
            return new LogInCommand(parsedInputs[1]);
        case COMMAND_ADD:
            checkAddValidity(parsedInputs);
            return new AddCommand(parsedInputs[1]);
        case COMMAND_BYE:
            return new ByeCommand();
        default:
            throw new DukeException("Sorry! I don't know what that means :-(");
        }
    }

    private static void checkAddValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your add command!");
        } else if (!input[1].contains("/")) {
            throw new DukeException("An add command needs to be in a 'name /day /time /location' format!");
        }
        String[] position = input[1].split(" /",4);
        if (position[0].isEmpty()) {
            throw new DukeException("There is no name in your add command!");
        } else if (position[1].isEmpty()) {
            throw new DukeException("There is no day in your add command!");
        } else if (position[2].isEmpty()) {
            throw new DukeException("There is no time in your add command!");
        } else if (position[3].isEmpty()) {
            throw new DukeException("There is no location in your add command!");
        }

    }


    /**
     * Checks the index's validity.
     *
     * @param input user's string input.
     * @throws DukeException if the index is not a number or within valid range.
     */
    private static void checkTaskIndexValidity(String[] input) throws DukeException {
        try {
            Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new DukeException("Please enter the task number you want to mark as done!");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("You've entered an invalid task number!");
        }
    }

    /**
     * Checks the validity of the description for todo.
     *
     * @param input user's string input.
     * @throws DukeException if the description for todo is an empty field.
     */
    private static void checkTodoValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your todo command!");
        }
    }

    /**
     * Checks the validity of the description for deadline.
     *
     * @param input user's string input.
     * @throws DukeException if the description for deadline is an empty field.
     */
    private static void checkDeadlineValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your deadline command!");
        } else if (!input[1].contains("/by")) {
            throw new DukeException("A deadline task requires a '/by' to indicate time frame!");
        }
        int byPosition = input[1].indexOf("/by");
        if (input[1].substring(0, byPosition).isEmpty()) {
            throw new DukeException("There is no description in your deadline command!");
        } else if (input[1].substring(byPosition + 3).isEmpty()) {
            throw new DukeException("Please indicate time frame!");
        }
    }

    /**
     * Checks the validity of the description for event.
     *
     * @param input user's string input.
     * @throws DukeException if the description for event is an empty field.
     */
    private static void checkEventValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your event command!");
        } else if (!input[1].contains("/at")) {
            throw new DukeException("An event task requires an '/at' to indicate location!");
        }
        int atPosition = input[1].indexOf("/at");
        if (input[1].substring(0, atPosition).isEmpty()) {
            throw new DukeException("There is no description in your event command!");
        } else if (input[1].substring(atPosition + 3).isEmpty()) {
            throw new DukeException("An event task requires an '/at' to indicate location!");
        }
    }

    private static void checkLogInValidity(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("There is no description in your login command!");
        } else if (!input[1].contains("/")) {
            throw new DukeException("An login requires an '/' to indicate password!");
        }
        int atPosition = input[1].indexOf("/");
        if (input[1].substring(0, atPosition).isEmpty()) {
            throw new DukeException("There is no username in your login command!");
        } else if (input[1].substring(atPosition + 1).isEmpty()) {
            throw new DukeException("An login requires a password!");
        }
    }

    /**
     * Checks the validity of the KEYWORD for find.
     *
     * @param input user's string input.
     * @throws DukeException if the KEYWORD is an empty field.
     */
    private static void verifyFind(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("Search description is empty");
        }
    }

}
