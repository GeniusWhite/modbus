package lv.modbusProject.DAL;

import lv.modbusProject.Domain.Event;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SystemSettingRepository {


    public List<Event> getSystemSettings(String date) {

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        DbConnection dbConnection  = new DbConnection ();


        String sql = "Select* from accessEvent where DATEPART(yy, eventDate)=? and DATEPART(mm, eventDate)=? and DATEPART(dd, eventDate)=?";

        List<String> dates = new ArrayList(Arrays.asList(date.split("\\D"))) ;

        List<Event> eventList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dates.get(2));
            preparedStatement.setString(2, dates.get(1));
            preparedStatement.setString(3, dates.get(0));


            resultSet = preparedStatement.executeQuery();


            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                Event event = new Event();
                event.setEventID(resultSet.getInt(1));
                event.setEventDateString(resultSet.getTimestamp(2).toLocalDateTime().toLocalDate().format(dateTimeFormatter));
                event.setEventTimeString(resultSet.getTimestamp(3).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
                event.setEventInfo(resultSet.getString(4));


                eventList.add(i, event);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return eventList;
    }




}
