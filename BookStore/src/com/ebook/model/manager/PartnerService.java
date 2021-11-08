
package com.ebook.model.manager;

import com.ebook.dal.PartnerDAO;
import com.ebook.model.partner.Partner;

public class PartnerService {
    private PartnerDAO partnerDAO = new PartnerDAO();

    public void addPartner(Partner partner){
        try{
            partnerDAO.addPartner(partner);
        }catch (Exception ex){
            System.out.println("Partner service:Threw an error adding a partner account.");
        }
    }

    public Partner findPartnerById(int partnerID){
        try{
            Partner partner = partnerDAO.findPartnerById(partnerID);
            return partner;
        }catch(Exception ex){
            System.out.println("Partner Service: Couldn't find a partner by ID.");

        }
        return null;
    }
}
