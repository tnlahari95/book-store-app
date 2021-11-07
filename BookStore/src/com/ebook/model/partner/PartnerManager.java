package com.ebook.model.partner;
import java.util.Set;

import com.ebook.dal.PartnerDAO;

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
	 public Partner updatePartnerName(String partnerID, String partnerName) {
		PartnerDAO pd = new PartnerDAO();
		return pd.updatePartnerName(partnerID, partnerName);
	}
	
	public Partner updatePartnerDetails(String partnerID, String partnerDetails) {
		PartnerDAO pd = new PartnerDAO();
		return pd.updatePartnerDetails(partnerID, partnerDetails);
	}
}
