package Major;

import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Dao.impl.ProductDaoH2Impl;
import Exceptions.DAOException;
import java.util.Scanner;

public class CreateProducts {
  public static void createProducts(){
    Scanner scanner = new Scanner(System.in);
    ProductDto productDto = new ProductDto();
    ProductDaoH2 productDaoH2 = new ProductDaoH2Impl();

    System.out.println("Ingrese el nombre del producto");
    String name = scanner.nextLine();
    System.out.println("Ingrese la marca");
    String brand = scanner.nextLine();
    System.out.println("Ingrese el precio");
    double price = scanner.nextDouble();

    productDto.setName(name);
    productDto.setBrand(brand);
    productDto.setPrice(price);

    try {
      productDaoH2.insert(productDto);
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(productDto);
      }

}
