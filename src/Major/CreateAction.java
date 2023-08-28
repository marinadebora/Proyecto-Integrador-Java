package Major;

import java.util.Scanner;


public class CreateAction {
    public  static  void createAction(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Para crear ingreso escriba  1");
            System.out.println("Para crear gasto escriba  2");
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                int option = scanner.nextInt();
                if(option == 1) {
                    System.out.println("1");
                    CreateSale.createSale();
                } else if (option ==2) {
                    System.out.println("2");
                    CreateBills.createBills();
                }else{
                    System.out.println("Ingrese un numero valido");
                }
            }
        }while (!scanner.hasNextInt());
    }
}
