package practice.ood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.type of vending machine: color, size, weight, manufacture, etc.
 * 2.type payment method? credit card, paper money, coins
 * 3.type of items? beverage, food, snacks?
 * 4.what if the items are sold out? Do we need to consider refill the vending machine?
 * 5.consider cancel transaction?
 */
public class VendingMachine {
    private Map<Coin, Integer> coinsMap;
    private Map<String, Item> itemMap;
    private Map<Coin, Integer> curMoney;
    private List<Item> curItem;
    private State curState;

    private NoInsertNoSelect noInsertNoSelect;
    private HasInsertNoSelect hasInsertNoSelect;
    private NoInsertHasSelect noInsertHasSelect;
    private HasInsertHasSelect hasInsertHasSelect;
    private CancelTrans cancelTrans;

    private void initialState() {
        noInsertNoSelect = new NoInsertNoSelect(this);
        hasInsertHasSelect = new HasInsertHasSelect(this);
        noInsertHasSelect = new NoInsertHasSelect(this);
        hasInsertHasSelect = new HasInsertHasSelect(this);
        cancelTrans = new CancelTrans(this);
    }

    public void transferToNINS() {
        this.curState = this.noInsertNoSelect;
    }

    public void transferToHIHS() {
        this.curState = this.hasInsertHasSelect;
    }

    public void transferToNIHS() {
        this.curState = this.noInsertHasSelect;
    }

    public void transferToHINS() {
        this.curState = this.hasInsertNoSelect;
    }

    private VendingMachine(Map<Coin, Integer> coinsMap, Map<String, Item> itemMap) {
        this.coinsMap = coinsMap;
        this.itemMap = itemMap;
        this.curMoney = new HashMap<>();

        initialState();
        curState = this.noInsertNoSelect;
    }

    private static volatile VendingMachine INSTANCE;

