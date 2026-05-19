class Mobil {
    String merkMobil;
    String warna;
    Mesin komponenMesin;
    Ban[] daftarBan;

    public Mobil(String merkMobil, String warna) {
        this.merkMobil = merkMobil;
        this.warna = warna;
        this.komponenMesin = new Mesin("NS-V8-100X", 3000);
        this.daftarBan = new Ban[4];
    }

    public void pasangSetBan(Ban[] setBan) {
        this.daftarBan = setBan;
    }

    public void tampilkanSpesifikasi() {
        System.out.println("Spesifikasi Mobil:");
        System.out.println("- Merk: " + merkMobil);
        System.out.println("- Warna: " + warna);
        System.out.println("- Mesin: " + komponenMesin.jenisNoSeri + " (" + komponenMesin.kapasitasCC + " CC)");
        System.out.println("- Komponen Ban:");
        if (daftarBan != null) {
            for (Ban b : daftarBan) {
                if (b != null) {
                    System.out.println("  * Ban " + b.merk + " Ring " + b.ukuranRing);
                }
            }
        }
    }
}