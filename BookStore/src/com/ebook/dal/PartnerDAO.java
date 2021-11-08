<<<<<<< HEAD
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
    
   public void removePartner(int id) {
	   partners.remove(id);

   }
   public void updatePartnerEmail(int id, String newEmail) {
	   Partner partner = findPartnerById(id);
	   partner.setEmail(newEmail);   
   }
   
   public void resetPartnerPassword(int id,String newPassword) {
	   Partner partner = findPartnerById(id);
	   partner.setPassword(newPassword);
	   
   }
}
=======
package com.ebook.dal;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.ebook.model.partner.Partner;

public class PartnerDAO {
    public PartnerDAO(){}
    
   private static HashMap<String,Partner>partners = new HashMap<>();
   
   
   public Partner addPartner(String name, String partnerInfo) {
	   
	  Partner partner = new Partner(name, partnerInfo);
	  
	  Random randomGenerator = new Random();
	  int randomInt = randomGenerator.nextInt(10000);
	  String id = "PI" + randomInt;
	  
	  partner.setpartnerId(id);
	 
	  partners.put(id,partner);
	  return partner;
   }
   
   public Partner findPartnerById(String id) {
	 return partners.get(id);
   }
    
   public void removePartner(String id) {
	   partners.remove(id);
	  
   }

   
   public Set<Partner>getAllPartners(){
	   Set<Partner> partners = new HashSet<>();
	   Iterator<Partner>partner = partners.iterator();
	   while(partner.hasNext()) {
		   partners.add((Partner) partner);
	   }
	   return partners;
   }
}
>>>>>>> 04120a596ac7707a16f45a1d1a4283a9147cf0c9
    