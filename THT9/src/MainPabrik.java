public class MainPabrik {
    public static void main(String[] args) {
        Ban b1 = new Ban("Bridgestone", 18);
        Ban b2 = new Ban("Bridgestone", 18);
        Ban b3 = new Ban("Bridgestone", 18);
        Ban b4 = new Ban("Bridgestone", 18);
        Ban[] setBanMobil = {b1, b2, b3, b4};

        Mobil mobilUtama = new Mobil("Supra MK4", "Putih");

        mobilUtama.pasangSetBan(setBanMobil);

        Montir montirEko = new Montir("M-01", "Eko");

        System.out.println("--- Tahap 1: Tampilkan Spesifikasi Awal ---");
        mobilUtama.tampilkanSpesifikasi();
        System.out.println();

        System.out.println("--- Tahap 2: Proses Inspeksi Kelayakan ---");
        montirEko.lakukanQualityControl(mobilUtama);
        System.out.println();

        System.out.println("--- Tahap 3: Mobil Gagal Uji (Dihancurkan) ---");
        mobilUtama = null;

        System.out.println("Pembuktian Eksistensi Objek Setelah Mobil Dihancurkan:");
        System.out.println("Merk Ban 1 di Gudang: " + b1.merk);
        System.out.println("Merk Ban 2 di Gudang: " + b2.merk);
        System.out.println("Merk Ban 3 di Gudang: " + b3.merk);
        System.out.println("Merk Ban 4 di Gudang: " + b4.merk);
    }
}  