class Montir {
    String idMontir;
    String nama;

    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    public void lakukanQualityControl(Mobil m) {
        System.out.println("Montir " + this.nama + " (ID: " + this.idMontir + ") sedang memeriksa kelayakan mobil " + m.merkMobil);
    }
}