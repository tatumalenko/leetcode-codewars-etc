public class Runner {
    public static void main(String[] args) {
        // CTE/RTE: Compile/Run Time Error
        // CTV/RTV: Compile/Run Time Value
        Animal a = new Animal(2);
        Dog d = new Dog("DogCompile-DogRun", 3);

        // UPCASTING
        System.out.println("\nUPCASTING:");
        Animal a2 = new Dog("AnimalCompile-DogRun", 4);

        // DOWNCASTING
        System.out.println("\nDOWNCASTING:");
        // TypeMismatch (CTE): Animal (RTV) is NOT a Dog (CTV)
        // Dog d2 = new Animal(5);
        // Dog d2 = a2;
        Dog d2 = (Dog) a2; // Ok since not CTE and b/c truly Dog RTV

        // ClassCastException (RTE): RTV still is NOT a Dog (CTV)
        // Dog d2 = (Dog) new Animal(5);
        // Dog d2 = (Dog) a;

        // NO LATE-BINDING FOR STATIC METHODS
        System.out.println("\nNO LATE-BINDING FOR STATIC METHODS:");
        System.out.println("static startBarking()");
        a.startBarking(); // This is class Animal, Animal.toString
        d.startBarking(); // This is class Animal, Dog.toString
        a2.startBarking(); // This is class Animal, Dog.toString
        d2.startBarking(); // This is class Animal, Dog.toString

        System.out.println("non-static speak()");
        a.speak(); // This is class Animal
        d.speak(); // This is class Dog
        a2.speak(); // This is class Animal
        d2.speak(); // This is class Dog

        System.out.println("\nMETHOD HIDING (STATIC METHOD `name` REIMPLEMENTED)");
        a.name();
        d.name();
        a2.name();
        d2.name();

        // COVARIANT RETURN TYPE
        System.out.println("\nCOVARIANT RETURN TYPE:");
        // a.get().message(); // Animal has no `message()` method
        d.get().message();

        // OBJECT VARIABLES DO NOT OVERRIDE/LATE-BIND
        System.out.println("\nOBJECT VARIABLES DO NOT OVERRIDE/LATE-BIND:");
        System.out.println("(Animal) new Dog() -> variablesDoNotLateBind: " + a2.variablesDoNotLateBind);

        // STRING CONSTANT POOL
        System.out.println("STRING CONSTANT POOL:");
        String s1 = "Welcome";
        String s2 = "Welcome"; // It doesn't create a new instance
        String s3 = new String("Welcome"); // Would create 2 objects (one in heap + pool)
        System.out.println("s1 == s2? " + (s1 == s2)); // True. s1 and s2 point to same in pool
        System.out.println("s1 == s3? " + (s1 == s3)); // False. s1 from pool, s3 from heap

        main2();

        String str;
        System.out.println(s);
    }

    public static void main2() {
        System.out.println("\nINTERFACES & ABSTRACT CLASSES:");
        Person p = new Person();
        Talkable t = new Person();

        System.out.print("(Person) new Persion() -> startSpeaking(): ");
        p.startSpeaking();

        System.out.print("(Talkable) new Persion() -> startSpeaking(): ");
        t.startSpeaking();
        System.out.println("");

        Whisperable w = new Cat();
        w.startSpeaking();
        w.scream();

        System.out.println("");
    }
}

interface Talkable {
    final String language = "French"; // USE OF FINAL REDUNDANT!! NO NEED!!
    int speed = 2;

    String speak(); // IMPLICITLY PUBLIC!!

    void startSpeaking();

    void scream();
}

interface Whisperable extends Talkable {

}

class Cat implements Whisperable {
    public String speak() {
        return "Meowwwwww";
    }

    public void startSpeaking() {
        System.out.println(this.speak());
    }

    public void scream() {
        System.out.println("CAT SCREAMS MEOWWW!!");
    }
}

abstract class Human implements Talkable {
    String language = "English"; // In a sense 'overrides'
    static int speed = 3;
    static String species = "Homo Sapian";

    public String speak() {
        return "speak() from Human in " + this.language;
    }

    // public abstract void startSpeaking(); // MAKES NO DIFFERENCE
    public void startSpeaking() {
        System.out.print(this.speak());
        System.out.println(" " + this.speed);
        this.scream();
    }
}

class Person extends Human {
    // String language = "Russian";
    int speed = 4;

    public String speak() { // MUST BE PUBLIC!!
        // ERROR: AMBIGIOUS if Person also IMPLEMENTS Talkable
        // since can't tell if refers to Talkable or Human language
        // If Person does NOT IMPLEMENT Talkable, then uses Human.language
        // return this.language;

        this.species = "Poop";

        String msg = "speak() from Person in " + this.language + " as a " + this.species;

        return msg;
    }

    // public void startSpeaking() {
    // System.out.print(this.speak());
    // System.out.println(" " + this.speed);
    // // this.speed = 5; // CANNOT CHANGE FINAL CLASS FIELD
    // }

    public void scream() {
        System.out.println("AHHHH PERSON!!!!");
    }
}

/**
 * Animal
 */
class Animal {
    int numberOfLegs;
    int variablesDoNotLateBind = 100;

    public Animal() {
        this.numberOfLegs = 0;
    }

    public Animal(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    Animal get() {
        return this;
    }

    public static void speak() {
        System.out.print("This is class Animal. ");
    }

    public void startBarking() {
        speak();
        System.out.println(toString());
    }

    public static void name() {
        System.out.println("static method from Animal");
    }

    /**
     * toString method override for `Animal` class.
     * 
     * @return toString representation of class with all attribute information
     */
    @Override
    public String toString() {
        return "numberOfLegs: " + this.numberOfLegs;
    }
}

/**
 * Dog
 */
class Dog extends Animal {
    public String name;
    int variablesDoNotLateBind = 50;

    public Dog() {
        this.name = "";
    }

    public Dog(String name, int numberOfLegs) {
        super(numberOfLegs);
        this.name = name;
    }

    @Override
    Dog get() {
        // Covariant return type: Animal -> Dog
        // Only possible if overriden return type is subclass of super return type
        return this;
    }

    void message() {
        System.out.println("Called from `Dog.message`.");
    }

    public static void speak() {
        System.out.println("\nThis is class Dog.");
    }

    public static void name() {
        System.out.println("static method from Dog");
    }

    /**
     * toString method override for `Dog` class.
     * 
     * @return toString representation of class with all attribute information
     */
    @Override
    public String toString() {
        return "name: " + this.name + ", " + super.toString();
    }
}
