import java.util.Scanner;

public class Main {

    // Menyimpan daftar menu
    static Menu[] daftarMenu = {
        new Menu("Nasi Goreng", 25000, "Makanan"),
        new Menu("Mie Ayam", 20000, "Makanan"),
        new Menu("Sate Ayam", 30000, "Makanan"),
        new Menu("Ayam Bakar", 35000, "Makanan"),
        new Menu("Es Teh", 5000, "Minuman"),
        new Menu("Jus Alpukat", 15000, "Minuman"),
        new Menu("Kopi Hitam", 8000, "Minuman"),
        new Menu("Teh Tarik", 12000, "Minuman")
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Tampilkan menu
        tampilkanMenu();

        // Maksimal 4 pesanan
        String[] pesanan = new String[4];
        int[] jumlah = new int[4];

        System.out.println("\nSilakan masukkan pesanan Anda (maksimal 4 menu):");
        System.out.println("Contoh: Nasi Goreng = 2");

        System.out.print("Pesanan 1: ");
        String p1 = input.nextLine();
        System.out.print("Pesanan 2: ");
        String p2 = input.nextLine();
        System.out.print("Pesanan 3: ");
        String p3 = input.nextLine();
        System.out.print("Pesanan 4: ");
        String p4 = input.nextLine();

        // Proses input tanpa pengulangan
        if (!p1.equals("")) prosesInput(p1, pesanan, jumlah, 0);
        if (!p2.equals("")) prosesInput(p2, pesanan, jumlah, 1);
        if (!p3.equals("")) prosesInput(p3, pesanan, jumlah, 2);
        if (!p4.equals("")) prosesInput(p4, pesanan, jumlah, 3);

        // Hitung total dan cetak struk
        cetakStruk(pesanan, jumlah);

        // Tutup Scanner untuk menghindari resource leak
        input.close();
    }

    static void tampilkanMenu() {
        System.out.println("=== MENU MAKANAN ===");
        if (daftarMenu[0].kategori.equals("Makanan")) System.out.println("- " + daftarMenu[0].nama + " : Rp " + daftarMenu[0].harga);
        if (daftarMenu[1].kategori.equals("Makanan")) System.out.println("- " + daftarMenu[1].nama + " : Rp " + daftarMenu[1].harga);
        if (daftarMenu[2].kategori.equals("Makanan")) System.out.println("- " + daftarMenu[2].nama + " : Rp " + daftarMenu[2].harga);
        if (daftarMenu[3].kategori.equals("Makanan")) System.out.println("- " + daftarMenu[3].nama + " : Rp " + daftarMenu[3].harga);

        System.out.println("\n=== MENU MINUMAN ===");
        if (daftarMenu[4].kategori.equals("Minuman")) System.out.println("- " + daftarMenu[4].nama + " : Rp " + daftarMenu[4].harga);
        if (daftarMenu[5].kategori.equals("Minuman")) System.out.println("- " + daftarMenu[5].nama + " : Rp " + daftarMenu[5].harga);
        if (daftarMenu[6].kategori.equals("Minuman")) System.out.println("- " + daftarMenu[6].nama + " : Rp " + daftarMenu[6].harga);
        if (daftarMenu[7].kategori.equals("Minuman")) System.out.println("- " + daftarMenu[7].nama + " : Rp " + daftarMenu[7].harga);
    }

    static void prosesInput(String inputStr, String[] pesanan, int[] jumlah, int index) {
        String[] bagian = inputStr.split("=");
        if (bagian.length == 2) {
            pesanan[index] = bagian[0].trim();
            jumlah[index] = Integer.parseInt(bagian[1].trim());
        }
    }

    static void cetakStruk(String[] pesanan, int[] jumlah) {
        int subtotal = 0;
        int diskon = 0;
        boolean adaDiskonMinuman = false;
        String minumanPromo = "";

        System.out.println("\n===== STRUK PEMESANAN =====");
        for (int i = 0; i < 4; i++) {
            if (pesanan[i] != null) {
                Menu item = cariMenu(pesanan[i]);
                if (item != null) {
                    int totalItem = item.harga * jumlah[i];
                    System.out.println(item.nama + " (" + item.kategori + ") x" + jumlah[i] + " = Rp " + totalItem);
                    subtotal += totalItem;

                    // Jika pesanan minuman dan total > 50.000, promo beli 1 gratis 1
                    if (item.kategori.equals("Minuman") && subtotal > 50000 && !adaDiskonMinuman) {
                        totalItem -= item.harga; // Gratis 1
                        adaDiskonMinuman = true;
                        minumanPromo = item.nama;
                    }
                } else {
                    System.out.println(pesanan[i] + " tidak ditemukan di menu.");
                }
            }
        }

        System.out.println("------------------------------");
        System.out.println("Subtotal: Rp " + subtotal);

        // Diskon 10% jika subtotal > 100.000
        if (subtotal > 100000) {
            diskon = subtotal * 10 / 100;
            System.out.println("Diskon 10%: -Rp " + diskon);
        }

        // Pajak 10%
        int pajak = (subtotal - diskon) * 10 / 100;
        System.out.println("Pajak 10%: Rp " + pajak);

        // Biaya pelayanan
        int layanan = 20000;
        System.out.println("Biaya Pelayanan: Rp " + layanan);

        // Total akhir
        int totalAkhir = subtotal - diskon + pajak + layanan;
        System.out.println("------------------------------");
        System.out.println("Total Bayar: Rp " + totalAkhir);

        // Info promo minuman
        if (adaDiskonMinuman) {
            System.out.println("Promo: Beli 1 gratis 1 untuk minuman " + minumanPromo);
        }

        System.out.println("Terima kasih atas pesanan Anda!");
    }

    static Menu cariMenu(String namaMenu) {
        if (daftarMenu[0].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[0];
        else if (daftarMenu[1].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[1];
        else if (daftarMenu[2].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[2];
        else if (daftarMenu[3].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[3];
        else if (daftarMenu[4].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[4];
        else if (daftarMenu[5].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[5];
        else if (daftarMenu[6].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[6];
        else if (daftarMenu[7].nama.equalsIgnoreCase(namaMenu)) return daftarMenu[7];
        else return null;
    }
}
