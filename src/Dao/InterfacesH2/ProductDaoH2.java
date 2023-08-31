package Dao.InterfacesH2;

import Dao.dto.ProductDto;

public interface ProductDaoH2 {
 //CREATE
  void insert(ProductDto productDto);
//READ
  void getAll();
  ProductDto getById(int productId);
//UPDATE
  void update(ProductDto productDto,int id);
//DELETE
  void delete(int productId);
}
