public class RekeningReguler extends Rekening {
    private final double BIAYA_ADMIN = 5000;

    public RekeningReguler(String nomorRekening, String namaPemilik, double saldo, String pin) {
        super(nomorRekening, namaPemilik, saldo, pin);
    }

    @Override
    public boolean tarik(double jumlah) {
        double totalTagihan = jumlah + BIAYA_ADMIN;
        if (jumlah > 0 && this.saldo >= totalTagihan) {
            this.saldo -= totalTagihan;
            mutasi.cetakLog("Penarikan Reguler (Biaya Admin Rp 5000)", jumlah);
            return true;
        }
        return false;
    }
}
