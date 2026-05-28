public class Nasabah {
    private String nama;
    private Rekening[] daftarRekening;
    private int jumlahRekening;

    public Nasabah(String nama) {
        this.nama = nama;
        this.daftarRekening = new Rekening[3];
        this.jumlahRekening = 0;
    }

    public boolean tambahRekening(Rekening rek) {
        if (jumlahRekening < 3) {
            daftarRekening[jumlahRekening] = rek;
            jumlahRekening++;
            return true;
        }
        return false;
    }

    public void laporKeluhan(CustomerService cs, String keluhan) {
        cs.layaniKeluhan(this.nama, keluhan);
    }

    public Rekening[] getDaftarRekening() {
        return daftarRekening;
    }

    public String getNama() {
        return nama;
    }
}