    public static VendingMachine getINSTANCE(Map<Coin, Integer> coinsMap, Map<String, Item> itemMap) {
        if (INSTANCE == null) {
            synchronized (VendingMachine.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VendingMachine(coinsMap, itemMap);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @description insert coins
     */
    public void insertCoins(Map<Coin, Integer> coins) throws Exception {
        this.coinsMap = coins;
        this.curState.insertCoins(coins);
    }

    /**
     * @param items
     * @return
     * @description select the items which you want to buy
     */
    public List<Item> selectItem(String items) throws Exception {
        return this.curState.selectItem(items);
    }


    /**
     * @param items
     * @return
     * @description finish the trasanction
     */
    public Pair executeTrans(List<Item> items) throws Exception {
        return this.curState.executeTrans(items);
    }

    public Map<Coin, Integer> getCoinsMap() {
        return coinsMap;
    }

    public void setCoinsMap(Map<Coin, Integer> coinsMap) {
        this.coinsMap = coinsMap;
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, Item> itemMap) {
        this.itemMap = itemMap;
    }

    public Map<Coin, Integer> getCurMoney() {
        return curMoney;
    }

    public void setCurMoney(Map<Coin, Integer> curMoney) {
        this.curMoney = curMoney;
    }

    public State getCurState() {
        return curState;
    }

    public void setCurState(State curState) {
        this.curState = curState;
    }

    public List<Item> getCurItem() {
        return curItem;
    }

    public void setCurItem(List<Item> curItem) {
        this.curItem = curItem;
    }
}

class Pair {
    private List<String> items;
    private float refund;

    public Pair(List<String> items, float refund) {
        this.items = items;
        this.refund = refund;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}

class Item {
    private int id;
    private int stock;
    private float price;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateStock(int v) {
        this.stock += v;
    }
}

enum Coin {
    Quarter(25), Dime(10), Nickels(5), Pennie(1);

    private int v;

    Coin(int v) {
        this.v = v;
    }
}


interface State {

    void insertCoins(Map<Coin, Integer> coins);

    List<Item> selectItem(String items) throws Exception;

    Pair executeTrans(List<Item> items) throws Exception;

    void cancelTrans();
}

abstract class AbstractState implements State {

    protected VendingMachine vendingMachine;

    public AbstractState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoins(Map<Coin, Integer> coins) {

    }

    @Override
    public List<Item> selectItem(String items) throws Exception {
        List<Item> res = new ArrayList<>();
        String[] arr = items.split(" ");
        for (String str : arr) {
            if (!vendingMachine.getItemMap().containsKey(str) || vendingMachine.getItemMap().get(str).getStock() == 0)
                return new ArrayList<>();
            res.add(vendingMachine.getItemMap().get(str));
        }
        return res;
    }

    @Override
    public Pair executeTrans(List<Item> items) throws Exception {
        return null;
    }

    @Override
    public void cancelTrans() {
        //Todo...
        //back to original state
    }
}

class NoInsertNoSelect extends AbstractState {

    public NoInsertNoSelect(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoins(Map<Coin, Integer> coins) {
        vendingMachine.setCurMoney(coins);
        if (vendingMachine.getCurItem().size() == 0) {
            vendingMachine.transferToHINS();
        } else {
            vendingMachine.transferToHIHS();
        }
    }

    @Override
    public List<Item> selectItem(String items) throws Exception {
        List<Item> res = super.selectItem(items);
        if (res.size() == 0) return res;
        if (vendingMachine.getCoinsMap().size() == 0)
            vendingMachine.transferToNIHS();
        else
            vendingMachine.transferToHIHS();
        return res;
    }

    @Override
    public Pair executeTrans(List<Item> items) throws Exception {
        throw new Exception("your operation has not been done");
    }
}

class HasInsertNoSelect extends AbstractState {

    public HasInsertNoSelect(VendingMachine vendingMachine) {
        super(vendingMachine);

    }

    @Override
    public void insertCoins(Map<Coin, Integer> coins) {
        this.vendingMachine.setCurMoney(coins);
    }

    @Override
    public List<Item> selectItem(String items) throws Exception {
        List<Item> res = super.selectItem(items);
        if (res.size() != 0) {
            vendingMachine.transferToHIHS();
        }
        return res;
    }

    @Override
    public Pair executeTrans(List<Item> items) throws Exception {
        throw new Exception("your operation has not been done");
    }
}

class NoInsertHasSelect extends AbstractState {

    public NoInsertHasSelect(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoins(Map<Coin, Integer> coins) {
        this.vendingMachine.setCurMoney(coins);
    }

    @Override
    public List<Item> selectItem(String items) throws Exception {
        return super.selectItem(items);
    }

    @Override
    public Pair executeTrans(List<Item> items) throws Exception {
        throw new Exception("your operation has not been done");
    }

}

class HasInsertHasSelect extends AbstractState {

    public HasInsertHasSelect(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoins(Map<Coin, Integer> coins) {
        vendingMachine.setCurMoney(coins);
    }

    @Override
    public List<Item> selectItem(String items) throws Exception {
        throw new Exception("you can not add item");
    }

    @Override
    public Pair executeTrans(List<Item> items) throws Exception {
        float price = 0;
        List<String> rItem = new ArrayList<>();
        for (Item item : items) {
            vendingMachine.getItemMap().get(item).updateStock(-1);
            price += vendingMachine.getItemMap().get(item).getPrice();
            rItem.add(item.getName());
        }

        float money = 0;
        for (Map.Entry<Coin, Integer> entry : vendingMachine.getCoinsMap().entrySet()) {
            money += entry.getKey().ordinal() * entry.getValue();
        }

        if (price > money)
            throw new Exception("money is not enough");

        //设置状态为成功
        return new Pair(rItem, money - price);
    }

    @Override
    public void cancelTrans() {
        super.cancelTrans();
    }
}

class CancelTrans extends AbstractState {

    public CancelTrans(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoins(Map<Coin, Integer> coins) {

    }

    @Override
    public List<Item> selectItem(String items) {
        return null;
    }

    @Override
    public Pair executeTrans(List<Item> items) {
        return null;
    }
}