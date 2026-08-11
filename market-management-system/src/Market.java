
import java.util.ArrayList;


public class Market implements Seller {

    private final String name;
    private static Market market = null;
    public static int REMAINING_Product;
    public static long BEST_SELLER;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    private Market(String name) {
        this.name = name;
    }

    public static Market getMarket() {
        if (market == null) {
            Market.market = new Market("Target Market grocery store");
            System.out.println("Market named <"+market.getName()+"> is added");

        }
        return Market.market;
    }

    @Override
    public String getName() {
        return name;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }




    public UI addProduct(Product product) {
        products.add(product);
        return new UI("Added Successfully", true);
    }


    public UI deleteProductFromMarket(Product product) {
        if (!products.contains(product)) {
            return new UI("Market does not have this Product", false);
        } else {
            if (product.getBuyStatus()==BuyStatus.AWAILABEL) {
                products.remove(product);
                return new UI("Deleted successfully", true);
            } else {
                String message = "Product is not Awailable and can not be deleted while it is unawailable";
                return new UI(message, false);
            }
        }

    }

    
    public UI addAdmin(Admin admin) {
        admins.add(admin);
        return new UI("Added Successfully", true);
    }

    public UI deleteAdmin(Admin admin) {

        if (!admins.contains(admin)) {
            return new UI("Market does not have this admin", false);
        } else {
            admins.remove(admin);
            return new UI("Deleted Successfully", true);
        }

    }

    public UI addMember(Member member) {
        members.add(member);
        return new UI("Added Successfully", true);
    }

    public UI deleteMember(Member member) {

        for(Member m: members) {
            if (m.getLastName() == member.getLastName()
             && m.getPassword()== member.getPassword()) {
                    members.remove(member);
                    return new UI("Deleted Successfully", true);
                }
        }


            if (member.getBoughtProducts().size()>0) {
                String message = "member has bought product and can not be deleted";
                return new UI(message, false);
            }

            return new UI("Member Doesn't Exist", true);
    }

    public UI manageBuyRequest(Product product, Member member) {
        boolean productIsAvailabe = product.getBuyStatus() == BuyStatus.AWAILABEL;
        if (productIsAvailabe) {
            member.addProducttoBoughtList(product);
            product.setSeller(member);
            product.setBuyStatus();
            return new UI("Bought Successfully", true);
        }
         else {
            return new UI("Sorry, Product Status is " + product.getBuyStatus(), false);
        }
    }
    public UI manageGiveBackRequest(Product product, Member member) {
        if (member.getBoughtProducts().contains(product)) {
            product.setSeller(Market.getMarket());
            return new UI("Product was given back successfully", true);

        } else {
            return new UI("Wrong Order in Give Back request", false);
        }
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public Member authorizeAndReturnMember(int userID, String userPassword) {
        for (Member member : members) {
            if (member.authorizeSignInInfo(userID, userPassword)) {
                return member;
            }
        }

        return null;
    }

    public Admin authorizeAndReturnAdmin(String name, String password) {
        for (Admin admin : admins) {
            if (admin.authenticateAdmin(name, password)) {
                return admin;
            }
        }

        return null;
    }

}
