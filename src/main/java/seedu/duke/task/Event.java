package seedu.duke.task;

public class Event extends Task {

    //protected String at;

    public Event(String description, String location, String timeStart, String timeEnd) {
        super(description, location, timeStart, timeEnd);

        //this.at = at;
        //setTaskType("E");
    }

    /*public String getAt() {
        //return at;
    }*/

    @Override
    public String toString() {
        return description + " " + location + " "  + " " + timeStart + "-" + timeEnd;
    }
}
