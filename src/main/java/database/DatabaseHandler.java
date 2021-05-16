package database;


import java.sql.*;

public class DatabaseHandler {

    private static String dbPassord = "12345";
    private static String dbUser = "root";

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException{

        Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/userscarsharing",dbUser, dbPassord);
        Class.forName("com.mysql.cj.jdbc.Driver");
        return  connectionString;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_NAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_NUMBER + ")" + "VALUES(?,?,?)";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getUserName());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getNumber());

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

        public ResultSet getUser(User user){
            ResultSet resultSet = null;

            String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                    Const.USERS_NAME + "=? AND " + Const.USERS_PASSWORD + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1,user.getUserName());
                prSt.setString(2,user.getPassword());

                prSt.executeQuery();
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
            return resultSet;
        }


}