package Major;

import Dao.InterfacesH2.ProductDaoH2;
import Dao.InterfacesH2.SaleDaoH2;
import Dao.dto.PrintSaleDto;
import Dao.dto.ProductDto;
import Dao.dto.SaleDto;
import Dao.impl.ProductDaoH2Impl;
import Dao.impl.SaleDaoH2Impl;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreateSale {
    public static void createSale(){
      Scanner scanner = new Scanner(System.in);
      ProductDaoH2 productDaoH2 = new ProductDaoH2Impl();
      String date = new Date().toString();
      int salir ;
      SaleDto sale;
      PrintSaleDto print;
      SaleDaoH2 saleDaoH2 = new SaleDaoH2Impl();
      double totalCompra= 0;
      List<PrintSaleDto> productList= new ArrayList<>();

        do {
          System.out.println("ingrese el codigo del producto");
          int product_id= scanner.nextInt();
          ProductDto getProductDto = null;
          try {
            getProductDto = productDaoH2.getById(product_id);
          } catch (DAOException e) {
            throw new RuntimeException(e);
          }

          double price = getProductDto.getPrice();
          System.out.println(getProductDto);

          System.out.println("ingrese la cantidad");
          int  units = scanner.nextInt();
          sale = new SaleDto(date,totalCompra,product_id,price,units);
          totalCompra+=sale.calculateTotal(price,units);
          print = new PrintSaleDto(units,product_id,getProductDto.getName(), getProductDto.getBrand(), price);
          productList.add(print);
          System.out.println("para salir seleccione 1 o cualquier tecla para seguir");
          salir = scanner.nextInt();
          try {
            saleDaoH2.insert(sale);
          } catch (DAOException e) {
            throw new RuntimeException(e);
          }

        }while (!(salir == 1));
      System.out.println("____________________________________________________");
      System.out.println(date);
      productList.forEach(System.out::println);
      System.out.println("TOTAL: "+ totalCompra);
      System.out.println("____________________________________________________");

    }
}