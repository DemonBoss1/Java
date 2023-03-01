import java.util.LinkedList;

public class Ex2  {

    class ParentClass {
        Integer CoolNumber;
        ParentClass() {
            CoolNumber = 100;
        }
    }

    class ChildClass extends ParentClass {
        ChildClass() {
            super();
            System.out.println("Число из родительского класса: "+GetFromParent());
        }
        Integer GetFromParent() {
            return super.CoolNumber;
        }
    }

    public void Run() {
        ChildClass Child = new ChildClass();
    }
}