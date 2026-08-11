

import java.util.ArrayList;
import java.util.Scanner;


public class Member implements Seller {

    private int memberCounter = 0;
    private static int memberID;
    private int mamberID;

    public static int getMemberID() {
        return memberID;
    }

    private static String firstName;

    public static String getFirstName() {
        return firstName;
    }

    private static String lastName;

    public static String getLastName() {
        return lastName;
    }

    private static String password;

    public static String getPassword() {
        return password;
    }

    private ArrayList<Product> BoughtProducts;
    private ArrayList<Product> RemainingProducts;

    public Member(String firstName, String lastName, String password ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberID = memberCounter++;
        this.password = password;
        BoughtProducts = new ArrayList<>();
    }

    public void addProducttoBoughtList(Product product) {
        BoughtProducts.add(product);
    }

    public void addProducttoRemainingList(Product product) {RemainingProducts.add(product);}

    public ArrayList<Product> getBoughtProducts() {return BoughtProducts;}
    public ArrayList<Product> getRemainingProducts() {return RemainingProducts;}


    public static Member createMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First Name");
        String memberFirstName = scanner.nextLine();

        System.out.println("\nEnter Last Name");
        String memberLastName = scanner.nextLine();

        System.out.println("\nEnter Password ");
        String memberPassword = scanner.nextLine();

        return new Member(memberFirstName, memberLastName, memberPassword);
    }

    @Override
    public String toString() {
        return "Member{" + "firstName= " + firstName + ", lastName= " + lastName + ", memberID= " + memberID + '}';
    }

    public String getFullInfotoAdmin() {
        StringBuffer stb = new StringBuffer();
        stb.append("firstName=").append(firstName).append(", lastName=").append(lastName).append(", id=").append(memberID).append(", password=").append(password);
        if (BoughtProducts.size() > 0) {
            stb = stb.append("\n  LIST OF BOUGHT PRODUCTS");
            for (Product BoughtProduct : BoughtProducts) {
                stb.append("\n     ");
                stb.append(BoughtProduct.getName());
            }
        } else {
            stb.append("\n     THIS MEMBER HAS NOT BOUGHT A PRODUCT YET");
        }
        return stb.toString();
    }

    public boolean authorizeSignInInfo(int userID, String userPassword) {
        return (this.mamberID == userID && (this.password == null ? userPassword == null : this.password.equals(userPassword.toLowerCase())));
    }

    @Override
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

}
