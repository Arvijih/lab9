import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Нярав болон агуулах үүсгэх
        Clerk clerk = new Clerk("Bat", null);
        Warehouse warehouse = new Warehouse("Tov aguulah", clerk);
        clerk.setWarehouse(warehouse);

        // Бараа үүсгэх
        InventoryItem item1 = new InventoryItem("A001", "tsaas", 100);
        InventoryItem item2 = new InventoryItem("B002", "Beh", 50);
        List<InventoryItem> receivedItems = Arrays.asList(item1, item2);

        // Орлогын падаан үүсгэх ба бараа хүлээн авах
        Receipt receipt = clerk.createReceipt(receivedItems, "Naran", new Date());
        warehouse.receiveGoods(receipt);

        // Зарлагын падаан үүсгэх ба бараа зарлага гаргах
        InventoryItem issueItem = new InventoryItem("A001", "Tsaas", 20);
        List<InventoryItem> issuedItems = Arrays.asList(issueItem);
        IssueSlip issueSlip = clerk.createIssueSlip(issuedItems, "Saraa", new Date());
        warehouse.issueGoods(issueSlip);

        // Нөөцийн тайлан гаргах
        InventoryReport report = clerk.viewReport(new Date(), new Date(), null);
        System.out.println("Tailan: " + report);

        // Тооллого хийх
        StocktakingRecord stocktaking = clerk.performStocktaking(item1, 80, new Date());
        warehouse.performStocktaking(stocktaking);

        System.out.println("programm amjilttai ajillalaa.");
    }
}

// Агуулахын класс
class Warehouse {
    private String name;
    private Clerk clerk;
    private List<InventoryItem> items;

    public Warehouse(String name, Clerk clerk) {
        this.name = name;
        this.clerk = clerk;
        this.items = new ArrayList<>();
    }

    public void receiveGoods(Receipt receipt) {
        System.out.println("Baraa huleen avlaa: " + receipt);
    }

    public void issueGoods(IssueSlip issueSlip) {
        System.out.println("Baraa zarlaga gargalaa: " + issueSlip);
    }

    public InventoryReport generateReport(Date startDate, Date endDate, List<InventoryItem> selectedItems) {
        return new InventoryReport(startDate, endDate, selectedItems);
    }

    public void performStocktaking(StocktakingRecord record) {
        System.out.println("Toollogo hiilee: " + record);
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }
}

// Няравын класс
class Clerk {
    private String name;
    private Warehouse warehouse;

    public Clerk(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    public Receipt createReceipt(List<InventoryItem> items, String deliveredBy, Date date) {
        return new Receipt(items, deliveredBy, date);
    }

    public IssueSlip createIssueSlip(List<InventoryItem> items, String receivedBy, Date date) {
        return new IssueSlip(items, receivedBy, date);
    }

    public InventoryReport viewReport(Date startDate, Date endDate, List<InventoryItem> selectedItems) {
        return warehouse.generateReport(startDate, endDate, selectedItems);
    }

    public StocktakingRecord performStocktaking(InventoryItem item, int actualQuantity, Date date) {
        return new StocktakingRecord(item, actualQuantity, date);
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}

// Барааны класс
class InventoryItem {
    private String code;
    private String name;
    private int quantity;

    public InventoryItem(String code, String name, int quantity) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}

// Орлогын падааны класс
class Receipt {
    private List<InventoryItem> items;
    private String deliveredBy;
    private Date date;

    public Receipt(List<InventoryItem> items, String deliveredBy, Date date) {
        this.items = items;
        this.deliveredBy = deliveredBy;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orlogiin padaan - Baraa: " + items + ", Huleen avsan: " + deliveredBy + ", Ognoo: " + date;
    }
}

// Зарлагын падааны класс
class IssueSlip {
    private List<InventoryItem> items;
    private String receivedBy;
    private Date date;

    public IssueSlip(List<InventoryItem> items, String receivedBy, Date date) {
        this.items = items;
        this.receivedBy = receivedBy;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Zarlagiin padaan - Baraa: " + items + ", Huleen avsan: " + receivedBy + ", Ognoo: " + date;
    }
}

// Нөөцийн тайлангийн класс
class InventoryReport {
    private Date startDate;
    private Date endDate;
    private List<InventoryItem> items;

    public InventoryReport(Date startDate, Date endDate, List<InventoryItem> items) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Tailan - Ehleh ognoo: " + startDate + ", Duusan ognoo: " + endDate + ", Baraa: " + items;
    }
}

// Тооллогын бүртгэлийн класс
class StocktakingRecord {
    private InventoryItem item;
    private int actualQuantity;
    private Date date;

    public StocktakingRecord(InventoryItem item, int actualQuantity, Date date) {
        this.item = item;
        this.actualQuantity = actualQuantity;
        this.date = date;
    }

    @Override
    public String toString() {
        return item + ": Toolson too hemjee = " + actualQuantity + ", Ognoo = " + date;
    }
}
