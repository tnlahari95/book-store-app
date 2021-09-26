

public class PartnerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bookstorecomp433";
    private static final String username = "book_store";
    private static final String password = "123";
    , "123"

    private static Connection connection;
    static{
        try {

            Class.forName("org.mysql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("DB Partner: Check your SQL JDBC Driver");
            e.printStackTrace();
            return null;
        }

        try{
            connection = DriverManager.getConnection(URL,username,password);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void addPartner(Partner partner){

            Connection con = DBHelper.getConnection();
            PreparedStatement Partner_Pst = null;
            try {
                //Insert the customer object
                String custStm = "INSERT INTO partner (partnerID, name, email,password) VALUES(?, ?, ?,?)";
                Partner_Pst = con.prepareStatement(Partner_Pst);
                Partner_Pst.setString(1, Partner_Pst.getPartnerId());
                Partner_Pst.setString(2, Partner_Pst.getPartnerName());
                Partner_Pst.setString(3, Partner_Pst.getEmail());
                Partner_Pst.executeUpdate();
            } catch (SQLException ex) {

            } finally {

                try {
                    if (con != null) {
                        con.close();
                    }

                } catch (SQLException ex) {
                    System.err.println("PartnerDAO: Threw a SQLException saving the customer object.");
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void addPartner(Partner partner){
    Statement statement = connection.createStatement();
    try{
        Statement statement1 = connection.creatStatement();
        String sql = "INSERT INTO partner VALUES"
    }





}