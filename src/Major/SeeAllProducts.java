package Major;

import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Dao.impl.ProductDaoH2Impl;

import java.util.List;

public class SeeAllProducts {
  public static void seeAllProducts(){
    ProductDaoH2 productDaoH2 = new ProductDaoH2Impl();
   List<ProductDto> productList= productDaoH2.getAll();
   productList.forEach(System.out::println);

  }
}
