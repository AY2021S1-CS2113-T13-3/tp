package seedu.duke.command;

//import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

/**
 * Terminates Duke program.
 */
public class ByeCommand extends Command {

    public ByeCommand() {
        super(null);
    }

    //@Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) {
        isExit = true;
        ui.showBye();
    }
}
