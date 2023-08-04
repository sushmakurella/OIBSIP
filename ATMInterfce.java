
import java.util.*;
interface AtmOperations{
    public void transactionHist();
    public void withdrawAmount();
    public void depositAmount();
    public void transferAmount();
    public void viewBalance();
}

class ATM{
    private double balance=100000;
   
    public ATM(){

    }
    public double getBalance(){
        return balance;

    }
    public void setBalance(double balance){
        this.balance=balance;
     }
    

}
class AtmOperationsImpl implements AtmOperations{
    ATM atm=new ATM();
    Scanner sc=new Scanner(System.in);
    int transactions=0;
    String transactionHistory="";
    public void transactionHist(){
        if(transactions==0){
            System.out.println("No Transactions Yet");

        }
        else{
            System.out.println("No of transactions: "+transactions);
            System.out.println(transactionHistory);
        }
      
    }
    public void withdrawAmount(){
        System.out.println("Enter Amount to withdraw: ");
        double amount=sc.nextDouble();
        try{
            if(atm.getBalance()>=amount && amount<=20000){
            atm.setBalance(atm.getBalance()-amount);
            System.out.println("Withdraw Successfully");
            transactions++;
            String st=transactions+" "+ amount +" Rs Withdrawed\n";
            transactionHistory=transactionHistory.concat(st);
            
            }
            else if(amount>20000 && atm.getBalance()<amount){
                System.out.println("Insufficient Balance");
                System.out.println("you can only withdraw upto 20000 at a time");
            }
            else if(amount>20000){
                System.out.println("you can only withdraw upto 20000 at a time");
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        catch(Exception e){

        }

    }
    public void depositAmount(){
        System.out.println("Enter amount to deposit");
        double amount=sc.nextDouble();
        try{
            if(amount<=100000){
                atm.setBalance(atm.getBalance()+amount);
                System.out.println("\n Successfully Deposited");
                transactions++;
                String st=transactions+" "+ amount+" Rs deposited\n";
                transactionHistory=transactionHistory.concat(st);
            }
            else{
                System.out.println("Sorry....The max Limit is 100000");
            }
        }
        catch(Exception e){

        }

    }
    public void transferAmount(){
        sc.nextLine();
        System.out.println("Enter the recpient name: ");
        String recp=sc.nextLine();
        System.out.println("Enter the recepient id: ");
        int recpid=sc.nextInt();
        System.out.println("Enter amount to transfer");
        double amount=sc.nextDouble();
        try{
            if(atm.getBalance()>=amount){
                if(amount<=20000){
                 atm.setBalance(atm.getBalance()-amount);
                 System.out.println("Successfully Transfered to "+recp);
                 transactions++;
                 String st=transactions+" "+amount +" Rs transferred to "+recp+"\n";
                 transactionHistory=transactionHistory.concat(st);
                }
                else{
                    System.out.println("Sorry The max limit to transfer is 20000/-");
                }

            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        catch(Exception e){

        }

    }
    public void viewBalance(){
        System.out.println("Available Balance is: "+atm.getBalance());

    }

}
public class ATMInterfce {

    public static void main(String args[]){
        AtmOperationsImpl op=new AtmOperationsImpl() ;

            
        
        System.out.println("<<<<<<<<<<<ATM INTERFACE>>>>>>>>>>>");
        Scanner sc=new Scanner(System.in);
        try{
        
        System.out.println("Enter the user name: ");
        String username=sc.nextLine();
        System.out.println("Enter the Account Number:");
        String userid=sc.nextLine();
        System.out.println("Enter the user pin: ");
        int userpin=sc.nextInt();
        while(true){
            System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            System.out.println("1.Transactions History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.view Available Balance\n6.Quit");
            //System.out.println("<<<<<<**********<>*<>***********>>>>>>");
            System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            System.out.println("Enter choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:op.transactionHist();
                       break;
                case 2:op.withdrawAmount();
                       break;
                case 3:op.depositAmount();
                       break;
                case 4:op.transferAmount();
                       break;
                case 5:op.viewBalance();
                       break;
                case 6:System.out.println("Thank you! Please Visit Again");
                       System.exit(0);
                       break;
                default:
                System.out.println("Please Enter the number between 1-6");
                   
            }
        }
        }
        catch(Exception e){
            System.out.println("Invalid");
        }


        

    }
    
}
