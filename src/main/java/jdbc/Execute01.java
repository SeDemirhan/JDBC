package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        // 2.Adım: Database'e bağlan
      Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice","postgres","118411");

        //3.Adım: Statement olustur
        Statement st= con.createStatement();

        //4.Adım :  Query calıstır

        //1.Example: "workers" adında bir table oluşturup
        // "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        String sql1="CREATE TABLE workers2(worker2_id VARCHAR(50),worker2_name VARCHAR(50),worker2_salary INT)";
       // boolean result = st.execute(sql1);
       // System.out.println(result);




        //2.Örnek: Alter table by adding worker_address column into the workers table

        String sql2="alter table workers2 add worker2_address varchar(50)";
       // st.execute(sql2);



       //3.Example: Drop workers table

        String sql3="drop table workers2";
       //st.execute(sql3);



        //5. Adım: Bağlantı ve statementi kapat
       con.close();
       st.close();

    }
}
