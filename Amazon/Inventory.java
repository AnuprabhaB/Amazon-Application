public class Inventory {
    private String pro_name;
    private int quantity;
    private int ios_num;
    private int price;
    public Inventory(String name,int quan,int ios,int price){
        this.pro_name=name;
        this.quantity=quan;
        this.ios_num=ios;
        this.price=price;
    }
    public Inventory(){

    }
    public String getProductName(){
        return pro_name;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getIOS(){
        return ios_num;
    }
    public int getPriceOfProduct(){
        return price;
    }
    public void setQuantity(int quan){
        this.quantity=quantity-quan;
    }
    public void increaseQuantity(int quan){
        this.quantity=quantity+quan;
    }
}
