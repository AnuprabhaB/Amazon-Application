import java.util.*;
public class Seller {
    Scanner in=new Scanner(System.in);
    private String pass;
    private List<String> sell_products;
    public Map<String,Seller> seller;
    public Map<Integer,Inventory> products;
    private String seller_id;
    private Admin ad;
    public Seller(String pass,List<String> list){
        this.pass=pass;
        this.sell_products=list;
    }
    public Seller(Map<String,Seller> seller,String seller_name,Map<Integer,Inventory> product){
    this.seller=seller;
    this.seller_id=seller_name;
    this.products=product;
    seller_start();
    }
    public String getSellerPass(){
        return pass;
    }
    public List<String> getSellerProducts(){
        return sell_products;
    }
    public void seller_start(){
        int choice;
        do{
            System.out.println("--------------------------Seller login-------------------------");
            System.out.println("What you want to do");
            System.out.println("  1.Add products to inventory");
            System.out.println("  2.View my products");
            System.out.println("  3.Exit");
            System.out.println("Enter your choice");
            choice=in.nextInt();
            switch(choice){
                case 1:{
                    addToInventory();
                    break;
                }
                case 2:{
                    viewSellerProducts();
                    break;
                }
                case 3:{
                    System.out.println("**************************Thanks for visiting!******************************");
                    break;
                }
            }
        }while(choice!=3);

    }
    public void addToInventory(){
        System.out.println("Enter the product name you want to add: ");
        in.nextLine();
        String pro_name=in.nextLine();
        System.out.println("Enter product quantity: ");
        int quan=in.nextInt();
        System.out.println("Enter IOS number of the product: ");
        int ios=in.nextInt();
        System.out.println("Enter Price: ");
        int price=in.nextInt();
        if(isValidateIOS(ios)){
            System.out.println("--------------Your IOS is validated and the product is added successfully to inventory---------");
            products.put(7258,new Inventory(pro_name,quan,ios,price));
        }
        else{
            System.out.println("Your IOS is not valid please check again");
            addToInventory();
        }
    }
    public boolean isValidateIOS(int ios){
        for(Map.Entry<Integer,Inventory> entry: products.entrySet()){
            Inventory inv=entry.getValue();
            if(inv.getIOS()==ios) return false;
        }
        return true;
    }
    public void viewSellerProducts(){
        System.out.println("The following are your products");
        for(Map.Entry<String,Seller> entry:seller.entrySet()){
            Seller sel=entry.getValue();
            if(entry.getKey().equals(seller_id)){
                System.out.println(sel.getSellerProducts());
            }
        }
    }
}
