public class PartnerInventory{

    // Integer value is for keeping track of remain quantity of the product.
    Map <Product,Integer> partnerIntentory = new HashMap<>();

    public Map<Product,Integer> getPartnerIntentory() {
        return partnerIntentory;
    }

    public void setPartnerIntentory(Map<Product,Integer> partnerIntentory) {
        this.partnerIntentory = partnerIntentory;
    }

    public void updateQuantity(){

    }

}