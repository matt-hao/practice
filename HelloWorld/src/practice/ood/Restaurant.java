package practice.ood;

import java.util.*;

/**
 * 1.clarify:
 * 1. reservation?
 * 2. shared?
 * 3. different table?
 */
class Restaurant {
    private List<Table> tables;
    private List<Meal> menu;
    private Map<Table, List<TimePeriod>> reservation;

    public Table findTable(Party party) {
        //
        //table.markUnavailable();
        return null;
    }

    private void clearTable(Table table) {
        table.markAvailable();
    }

    public void checkOut(Table table) {
        table.getOrder().calPrices();
        this.clearTable(table);
    }

    public Reservation findTableForReservation(TimePeriod t) {
        return null;
    }

    public void confirmReservation(Reservation r) {
    }
}

class Reservation {
    TimePeriod time;
    Table table;
    Party party;
}

class TimePeriod {
    Date time;
}

class Party {
    int capacity;
}

class Table {
    private int capacity;
    private boolean isAvailable;
    private Order order;

    public void markUnavailable() {
        isAvailable = false;
    }

    public void markAvailable() {
        isAvailable = true;
    }

    public Order getOrder() {
        return this.order;
    }
}

class Order {
    private Party party;
    private Table table;
    private List<Meal> meals;

    public double calPrices() {
        double r = 0;
        for (Meal m : meals) {
            r += m.getPrice();
        }
        return r;
    }
}

class Meal {
    private double price;

    public double getPrice() {
        return this.price;
    }
}
