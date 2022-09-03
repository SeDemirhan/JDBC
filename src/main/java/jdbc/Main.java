package jdbc;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        //DBWork objesini olustur
        DBWork db = new DBWork();

        //Connection methodunu çağır

        Connection con =db.connect_to_db("sql_practice","postgres","118411");

        //Yeni table oluşturma methodunu çağır.
        db.createTable(con,"employees");
    }
}
