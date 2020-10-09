package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
//import seedu.duke.task.Event;
//import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

/**
 * Adds an event to the task list.
 */
public class LogInCommand extends Command {

    public LogInCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        String[] parsedInputs = input.split(" /", 2);
        User newUser = new User(parsedInputs[0], parsedInputs[1]);
        currentUser = newUser;
        users.addUser(newUser);
        ui.greetUser(newUser);
        isLogIn = true;


        //storage.write(tasks);
    }
}
