package Dao.impl;

import Dao.InterfacesH2.SaleDaoH2;
import Dao.dto.ProductDto;
import Dao.dto.SaleDto;
import Models.Product;
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
       Sale newSale = convertDtoToObject(saleDto);

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO SALE ( PRODUCT , PRICE , UNITS , DATE ,TOTAL) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,newSale.getProduct_id());
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
        SaleDto saleDto = new SaleDto();
        convertDtoToObject(saleDto);
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM SALES");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){

                saleDto.setProduct_id(result.getInt("PRODUCT_ID"));
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

    public Sale convertDtoToObject (SaleDto saleDto){
        Sale newSale= new Sale();
        newSale.setProduct_id(saleDto.getProduct_id());
        newSale.setPrice(saleDto.getPrice());
        newSale.setUnits(saleDto.getUnits());
        newSale.setDate(saleDto.getDate());
        newSale.setTotal(saleDto.getTotal());
        return newSale;
    }


}
