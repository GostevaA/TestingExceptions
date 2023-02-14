public class Smartphone extends Product {
    protected String vendor;

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Smartphone(String name, int id, int price, String vendor) {
        super(name, id, price);
        this.vendor = vendor;
    }
}
