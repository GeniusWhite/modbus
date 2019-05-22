package lv.modbusProject.DAL;

import lv.modbusProject.Domain.Event;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Repository {




    public void addEvent(Event event) {

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "insert into accessEvent (eventInfo)" +
                "values (?)";


        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1, event.getEventInfo());



            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
