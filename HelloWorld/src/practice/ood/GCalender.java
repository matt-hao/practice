package practice.ood;

import java.util.List;

/**
 * create event
 * invite user
 * notify users at specific time
 * notify user periodically
 */
public class GCalender {



    class Event {
        int id;
        int createByUserId;
        String title;
        List<User> attendes;
        String strategy;

    }


    class User {
        int id;
        String name;
        String email;
        List<Event> events;
    }
}

