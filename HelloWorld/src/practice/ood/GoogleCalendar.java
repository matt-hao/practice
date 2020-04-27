package practice.ood;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 http://www.mitbbs.com/article_t1/JobHunting/32635005_0_1.html
 https://www.jiuzhang.com/qa/3498/
 : new
 : invite
 : display
 : modify
 : notify
 : delete

 create event
 invite user
 notify users at specific time
 notify user periodically
 */
class GoogleCalendar{
    List<Calendar> calendars;
    Map<User, Calendar> map;

    Calendar getCalendarByUser(User user){
        return map.get(user);
    }
}

class Calendar{
    private List<Event> events;
    private User user;

    public List<Event> display(){
        return this.events;
    }

    public Event createEvent(Event event){
        this.events.add(event);
        return event;
    }

    public boolean removeEvent(Event event){
        return this.events.remove(event);
    }


    public boolean inviteUser(Event e, List<User> users){
        for(User u: users) e.invite(u);
        return true;
    }

    public boolean notify(Event e){
        return e.notifyUser();
    }
}

class Event{
    Calendar calendar;

    //basic info
    String title;
    String location;
    String description;

    User organizer;
    List<User> sharedUsers;

    //true: public
    //false: private
    boolean visibility;

    //notification strategy: day, week, month
    String strategy;
    Date nextNotifyTime;

    // 1-modify event
    // 2-invite others
    // 3-see guest list
    // 1 + "/" + 2
    String permission;

    Date startTime;
    Date endTime;

    public boolean invite(User user){
        // consider removing duplicate
        user.getCalendar().createEvent(this);
        return this.sharedUsers.add(user);
    }

    public boolean notifyUser(){
        //change nextNextNotifyTime
        return true;
    }
}

class User{
    private int id;
    private String name;
    private String email;

    private Calendar calendar;

    public Calendar getCalendar(){return this.calendar;}
}
