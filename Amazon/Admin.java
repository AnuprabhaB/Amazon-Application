import java.util.*;
public class Admin {
    public Map<Integer,Inventory> products=new HashMap<>();
    public Map<String,Customer> customer=new HashMap<>();
    public Map<String,Seller> seller=new HashMap<>();
    public  Map<String,Inventory> card=new HashMap<>();
    private String id;
    private String pass;
    Scanner in=new Scanner(System.in);
    public Admin(){
        this.id="Anu";
        this.pass="2710";
        putData();
    }
    public void putData(){
        products.put(1234,new Inventory("xyz",10,7011,12000));
        products.put(5467,new Inventory("Samsung Phone",10,7011,12000));
        products.put(9265,new Inventory("iPhone",10,7011,12000));
        products.put(6729,new Inventory("Bluetooth",10,7011,12000));
        products.put(9561,new Inventory("Airpods",10,7011,12000));
        products.put(7813,new Inventory("Makeup",10,7011,12000));
        products.put(7831,new Inventory("Dresses",10,7011,12000));
        products.put(1945,new Inventory("Bangles",10,7011,12000));

        customer.put("udaya",new Customer("1234@123","Vinoba nagar,Coimbatore","9944638322"));
        customer.put("dhanush",new Customer("1234@123","Vinoba nagar,Coimbatore","9944638322"));
        customer.put("ranjith",new Customer("1234@123","Vinoba nagar,Coimbatore","9944638322"));
        customer.put("venkat",new Customer("1234@123","Vinoba nagar,Coimbatore","9944638322"));
        customer.put("elamathi",new Customer("1234@123","Vinoba nagar,Coimbatore","9944638322"));
        customer.put("arthi",new Customer("1234@123","Vinoba nagar,Coimbatore","9944638322"));

        seller.put("Raj",new Seller("sell@123",Arrays.asList("Toys","Samsung Phone")));
        seller.put("Vimel",new Seller("sell@123",Arrays.asList("iPhone","Bluetooth")));
        seller.put("Arun",new Seller("sell@123",Arrays.asList("Airpods","Makeup")));
        seller.put("Ashwin",new Seller("sell@123",Arrays.asList("Dressse","Bangles")));
        seller.put("Dhanu",new Seller("sell@123",Arrays.asList("iPhone","Samsung Phone")));
        start();
    }
    public void start(){
        System.out.println("----------------------------WELCOME TO AMAZON------------------------------");
        System.out.println("  Enter you login options:  ");
        System.out.println("  1.Customer");
        System.out.println("  2.Seller");
        System.out.println("  3.Admin");
        System.out.println("Enter choice:");
        int choice=in.nextInt();
        switch(choice){
            case 1:{
                String customer=isCustomer();
                if(!customer.equals("false")){
                    Customer cus=new Customer(products,customer,card);
                }
                else{
                    isCustomer();
                }
                break;
            }
            case 2:{
                String sel=isSeller();
                if(!sel.equals("false")){
                    Seller sell=new Seller(seller,sel,products);
                }
                else {
                    isSeller();
                }
                 break;
            }
            case 3:{
                if(isAdmin()){
                    adminStart();
                }
                break;
            }
            default:
                System.out.println("Invalid choice");
        }
    }

    public String isCustomer(){
        System.out.println("Enter your username:");
        String name=in.next();
        System.out.println("Enter your password:");
        String pass=in.next();
        for(Map.Entry<String,Customer> entry:customer.entrySet()){
            Customer cus=entry.getValue();
            if(entry.getKey().equals(name) && cus.getPass().equals(pass)){
                return name;
            }
        }
        System.out.println("Invalid user name or password try again");
        return "false";
    }
    public String isSeller(){
        System.out.println("Enter your Seller username:");
        String name=in.next();
        System.out.println("Enter your password:");
        String pass=in.next();
        for(Map.Entry<String,Seller> entry:seller.entrySet()){
            Seller sel=entry.getValue();
            if(entry.getKey().equals(name)&& sel.getSellerPass().equals(pass)){
                return name;
            }
        }
        System.out.println("Invalid user name or password try again");
        return "false";
    }
    public boolean isAdmin(){
        System.out.println("Enter your admin id: ");
        String id=in.next();
        System.out.println("Enter Your Password: ");
        String pass=in.next();
        return isCheckAdmin(id,pass);
    }
    public boolean isCheckAdmin(String id,String pass){
        if(this.id.equals(id) && this.pass.equals(pass)) return true;
        else return false;
    }
    public void adminStart(){
        int choice;
        do{
            System.out.println("--------------------------Admin Login---------------------");
            System.out.println("What details you want to know");
            System.out.println("  1.Seller details");
            System.out.println("  2.Customer details");
            System.out.println("  3.Product details");
            System.out.println("  4.Exit");
            System.out.println("Enter your choice: ");
            choice=in.nextInt();
            switch(choice){
                case 1:{
                 sellerDetails();
                 break;
                }
                case 2:{
                 customerDetails();
                 break;
                }
                case 3:{
                  productDetails();
                  break;
                }
                case 4:{
                    System.out.println("**************************Thanks for visiting!******************************");
                }
            }

        }while(choice!=4);


    }
    public void sellerDetails(){
    for(Map.Entry<String,Seller> entry: seller.entrySet()){
        Seller sel=entry.getValue();
        System.out.println("Seller name: "+entry.getKey()+"   "+"Seller products: "+sel.getSellerProducts());
    }
    }
    public void customerDetails(){
    for(Map.Entry<String,Customer> entry: customer.entrySet()){
        Customer cus=entry.getValue();
        System.out.println("Name of Customer:" +entry.getKey());
        System.out.println("Address: "+cus.getAddress());
        System.out.println("Phone Number "+cus.getPhonenum());
        System.out.println("------------------------------------------------------------");
    }
    }
    public void productDetails(){
        for(Map.Entry<Integer,Inventory> entry: products.entrySet()){
            Inventory cus=entry.getValue();
            System.out.println("Product details:");
            System.out.println("Product id: "+entry.getKey()+"    "+"Product name: "+cus.getProductName()+"    "+"Quantity: "+cus.getQuantity()+"    "+"IOS number: "+cus.getIOS()+"    "+"Price: "+cus.getPriceOfProduct());
            System.out.println();
        }
    }
    public boolean isValidateIOS(int ios){
        for(Map.Entry<Integer,Inventory> entry: products.entrySet()){
            Inventory inv=entry.getValue();
            if(inv.getIOS()==ios) return false;
        }
        return true;
    }


}
