package practice.ood;

public class CoffeeMaker {
    public Coffee brew(CoffeePack pack){
        Coffee c = new SimpleCoffee();
        for (int i = 0; i < pack.getMilkNeeded(); i++){
            c = new CoffeeWithMilk(c);
        }

        for (int i = 0; i < pack.getSugarNeeded(); i++) {
            c = new CoffeeWithSugar(c);
        }
        return c;
    }

    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Coffee res = coffeeMaker.brew(new CoffeePack(2, 3));
        System.out.println(res.getCost());
        System.out.println(res.getIngredient());
    }
}


class  CoffeePack{
    private int milkNeeded;
    private int sugarNeeded;

    public CoffeePack(int milkNeeded, int sugarNeeded) {
        this.milkNeeded = milkNeeded;
        this.sugarNeeded = sugarNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }
    public int getSugarNeeded() {
        return sugarNeeded;
    }
}

interface Coffee{
    double getCost();
    String getIngredient();
}

abstract class CoffeeDecoration implements Coffee{
    Coffee c;

    public CoffeeDecoration(Coffee c) {
        this.c = c;
    }

    @Override
    public double getCost() {
        return c.getCost();
    }

    @Override
    public String getIngredient() {
        return c.getIngredient();
    }
}

class SimpleCoffee implements Coffee{

    @Override
    public double getCost() {
        return 2;
    }

    @Override
    public String getIngredient() {
        return "Original Coffee";
    }
}


class CoffeeWithMilk extends CoffeeDecoration{

    public CoffeeWithMilk(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", Milk";
    }
}

class CoffeeWithSugar extends CoffeeDecoration{

    public CoffeeWithSugar(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", Sugar";
    }
}