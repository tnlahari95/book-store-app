package com.ebook.dal;


import java.util.HashMap;

import com.ebook.model.partner.Partner;

public class PartnerDAO {
    public PartnerDAO(){}
    
   private static HashMap<Integer,Partner>partners = new HashMap<>();
   
   
   public void addPartner(Partner partner) {
	  int id = partner.getpartnerId();
	  partners.put(id,partner);
   }
   
   public Partner findPartnerById(int id) {
	 return partners.get(id);
   }
   
   
   public void removePartner(Partner partner) {
	   partners.remove(partner);

   }
}
    

   
   
   
