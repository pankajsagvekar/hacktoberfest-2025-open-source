/**
 * Kelas ini mendemonstrasikan penggunaan array, tipe data double,
 * dan perulangan 'for' untuk menghitung rata-rata.
 */
public class HitungRataRata {

    public static void main(String[] args) {
        // 1. Deklarasi dan inisialisasi array dengan tipe data double
        // Angka-angka ini bisa mewakili nilai ujian, misalnya.
        double[] nilaiUjian = {85.5, 90.0, 78.5, 92.0, 88.0};

        // 2. Variabel untuk menyimpan total penjumlahan nilai
        double totalNilai = 0.0;
        
        // Variabel untuk menyimpan panjang array
        int jumlahData = nilaiUjian.length;

        // 3. Perulangan 'for' untuk menjumlahkan semua elemen array
        System.out.println("Memproses nilai-nilai:");
        for (int i = 0; i < jumlahData; i++) {
            totalNilai = totalNilai + nilaiUjian[i];
            System.out.println("  Nilai ke-" + (i + 1) + ": " + nilaiUjian[i]);
        }

        // 4. Hitung rata-rata
        // Memastikan pembagian menggunakan double agar hasilnya presisi
        double rataRata = totalNilai / jumlahData;

        // 5. Menampilkan hasil
        System.out.println("\n--- Hasil ---");
        System.out.println("Total semua nilai: " + totalNilai);
        System.out.println("Jumlah data: " + jumlahData);
        System.out.println("Rata-rata nilai adalah: " + rataRata);
    }
}
