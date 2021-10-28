package com.ebook.model.service;
import com.ebook.dal.PartnerDAO;
import com.ebook.model.partner.Partner;
//this class is a Facade between Partner and PartnerDAO classes



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
    
    
    public void removePartner(int id) {
    	try {
     		partnerDAO.removePartner(id);
    	}catch(Exception ex) {
    		 System.out.println("Partner Service: Couldn't delete a partner.");	
    	}	
    }
    
    public void updatePartnerPassword(int id, String newPassword) {
    	try {
    		partnerDAO.resetPartnerPassword(id, newPassword);	
    	}catch(Exception ex) {
   		 System.out.println("Partner Service: Couldn't update password for"+ findPartnerById(id));	
     	}	
    	
    }
    
    public void updatePartnerEmail(int id, String newEmail) {
    	partnerDAO.updatePartnerEmail(id, newEmail);
    	
    }
    
}
