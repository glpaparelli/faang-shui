import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // System.out.println("====================================");
        
        // OptiverOA1Q1 oaQ1e1 = new OptiverOA1Q1(100);
        // oaQ1e1.recordLog("1", 0);
        // oaQ1e1.recordLog("2", 300);
        // System.out.println(oaQ1e1.getLogs());
        // System.out.println(oaQ1e1.getLogCount() + "");
        // oaQ1e1.recordLog("3", 1200);
        // oaQ1e1.recordLog("1", 1800);
        // System.out.println(oaQ1e1.getLogs());
        // System.out.println(oaQ1e1.getLogCount() + "");
        // oaQ1e1.recordLog("4", 3900);
        // System.out.println(oaQ1e1.getLogs());

        // System.out.println("====================================");

        // OptiverOA1Q1 oaQ1e2 = new OptiverOA1Q1(2);
        // oaQ1e2.recordLog("1", 0);
        // oaQ1e2.recordLog("7", 600);
        // oaQ1e2.recordLog("3", 1200);
        // oaQ1e2.recordLog("5", 1800);
        // System.out.println(oaQ1e2.getLogs());
        // System.out.println(oaQ1e2.getLogCount() + "");
        // oaQ1e2.recordLog("2", 2400);
        // System.out.println(oaQ1e2.getLogs());
        // System.out.println(oaQ1e2.getLogCount() + "");

        // System.out.println("====================================");

        // OptiverOA1Q2 oaQ2e1 = new OptiverOA1Q2(1000);
        // oaQ2e1.addDividend(100, 10);
        // oaQ2e1.addDividend(50, 100);
        // oaQ2e1.price(15);
        // oaQ2e1.editDividend(2, 40, 20);
        // oaQ2e1.price(15);
        // oaQ2e1.price(25);

        // System.out.println("====================================");

        // OptiverOA1Q2 oaQ2e2 = new OptiverOA1Q2(100);
        // oaQ2e2.addDividend(1, 1);
        // oaQ2e2.addDividend(2, 2);
        // oaQ2e2.addDividend(3, 3);
        // oaQ2e2.addDividend(4, 4);
        // oaQ2e2.addDividend(5, 5);
        // oaQ2e2.price(1);
        // oaQ2e2.price(2);
        // oaQ2e2.price(3);
        // oaQ2e2.price(4);
        // oaQ2e2.price(5);

        // System.out.println("====================================");


        List<Elephant> myElephants = new ArrayList<>();
        myElephants.add(new Elephant("marry", 300));
        myElephants.add(new Elephant("rob", 250));

        List<Event> mySchedule = new ArrayList<>();
        mySchedule.add(new Event("marry", 10, 15));
        mySchedule.add(new Event("rob", 13, 20));

        OptiverOA2 optiverOA2 = new OptiverOA2(myElephants, mySchedule);

        optiverOA2.elephantEntered(8, 200);
        optiverOA2.elephantEntered(10, 310);
        optiverOA2.elephantEntered(10, 300);
        List<Elephant> inspection1 = optiverOA2.getBiggestElephants();
        inspection1.forEach(s -> System.out.println(s.getElephantName()));
        optiverOA2.elephantEntered(13, 250);
        optiverOA2.elephantLeft(13, 310);
        List<Elephant> inspection2 = optiverOA2.getBiggestElephants();
        inspection2.forEach(s -> System.out.print(s.getElephantName() + ", "));
        System.out.println("");
        optiverOA2.elephantLeft(15, 300);
        List<Elephant> inspection3 = optiverOA2.getBiggestElephants();
        inspection3.forEach(s -> System.out.print(s.getElephantName() + ", "));
        System.out.println("");
        
    }
}
