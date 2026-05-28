public class RekeningPrioritas extends Rekening {
    private final double MIN_TARIK = 500000;

    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldo, String pin) {
        super(nomorRekening, namaPemilik, saldo, pin);
    }

    @Override
    public boolean tarik(double jumlah) {
        if (jumlah < MIN_TARIK) {
            System.out.println("   [GAGAL] Batas penarikan minimum akun prioritas adalah Rp " + MIN_TARIK);
            return false;
        }
        if (this.saldo >= jumlah) {
            this.saldo -= jumlah;
            mutasi.cetakLog("Penarikan Prioritas (Bebas Admin)", jumlah);
            return true;
        }
        return false;
    }
}
