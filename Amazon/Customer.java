import java.util.*;
public class Customer{
    Scanner in=new Scanner(System.in);
    private String password;
    private String address;
    private String phone_num;
    private Admin admin;
    public Map<Integer,Inventory> products;
    private Map<String,Inventory> card;

    private String custom_name;
    public Customer(Map<Integer,Inventory> product,String customer,Map<String,Inventory> cards){
        this.products=product;
        this.custom_name=customer;
        this.card=cards;
        customer_start();
    }
   public Customer(String pass,String add,String phone){
       this.password=pass;
       this.address=add;
       this.phone_num=phone;
   }
   public String getPass(){
        return password;
   }
   public String getAddress(){
        return address;
   }
   public String getPhonenum(){
        return phone_num;
   }
   public void customer_start(){
       int choice;
       do{
           System.out.println("-------------------------Welcome - Amazon user-----------------------");
           System.out.println("  1.Search product:");
           System.out.println("  2.View Cart:");
           System.out.println("  3.Exit");
           System.out.println("Enter your choice:");
           choice=in.nextInt();
           //in.next();
           switch(choice){
               case 1:{
                   searchProduct(custom_name);
                   break;
               }
               case 2:{
                   viewCart();
                   break;
               }
               case 3:{
                   System.out.println("**************************Thanks for visiting!******************************");
                   break;
               }
               default:
                   System.out.println("Invalid choice");
           }

       }while(choice!=3);
   }
    public void searchProduct(String customer){
        System.out.println("Enter name of product you want to search: ");
        in.nextLine();
        String name=in.nextLine().toLowerCase();
        boolean product_present=false;
        for(Map.Entry<Integer,Inventory> entry:products.entrySet()){
            Inventory invent=entry.getValue();
            //System.out.println(invent.getProductName());
            System.out.println(name);
            if(Objects.equals(invent.getProductName().toLowerCase(), name)){
                product_present=true;
                System.out.println(invent.getProductName());
                System.out.println(invent.getPriceOfProduct());
                System.out.println(invent.getQuantity());
                System.out.println("Do you wish to.......");
                System.out.println("  1.BUY NOW");
                System.out.println("  2.ADD TO CART");
                System.out.println("  3.EXIT");
                int choice=in.nextInt();
                in.nextLine();
                switch(choice){
                    case 1:{
                         buyNow(invent,custom_name);
                    }
                    case 2:{
                          addToCart(name,custom_name,invent);
                    }
                    case 3:{
                        System.out.println("******************************Thanks for visiting amazon!*******************************");
                        return;
                    }
                }
            }
        }
        if(!product_present) {
            System.out.println("---------The product you have searched is not available search with correct name---------");
            searchProduct(customer);
        }
        else searchProduct(customer);
    }
    public void buyNow(Inventory inv,String customer){
        System.out.println("Enter the quantity of the product you want to purchase: ");
        int quan=in.nextInt();
        if(quan>inv.getQuantity()){
            System.out.println("-----------Your Quantity range is higher than the available quantity give the correct count-------");
            buyNow(inv,customer);
        }
        else{
            inv.setQuantity(quan);
            System.out.println("Your Order is Placed Successfully !");
            System.out.println("------------------Order details:-----------------------");
            System.out.println("Product name: "+inv.getProductName());
            System.out.println("Quantity: "+quan);
            System.out.println("Price: "+inv.getPriceOfProduct());
            System.out.println("Thank you! Keep Purchasing!");
            System.out.println("--------------------------------------------------------");
            searchProduct(customer);
        }
    }
    public void addToCart(String name,String customer,Inventory inv){
        card.put(customer,inv);
        System.out.println("Your Card products are: ");
        for(Map.Entry<String,Inventory> entry: card.entrySet()){
            System.out.println(entry.getValue().getProductName());
            System.out.println(entry.getValue().getPriceOfProduct());
        }
//        Map<String,Customer> custom=admin.customer;
//        for(Map.Entry<String,Customer> entry:custom.entrySet()){
//            System.out.println(entry.getKey());
//        }

    }
    public void viewCart(){
        System.out.println("Your Card products are: ");
        for(Map.Entry<String,Inventory> entry: card.entrySet()){
            if(entry.getKey().equals(custom_name)){
                System.out.println(entry.getValue().getProductName());
                System.out.println(entry.getValue().getPriceOfProduct());
            }
        }
    }

}
