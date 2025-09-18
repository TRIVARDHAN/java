import java.util.*;
class bankname 
{
   String name ;
   int pincode;
   String address;
   void bankdetails(String name,int pincode,String address)
   {
       this.name =name ;
       this.pincode=pincode;
       this.address=address;
       
   }
   void display_bankname()
   {
       System.out.println("Enter the name of the bank:"+name );
        System.out.println("Enter the pincode of the bank:"+pincode );
         System.out.println("Enter the address of the bank:"+address);
   }
}
class customer extends bankname 
{
    String cutname ;
    int age ;
    int isfi;
    void customer(String cutname ,int age ,int isfi)
    {
        this.cutname =cutname;
        this.age=age;
        this.isfi=isfi ;
        
    }
    void display_customer_details()
    {
         System.out.println("Enter the name of the user :"+cutname  );
          System.out.println("Enter the age of the user:"+age  );
           System.out.println("Enter the isfi code for which bank ur belong to:"+isfi );
    }
}
class acc extends bankname
{
    int total_amt;
    int lones ;
    int tax_tbepayed;
    void bankacc(int total_amt,int lones,int tax_tbepayed)
    {
        this.total_amt=total_amt;
        this.lones=lones;
        this.tax_tbepayed=tax_tbepayed;
        
    }
    void display_accbalance()
    {
         System.out.println("the amt present in user bank is :"+total_amt);
          System.out.println("no of lones the user holding :"+lones );
           System.out.println("the remaining tax wwould bbe payed by the user :"+tax_tbepayed  );
    }
}
class bankinfo
{
    public static void main(String args[])
    {
        customer m=new customer();
        m.bankdetails("SBI",603210,"ap ");
        m. customer("tri",25,260135);
        m.display_bankname();
        m.display_customer_details();
        System.out. println("BANK BANCLENCE");
        acc m1=new acc();
        m1.bankdetails("SBI",603210,"ap ");
         m.display_bankname();
         m1.bankacc(45000,0,1500);
         m1.display_accbalance();
        
    }
}