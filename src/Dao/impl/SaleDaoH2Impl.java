package Dao.impl;

import Dao.InterfacesH2.SaleDaoH2;
import Dao.dto.SaleDto;
import Exceptions.DAOException;
import Models.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.JdbcConfig;
public class SaleDaoH2Impl implements SaleDaoH2 {
    private  final Connection connection;

    public SaleDaoH2Impl() {
        this.connection = JdbcConfig.getDBConnection();
    }

    public SaleDaoH2Impl(Connection connection) {
        this.connection = connection;
    }

    PreparedStatement preparedStatement = null;

    @Override
    public void insert(SaleDto saleDto) throws DAOException {
       Sale newSale = convertDtoToObject(saleDto);

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO SALES ( PRODUCT_ID , PRICE , UNITS , DATE ,TOTAL) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,newSale.getProduct_id());
            preparedStatement.setDouble(2,newSale.getPrice());
            preparedStatement.setInt(3,newSale.getUnits());
            preparedStatement.setString(4,newSale.getDate());
            preparedStatement.setDouble(5,newSale.getTotal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("No se pudo cargar la venta",e);
        }
    }

    @Override
    public List <SaleDto>  getAll() throws DAOException{
        List <SaleDto> saleDtoList = new ArrayList<>();
        SaleDto saleDto = new SaleDto();
        convertDtoToObject(saleDto);
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM SALES");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
               saleDtoList.add(convertResulSetToDto(result));
            }
        } catch (SQLException e) {
            throw new  DAOException("error al buscar los productos",e);
        }
        return saleDtoList;
    }

    public Sale convertDtoToObject (SaleDto saleDto){
        Sale newSale= new Sale();
        newSale.setProduct_id(saleDto.getProduct_id());
        newSale.setPrice(saleDto.getPrice());
        newSale.setUnits(saleDto.getUnits());
        newSale.setDate(saleDto.getDate());
        newSale.setTotal(saleDto.getTotal());
        return newSale;
    }

    public SaleDto convertResulSetToDto(ResultSet result){
        SaleDto saleDto = new SaleDto();
        try {
            saleDto.setProduct_id(result.getInt("PRODUCT_ID"));
            saleDto.setPrice(result.getDouble("PRICE"));
            saleDto.setUnits(result.getInt("UNITS"));
            saleDto.setDate(result.getString("DATE"));
            saleDto.setTotal(result.getDouble("TOTAL"));
            convertDtoToObject(saleDto);
            return saleDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
