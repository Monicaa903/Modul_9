public class MainRumahSakit {
    public static void main(String[] args) {
        // Bagian 4
        Dokter drMoona = new Dokter("Moona", "Anak");
        Dokter drAtin = new Dokter("Atin", "Bedah");

        Pasien pasienFerdi = new Pasien("Ferdi", 8);
        Pasien pasienEl = new Pasien("El", 25);

        System.out.println("--- Simulasi Pemeriksaan Pasien (Asosiasi) ---");
        drMoona.periksaPasien(pasienFerdi);
        System.out.println();

        System.out.println("--- Pendirian RS Sehat Selalu & Pengisian Data ---");
        // Mendirikan Rumah Sakit
        RumahSakit rs = new RumahSakit("RS Sehat Selalu");

        Dokter[] dokterRS = new Dokter[]{drMoona, drAtin};
        rs.setDokter(dokterRS);

        rs.tampilkanRuangan();
        System.out.println();
        rs.tampilkanDokter();
        System.out.println();

        System.out.println("--- Pengujian Terakhir: RS Dihancurkan (rs = null) ---");
        rs = null;

        System.out.println("Eksperimen Pemanggilan Objek Dokter Setelah RS Gulung Tikar:");
        System.out.println("Nama Dokter 1: " + drMoona.nama);
        System.out.println("Nama Dokter 2: " + drAtin.nama);
        System.out.println("Nama Pasien 1: " + pasienFerdi.nama);
        System.out.println("Nama Pasien 2: " + pasienEl.nama);
    }
}