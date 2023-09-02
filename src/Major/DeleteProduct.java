package Major;

import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Dao.impl.ProductDaoH2Impl;
import Exceptions.DAOException;
import java.util.Scanner;

public class DeleteProduct {
  public static void deleteProduct(){
    Scanner scanner = new Scanner(System.in);
    ProductDaoH2 productDaoH2 = new ProductDaoH2Impl();
    System.out.println("Ingrese el codigo del producto que desea eliminar");
    int id= scanner.nextInt();
    ProductDto deleteProduct = null;
    try {
      deleteProduct = productDaoH2.getById(id);
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }
    if(deleteProduct == null){
      System.out.println("Producto no encontrado");
    }else {
      System.out.println(deleteProduct);
      System.out.println("Esta seguro que desea eliminar este producto? Y ");
      scanner.nextLine();
      String delete = scanner.nextLine().toUpperCase();

    if(delete.equals("Y")){
      try {
        productDaoH2.delete(id);
      } catch (DAOException e) {
        throw new RuntimeException(e);
      }

    }else{
      System.out.println("Producto no eliminado");
    }
    }
  }
}
