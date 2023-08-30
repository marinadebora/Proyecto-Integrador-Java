package Major;

import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Dao.impl.PructDaoH2Impl;

import java.util.Scanner;

public class UpdateProduct {
  public static void updateProduct(){
    Scanner scanner = new Scanner(System.in);
    ProductDaoH2 productDaoH2 = new PructDaoH2Impl();


    System.out.println("Ingrese el codigo del producto");
    int id = scanner.nextInt();
    scanner.nextLine();
    ProductDto getProductDto = productDaoH2.getById(id);
    System.out.println(getProductDto);
//    System.out.println("Ingrese el nombre del producto");
//    String name = scanner.nextLine();
//    System.out.println("Ingrese la marca");
//    String brand = scanner.nextLine();
//    System.out.println("Ingrese el precio");
//    double price = scanner.nextDouble();
//    ProductDto newProductDto = new ProductDto(name,brand,price);
//    productDaoH2.update(newProductDto);

  }
}
