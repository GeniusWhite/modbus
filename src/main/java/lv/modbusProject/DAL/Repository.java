package lv.modbusProject.DAL;

import lv.modbusProject.Domain.Worker;
import lv.modbusProject.Domain.Event;

import org.springframework.stereotype.Component;

import java.sql.*;
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

    public List<Event> getEvent(String date) {

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

    public void checkKey(String key) {




    }

    public List<Worker> getWorkers() {

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;
        DbConnection dbConnection  = new DbConnection ();

        String sql = "select worker.workerID, worker.firstName, worker.lastName, workerKey.keyString, workerKey.keyLifeStart, workerKey.keyLifeEnd " +
                "from worker " +
                "JOIN workerKey on worker.workerKeyID = workerKey.workerKeyID";


        List<Worker> workers = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();


            int i = 0;
            while (resultSet.next()) {

                Worker worker = new Worker();

                worker.setWorkerID(resultSet.getInt(1));
                worker.setFirstName(resultSet.getString(2));
                worker.setLastName(resultSet.getString(3));
                worker.setKeyString(resultSet.getString(4));
                worker.setKeyLifeStart(resultSet.getTimestamp(5));
                worker.setKeyLifeEnd(resultSet.getTimestamp(6));

                workers.add(i,worker);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }







        return workers;
    }

    public List<Event> getEventRange(String date) {


           String [] dates = date.split("/");

        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;
        DbConnection dbConnection  = new DbConnection ();

        String sql = "Select* from accessEvent where (DATEPART(yy, eventDate) between ? and ?) and (DATEPART(mm, eventDate) between ? and ?) and (DATEPART(dd, eventDate) between ? and ?)";

        List<String> dateFrom = new ArrayList(Arrays.asList(dates[0].split("\\D"))) ;
        List<String> dateTill = new ArrayList(Arrays.asList(dates[1].split("\\D"))) ;

        List<Event> eventList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dateFrom.get(2));
            preparedStatement.setString(2, dateTill.get(2));
            preparedStatement.setString(3, dateFrom.get(1));
            preparedStatement.setString(4, dateTill.get(1));
            preparedStatement.setString(5, dateFrom.get(0));
            preparedStatement.setString(6, dateTill.get(0));

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
