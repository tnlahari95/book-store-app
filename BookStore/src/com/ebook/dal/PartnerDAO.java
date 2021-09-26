

public class PartnerDAO {
    public PartnerDAO(){}


    public void addPartner(Partner partner){

            Connection con = DBHelper.getConnection();
            PreparedStatement Partner_Pst = connection.Partner_Pst("INSERT INTO partner (partnerID, name, email,password) VALUES(?, ?, ?,?)");
            try {
                //Insert the partner object
                Partner_Pst.setString(1, partner.getPartnerId());
                Partner_Pst.setString(2, partner.getPartnerName());
                Partner_Pst.setString(3, partner.getEmail());
                Partner_Pst.setString(4, partner.getPassword());
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

}