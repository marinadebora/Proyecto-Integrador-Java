package Test.dao.impl;


import Dao.dto.ExpensesDto;
import Dao.impl.ExpensesDaoH2Impl;
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

@DisplayName("Expenses Dao implementacion test")
public class ExpensesDaoH2ImplTest {
  @Mock
  private Connection mockConnection;
  @Mock
  private PreparedStatement mockPreparedStatement;
  @Mock
  private ResultSet mockResultSet;
  private ExpensesDaoH2Impl expensesDaoH2;
  @BeforeEach
  void setUp() throws SQLException {
    MockitoAnnotations.initMocks(this);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    expensesDaoH2 = new ExpensesDaoH2Impl(mockConnection);
  }
  @Test
  @DisplayName("Prueba el metodo insert si los datos son validos")
   void testInsertExpenses_WhenTheExpensesIsValid() throws SQLException {
    //GIVEN
    ExpensesDto expensesDto = new ExpensesDto("compra","libreria",4500.00);

    when(mockPreparedStatement.executeUpdate()).thenReturn(1);

    //WHEN
    try {
      expensesDaoH2.insert(expensesDto);
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    //THEN
    verify(mockPreparedStatement).setString(1, expensesDto.getExpenseType());
    verify(mockPreparedStatement).setString(2, expensesDto.getAddressee());
    verify(mockPreparedStatement).setDouble(3, expensesDto.getAmount());
    verify(mockPreparedStatement).executeUpdate();

  }
  @Test
  @DisplayName("Prueba el metodo getAll si los datos son validos")
  void getAll_ExpensesIfTheyExistInDB() throws SQLException {
    // GIVEN
    List<ExpensesDto> exensesList = new ArrayList<>();
    exensesList= List.of(
        new ExpensesDto("pago servicio","edesur",15000.00),
        new ExpensesDto("compra","libreria",4200.00)
    );

    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(true, true,false);
    when(mockResultSet.getString("EXPENSETYPE")).thenReturn("pago servicio","compra");
    when(mockResultSet.getString("ADDRESSEE")).thenReturn("edesur","libreria");
    when(mockResultSet.getDouble("AMOUNT")).thenReturn(15000.00,4200.00);
    when(mockResultSet.getString("DATE")).thenReturn("");
    when(mockResultSet.getDouble("TOTAL")).thenReturn(1.0);
    // WHEN

    List<ExpensesDto> result = null;
    try {
      result = expensesDaoH2.getAll();
    } catch (DAOException e) {
      throw new RuntimeException(e);
    }

    //THEN
    verify(mockPreparedStatement).executeQuery();
    verify(mockResultSet, times(2)).getString("EXPENSETYPE");
    verify(mockResultSet, times(2)).getString("ADDRESSEE");
    verify(mockResultSet, times(2)).getDouble("AMOUNT");

    Assertions.assertEquals(exensesList.size(), result.size());
  }
}

