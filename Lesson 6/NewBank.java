public class NewBank {

    private String accountNumber; // (номер счета)
    private double balance; // (баланс)
    private String ownerName; // (имя владельца)

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String sAccountNumber) {
        if (sAccountNumber.isEmpty()) {
            accountNumber = "NoAccountNumber";
        } else accountNumber = sAccountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String sOwnerName) {
        if (sOwnerName.isEmpty()) {
            ownerName = "NoName";
        } else ownerName = sOwnerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double dBalance) {
        balance = dBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ошибка пополнения: Сумма должна быть положительной. Вы ввели: " + amount);
        }
        balance += amount;
        System.out.println("Вы зачислили: " + amount + " Текущий баланс: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ошибка снятия: Сумма должна быть положительной. Вы ввели: " + amount);
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Ошибка снятия: Недостаточно средств. Запрошено: " + amount + ", доступно: " + balance);
        }
        balance -= amount;
        System.out.println("Вы сняли: " + amount + " Текущий баланс: " + balance);
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("Информация об Банковском счете");
        System.out.println("======================================");
        System.out.println("Номер счета: " + "'" + getAccountNumber() + "'\n" +
                "Имя владельца: " + "'" + getOwnerName() + "'\n" +
                "Баланс: " + "'" + getBalance() + "'");
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        NewBank ba = new NewBank();

        ba.setAccountNumber("ЦА16545/165-5");
        ba.setOwnerName("");
        ba.setBalance(10000.00);

        ba.displayInfo();

        try {
            ba.deposit(500.00);
            ba.withdraw(2500.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println("\n--- Тестирование исключений ---");


        try {
            ba.withdraw(-100.00); // Эта операция должна вызвать исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }


        System.out.println("\n--- Итоговое состояние счета ---");
        ba.displayInfo();
    }
}