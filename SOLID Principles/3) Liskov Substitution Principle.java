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
