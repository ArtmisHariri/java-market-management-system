import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Scanner;

public class Product {

    private static String name;
    private String productID ;
    private static Type type;
    private String brand;
    private int price;
    private int number;
    private String productionDate;
    private String expirationDate;
    private String factoryAddress;
    private BuyStatus buyStatus;
    private Seller seller;
    Scanner scanner = new Scanner(System.in);

    public Product(String name, String productID , String brand , int price , int number , Type type , String factoryAddress) {
        this.name = name;
        this.productID = productID ;
        this.type = type ;
        this.brand = brand ;
        this.price = price;
        this.number = number ;
        this.productionDate = productionDate ;
        this.expirationDate = expirationDate ;
        this.factoryAddress = factoryAddress ;
        this.seller = Market.getMarket();
    }

    public Product(InputStream in) {
    }


    public static String getName() {
        return name;
    }

    public String getProductID() {
        return productID;
    }

    public String getBrand() {
        return brand;
    }
    public static Type getProductType() {
        return type;
    }
    public int getPrice() {
        return price;
    }
    public int getNumber(){
        return number;
    }
    public String getProductionDate(){
        return productionDate;
    }
    public String getExpirationDate(){
        return expirationDate;
    }
    public String getFactoryAddress(){
        return factoryAddress;
    }


    public BuyStatus getBuyStatus() {
        return buyStatus;
    }

    public Seller getSeller() {
        return seller;
    }

    public  void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setBuyStatus() {
        if (number  > 0 ) {
            this.buyStatus = BuyStatus.AWAILABLE;


            System.out.println("THANKS FOR YOUR SHOPPING");
        }

    }

    public void setBorrowStatus2BorrowExpired() {
        if (number == 0) {
            this.buyStatus = BuyStatus.UNAWAILABLE;
        } else {
            System.out.println("SORRY! WE ARE OUT OF THIS PRODUCT");
        }
    }
    public String toString() {
        return "product{" + "name=" + name + ", productID=" + productID + ", price=" + price + " , type=" + type + " ,brand=" + brand + " ,number=" + number +
                " ,productionDate=" + productionDate + " ,expirationDate=" + expirationDate + " , factoryAddress=" + factoryAddress + " , buyStatus=" + buyStatus +'}';
    }

    public String getFullInfotoAdmin() {
        return "product{" + "name=" + name + ", productID=" + productID + ", price=" + price + " , type=" + type + " ,brand=" + brand + " ,number=" + number +
            " ,productionDate=" + productionDate + " ,expirationDate=" + expirationDate + " , factoryAddress=" + factoryAddress + " , buyStatus=" + buyStatus + " , seller=" + seller.getName() +'}';
    }

    public static Product addProduct() {
        Product product = new Product(System.in);

        System.out.println("Enter products Name");
        String productName = product.setName();
        System.out.println("\nEnter the productID");
        String productID = product.setProductID();
        System.out.println("\nENTER THE BRAND OF PRODUCT");
        String productBrand = product.setBrand();
        System.out.println("\nENTER THE PRICE OF PRODUCT");
        int productPrice = product.setPrice();
        System.out.println("\nEnter the number of product");
        int productNumber = product.setNumber();
        System.out.println("\nEnter the production date of product");
        String productionDate = product.setProductionDate();
        System.out.println("\nEnter the expiration date of product");
        String expirationDate = product.setExpirationDate();
        System.out.println("\nEnter the address of factory");
        String factoryAddress = product.setFactoryAddress();
        System.out.println("\nEnter the type of product");
        Type type = product.setProductType();
      
        return new Product(productName, productID, productBrand,productPrice,productNumber,type,factoryAddress);

    }

    private Type setProductType() {
        String input = scanner.next();
        
        switch(input){
            case "FOOD":{
                return ProductType.FOOD;
            }
            case "ELECTRONIC":{
                return ProductType.ELECTRONIC;
            }
            case "STATIONARY":{
                return ProductType.STATIONARY;
            }
            case "CLOTHING":{
                return ProductType.CLOTHING;
            }
            case "PHARAMACETICAL":{
                return ProductType.PHARAMACEUTICAL;
            }
            case "ACCESSORY":{
                return ProductType.ACCESSORY;
            }
            default:{
                return ProductType.STATIONARY;
            }
        }
    }

    private String setFactoryAddress() {
        String address = scanner.next();
        return address;
    }

    private String setExpirationDate() {
        String date = scanner.next();
        return date;
    }

    private String setProductionDate() {
        String date = scanner.next();
        return date;
    }

    private int setNumber() {
        int price = scanner.nextInt();
        return price;
    }

    private int setPrice() {
        int price = scanner.nextInt();
        return price;
    }

    private String setBrand() {
        String brand = scanner.next();
        return brand;
    }

    private String setProductID() {
        String ID = scanner.next();
        return ID;
    }

    private String setName() {
        String name = scanner.next();
        return name;
    }

    public void chargeProduct(){
        Product product = new Product(System.in);
        System.out.println("\n name of product:" + name );
        name = product.getName();
        System.out.println("\n type of product:" + type);
        type = Product.getProductType();
        System.out.println("expiration date:" + expirationDate);
        expirationDate = product.getExpirationDate();
        System.out.println("number of product:" + number);
        number = product.getNumber();
    }

}


