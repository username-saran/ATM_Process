package com.atmprocess;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RealLife {
    static RealLife atmOperations = new RealLife();
    static CreationATM[] ATM = {
            new CreationATM(2000,20,40000),
            new CreationATM(500,10,5000),
            new CreationATM(100,100,10000)
    };
    static List<CreationATM> Atm_attributes = Arrays.asList(ATM);
    static CustomerDetails[] customerDetails = {
            new CustomerDetails(101,"Suresh",2343,25234),
            new CustomerDetails(102,"Ganesh",5432,34123),
            new CustomerDetails(103,"Magesh",7854,26100),
            new CustomerDetails(104,"Naresh",2345,80000),
            new CustomerDetails(105,"Harish",1907,103400)
    };
    static List<CustomerDetails> CUS = Arrays.asList(customerDetails);
    public int checkBalance(int accountNumber,int pin)
    {
        for(CustomerDetails customer : CUS){
            if(customer.getAccNo() == accountNumber && customer.getPin()==pin){
                return customer.getAccountBalance();
            }
        }
        return 0;
    }

    public boolean withDrawPossible(int accountNumber,int pin,int amt){
        for(CustomerDetails customer : CUS){
            if(customer.getAccNo() == accountNumber && customer.getPin()==pin && customer.getAccountBalance()>=amt){
                customer.setAccountBalance(customer.getAccountBalance()-amt);
                return true;
            }
        }
        return false;
    }

    public boolean transferPossible(int accountNumber,int pin,int amt,int otherAccNo){
        for(CustomerDetails customer : CUS){
            if(customer.getAccNo() == accountNumber && customer.getPin()==pin&&customer.getAccountBalance()>=amt){
                customer.setAccountBalance(customer.getAccountBalance()-amt);
            }
        }
        for(CustomerDetails customer : CUS){
            if(customer.getAccNo() == otherAccNo){
                customer.setAccountBalance(customer.getAccountBalance()+amt);
                return true;
            }
        }

        return false;
    }

    public static boolean correctPinOrNot(int acc)
    {
        for(CustomerDetails customer : CUS){
            if(customer.getAccNo() == acc){
                return true;
            }
        }
        return false;
    }
    public static boolean correctPinOrNot(int acc,int pin)
    {
        for(CustomerDetails customer : CUS){
            if(customer.getAccNo() == acc && customer.getPin()==pin){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int amount;
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
        int otherAccNo;
        int accNo,pin;
        System.out.println("Welcome to ABCD Bank ATM");
        System.out.println("------------------------");
        System.out.println("Please Enter Account Number: ");
        int accountNo = scanner.nextInt();
        System.out.println("Enter Your Four Digit Pin: ");
        int pinNumber = scanner.nextInt();
        while (condition) {
            System.out.println("____Why do you use our ATM?____");
            System.out.println("1 . Check Balance");
            System.out.println("2 . Withdraw Amount");
            System.out.println("3 . Transfer Amount");
            System.out.println("4 . AMT Balance");
            System.out.println("5 . Exit");
            System.out.println("_______________________________");
            System.out.println("Enter Your Choice: ");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1-> {
                    System.out.println("\nYou have to chosen Balance Checking Option\n");
                    accNo=accountNo;
                    pin=pinNumber;
                    if (correctPinOrNot(accNo, pin)) {
                        int balance = atmOperations.checkBalance(accNo, pin);
                        System.out.println("Your Current Balance is " + balance);
                    }
                    else{
                        System.out.println("*** enter correct PIN or Account Number ***");
                    }
                }
                case 2->{
                    System.out.println("You have to chosen Withdrawing Option\n");
                    accNo=accountNo;
                    pin=pinNumber;
                    System.out.println("Enter Amount of Money to withdraw: ");
                    amount=scanner.nextInt();
                    if(correctPinOrNot(accNo,pin)) {
                        while(amount>0){
                            if(amount>=2000){
                                if(atmOperations.withDrawPossible(accNo,pin,amount)){
                                    int withdrawAmount=amount;
                                    if(Atm_attributes.stream().filter(atm -> atm.getValue()>=withdrawAmount).count()>1){
                                        //Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getValue()-withdrawAmount));
                                        Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setNumber(atm.getNumber()-(withdrawAmount/2000)));
                                        Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getNumber()*2000));
                                        amount%=2000;
                                        System.out.println("*** Amount WithDrawn Successfully ***");
                                    }
                                }
                                else{
                                    System.out.println("*** Insufficient Amount, Sorry for your Inconvenience ***");
                                }
                            }
                            else if(amount>=500 && amount<2000){
                                if(atmOperations.withDrawPossible(accNo,pin,amount)){
                                    int withdrawAmount=amount;
                                    if(Atm_attributes.stream().filter(atm -> atm.getValue()>=withdrawAmount).count()>1){
                                        //Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setValue(atm.getValue()-withdrawAmount));
                                        Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setNumber(atm.getNumber()-(withdrawAmount/500)));
                                        Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setValue(atm.getNumber()*500));
                                        System.out.println("*** Amount WithDrawn Successfully ***");
                                        amount%=500;
                                    }
                                }
                                else{
                                    System.out.println("*** Insufficient Amount, Sorry for your Inconvenience ***");
                                }
                            }
                            else if(amount>=100 && amount<500){
                                if(atmOperations.withDrawPossible(accNo,pin,amount)){
                                    int withdrawAmount=amount;
                                    if(Atm_attributes.stream().filter(atm -> atm.getValue()>=withdrawAmount).count()>1){
                                        //Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setValue(atm.getValue()-withdrawAmount));
                                        Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setNumber(atm.getNumber()-(withdrawAmount/100)));
                                        Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setValue(atm.getNumber()*100));
                                        System.out.println("*** Amount WithDrawn Successfully ***");
                                        amount%=100;
                                    }
                                }
                                else{
                                    System.out.println("*** Insufficient Amount, Sorry for your Inconvenience ***");
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("*** enter correct PIN or Account Number ***");
                    }
                }
                case 3->{
                    System.out.println("You have to chosen Transfer Option\n");
                    accNo=accountNo;
                    pin=pinNumber;
                    System.out.println("Enter Amount of Money to transfer: ");
                    amount=scanner.nextInt();
                    if(correctPinOrNot(accNo,pin)){
                        if(amount<=10000){
                            System.out.println("Enter Account Number of Your Friend: ");
                            otherAccNo= scanner.nextInt();
                            if(correctPinOrNot(otherAccNo)){
                                while(amount>0)
                                {
                                    if(amount>=2000){
                                        if(atmOperations.transferPossible(accNo,pin,amount,otherAccNo)){
                                            int transferAmount=amount;
                                            if(Atm_attributes.stream().filter(atm -> atm.getValue()>=transferAmount).count()>1){

                                                //Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getValue()+transferAmount));
                                                Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setNumber(atm.getNumber()+transferAmount/2000));
                                                Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getNumber()*2000));
                                                System.out.println("*** Amount Transferred Successfully ***");
                                                amount%=2000;
                                            }
                                        }
                                        else{
                                            System.out.println("*** Insufficient Amount, Sorry for your Inconvenience ***");
                                        }
                                    }
                                    else if(amount>=500 && amount<2000){
                                        if(atmOperations.transferPossible(accNo,pin,amount,otherAccNo)){
                                            int transferAmount=amount;
                                            if(Atm_attributes.stream().filter(atm -> atm.getValue()>=transferAmount).count()>1){

                                                //Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setValue(atm.getValue()+transferAmount));
                                                Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setNumber(atm.getNumber()+transferAmount/500));
                                                Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setValue(atm.getNumber()*500));
                                                System.out.println("*** Amount Transferred Successfully ***");
                                                amount%=500;
                                            }
                                        }
                                        else{
                                            System.out.println("*** Insufficient Amount, Sorry for your Inconvenience ***");
                                        }
                                    }
                                    else if(amount>=100 && amount<500){
                                        if(atmOperations.transferPossible(accNo,pin,amount,otherAccNo)){
                                            int transferAmount=amount;
                                            if(Atm_attributes.stream().filter(atm -> atm.getValue()>=transferAmount).count()>1){

                                                //Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setValue(atm.getValue()+transferAmount));
                                                Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setNumber(atm.getNumber()+transferAmount/100));
                                                Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setValue(atm.getNumber()*100));
                                                System.out.println("*** Amount Transferred Successfully ***");
                                                amount%=100;
                                            }
                                        }
                                        else{
                                            System.out.println("*** Insufficient Amount, Sorry for your Inconvenience ***");
                                        }
                                    }
                                }
                            }
                            else{
                                System.out.println("*** enter correct PIN or Account Number ***");
                            }
                        }
                        else{
                            System.out.println("Amount Must be less than 10000");
                        }
                    }

                }
                case 4-> Atm_attributes.forEach(System.out::println);
                case 5-> {
                    condition=false;
                    System.out.println("*^*^*^ Thanks for Using Our ATM *^*^*^");
                }
                default -> System.out.println("Enter from 1,2,3,4,5");
            }
        }
    }
}
