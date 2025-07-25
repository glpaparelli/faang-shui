// https://leetcode.com/discuss/post/3821560/optiver-oa-by-test99393-lqdu/z
import java.util.ArrayList;
import java.util.List;

import java.util.*;

class Dividend {
    private int amount;
    private int day;

    public Dividend(int amount, int day) {
        this.amount = amount;
        this.day = day;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getDay() {
        return this.day;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "day = " + day + ", amount = " + amount;
    }
}

public class OptiverOA1Q2 {
    private int price;
    private List<Dividend> dividends; // To maintain order for indexing
    private TreeMap<Integer, Integer> dayToAmountMap; // To efficiently calculate price

    public OptiverOA1Q2(int price) {
        this.price = price;
        this.dividends = new ArrayList<>();
        this.dayToAmountMap = new TreeMap<>();
    }

    public void addDividend(int amount, int day) {
        Dividend newDividend = new Dividend(amount, day);
        dividends.add(newDividend);
        dayToAmountMap.put(day, amount);
    }

    public void editDividend(int index, int amount, int day) {
        this.dividends.set(index - 1, new Dividend(amount, day));
        this.dayToAmountMap.remove(day);
        this.dayToAmountMap.put(day, amount);
    }

    public void price(int day) {
        int result = price;
        
        // headmap returns the keys (days) less than the given day. 
        // if we want the price on day 15 we need all the dividends that 
        // are "active" on day 15 or early. For example a dividend with day 10 is active
        // on day 15. 
        for (Map.Entry<Integer, Integer> entry : dayToAmountMap.headMap(day + 1).entrySet()) 
            result -= entry.getValue();
        
        
        System.out.println(result);
    }
}


