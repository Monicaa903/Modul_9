class RumahSakit {
    String namaRumahSakit;
    Ruangan[] daftarRuangan; 
    Dokter[] daftarDokter;

    public RumahSakit(String namaRumahSakit) {
        this.namaRumahSakit = namaRumahSakit;
              
        Ruangan r1 = new Ruangan("R-01", 10);
        Ruangan r2 = new Ruangan("R-02", 15);
        this.daftarRuangan = new Ruangan[]{r1, r2};
    }
    public void setDokter(Dokter[] daftarDokter) {
        this.daftarDokter = daftarDokter;
    }

    public void tampilkanRuangan() {
        System.out.println("Daftar Ruangan di " + namaRumahSakit + ":");
        for (Ruangan r : daftarRuangan) {
            if (r != null) {
                System.out.println("- No. Registrasi: " + r.nomorRegistrasi + 
                                   ", Kapasitas Maksimal: " + r.kapasitasMaksimal + " pasien");
            }
        }
    }

    // Bagian 3
    public void tampilkanDokter() {
        System.out.println("Daftar Dokter yang bertugas di " + namaRumahSakit + ":");
        if (daftarDokter != null) {
            for (Dokter d : daftarDokter) {
                if (d != null) {
                    System.out.println("- Dr. " + d.nama + " (" + d.spesialisasi + ")");
                }
            }
        }
    }
}