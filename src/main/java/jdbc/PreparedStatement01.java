package jdbc;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice","postgres","118411");
        Statement st= con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees
        // değerini 9999 olarak güncelleyin.

        // 1.Adım: Prepared statement query

        String sql1="update companies set number_of_employees=? where company=?";

        // 2.Adım: PreparedStatement objesini olustur

        PreparedStatement pst1= con.prepareStatement(sql1);

        // 3. Adım: set..() methodları ile soru işaretleri için değer gir

        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");
        
        // 4. Adım: Execute query
        
        int updateRowSayısı =  pst1.executeUpdate();
        System.out.println("updateRowSayisi = " + updateRowSayısı);
        
        String sql2="select * from companies";

        ResultSet result1=st.executeQuery(sql2);

        while (result1.next()){

            System.out.println(result1.getInt(1)+" "+result1.getString(2)+" "+ result1.getInt(3));
        }



        //google için degisiklik



        pst1.setInt(1,15000);
        pst1.setString(2,"GOOGLE");



        int updateRowSayısı2 =  pst1.executeUpdate();
        System.out.println("updateRowSayisi = " + updateRowSayısı2);

        String sql3="select * from companies";

        ResultSet result2=st.executeQuery(sql3);

        while (result2.next()){

            System.out.println(result2.getInt(1)+" "+result2.getString(2)+" "+ result2.getInt(3));
        }

        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

        String sql4 = "SELECT * FROM ?";
        PreparedStatement pst2=con.prepareStatement(sql4);
        pst2.setString(1,"companies");

        ResultSet result4=pst2.executeQuery();

        while (result4.next()){
            System.out.println(result4.getInt(1)+" "+result4.getString(2)+" "+ result4.getInt(3));
        }

    }
}
