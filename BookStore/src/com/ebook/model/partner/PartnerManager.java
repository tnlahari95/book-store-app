package com.ebook.model.partner;
import java.util.Set;

import com.ebook.dal.PartnerDAO;



public class PartnerManager {
    private PartnerDAO partnerDAO = new PartnerDAO();

    
    public Partner addPartner(String name, String partnerInfo){
        
        Partner partner =  partnerDAO.addPartner(name,partnerInfo);
          return partner;
          
    }

    public Partner findPartnerById(String partnerID){
        try{
            Partner partner = partnerDAO.findPartnerById(partnerID);
            return partner;
        }catch(Exception ex){
            System.out.println("Partner Service: Couldn't find a partner by ID.");

        }
        return null;
    }
    
    
    public void removePartner(String id) {
    	try {
     		partnerDAO.removePartner(id);
    	}catch(Exception ex) {
    		 System.out.println("Partner Service: Couldn't delete a partner.");	
    	}	
    }
    
    
    public Set<Partner> getAllPartners(){
    	try {
    		return partnerDAO.getAllPartners();	
    	}catch(Exception ex) {
   		 	System.out.println("Partner Service: Couldn't find the list of partners");	
     	}
    	return null; 	
    }
    
}
