package seedu.duke.command;

import seedu.duke.exception.DukeException;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;
import java.util.ArrayList;
import java.util.Arrays;

import seedu.duke.task.Event;

public class CompareCommand extends Command {

    public CompareCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser) throws DukeException {

        ArrayList<Integer> outputArray = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19,20,21,22,23));

        if (nowUser != null) {
            String[] parsedInputs = input.split(" /", 3);
            String targetName = parsedInputs[0].substring(1);
            String date = parsedInputs[1];
            ArrayList<Event> nowUserTimetable;
            ArrayList<Event> targetUserTimetable;

            User targetUser = users.getUserByName(targetName);

            if (targetUser == null) {
                throw new DukeException("No such user!");
            }

            switch (date) {
            case "mon":
                nowUserTimetable = nowUser.getTimetable().getTimetable("mon");
                targetUserTimetable = targetUser.getTimetable().getTimetable("mon");
                break;
            case "tue":
                nowUserTimetable = nowUser.getTimetable().getTimetable("tue");
                targetUserTimetable = targetUser.getTimetable().getTimetable("tue");
                break;
            case "wed":
                nowUserTimetable = nowUser.getTimetable().getTimetable("wed");
                targetUserTimetable = targetUser.getTimetable().getTimetable("wed");
                break;
            case "thu":
                nowUserTimetable = nowUser.getTimetable().getTimetable("thu");
                targetUserTimetable = targetUser.getTimetable().getTimetable("thu");
                break;
            case "fri":
                nowUserTimetable = nowUser.getTimetable().getTimetable("fri");
                targetUserTimetable = targetUser.getTimetable().getTimetable("fri");
                break;
            case "sat":
                nowUserTimetable = nowUser.getTimetable().getTimetable("sat");
                targetUserTimetable = targetUser.getTimetable().getTimetable("sat");
                break;
            case "sun":
                nowUserTimetable = nowUser.getTimetable().getTimetable("sun");
                targetUserTimetable = targetUser.getTimetable().getTimetable("sun");
                break;
            default:
                throw new DukeException("Sorry! I don't know what day you mean :-(");
            }

            /**
             * Compare targetUser and nowUser Timetables (ArrayList<Object>)
             * Assuming for each day of the week, timetable ArrayList<Object> contains only [0:23] timeslots
             * Loop below returns an outputArray that holds the common available hours in that day
             */
            for (Event event : nowUserTimetable) {
                int tempX = (Integer.valueOf(Integer.parseInt(event.getTimeStart().substring(0,2))));
                int tempY = (Integer.valueOf(Integer.parseInt(event.getTimeEnd().substring(0,2))));

                for (int i = tempX; i < tempY + 1; i++) {
                    outputArray.remove(Integer.valueOf(i));
                }
            }

            for (Event event : targetUserTimetable) {
                int tempX = (Integer.valueOf(Integer.parseInt(event.getTimeStart().substring(0,2))));
                int tempY = (Integer.valueOf(Integer.parseInt(event.getTimeEnd().substring(0,2))));

                for (int i = tempX; i < tempY; i++) {
                    outputArray.remove(Integer.valueOf(i));
                }
            }

            ui.printCompare(outputArray);

        }
    }
}