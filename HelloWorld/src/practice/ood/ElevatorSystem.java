package practice.ood;

import java.util.List;
import java.util.Random;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void handleExternalReq(Request request) {
        strategy.execute(request, elevators);
    }
}

class Elevator {
    private Status status;
    private int level;
    private int limit;
    private List<Button> buttons;
    private List<Boolean> up;
    private List<Boolean> down;

    public void handExternalReq(Request request) {
    }

    public void handInternalReq(Request request) {

    }

    private boolean isRequestValid(Request request) {
        return true;
    }

    private int getWeight() {
        return 0;
    }

    public void openGate() {
    }

    public void closeGate() {
    }
}

enum Status {
    IDLE, UP, DOWN
}

interface Strategy {
    public void execute(Request request, List<Elevator> elevators);
}

class RandomStrategy implements Strategy {

    @Override
    public void execute(Request request, List<Elevator> elevators) {
        Random r = new Random();
        if (request instanceof ExternalRequest)
            elevators.get(r.nextInt()).handExternalReq(request);
        else
            elevators.get(r.nextInt()).handInternalReq(request);
    }
}

class Request {
    int level;
    int direction;
}

class ExternalRequest extends Request {

}

class InternalRequest extends Request {

}

class Button{

}