package Test.dao.impl;

import Dao.dto.SaleDto;
import Dao.impl.SaleDaoH2Impl;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@DisplayName("Sale Dao implementacion test")
public class SaleDaoH2ImplTest {
  @Mock
  private Connection mockConnection;
  @Mock
  private PreparedStatement mockPreparedStatement;
  @Mock
  private ResultSet mockResultSet;
  private SaleDaoH2Impl saleDaoH2;
  @BeforeEach
  void setUp() throws SQLException {
    MockitoAnnotations.initMocks(this);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    saleDaoH2 = new SaleDaoH2Impl(mockConnection);
  }
  @Test
  @DisplayName("Prueba el metodo insert si los datos son validos")
  void testInsertSale_WhenTheExpensesIsValid() throws SQLException {
    //GIVEN
    SaleDto saleDto = new SaleDto(1,1620.00,3);

    when(mockPreparedStatement.executeUpdate()).thenReturn(1);

    //WHEN
    try {
      saleDaoH2.insert(saleDto);
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    //THEN
    verify(mockPreparedStatement).setInt(1, saleDto.getProduct_id());
    verify(mockPreparedStatement).setDouble(2, saleDto.getPrice());
    verify(mockPreparedStatement).setInt(3, saleDto.getUnits());
    verify(mockPreparedStatement).executeUpdate();

  }
  @Test
  @DisplayName("Prueba el metodo getAll si los datos son validos")
  void getAll_ExpensesIfTheyExistInDB() throws SQLException {
    // GIVEN
    List<SaleDto> saleList = new ArrayList<>();
    saleList= List.of(
        new SaleDto("Sat Sep 02 22:52:54 ART 2023",12400.00,1,12400.00,1),
        new SaleDto("Sat Sep 02 22:52:54 ART 2023",19500.00,2,9750.00,2)
    );

    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(true, true,false);
    when(mockResultSet.getString("DATE")).thenReturn("Sat Sep 02 22:52:54 ART 2023");
    when(mockResultSet.getDouble("TOTAL")).thenReturn(12400.00,19500.00);
    when(mockResultSet.getInt("PRODUCT_ID")).thenReturn(1,2);
    when(mockResultSet.getDouble("PRICE")).thenReturn(12400.00,9750.00);
    when(mockResultSet.getInt("UNITS")).thenReturn(1,2);

    // WHEN

    List<SaleDto> result = null;
    try {
      result = saleDaoH2.getAll();
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    //THEN
    verify(mockPreparedStatement).executeQuery();
    verify(mockResultSet, times(2)).getString("DATE");
    verify(mockResultSet, times(2)).getDouble("TOTAL");
    verify(mockResultSet, times(2)).getInt("PRODUCT_ID");
    verify(mockResultSet, times(2)).getDouble("PRICE");
    verify(mockResultSet, times(2)).getInt("UNITS");

    Assertions.assertEquals(saleList.size(), result.size());
  }
}
