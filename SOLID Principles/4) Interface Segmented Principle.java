4) Interface Segmented Principle - Interfaces should be such, that client(waiter) should not implement unnecessary functions they do not need.


interface RestaurantEmployee {
    void washDishes();
    void serveCustomers();
    void cookFood();
}

class waiter implements RestaurantEmployee {

      public void washDishes() {
          // not my job
      }

      public void serveCustomers() {
          // yes and here is my implementation
          System.out.println("Serving the customer");
      }

      public void cookFood() {
          // not my job
      }

}



############################################################# Solution ########################################################

interface WaiterInterface {
    void serveCustomers();
    void takeOrder();
}


interface ChefInterface {
    void cookFood();
    void decideMenu();
}


// now waiter class does not need to implement cook food and wasdishes functionalities, it is only implementing functionalities related to itself
class waiter implements WaiterInterface {
  
    public void serveCustomers() {
        System.out.println("serving the customer");
    }

    public void takeOrder(){
        System.out.println("taking orders");
    }
  
}




