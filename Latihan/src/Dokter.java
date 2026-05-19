class Dokter{
    String nama;
    String spesialisasi;

    public Dokter(String nama, String spesialisasi){
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }
   public void periksaPasien(Pasien pasien) {
        System.out.println("Dokter " + this.nama + " (" + this.spesialisasi + 
                           ") sedang memeriksa pasien bernama " + pasien.nama + 
                           " yang berumur " + pasien.umur + " tahun.");
    }
}