import Entities.Expenses;
import Entities.Sale;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateSale {
    public static void createSale(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("si desea crear una venta presione 1");
        System.out.println("si desea crear un gasto presione 2");

        int option = scanner.nextInt();
        scanner.nextLine();
        int salir = 0;
        double totalCompra= 0;
        if(option == 1){

            double price;
            int units;
            Sale sale;
            ArrayList<Sale> detailSale = new ArrayList<>();
            int count;


            do {
               System.out.println("ingrese el producto");
               String product= scanner.nextLine();

               System.out.println("ingrese la cantidad");
               units = scanner.nextInt();

               System.out.println("ingrese el precio");
               price = scanner.nextDouble();

               sale = new Sale(product,price,units);
               totalCompra+=sale.calculateTotal(price,units);
               count= sale.createId();
               detailSale.add(sale);

               System.out.println("para salir seleccione 1");
               salir = scanner.nextInt();
               scanner.nextLine();

          }while (!(salir == 1));

                System.out.println("detalle de la compra: "+
                        "Numero de Compra: "+ count+
                        "\nFecha: "+ sale.getDate() );
                        detailSale.forEach(System.out::println);
                 System.out.println("Total: "+ totalCompra);





        }else if (option == 2){
            String expenseType;
            double amount;
            String addressee;
            Expenses expenses;
            int count;
            do {
                System.out.println("ingrese el typo de gastos");
                expenseType= scanner.nextLine();

                System.out.println("ingrese su destinatario");
                addressee= scanner.nextLine();

                System.out.println("ingrese el monto");
                amount = scanner.nextInt();
                expenses= new Expenses(expenseType,addressee,amount);
                totalCompra+=amount;
                count = expenses.createId();
                System.out.println("para salir seleccione 1");
                salir = scanner.nextInt();
                scanner.nextLine();
            }while (!(salir == 1));


            System.out.println("detalle del gasto: "+
                    "Numero de comprobante: "+ count+
                    "\nFecha: "+ expenses.getDate()+
                    "\nTypo de gasto: "+ expenseType+
                    "\nDestino: "+ addressee+
                    "\nmonto gastado: "+amount);
            ;
        }else{
            System.out.println("Ingrese una opcion correcta!");
        }


    }
}
// protected  String expenseType;
//    protected String addressee;
//    protected double amount;