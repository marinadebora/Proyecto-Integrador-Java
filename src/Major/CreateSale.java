package Major;

import Dao.Interfaces.SaleDaoH2;
import Dao.dto.SaleDto;
import Dao.impl.SaleDaoH2Impl;
import Models.Expenses;
import Models.Sale;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreateSale {
    public static void createSale(){
        Scanner scanner = new Scanner(System.in);

                int salir ;
                double totalCompra= 0;

                    double price;
                    int units;
                    SaleDto sale;
                    SaleDto saleDto;
                   List<SaleDto> productList= new ArrayList<>();
                    do {
                        System.out.println("ingrese el producto");
                        String product= scanner.nextLine();

                        System.out.println("ingrese la cantidad");
                        units = scanner.nextInt();

                        System.out.println("ingrese el precio");
                        price = scanner.nextDouble();

                        sale = new SaleDto(product,price,units);
                        totalCompra+=sale.calculateTotal(price,units);
                        productList.add(sale);
                        System.out.println("para salir seleccione 1 o cualquier tecla para seguir");
                        salir = scanner.nextInt();
                        scanner.nextLine();
                        String date = new Date().toString();
                        SaleDaoH2 saleDaoH2 = new SaleDaoH2Impl();
                        saleDto = new SaleDto(date,totalCompra,product,price,units);
                        saleDaoH2.insert(saleDto);

                    }while (!(salir == 1));
                    productList.forEach(System.out::println);
                    System.out.println(saleDto);

    }
}
// protected  String expenseType;
//    protected String addressee;
//    protected double amount;