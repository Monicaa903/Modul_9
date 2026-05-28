public class CustomerService {
    private String namaCS;

    public CustomerService(String namaCS) {
        this.namaCS = namaCS;
    }

    public void layaniKeluhan(String namaNasabah, String keluhan) {
        System.out.println("CS " + namaCS + " menerima keluhan dari " + namaNasabah + ": \"" + keluhan + "\"");
    }
}
