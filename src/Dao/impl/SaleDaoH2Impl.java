package Dao.impl;

import Dao.Interfaces.SaleDaoH2;
import Dao.dto.SaleDto;
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

    PreparedStatement preparedStatement = null;

    @Override
    public void insert(SaleDto saleDto) {
        Sale newSale= new Sale();
        newSale.setProduct(saleDto.getProduct());
        newSale.setPrice(saleDto.getPrice());
        newSale.setUnits(saleDto.getUnits());
        newSale.setDate(saleDto.getDate());
        newSale.setTotal(saleDto.getTotal());


        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO SALE ( PRODUCT , PRICE , UNITS , DATE ,TOTAL) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,newSale.getProduct());
            preparedStatement.setDouble(2,newSale.getPrice());
            preparedStatement.setInt(3,newSale.getUnits());
            preparedStatement.setString(4,newSale.getDate());
            preparedStatement.setDouble(5,newSale.getTotal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void  getAll() {
        List <SaleDto> saleDtoList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM SALE");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                SaleDto saleDto = new SaleDto();
                saleDto.setProduct(result.getString("PRODUCT"));
                saleDto.setPrice(result.getDouble("PRICE"));
                saleDto.setUnits(result.getInt("UNITS"));
                saleDto.setDate(result.getString("DATE"));
                saleDto.setTotal(result.getDouble("TOTAL"));
                saleDtoList.add(saleDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        saleDtoList.forEach(System.out::println);
    }

    @Override
    public void update(SaleDto saleDto) {

    }

    @Override
    public void delete(int saleId) {

    }
}
