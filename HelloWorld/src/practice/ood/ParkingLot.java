package practice.ood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 498. Parking Lot
 * 中文English
 * Design a parking lot.
 * <p>
 * see CC150 OO Design for details.
 * <p>
 * n levels, each level has m rows of spots and each row has k spots.So each level has m x k spots.
 * The parking lot can park motorcycles, cars and buses
 * The parking lot has motorcycle spots, compact spots, and large spots
 * Each row, motorcycle spots id is in range [0,k/4)(0 is included, k/4 is not included), compact spots id is in range [k/4,k/4*3)(k/4*3 is not included) and large spots id is in range [k/4*3,k)(k is not included).
 * A motorcycle can park in any spot
 * A car park in single compact spot or large spot
 * A bus can park in five large spots that are consecutive and within same row. it can not park in small spots
 */

// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    protected VehicleSize vehicleSize;
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle() {
        this.vehicleSize = VehicleSize.Motorcycle;
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car() {
        this.vehicleSize = VehicleSize.Compact;
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus() {
        this.vehicleSize = VehicleSize.Large;
    }
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
    private int m;
    private int k;
    private Spot[][] spots;

    public Level(int m, int k) {
        this.m = m;
        this.k = k;
        this.spots = new Spot[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                spots[i][j] = new Spot(this);
            }
        }
    }

    public List<Spot> findAvailableSpots(Vehicle vehicle) {
        //todo....
        switch (vehicle.vehicleSize) {
            case Motorcycle:
                return findAvailableSpotsForMoto();
            case Compact:
                return findAvailableSpotsForCom();
            case Large:
                return findAvaibleSpotsForLarge();
            default:
                return new ArrayList<>();
        }
    }

    private List<Spot> findAvailableSpotsForMoto() {
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.k; j++) {
                if (!this.spots[i][j].getAvailable())
                    continue;
                spots.add(this.spots[i][j]);
                return spots;
            }
        }
        return spots;
    }

    private List<Spot> findAvailableSpotsForCom() {
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < this.m; i++) {
            for (int j = this.k / 4; j < this.k; j++) {
                if (!this.spots[i][j].getAvailable())
                    continue;
                spots.add(this.spots[i][j]);
                return spots;
            }
        }
        return spots;
    }

    private List<Spot> findAvaibleSpotsForLarge() {
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < this.m; i++) {
            for (int j = this.k / 4 * 3; j < this.k; ) {
                if (!this.spots[i][j].getAvailable()) {
                    j++;
                    continue;
                }

                if (this.k - j <= 5) break;

                int h = j;
                for (; h < j + 5; h++) {
                    if (!this.spots[i][h].getAvailable()) break;
                }

                if (h != j + 5) {
                    j = h + 1;
                    continue;
                } else {
                    for (h = j; h < j + 5; h++) {
                        spots.add(this.spots[i][h]);
                    }
                    return spots;
                }
            }
        }
        return spots;
    }

    public void parkVehicle(List<Spot> spots, Vehicle vehicle) {
        for (Spot s : spots) {
            s.takeSpot(vehicle);
        }
    }

    public void setSpots(Spot[][] spots) {
        this.spots = spots;
    }

    public Spot[][] getSpots() {
        return this.spots;
    }
}

class Spot {
    private boolean available;
    private Vehicle vehicle;
    private Level level;

    public Spot() {
    }

    public Spot(Level level) {
        this.level = level;
        this.available = true;
    }

    public void takeSpot(Vehicle vehicle) {
        this.setVehicle(vehicle);
        this.setAvailable(false);
    }

    public void clearSpot() {
        this.setVehicle(null);
        this.setAvailable(true);
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }
}

public class ParkingLot {

    private List<Level> levels;

    private Map<Vehicle, List<Spot>> map;

    private static volatile ParkingLot INSTANCE;

    public ParkingLot getINSTANCE(int n, int num_rows, int spots_per_row) {
        if (INSTANCE == null) {
            synchronized (ParkingLot.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ParkingLot(n, num_rows, spots_per_row);
                }
            }
        }
        return INSTANCE;
    }

    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    private ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        this.levels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            levels.add(new Level(num_rows, spots_per_row));
        }
        this.map = new HashMap<>();
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        if (vehicle == null) return false;
        for (Level level : levels) {
            List<Spot> spots = level.findAvailableSpots(vehicle);
            if (spots == null || spots.size() == 0) continue;

            level.parkVehicle(spots, vehicle);
            map.put(vehicle, spots);
            return true;
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        if (vehicle == null || !map.containsKey(vehicle)) return;
        for (Spot s : map.get(vehicle)) {
            s.clearSpot();
        }
        map.remove(vehicle);
    }
}