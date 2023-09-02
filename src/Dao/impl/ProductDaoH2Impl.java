package Dao.impl;

import Config.JdbcConfig;
import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Exceptions.DAOException;
import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoH2Impl implements ProductDaoH2 {
  private  final Connection connection;

  public ProductDaoH2Impl() {
    this.connection = JdbcConfig.getDBConnection();
  }
  PreparedStatement preparedStatement = null;
  @Override
  public void insert(ProductDto productDto) throws DAOException{
  Product product = convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement(
          "INSERT INTO PRODUCTS (NAME,BRAND,PRICE)VALUES (?,?,?)");
      preparedStatement.setString(1,product.getName());
      preparedStatement.setString(2,product.getBrand());
      preparedStatement.setDouble(3,product.getPrice());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DAOException("No se pudo crear el producto",e);
    }
  }

  @Override
  public List<ProductDto> getAll() {
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS");
      ResultSet result = preparedStatement.executeQuery();
      List<ProductDto> productList = new ArrayList<>();
      while (result.next()){
        productList.add(convertResulSetToDto(result));
      }
      return productList;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ProductDto getById(int productId) throws DAOException {
    ProductDto productDto= new ProductDto();
    convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE ID = ?");
      preparedStatement.setInt(1,productId);
      ResultSet result = preparedStatement.executeQuery();
      if(result.next()){
        productDto.setName(result.getString("NAME"));
        productDto.setBrand(result.getString("BRAND"));
        productDto.setPrice(result.getDouble("PRICE"));
        return productDto;
      }
      return null;
    } catch (SQLException e) {
      throw new DAOException("error al obtener producto por id",e);
    }
  }

  @Override
  public void update(ProductDto productDto,int id) throws DAOException{
    Product product = convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement(
          "UPDATE PRODUCTS SET NAME = ?, BRAND = ?, PRICE = ? WHERE id = ?");
      preparedStatement.setString(1,product.getName());
      preparedStatement.setString(2,product.getBrand());
      preparedStatement.setDouble(3,product.getPrice());
      preparedStatement.setInt(4,id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new  DAOException("No se pudo editar el producto",e);
    }
  }

  @Override
  public void delete(int productId) throws RuntimeException {
    try {
      preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTS WHERE id=?");
      preparedStatement.setInt(1,productId);
      int erased = preparedStatement.executeUpdate();

      if(erased ==0){
        System.out.println("Ocurrio un error el producto no fue eliminado");
      }else{
        System.out.println("Producto eliminado con exito");
      }
    } catch (SQLException|RuntimeException e) {
      throw new RuntimeException("No se puede eliminar este producto, esta siendo utilizado en la base de datos");
    }
  }
 public  Product convertDtoToObject (ProductDto productDto){
   Product product = new Product();
   product.setName(productDto.getName());
   product.setBrand(productDto.getBrand());
   product.setPrice(productDto.getPrice());
   return product;
 }

  public ProductDto convertResulSetToDto(ResultSet result){
    ProductDto productDto = new ProductDto();
    try {
      productDto.setName(result.getString("NAME"));
      productDto.setBrand(result.getString("BRAND"));
      productDto.setPrice(result.getDouble("PRICE"));
      convertDtoToObject(productDto);
      return productDto;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
