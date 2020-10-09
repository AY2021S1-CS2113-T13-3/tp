package seedu.duke;

import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.command.LogInCommand;
import seedu.duke.exception.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

//import seedu.duke.storage.Storage;

public class Duke {

    //private Storage storage;
    private TaskList tasks;
    private UserList users;
    private final Ui ui;

    public Duke() {
        ui = new Ui();
        /*try {
            storage = new Storage();
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
        }*/
        users = new UserList();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        User nowUser = null;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(users, ui, nowUser/*, storage*/);

                if (c.isLogIn() == true) {
                    nowUser = c.getCurrentUser();
                }
                //System.out.println(nowUser.getName());
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }



    /**
     * Main entry-point for the java.duke.Duke application.
     */
    /*    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

    }*/
}
