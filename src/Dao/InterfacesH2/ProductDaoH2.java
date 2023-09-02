package Dao.InterfacesH2;

import Dao.dto.ProductDto;
import Exceptions.DAOException;

import java.util.List;

public interface ProductDaoH2 {
 //CREATE
  void insert(ProductDto productDto)throws DAOException;
//READ
  List<ProductDto> getAll();
  ProductDto getById(int productId) throws DAOException;
//UPDATE
  void update(ProductDto productDto,int id)throws DAOException;
//DELETE
  void delete(int productId) throws DAOException;
}
