

class Invoice{
    
    private String itemNo;
    private String itemDescription;
    private int quantity;
    private int ppi;
    
    public static int objcount=0;
    
    Invoice(String itemNo,String itemDesc,int quantity,int ppi){
        
        this.itemNo = itemNo;
        this.itemDescription = itemDesc;
        this.quantity = quantity;
        this.ppi = ppi;
        objcount++;
        
        
    }
    
    public void setitemNo(String itemNo){
        this.itemNo = itemNo;
    }
    
    public void setitemDescription(String itemDesc){
        this.itemDescription = itemDesc;
    }
    
    public void setQuantity(int quant){
        
        this.quantity = quant;
    }
    public void setppi(int ppi){
        this.ppi = ppi;
    }
    
    public String getitemNo(){
        return this.itemNo;
    }
    
    public String getitemdesc(){
        return this.itemDescription;
    }
    
    public int getQuantity(){
        return this.quantity;
        
    }
    
    public int getppi(){
        return this.ppi;
    
    }
    
    public int getInvoiceAmount(){
        
        return this.ppi*this.quantity;
    }
    
    public int MaxQuantity(Invoice I1,Invoice I2){

     Invoice Max;
     if(I1.quantity>I2.quantity){
         Max = I1;
     }
     else{
         Max = I2;
     }



    return Max.quantity;
}
    
    
}








public class ANS1 {



    public static void main(String[] args) {
        
        Invoice I1 = new Invoice("1", "hammer", 3, 50);
        Invoice I2 = new Invoice("2","chainsaw",6,100);
        System.out.println("\n FOR INVOICE : \nThe Invoice item no is : "+I1.getitemNo() +"\nThe Invoice description is : "+I1.getitemdesc() +
                "\n The invoice quantity : "+I1.getQuantity() + "\nThe invoice price per item : "+I1.getppi() + "\n The invoice amount is  :"
        + " "+I1.getInvoiceAmount()+"\nThis is invoice no : "+I2.objcount);
        System.out.println("\n FOR INVOICE : \nThe Invoice item no is : "+I2.getitemNo() +"\nThe Invoice description is : "+I2.getitemdesc() +
                "\n The invoice quantity : "+I2.getQuantity() + "\nThe invoice price per item : "+I2.getppi() + "\n The invoice amount is  :"
        + " "+I2.getInvoiceAmount() + " \n this is invoice no : "+I2.objcount);
        
        System.out.println(" \n Out of Invoice 1 and Invoice 2  the max Quantity is : "+ I1.MaxQuantity(I1, I2));
        
        
        
        
    }
    
}
