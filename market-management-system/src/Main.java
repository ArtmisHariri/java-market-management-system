import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input is a String of command and fields
        // First an "addMarket" is necessary
        // Then an "addAdmin"
        // Members are accessed with an ID(int) and a password(String)

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        while(true){

            switch(words[0]){

                case "addMarket":{
                    Market market = Market.getMarket();
                    break;
                }
                case "printMembers":{
                    Market market = Market.getMarket();
                    List <Member> members = market.getMembers();
                    for(Member m: members){
                        System.out.println(m.getFirstName()+" "+m.getLastName());
                    }
                    break;
                }
                case "printProducts":{
                    Market market = Market.getMarket();
                    List <Product> products = market.getProducts();
                    for(Product p: products){
                        System.out.println(p.getName()+" "+p.getPrice()+"$ "+p.getSeller().getName());
                    }
                    break;
                }
                case "addProduct":{
                    Market market = Market.getMarket();
                    Product product = Product.addProduct();
                    market.addProduct(product);

                    break;
                }
                case "deleteProduct":{
                    Market market = Market.getMarket();
                    Product product = Product.addProduct();
                    market.deleteProductFromMarket(product);
                    break;
                }
                case "addMember":{
                    Market market = Market.getMarket();
                    Member member = Member.createMember();
                    market.addMember(member);
                    break;
                }
                case "deleteMember":{                       // Example: deleteMember firstName lastName password
                    String firstName = words[1];
                    String lastName = words[2];
                    String password = words[3];
                    Market market = Market.getMarket();
                    Member member = new Member(firstName, lastName, password);
                    market.deleteMember(member);
                    break;
                }
                case "buy":{
                    Market market = Market.getMarket();
                    Member member = Member.createMember();
                    Product product = Product.addProduct();
                    market.manageBuyRequest(product, member);
                    break;
                }
                case "giveBack":{
                    Market market = Market.getMarket();
                    Member member = Member.createMember();
                    Product product = Product.addProduct();
                    market.manageGiveBackRequest(product, member);
                    break;
                }
                case "authorizeMember":{    // Example: authorizeMember 576 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    if(market.authorizeAndReturnMember(id, password) == null){
                        System.out.println("Member Is Not Found");
                    }else{
                        System.out.println("Member Is Authorized");
                    }
                    break;
                }
                case "addAdmin":{            // Example: addAdmin admin AdminP4$$W0RD
                    String name = words[1];
                    String password = words[2];
                    Admin admin = Admin.addAdimin(name, password);
                    Market market = Market.getMarket();
                    market.addAdmin(admin);
                    System.out.println("Admin Is Added");
                    break;
                }
                case "authorizeAdmin":{      // Example: authorizeAdmin admin AdminP4$$W0RD
                    Market market = Market.getMarket();
                    String name = words[1];
                    String password = words[2];
                    Admin output = market.authorizeAndReturnAdmin(name, password);
                    if(output != null){
                        System.out.println("Admin Is Authorized");
                    }else{
                        System.out.println("Admin Is Not Found");
                    }
                    break;
                }
                case "getNameMember":{        // Example: getNameMember 4353 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    if(member != null){
                        System.out.println(member.getFirstName()+" "+member.getLastName());
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }
                case "getFirstNameMember":{        // Example: getFirstNameMember 443 AP4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    if(member != null){
                        System.out.println(member.getFirstName());
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }
                case "getLastNameMember":{           // Example: getLastNameMember 483 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    if(member != null){
                        System.out.println(member.getLastName());
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }
                case "getFullInfotoAdmin":{         // Example: getFullInfotoAdmin 4853 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    if(member != null){
                        System.out.println(member.getFullInfotoAdmin());
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }

                case "addProducttoBoughtList":{         // Example: addProducttoBoughtList 3853 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    Product product = Product.addProduct();
                    if(member != null){
                        member.addProducttoBoughtList(product);
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }

                case "addProducttoRemainingList":{         // Example: addProducttoRemainingList 53 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    Product product = Product.addProduct();
                    if(member != null){
                        member.addProducttoRemainingList(product);
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }

                case "printBoughtProducts":{         // Example: printBoughtProducts 53 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    if(member != null){
                        List<Product> products = member.getBoughtProducts();
                        for (Product p: products){
                            System.out.println(p.getName()+" "+p.getPrice()+"$ "+p.getSeller().getName());
                        }
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }

                case "getRemainingProducts":{         // Example: getRemainingProducts 3153 P4$$W0RD
                    Market market = Market.getMarket();
                    int id = Integer.parseInt(words[1]);
                    String password = words[2];
                    Member member = market.authorizeAndReturnMember(id, password);
                    if(member != null){
                        List<Product> products = member.getRemainingProducts();
                        for (Product p: products){
                            System.out.println(p.getName()+" "+p.getPrice()+"$ "+p.getSeller().getName());
                        }
                    }
                    else{
                        System.out.println("Member not found");
                    }
                }

                case "exit":{
                    return;
                }
            }

            words = scanner.nextLine().split(" ");

        }
            
    }
}
