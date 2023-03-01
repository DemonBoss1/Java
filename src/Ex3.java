import java.util.LinkedList;

public class Ex3 {
    class ParentClass {
        Integer Age;
        String Name;
        ParentClass() {
            Age = 16;
            Name = "Хатсуне Мику";
        }
        void GetData() {
            this.Age = LabLib.inputIntRetry("Введите возраст: ", (a) -> a >= 0);
        }
        void Print() {
            System.out.println(this.Name+", "+this.Age+" лет.");
        }
    }

    class ChildClass extends ParentClass {
        ChildClass() {
            super();
        }
        void GetData() {
            this.Name = LabLib.inputString("Введите имя: ");
        }
    }

    public void Run() {
        ParentClass Parent = new ParentClass();
        ChildClass Child = new ChildClass();
        Parent.GetData();
        Parent.Print();
        Child.GetData();
        Child.Print();
    }
}
