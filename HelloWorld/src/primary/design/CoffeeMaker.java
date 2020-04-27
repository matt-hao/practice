package primary.design;

/**
 * 设计一个自动咖啡机，加入一袋咖啡包，简单地煮一杯咖啡。
 * <p>
 * 每个咖啡包包含有咖啡的配方，如加入了多少牛奶，或加入了多少糖
 * 咖啡机可根据咖啡包提供的配方制作咖啡
 * 只考虑两种成分成分：糖（sugar）和牛奶（milk）
 * 普通咖啡的成本是2元。 加入一份牛奶或糖会使成本增加0.5元
 * 考虑使用Decorator Design Pattern
 */
public class CoffeeMaker {
    public void makeCoffee(CoffeePack coffeePack) {
        Coffee coffee = new SimpleCoffee();
        for (int i = 0; i < coffeePack.getMilk(); i++) {
            coffee = new WithMilk(coffee);
        }

        for (int i = 0; i < coffeePack.getSugar(); i++) {
            coffee = new WithSugar(coffee);
        }

        System.out.println(coffee.getCost());
        System.out.println(coffee.getIngredient());
    }

    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeCoffee(new CoffeePack(10, 1));
    }
}

class CoffeePack {
    private int milk;
    private int sugar;

    CoffeePack(int milk, int sugar) {
        this.milk = milk;
        this.sugar = sugar;
    }

    public int getMilk() {
        return milk;
    }

    public int getSugar() {
        return sugar;
    }
}

interface Coffee {
    double getCost();

    String getIngredient();
}

class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 2;
    }

    @Override
    public String getIngredient() {
        return "Plain Coffee";
    }
}

abstract class DecorateCoffee implements Coffee {
    private Coffee coffee;

    DecorateCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getIngredient() {
        return coffee.getIngredient();
    }
}

class WithMilk extends DecorateCoffee {

    WithMilk(Coffee coffee) {
        super(coffee);
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

class WithSugar extends DecorateCoffee {

    WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", Sugar";
    }
}