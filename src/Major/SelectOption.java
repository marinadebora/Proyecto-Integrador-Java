package Major;

import Exceptions.DAOException;
import Exceptions.InvalidException;

import java.util.Scanner;

public class SelectOption {
  public static void selectOption() throws InvalidException {
    Scanner scanner = new Scanner(System.in);
    int option;
    do {
      System.out.println("ELIJA UNA OPCION: ");
      System.out.println("____________________________________________________");
      System.out.println("0. SALIR");
      System.out.println("1. CREAR VENTA");
      System.out.println("2. CREAR GASTO");
      System.out.println("3. CREAR PRODUCTO");
      System.out.println("4. VER TODOS LOS  PRODUCTO");
      System.out.println("5. EDITAR PRODUCTO");
      System.out.println("6. ELIMINAR PRODUCTO");
      System.out.println("7. CERRAR CAJA DEL DIA");
      System.out.println("8. CERRAR CAJA DEL MES");
      System.out.println("____________________________________________________");
      boolean isInt = scanner.hasNextInt();
      if (isInt){
         option = scanner.nextInt();
      }else {
       throw new InvalidException("Ingrese un número valido");
      }
      switch (option) {
        case 1 -> CreateSale.createSale();
        case 2 -> CreateBills.createBills();
        case 3 -> CreateProducts.createProducts();
        case 4 -> SeeAllProducts.seeAllProducts();
        case 5 -> UpdateProduct.updateProduct();
        case 6 -> DeleteProduct.deleteProduct();
        case 7 ->CloseBox.closeBox();
        case 8 ->CloseBoxPerMonth.closeBoxPerMonth();
      }
    }while (option != 0);
  }
}
