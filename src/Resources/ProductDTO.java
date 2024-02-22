package Resources;

public class ProductDTO {

    private String type;
    private String prdt_name; 
    private int uom;
    private String mnfdate; 
    private String expdate; 
    private double price;
    private String manufacturer;
    private int prdt_count;


    public ProductDTO(String type, String prdt_name, int uom, String mnfdate, String expdate, double price, String manufacturer, int prdt_count) {
        this.type = type;
        this.prdt_name = prdt_name;
        this.uom = uom;
        this.mnfdate = mnfdate;
        this.expdate = expdate;
        this.price = price;
        this.manufacturer = manufacturer;
        this.prdt_count = prdt_count;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrdt_name() {
        return this.prdt_name;
    }

    public void setPrdt_name(String prdt_name) {
        this.prdt_name = prdt_name;
    }

    public int getUom() {
        return this.uom;
    }

    public void setUom(int uom) {
        this.uom = uom;
    }

    public String getMnfdate() {
        return this.mnfdate;
    }

    public void setMnfdate(String mnfdate) {
        this.mnfdate = mnfdate;
    }

    public String getExpdate() {
        return this.expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrdt_count() {
        return this.prdt_count;
    }

    public void setPrdt_count(int prdt_count) {
        this.prdt_count = prdt_count;
    }

}


