import java.util.Scanner;

class Rekening27 {
    String Rekening;
    String nama;
    String telefon;
    String email;
    double saldo;

    // Konstruktor untuk membuat objek Rekening27 dengan parameter yang diberikan
    public Rekening27(String Rekening, String nama, String telefon, String email, double saldo) {
        this.Rekening = Rekening;
        this.nama = nama;
        this.telefon = telefon;
        this.email = email;
        this.saldo = saldo;
    }

    // Metode untuk menampilkan menu
    public static void menu() {
        System.out.println("Pilih Menu:");
        System.out.println("1. Masukkan/tambahkan data Rekening");
        System.out.println("2. Tampilkan semua data Rekening");
        System.out.println("3. Urutkan data Rekening berdasarkan saldo dalam mode menurun");
        System.out.println("4. Menampilkan data Rekening yang memiliki saldo < 50.000");
        System.out.println("5. Cari data Rekening berdasarkan kata kunci nama");
        System.out.println("6. Tarik dari Rekening untuk sejumlah uang tertentu");
        System.out.println("7. Setor ke Rekening untuk sejumlah uang tertentu");
    }

    // Metode untuk melakukan setoran ke saldo
    public void deposit(double amount) {
        saldo += amount;
    }

    // Metode untuk melakukan penarikan dari saldo
    public void withdraw(double amount) {
        if (saldo >= amount) {
            saldo -= amount;
        } else {
            System.out.println("Saldo tidak mencukupi!");
        }
    }

    // Metode untuk menampilkan informasi Rekening27 dalam bentuk string
    public String toString() {
        return "Rekening: " + Rekening + 
        "\nNama\t: " + nama + 
        "\nTelefon\t: " + telefon + 
        "\nEmail\t: " + email + 
        "\nSaldo\t: " + saldo + "\n";
    }

    // Metode untuk mendapatkan saldo
    public double getBalance() {
        return saldo;
    }

    // Metode untuk mendapatkan nama
    public String getName() {
        return nama;
    }

    // Metode untuk mendapatkan nomor rekening
    public String getAccountNumber() {
        return Rekening;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemBank sistem = new SistemBank(1000);
        int pilih = 0;
        do {
            menu();
            System.out.println();
            System.out.print("Menu: ");
            pilih = sc.nextInt();
            sc.nextLine();
            String rek = "";
            int jumlah = 0;
            switch (pilih) {
                case 1:
                    // Input data akun baru dari pengguna
                    sc.nextLine();
                    System.out.println("Masukkan data akun baru");
                    System.out.print("Nomor Rekening: ");
                    String nomorRekening = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Nomor Telefon: ");
                    String nomorTelefon = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Saldo: ");
                    double saldo = sc.nextDouble();
        
                    // Menambahkan akun baru ke sistem
                    sistem.addAccount(new Rekening27(nomorRekening, nama, nomorTelefon, email, saldo));
                    break;
                case 2:
                    // Menampilkan semua rekening
                    sistem.displayAllAccounts();
                    break;
                case 3:
                    // Mengurutkan akun berdasarkan saldo dalam mode menurun
                    sistem.sortAccountsByBalance();
                    break;
                case 4:
                    // Menampilkan akun dengan saldo kurang dari 50.000
                    sistem.displayLowBalanceAccounts();
                    break;
                case 5:
                    // Mencari akun berdasarkan kata kunci nama
                    System.out.print("Masukkan Nama yang ingin dicari: ");
                    String name = sc.nextLine();
                    sistem.searchAccountByName(name);
                    break;
                case 6:
                    // Melakukan penarikan dari akun
                    System.out.print("Masukkan Rekening anda: ");
                    rek = sc.nextLine();
                    System.out.print("Masukkan Jumlah uang yang ingin ditarik: ");
                    jumlah = sc.nextInt();
                    sc.nextLine();
                    sistem.withdrawFromAccount(rek, jumlah);
                    break;
                case 7:
                    // Melakukan setoran ke akun
                    System.out.print("Masukkan Rekening anda: ");
                    rek = sc.nextLine();
                    System.out.print("Masukkan Jumlah uang yang ingin ditarik: ");
                    jumlah = sc.nextInt();
                    sistem.depositToAccount(rek, jumlah);
                    break;
                default:
                    break;
            }
        } while (pilih > 0 && pilih < 8);
        sc.close();
    }
}