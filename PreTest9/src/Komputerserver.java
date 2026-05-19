public class KomputerServer {
    private String namaServer;
    private Harddisk harddiskInternal;
    private Monitor[] daftarMonitor;  

    public KomputerServer(String namaServer, String merkHD, int kapasitasHD, Monitor[] monitorEksternal) {
        this.namaServer = namaServer;
        this.harddiskInternal = new Harddisk(merkHD, kapasitasHD); 
        this.daftarMonitor = monitorEksternal;
    }
}
