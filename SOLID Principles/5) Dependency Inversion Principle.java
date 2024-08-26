5) Dependency Inversion Principle - class should depend on interfaces rather than concrete classes.


class MacBook {
    private final WiredKeyboard keyboard;
    private final WiredMouse mouse;

    public MacBook() {
        keyboard = new WiredKeyboard();
        mouse = new WiredMouse();
    }
}

Suppose we have two interfaces Mouse and Keyboard.

For Mouse - 
      |___ wired Mouse (concrete class)
      |___ bluetooth Mouse (concrete class)

For Keyboard - 
      |___ wired Keyboard (concrete class)
      |___ bluetooth Keyboard (concrete class)

Problem - In above Macbook class we have assigned objects of concrete class, this is wrong, suppose in future we need to enhance macbook with bluetooth features, we cant do
because we have assigned objects of concrete classes - (WiredKeyboard, WiredMouse) its not following dependency inversion principle


######################################################################################## Solution ###########################################################

class MacBook {
    private final Keyboard keyboard;
    private final Mouse mouse;

    public MacBook(Keyboard keyboard, Mouse mouse) {   // here through constructor we can assign whether we need wired or bluetooth value from interfaces
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
