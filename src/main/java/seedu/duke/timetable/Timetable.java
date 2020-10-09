package seedu.duke.timetable;

import seedu.duke.task.Event;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
    protected ArrayList<Object> monTimetable;
    protected ArrayList<Object> tueTimetable;
    protected ArrayList<Object> wedTimetable;
    protected ArrayList<Object> thuTimetable;
    protected ArrayList<Object> friTimetable;
    protected ArrayList<Object> satTimetable;
    protected ArrayList<Object> sunTimetable;

    public Timetable() {
        this.monTimetable = new ArrayList<>();
        this.tueTimetable = new ArrayList<>();
        this.wedTimetable = new ArrayList<>();
        this.thuTimetable = new ArrayList<>();
        this.friTimetable = new ArrayList<>();
        this.satTimetable = new ArrayList<>();
        this.sunTimetable = new ArrayList<>();
    }

    public ArrayList<Object> getMonTimetable() {
        return monTimetable;
    }

    public ArrayList<Object> getTueTimetable() {
        return tueTimetable;
    }

    public ArrayList<Object> getWedTimetable() {
        return wedTimetable;
    }

    public ArrayList<Object> getThuTimetable() {
        return thuTimetable;
    }

    public ArrayList<Object> getFriTimetable() {
        return friTimetable;
    }

    public ArrayList<Object> getSatTimetable() {
        return satTimetable;
    }

    public ArrayList<Object> getSunTimetable() {
        return sunTimetable;
    }


}