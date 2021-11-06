package com.ebook.model.partner;

public class Partner {
    private String name;
    private String partnerId;
    private PartnerInventory inventory;
   	private String partnerInfo;
    
   public Partner(String name,String partnerInformation) {
        this.name = name;
        this.inventory = new PartnerInventory();
        this.partnerInfo = partnerInformation;
      }
   public Partner() {}


    public String getPartnerName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpartnerId() {
        return partnerId;
    }

    public void setpartnerId(String id) {
        this.partnerId = id;
    }

    public String getPartnerInfo() {
		return partnerInfo;
	}

	public void setPartnerInfo(String partnerInfo) {
		this.partnerInfo = partnerInfo;
	}





	
}