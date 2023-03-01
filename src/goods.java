import java.util.Scanner;

public class goods {
    String name, manufacturer;
    int quantity, cost;
    goods(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите наименование товара => ");
        name=sc.nextLine();

        System.out.print("Введите производителя => ");
        manufacturer=sc.nextLine();

        System.out.print("Введите количество товара => ");
        quantity=sc.nextInt();

        System.out.print("Введите цену товара => ");
        cost=sc.nextInt();
    }
    public void printGoods(){
        System.out.println(this.name + "\t" + this.manufacturer + "\t" + this.quantity + "\t" + this.cost);
    }
    public static void printWarehouse(goods[] warehouse){
        System.out.println("№ \t Name \t Manufacturer \t Quantity \t Cost");
        for (int i=0;i<warehouse.length;i++){
            System.out.print((i+1) + "\t");
            warehouse[i].printGoods();
        }
    }
    public static int MaxQuantity(goods[] warehouse){
        int max = warehouse[0].quantity;
        int maxI=0;
        for (int i=maxI; i<warehouse.length; i++){
            if (max<warehouse[i].quantity) {
                max = warehouse[i].quantity;
                maxI=i;
            }
        }
        return maxI;
    }
    public static float averagePrice(goods[] warehouse){
        int count=0;
        for (goods i:warehouse){
            count+=i.cost;
        }
        try {
            return (count/ warehouse.length);
        }catch (Exception e) {
            return 0;
        }
    }
    public static void belowAveragePrice (goods[] warehouse){
        float averageCost = averagePrice(warehouse);
        System.out.println("Средняя стоимость товара равна " + averageCost);
        int count=0;
        for (goods i:warehouse)
            if (averageCost>i.cost){
                i.printGoods();
                count++;
            }
        System.out.println("Количество видов товаров ниже средней стоимости на складе: " + count);
    }
    public static void priceSort(goods[] warehouse){
        goods auxiliary;
        for (int i=0;i< warehouse.length;i++)
            for (int j = 0; j < warehouse.length-1; j++)
                if (warehouse[j].cost>warehouse[j+1].cost){
                    auxiliary=warehouse[j];
                    warehouse[j]=warehouse[j+1];
                    warehouse[j+1]=auxiliary;
                }
    }
    public static int searchName(goods[] warehouse){
        Scanner data = new Scanner(System.in);
        System.out.print("Введите наименование товара: ");
        String name = data.nextLine();
        for (int i=0; i<warehouse.length;i++)
            if (name.equals((warehouse[i].name))){
                return i;
            }
        return -1;
    }
    public void correctionsDataProduct(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите наименование товара => ");
        name=sc.nextLine();

        System.out.print("Введите производителя => ");
        manufacturer=sc.nextLine();

        System.out.print("Введите количество товара => ");
        quantity=sc.nextInt();

        System.out.print("Введите цену товара => ");
        cost=sc.nextInt();
        printGoods();
    }
}
