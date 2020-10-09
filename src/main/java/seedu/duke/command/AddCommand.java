package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.Event;
import seedu.duke.task.TaskList;
import seedu.duke.timetable.Timetable;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

/**
 * Adds an event to the task list.
 */
public class AddCommand extends Command {

    public AddCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        //Lec /day /time /location
        if (nowUser != null) {
            String[] parsedInputs = input.split(" /", 4);
            String[] timeInputs = parsedInputs[2].split("-", 2);

            String date = parsedInputs[1];

            for (int i = 0; i < users.getTotalUserCount(); i++) {
                if ((users.getUser(i + 1).getName() == nowUser.getName())) {
                    Event newEvent = new Event(parsedInputs[0], parsedInputs[3], timeInputs[0], timeInputs[1]);
                    ui.printEvent(newEvent, date);
                    switch (date) {
                    case "mon":
                        (users.getUser(i + 1).getTimetable()).getMonTimetable().add(newEvent);
                        break;
                    case "tue":
                        (users.getUser(i + 1).getTimetable()).getTueTimetable().add(newEvent);
                        break;
                    case "wed":
                        (users.getUser(i + 1).getTimetable()).getWedTimetable().add(newEvent);
                        break;
                    case "thu":
                        (users.getUser(i + 1).getTimetable()).getThuTimetable().add(newEvent);;
                        break;
                    case "fri":
                        (users.getUser(i + 1).getTimetable()).getFriTimetable().add(newEvent);
                        break;
                    case "sat":
                        (users.getUser(i + 1).getTimetable()).getSatTimetable().add(newEvent);
                        break;
                    case "sun":
                        (users.getUser(i + 1).getTimetable()).getSunTimetable().add(newEvent);
                        break;
                    default:
                        throw new DukeException("Sorry! I don't know what day you mean :-(");
                    }
                }
            }
            //((Timetable) currentUser.getTimetable())
            //tasks.addTask(newTask);
            //ui.printEvent(newEvent, date);
            //storage.write(tasks);
        } else {
            throw new DukeException("Sorry! You are not Logged in to any account :-(");
        }
    }
}