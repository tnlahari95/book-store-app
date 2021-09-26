
import com.ebook.dal.PartnerDAO;
import com.ebook.partner.PartnerInfo;

public class PartnerService {
    private PartnerDAO partnerDAO = new PartnerDAO();



    public void addPartner(PartnerInfo partner){
        try{
            partnerDAO.addPartner(partner);
        }catch (Exception ex){
            System.out.println("Partner service:Threw an error adding a partner account.");
        }
    }

    public void findPartnerById(int partnerID){
        try{
            PartnerInfo partner = partnerDAO.getPartner(partnerID);
            return partner;
        }catch(Exception ex){
            System.out.println("Partner Service: Couldn't find a partner by ID.");

        }
        return null;
    }


}
