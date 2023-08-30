package Dao.impl;

import Config.JdbcConfig;
import Dao.InterfacesH2.ProductDaoH2;
import Dao.dto.ProductDto;
import Models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PructDaoH2Impl implements ProductDaoH2 {
  private  final Connection connection;

  public PructDaoH2Impl() {
    this.connection = JdbcConfig.getDBConnection();
  }
PreparedStatement preparedStatement = null;
  @Override
  public void insert(ProductDto productDto) {
  Product product = convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTS (NAME,BRAND,PRICE)VALUES (?,?,?)");
      preparedStatement.setString(1,product.getName());
      preparedStatement.setString(2,product.getBrand());
      preparedStatement.setDouble(3,product.getPrice());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void getAll() {
    List<ProductDto> productList = new ArrayList<>();
    ProductDto productDto = new ProductDto();
    convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS");
      ResultSet result = preparedStatement.executeQuery();
      while (result.next()){
        productDto.setName(result.getString("NAME"));
        productDto.setBrand(result.getString("BRAND"));
        productDto.setPrice(result.getDouble("PRICE"));
        productList.add(productDto);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    productList.forEach(System.out::println);

  }

  @Override
  public ProductDto getById(int productId) {
    ProductDto productDto= new ProductDto();
    convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE ID = ?");
      preparedStatement.setInt(1,productId);
      ResultSet result = preparedStatement.executeQuery();
      productDto.setName(result.getString("NAME"));
      productDto.setBrand(result.getString("BRAND"));
      productDto.setPrice(result.getDouble("PRICE"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return productDto;
  }

  @Override
  public void update(ProductDto productDto) {
    Product product = convertDtoToObject(productDto);
    try {
      preparedStatement = connection.prepareStatement("UPDATE PRODUCT SET NAME = ?, BRAND = ?, PRICE = ? WHERE id = ?");
      preparedStatement.setString(1,product.getName());
      preparedStatement.setString(2,product.getBrand());
      preparedStatement.setDouble(3,product.getPrice());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(int productId) {

  }
 public  Product convertDtoToObject (ProductDto productDto){
   Product product = new Product();
   product.setName(productDto.getName());
   product.setBrand(productDto.getBrand());
   product.setPrice(productDto.getPrice());
   return product;
 }
}