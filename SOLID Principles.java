SOLID - 
1) Single Responsibility
2) Open/ Closed Principle
3) Liskov Substituiton Principle
4) Interface Segmented Principle
5) Dependency Inversion Principle

SOLID Principle Examples - 
1) Avoid Duplicate Code
2) Easy to maintain
3) Easy to understand
4) Flexible software
5) Reduce Complexity


################################################################################

1) Single Responsibility Principle - A class should have only 1 reason to change ---- ek class ke paas ek responsibility honi chahiye ek se zyada nahi

Marker Entity:

class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
       this.name = name;
       this.color = color;
       this.year = year;
       this.price = price;
    }
}


class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }


   // If suppose I need to change calculate Total with additon of GST or discount features - invoice class is getting changed because of changes in logic of calculateTotal

    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }

    public void printInvoice() {
      // print the Invoice
    }

    public void saveToDB() {
      // save the data into DB
    }

}


In future if I make changes of printInvoice or saveTODb, all these will lead to changes in Invoice class only.
That means number of ways of changing Invoice class is 3.

But Single Responsibility Principle says the class should have 1 reason to change, therefore above Invoice class doesnot follow Single Responsibility Principle.
