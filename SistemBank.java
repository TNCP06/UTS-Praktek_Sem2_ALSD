// Kelas SistemBank bertanggung jawab untuk mengelola kumpulan rekening bank dalam bentuk array
public class SistemBank {
    private Rekening27[] accounts;
    private int numOfAccounts;

    // Konstruktor untuk membuat objek SistemBank dengan kapasitas tertentu
    public SistemBank(int size) {
        accounts = new Rekening27[size];
        numOfAccounts = 0;
    }

    // Metode untuk menambahkan rekening baru ke dalam array rekening
    public void addAccount(Rekening27 account) {
        accounts[numOfAccounts] = account;
        numOfAccounts++;
    }

    // Metode untuk menampilkan semua rekening yang tersimpan dalam array
    public void displayAllAccounts() {
        for (int i = 0; i < numOfAccounts; i++) {
            System.out.println(accounts[i]);
        }
    }

    // Metode untuk mengurutkan rekening berdasarkan saldo dalam mode menurun
    public void sortAccountsByBalance() {
        for (int i = 0; i < numOfAccounts - 1; i++) {
            for (int j = 0; j < numOfAccounts - i - 1; j++) {
                if (accounts[j].getBalance() < accounts[j + 1].getBalance()) {
                    Rekening27 temp = accounts[j];
                    accounts[j] = accounts[j + 1];
                    accounts[j + 1] = temp;
                }
            }
        }
    }

     // Metode untuk menampilkan rekening dengan saldo kurang dari 50.000
    public void displayLowBalanceAccounts() {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i].getBalance() < 50000) {
                System.out.println(accounts[i]);
            }
        }
    }

    // Metode untuk mencari rekening berdasarkan kata kunci nama
    public void searchAccountByName(String keyword) {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i].getName().toLowerCase().equals(keyword.toLowerCase())) {
                System.out.println(accounts[i]);
            }
        } 
    }

    // Metode untuk melakukan penarikan dari rekening
    public void withdrawFromAccount(String rekening, double amount) {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(rekening)) {
                accounts[i].withdraw(amount);
                System.out.println("Tarik " + amount + " dari rekening " + rekening + ".");
                System.out.println("Saldo saat ini: " + accounts[i].getBalance());
            }
        }
    }

    // Metode untuk melakukan setoran ke rekening
    public void depositToAccount(String rekening, double amount) {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(rekening)) {
                accounts[i].deposit(amount);
                System.out.println("Tersetor " + amount + " ke Rekening " + rekening + ".");
                System.out.println("Saldo saat ini: " + accounts[i].getBalance());
                return;
            }
        }
    }
}