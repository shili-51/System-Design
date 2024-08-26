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



############################################################### Above class is changed to below to satisfy Single Responsibility Principle ##################################


// Invoice class contains only one function calaculateTotal which is only function now in Invoice which can change Invoice Class
class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }
}


// Save to DB function is defined in another class InvoiceDao, which now on changing can only change InvoiceDao class
class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
      // save the data into DB
    } 

}



// printInvoice function is defined in another class InvoicePrinter, which now on changing can only change InvoicePrinter class.
class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
      // print the Invoice
    } 

}


Now each class has single responsibility

--- Easy to maintain
--- Easy to understand
