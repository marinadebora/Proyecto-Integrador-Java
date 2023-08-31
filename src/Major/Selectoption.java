package Major;

import Dao.exception.InvalidException;

import java.util.Scanner;

public class Selectoption {
  public static void selectOption() throws InvalidException{
    Scanner scanner = new Scanner(System.in);
    int option =1;
    do {
      System.out.println("ELIJA UNA OPCION: ");
      System.out.println("____________________________________________________");
      System.out.println("0. SALIR");
      System.out.println("1. CREAR VENTA");
      System.out.println("2. CREAR GASTO");
      System.out.println("3. CREAR PRODUCTO");
      System.out.println("4. EDITAR PRODUCTO");
      System.out.println("5. ELIMINAR PRODUCTO");
      System.out.println("6. CERRAR CAJA");
      System.out.println("____________________________________________________");
      boolean isInt = scanner.hasNextInt();
      if (isInt){
         option = scanner.nextInt();
      }else {
       throw new InvalidException("Ingrese un número valido");
      }
  switch (option){
    case 1:
      CreateSale.createSale();
      break;
    case 2:
      CreateBills.createBills();
      break;
    case 3:
      CreateProducts.createProducts();
      break;
    case 4:
     UpdateProduct.updateProduct();
     break;
    case 5:
      DeleteProduct.deleteProduct();
      break;
    default:
      System.out.println("ingrese una opcion valida");

  }
    }while (option != 0);
  }
}
