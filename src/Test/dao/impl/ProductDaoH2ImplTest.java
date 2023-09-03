package Test.dao.impl;


import Dao.dto.ProductDto;
import Dao.impl.ProductDaoH2Impl;
import Exceptions.DAOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("pruebas para prdocts")

public class ProductDaoH2ImplTest {
  @Mock
  private Connection mockConnection;
  @Mock
  private PreparedStatement mockPreparedStatement;
  @Mock
  private ResultSet mockResultSet;
  private ProductDaoH2Impl productDaoH2;
  @BeforeEach
  void setUp() throws SQLException {
    MockitoAnnotations.initMocks(this);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    productDaoH2 = new ProductDaoH2Impl(mockConnection);
  }
  @DisplayName("verifica si el producto cumple con la estructura para ser enviado a la db")
  @Test
  void  insertProductsDto_WhenTheProductIsValid() throws DAOException, SQLException {
  //GIVEN
    ProductDto productDtoInit= new ProductDto("pantalon","levis",19400.00);

    when(mockPreparedStatement.executeUpdate()).thenReturn(1);

  //WHEN
    productDaoH2.insert(productDtoInit);

  //THEN
    verify(mockPreparedStatement).setString(1, productDtoInit.getName());
    verify(mockPreparedStatement).setString(2, productDtoInit.getBrand());
    verify(mockPreparedStatement).setDouble(3, productDtoInit.getPrice());
    verify(mockPreparedStatement).executeUpdate();
  }
  @DisplayName("Trae los productos de la db si existen, ")
  @Test
  void getAll_ProductsIfTheyExistInDB() throws SQLException {
    // GIVEN
    List<ProductDto> expectedList = new ArrayList<>();
    expectedList= List.of(
        new ProductDto("remera","narrow",9870.00),
        new ProductDto("chomba","kevingstone",14500.00),
        new ProductDto("polera","levis",11000.00)
    );

    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(true, true, true,false);
    when(mockResultSet.getString("NAME")).thenReturn("remera","chomba","polera");
    when(mockResultSet.getString("BRAND")).thenReturn("narrow","kevingstone","levis");
    when(mockResultSet.getDouble("PRICE")).thenReturn(9870.00,14500.00,11000.00);

    // WHEN

    List<ProductDto> result = productDaoH2.getAll();

    //THEN
    verify(mockPreparedStatement).executeQuery();
    verify(mockResultSet, times(3)).getString("NAME");
    verify(mockResultSet, times(3)).getString("BRAND");
    verify(mockResultSet, times(3)).getDouble("PRICE");

    Assertions.assertEquals(expectedList.size(), result.size());

  }
  @DisplayName("Trae el producto si el id es valido")
  @Test
  void getById_ReturnsProductdtoOnlyIdIsValid() throws SQLException {
    // GIVEN
    int product_Id = 1;
    ProductDto productDto = new ProductDto("remera", "levis", 9580.00);
    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(true);
    when(mockResultSet.getString("NAME")).thenReturn("remera");
    when(mockResultSet.getString("BRAND")).thenReturn("levis");
    when(mockResultSet.getDouble("PRICE")).thenReturn(9580.00);

    // WHEN
    ProductDto resultDto = null;
    try {
      resultDto = productDaoH2.getById(product_Id);
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    // THEN
    verify(mockPreparedStatement).setInt(1, product_Id);
    verify(mockPreparedStatement).executeQuery();
    verify(mockResultSet).next();
    verify(mockResultSet).getString("NAME");
    verify(mockResultSet).getString("BRAND");
    verify(mockResultSet).getDouble("PRICE");

    Assertions.assertNotNull(resultDto);
    Assertions.assertEquals(productDto.getName(), resultDto.getName());
    Assertions.assertEquals(productDto.getBrand(), resultDto.getBrand());
    Assertions.assertEquals(productDto.getPrice(), resultDto.getPrice());
  }
  @DisplayName("modifica un producto si el id y la extructura del producto son validas")
  @Test
  void updateProduct_ifIdAndProductAreValid() throws SQLException {
    //GIVEN
    int product_Id = 1;
    ProductDto productDtoInit= new ProductDto("pantalon","levis",19400.00);

    when(mockPreparedStatement.executeUpdate()).thenReturn(1);

    //WHEN
    try {
      productDaoH2.update(productDtoInit,product_Id);
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    //THEN
    verify(mockPreparedStatement).setString(1, productDtoInit.getName());
    verify(mockPreparedStatement).setString(2, productDtoInit.getBrand());
    verify(mockPreparedStatement).setDouble(3, productDtoInit.getPrice());
    verify(mockPreparedStatement).setInt(4, product_Id);
    verify(mockPreparedStatement).executeUpdate();
  }
  @DisplayName("elimina un producto si el id es valido y si no esta siendo utilizado en la db")
  @Test
  void deleteProductIfIdValid() throws SQLException {
    //GIVEN
    int productId =1;
    when(mockPreparedStatement.executeUpdate()).thenReturn(1);
    //WHEN
    productDaoH2.delete(productId);
    //THEN
    verify(mockPreparedStatement).setInt(1,productId);
    verify(mockPreparedStatement).executeUpdate();

  }
}
