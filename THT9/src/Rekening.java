public abstract class Rekening implements Otorisasi {
    protected String nomorRekening;
    protected String namaPemilik;
    protected double saldo;
    protected String pin;
    protected BukuMutasi mutasi;

    public Rekening(String nomorRekening, String namaPemilik, double saldo, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.pin = pin;
        this.mutasi = new BukuMutasi();
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            mutasi.cetakLog("Setoran", jumlah);
        }
    }

    public abstract boolean tarik(double jumlah);

    @Override
    public boolean verifikasiPIN(String pinInput) {
        return this.pin.equals(pinInput);
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }
}
