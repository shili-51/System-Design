2) Open/ Closed Principle - Open for extension but closed for Modification ---- jo class already use mein hai live hai, testing hai and its running perfectly in production,
  why to modify that class, you can extend that class and add your extra capabilities to that extended version

  
// Class is already in use - tested, live and receiving website traffic.
class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
      // save the data into DB
    } 

}


// received a new requirement to save this in file as well

// we are modifying the already up and running file which may be prone to bugs.
class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
      // save the data into DB
    } 

    public void saveToFile(String filename) {
      // save Invoice in the file with the given name
    } 

}


Improvement - we will extend the Parent class (Invoice) to other child class with extra capabilities required for example - subclass DataBaseInvoiceDao and subclass FileInvoiceDao

                                                      class INVOICE
                                                |                  |               |
                                (SQL DB) DataBaseInvoiceDao    FileInvoiceDao     In case any other capabiltiy is required in future.(Mongo DB)

  
interface InvoiceDao {
    public void save(Invoice invoice);
}


class DataBaseInvoiceDao implements InvoiceDao {

    @Override
    public void save(Invoice invoice) {
        // Save to DB
    }
}


class FileInvoiceDao implements InvoiceDao {

    @Override
    public void save(Invoice invoice) {
        // Save to file
    }
}
