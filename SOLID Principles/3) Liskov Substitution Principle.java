3) Liskov Substitution Principle - If class B is subtype of class A, then we should be able to replace object A with B without breaking the behaviour of the program.

  Subclass should extend the capability of parent class not narrow it down.


  
interface Bike {
    void turnOnEngine();
    void accelerate();
}


// Motorcyle class
class MotorCycle implements Bike {
    boolean isEngineOn;
    int speed;

    public void turnOnEngine() {
      //turn on the engine!
      isEngineOn = true;
    }

    public void accelerate() {
      //increase the speed
      speed = speed + 10;
    }
}

// Bicycle Class
class Bicycle implements Bike {

    public void turnOnEngine() {
      throw new AssertionError( detailMessage: "there is no engine");   // if we replace bike object with Bicyle object this line will break the functionality as Bicyle has no engine.
    }

    public void accelerate() {
      //do something
    }
}

So, replacing parent Bike with its Subclass Bicycle will break the code, this should not take place.


####################################################################################### Problem and Solution ###############################################################

public class Vehicle {
      public Interger getNumberOfWheels(){
          return 2;
      }

      public Boolean hasEngine(){
          return true;
      }

}

public class Motorcyle extends Vehicle {
}


public class Car extends Vehicle {
  
    @Override
    public Integer getNumberOfWheels(){
        return 4;
    }
}


Client Code - 
public class Main {
    public static void main(String args[]){
          List<Vehicle> vehicleList = new ArrayList<>();
          vehicleList.add(new MotorCycle());
          vehicleList.add(new Car());

          for(Vehicle vehicle : vehicleList){
              System.out.println(vehicle.hasEngine().toString());
          }
    }


}


Above code will be running perfectly fine but if I add another child subclass to Class vehicle which is downfalling its capability

  

public class Bicyle extends Vehicle {

      @Override
      public Boolean hasEngine(){
          return null;
      }

}


New Modified Client Code - 
public class Main {
    public static void main(String args[]){
          List<Vehicle> vehicleList = new ArrayList<>();
          vehicleList.add(new MotorCycle());
          vehicleList.add(new Car());
          vehicleList.add(new Bicycle());

          for(Vehicle vehicle : vehicleList){
              System.out.println(vehicle.hasEngine().toString());  // this will throw null pointer exception for Bicycle - will break code // reduced capability of Vehicle class
          }
    }

}


############################################################################### Solution ###########################################################################

// generic Method
public class Vehicle {
      public Interger getNumberOfWheels(){
          return 2;
      }

}

public class Bicyle extends Vehicle {

}



// used by car and motorbike classes
public class EngineVehicle extends Vehicle {
      public boolean hasEngine(){
          return true;
      }

}


public class Motorcyle extends EngineVehicle {
}


public class Car extends EngineVehicle {
  
}


New working Modified Client Code - 
public class Main {
    public static void main(String args[]){
          List<Vehicle> vehicleList = new ArrayList<>();
          vehicleList.add(new MotorCycle());
          vehicleList.add(new Car());
          vehicleList.add(new Bicycle());

          for(Vehicle vehicle : vehicleList){
              System.out.println(vehicle.getNumberOfWheels().toString());  // method of vehicle class is called and it will not break for any bike, motorbike, or bicycle
          }
    }

}



This code wont work - 
public class Main {
    public static void main(String args[]){
          List<Vehicle> vehicleList = new ArrayList<>();
          vehicleList.add(new MotorCycle());
          vehicleList.add(new Car());
          vehicleList.add(new Bicycle());

          for(Vehicle vehicle : vehicleList){
              System.out.println(vehicle.hasEngine().toString());  // vehicle is not aware of has Engine Method
          }
    }

}
  
