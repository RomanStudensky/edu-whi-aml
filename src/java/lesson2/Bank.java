package lesson2;
class BankAccount {

    private String accountNumber ; // (номер счета)
    private double balance ; // (баланс)
    private String ownerName ; // (имя владельца)

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String sAccountNumber){
        if (sAccountNumber.isEmpty()){
            accountNumber = "NoAccountNumber";
        }
        else accountNumber = sAccountNumber;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setOwnerName(String sOwnerName){
        if (sOwnerName.isEmpty()){
            ownerName = "NoName";
        }
        else ownerName = sOwnerName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double dBalance){
        balance = dBalance;
    }


    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;
            System.out.println("Вы зачислели: " + amount + " Текущий баланс: " + balance);
        }
        else System.out.println("Повторите ввод, вы ввели отрицаетльное чмсло или равное 0");
    }

    public void withdraw(double amount){
        if(amount < 0){
            System.out.println("Введите положительно число");
        }
        else if (amount > balance){
            System.out.println("Вы не можете снять такую сумму. Текущий баланс: " + balance);
        }
        else {
            balance -= amount;
            System.out.println("Вы сняли: " + amount + " Текущий баланс: " + balance);
        }

    }

    public void displayInfo(){
        System.out.println();
        System.out.println("Информация об Банковском счете");
        System.out.println("======================================");
        System.out.println("Номер счета: " + "'" + getAccountNumber() + "'\n" +
                           "Имя владельца: " + "'" + getOwnerName() + "'\n" +
                           "Баланс: " + "'" + getBalance() + "'");
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();

        ba.setAccountNumber("ЦА16545/165-5");
        ba.setOwnerName("");
        ba.setBalance(10000.00);

        ba.displayInfo();

        ba.deposit(500.00);
        ba.withdraw(2500.00);

    }
}