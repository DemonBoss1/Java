import java.util.*;

public class LabLib {
    static class Lab{
        double LabNum;
        String LabName;
        List<Task> MyTasks;
        String LabType = "Лаб. работа";

        public void Intro() {
            System.out.println("===== "+LabType+" №"+this.LabNum+". "+this.LabName+" =====");
            System.out.println("Порфирьев Артем");
        }

        Lab(double inLabNum, String inLabName, List<Task> inTasks) {
            this.LabNum = inLabNum;
            this.LabName = inLabName;
            this.MyTasks = inTasks;
        }

        public void Run(){
            this.Intro();
            System.out.println();
            System.out.println("Список задач:");
            ShowTaskDescriptions(this.MyTasks);
            System.out.println();
            TaskMenu(this.MyTasks);
            System.out.println("=====Конец "+LabType+" №"+this.LabNum+".=====");
        }
    }

    static class Task {
        TaskExec MyTask;
        String Description;

        Task(TaskExec inTask, String inDesc) {
            this.MyTask = inTask;
            Description = inDesc;
        }
    }

    interface TaskExec {
        void Run() throws Exception;
    }

    public static void TaskMenu(List<Task> inTasks) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Задача (ост. пустым для всех): ");
        String TaskStr = sc.nextLine();
        System.out.println();
        int TaskNum = inputIntNull(TaskStr, (a) -> a > 0 & a <= inTasks.size());
        if (TaskNum != -1) {
            ExecuteTask(inTasks.get(TaskNum-1),TaskNum);
        } else {
            int i = 1;
            for (Task fromInTasks : inTasks) {
                ExecuteTask(fromInTasks,i++);
            }
        }
    }

    public static void PressEnterToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nНажмите Enter чтобы продолжить.");
        sc.nextLine();
        System.out.println();
    }

    public static void ExecuteTask(Task inTask, int inTaskNum) {
        System.out.println("-----Задача " + inTaskNum + "-----\n");
        System.out.println(inTask.Description+"\n");
        try {
            inTask.MyTask.Run();
        } catch (Exception e) {
            System.out.println("При выполнении задачи "+inTaskNum+" произошла ошибка:\n"+e.toString());
        }
        PressEnterToContinue();
    }

    public static void ShowTaskDescriptions(List<Task> inTasks) {
        int i = 1;
        for (Task fromInTasks : inTasks) {
            System.out.println(""+(i++)+": "+fromInTasks.Description);
        }
    }

    interface IntCondition {
        public Boolean IntCheck(int inInt);
    };

    public static Integer inputIntNull(String value, IntCondition inIC) {
        try {
            if (inIC.IntCheck(Integer.parseInt(value))) {
                return Integer.parseInt(value);
            } else {
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static Integer inputIntRetry(String inPrompt, IntCondition inIC) {
        boolean Valid = false;
        int Result = -1;
        while (!Valid) {
            Scanner IntGetter = new Scanner(System.in);
            try {
                System.out.print(inPrompt);
                Result = IntGetter.nextInt();
                if (inIC.IntCheck(Result)) {
                    Valid = true;
                } else {
                    System.out.println("Число введено неверно!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Число введено неверно!");
            }
        }
        return Result;
    }

    public static Float inputFloatRetry(String inPrompt) {
        boolean Valid = false;
        float Result = -1;
        while (!Valid) {
            Scanner FloatGetter = new Scanner(System.in);
            try {
                System.out.print(inPrompt);
                Result = FloatGetter.nextFloat();
                Valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Число введено неверно!");
            }
        }
        return Result;
    }

    public static String inputString(String inPrompt) {
        Scanner StringGetter = new Scanner(System.in);
        System.out.print(inPrompt);
        String Result = StringGetter.nextLine();
        return Result;
    }
}
