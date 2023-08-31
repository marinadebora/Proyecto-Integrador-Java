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

    ProductDto getProductDto = productDaoH2.getById(id);
    System.out.println(getProductDto.toString());
    System.out.println("Ingrese el nuevo nombre del producto");
    scanner.nextLine();
    String name = scanner.nextLine();

    System.out.println("Ingrese el nuevo precio");
    Double price = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("Ingrese la nueva marca");
    String brand = scanner.nextLine();

    ProductDto newProductDto = new ProductDto(name,brand,price);
    productDaoH2.update(newProductDto,id);
    System.out.println("Producto editado con exito \n"+newProductDto);

  }
}
