package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private final List<TimeEntry> timeEntryList = new ArrayList<>();
    private long id = 1L;
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newTimeEntry = new TimeEntry(id++, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryList.add(newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(long id) {
        for (TimeEntry timeEntry: timeEntryList) {
            if(timeEntry.getId()==id){
                return timeEntry;
            }
        }
        return null;
    }


    public TimeEntry update(long id, TimeEntry timeEntry) {
        for (int i = 0; i < timeEntryList.size(); i++) {
            if(timeEntryList.get(i).getId()==id){
                timeEntry.setId(id);
                timeEntryList.set(i, timeEntry);
                return timeEntryList.get(i);
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < timeEntryList.size(); i++) {
            if(timeEntryList.get(i).getId()==id){
                timeEntryList.remove(i);
            }
        }
    }

    public List<TimeEntry> list() {
        return timeEntryList;
    }

}
