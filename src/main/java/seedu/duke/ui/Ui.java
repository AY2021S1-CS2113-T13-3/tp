package seedu.duke.ui;

//import seedu.duke.task.Deadline;
import seedu.duke.task.Event;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.user.User;

import java.util.Scanner;

/**
 * Prints relevant messages to user based on user interaction.
 */
public class Ui {
    private static final String MESSAGE_LINE = "____________________________________________________________";
    private static final String MESSAGE_SAD_FACE = ":(";
    private static final String MESSAGE_LOGO = " _    _ _                   _____       _ _____ _                \n"
            + "| |  | | |                 |  __ \\     | |_   _(_)               \n"
            + "| |  | | |__   ___ _ __ ___| |  \\/ ___ | |_| |  _ _ __ ___   ___ \n"
            + "| |/\\| | '_ \\ / _ \\ '__/ _ \\ | __ / _ \\| __| | | | '_ ` _ \\ / _ \\\n"
            + "\\  /\\  / | | |  __/ | |  __/ |_\\ \\ (_) | |_| | | | | | | | |  __/\n"
            + " \\/  \\/|_| |_|\\___|_|  \\___|\\____/\\___/ \\__\\_/ |_|_| |_| |_|\\___|\n"
            + "                                                                 \n";
    private static final String MESSAGE_GREETINGS = "\n" + MESSAGE_LOGO + "Hello! Welcome to WhereGotTime!\n"
            + "Please enter your time table details.\nYou may refer to the User Guide for instructions.\n";

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prints a horizontal divider line.
     */
    public void showLine() {
        System.out.println(MESSAGE_LINE);
    }

    /**
     * Reads user inputs.
     *
     * @return String the inputs provided by users, where leading and trailing spaces are trimmed.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Prints welcome message.
     */
    public void showWelcome() {
        System.out.println(MESSAGE_LINE + MESSAGE_GREETINGS + MESSAGE_LINE);
    }

    /**
     * Prints out all tasks saved in the array list.
     *
     * @param taskList the array list to print.
     */
    public void printList(TaskList taskList) {
        if (taskList.getTotalTaskCount() > 0) {
            System.out.println("Here are all the classes in your time table: ");
            int count = 1;
            for (Task t : taskList.getTaskList()) {
                System.out.println(count + ". " + t);
                count++;
            }
        } else {
            System.out.println("There is no class in your time table! Consider adding one?");
        }
    }

    /**
     * Prints out the deadline task given by the user.
     *
     * @param taskList the array list of tasks.
     * @param task the task to be added to the array list.
     */
    /*public void printDeadline(TaskList taskList, Deadline task) {
        System.out.println("Got it! I've added the following deadline in the list:\n" + task);
        System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }*/

    /**
     * Prints out the event task given by the user.
     *
     * @param event the task to be added to the array list.
     */
    public void printEvent(Event event, String date) {
        System.out.println("Got it! I've added the following event in " + date + "\n" + event);
        //System.out.println("Now now have " + taskList.getTotalTaskCount() + " tasks in the list.");
    }

    public void printDone(Task task) {

        System.out.println("Nice! I have marked this task as done:\n" + task);
    }

    /**
     * Prints out the task that has been deleted.
     *
     * @param taskList the array list of tasks.
     * @param task the task that has been deleted.
     */
    public void printDelete(TaskList taskList, Task task) {
        System.out.println("Noted. I have removed this class from your time table:\n" + task);
        System.out.println("Now you have " + taskList.getTotalTaskCount() + " class(es) in the time table.");
    }

    /**
     * Prints all result(s) that matches the search keyword.
     *
     * @param taskList the array list that contains the keyword.
     * @param keyword the word that the user searches.
     */
    public void printFind(TaskList taskList, String keyword) {
        if (taskList.getTotalTaskCount() > 0) {
            System.out.println("Here are the class(es) in your time table "
                    + "that matches the keyword \"" + keyword + "\":");
            int count = 1;
            for (Task t : taskList.getTaskList()) {
                System.out.println(count + ". " + t);
                count++;
            }
        } else {
            System.out.println("No class of yours contains the keyword \"" + keyword + "\".");
        }
    }

    /**
     * Prints farewell message.
     */
    public void showBye() {
        System.out.println("Thanks for using WhereGotTime. Hope to see you again soon!");
    }

    public void greetUser(User currentUser) {
        System.out.println("Hello " + currentUser.getName() + "!");
    }

    /**
     * Prints error message.
     *
     * @param message the error message to be printed.
     */
    public void showError(String message) {
        System.out.println(MESSAGE_SAD_FACE + " OOPS!!! " + message);
    }
}
