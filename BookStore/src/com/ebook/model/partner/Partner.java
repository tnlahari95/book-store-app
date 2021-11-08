<<<<<<< HEAD
package com.ebook.model.partner;


public class Partner {
    private String name;
    private int partnerId;
    private String password;
    private String email;
    private PartnerInventory inventory;

    public Partner(String name, int partnerId, String password, String email) {

        this.name = name;
        this.partnerId= partnerId;
        this.password = password;
        this.email = email;
        this.inventory = new PartnerInventory();
    }

    public String getPartnerName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpartnerId() {
        return partnerId;
    }

    public void setpartnerId(int partnerId) {
        partnerId = partnerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
=======
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
}
>>>>>>> 04120a596ac7707a16f45a1d1a4283a9147cf0c9
