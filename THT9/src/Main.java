import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.new Scanner(System.in));
        CustomerService csUtama = new CustomerService("Siti");
        Nasabah nasabahAktif = null;

        int pilihan;
        do {
            System.out.println("\n~~~ MENU UTAMA NEOBANK ~~~");
            System.out.println("1. Registrasi Nasabah");
            System.out.println("2. Buka Rekening Baru");
            System.out.println("3. Simulasi Transaksi (Setor/Tarik)");
            System.out.println("4. Hubungi Customer Service");
            System.out.println("5. Skenario Penutupan Akun Paksa (Analisis)");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = scanner.nextLine();
                    nasabahAktif = new Nasabah(nama);
                    System.out.println("SUKSES! Profil Nasabah '" + nama + "' berhasil dibuat.");
                    break;

                case 2:
                    if (nasabahAktif == null) {
                        System.out.println("GAGAL! Silakan registrasi nasabah terlebih dahulu.");
                        break;
                    }
                    System.out.print("Masukkan No Rekening Baru: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo Awal: ");
                    double saldoAwal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Buat PIN Akun: ");
                    String pin = scanner.nextLine();

                    System.out.println("Pilih Jenis Rekening:");
                    System.out.println("1. Reguler (Biaya Admin Rp 5000)");
                    System.out.println("2. Prioritas (Bebas Admin, Min Tarik Rp 500.000)");
                    System.out.print("Pilihan: ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine();

                    Rekening rekBaru = null;
                    if (tipe == 1) {
                        rekBaru = new RekeningReguler(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    } else if (tipe == 2) {
                        rekBaru = new RekeningPrioritas(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    }

                    if (rekBaru != null && nasabahAktif.tambahRekening(rekBaru)) {
                        System.out.println("SUKSES! Rekening berhasil ditambahkan ke profil nasabah.");
                    } else {
                        System.out.println("GAGAL! Rekening penuh (Maksimal 3) atau pilihan tidak valid.");
                    }
                    break;

                case 3:
                    if (nasabahAktif == null) {
                        System.out.println("GAGAL! Profil nasabah belum ada.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening: ");
                    String cariRek = scanner.nextLine();
                    Rekening rekDipilih = null;

                    for (Rekening r : nasabahAktif.getDaftarRekening()) {
                        if (r != null && r.getNomorRekening().equals(cariRek)) {
                            rekDipilih = r;
                            break;
                        }
                    }

                    if (rekDipilih == null) {
                        System.out.println("GAGAL! Rekening tidak ditemukan di dalam profil Anda.");
                        break;
                    }

                    System.out.print("Masukkan PIN Rekening: ");
                    String pinInput = scanner.nextLine();
                    if (!rekDipilih.verifikasiPIN(pinInput)) {
                        System.out.println("GAGAL! PIN salah! Otorisasi ditolak.");
                        break;
                    }

                    System.out.println("Pilih Aksi:\n1. Setor\n2. Tarik");
                    System.out.print("Pilihan: ");
                    int aksi = scanner.nextInt();
                    System.out.print("Masukkan Nominal: ");
                    double nominal = scanner.nextDouble();

                    if (aksi == 1) {
                        rekDipilih.setor(nominal);
                        System.out.println("SUKSES! Setoran berhasil. Saldo saat ini: Rp " + rekDipilih.getSaldo());
                    } else if (aksi == 2) {
                        if (rekDipilih.tarik(nominal)) {
                            System.out.println("SUKSES! Penarikan berhasil. Saldo saat ini: Rp " + rekDipilih.getSaldo());
                        } else {
                            System.out.println("GAGAL! Penarikan ditolak (Saldo tidak cukup / Syarat tidak terpenuhi).");
                        }
                    }
                    break;

                case 4:
                    if (nasabahAktif == null) {
                        System.out.println("GAGAL! Harus registrasi nasabah terlebih dahulu.");
                        break;
                    }
                    System.out.print("Masukkan Keluhan Anda: ");
                    String keluhan = scanner.nextLine();
                    nasabahAktif.laporKeluhan(csUtama, keluhan);
                    break;

                case 5:
                    if (nasabahAktif == null) {
                        System.out.println("GAGAL! Belum ada profil nasabah untuk disimulasikan.");
                        break;
                    }
                    
                    Rekening salinanReferensiRekening = null;
                    for (Rekening r : nasabahAktif.getDaftarRekening()) {
                        if (r != null) {
                            salinanReferensiRekening = r;
                            break;
                        }
                    }

                    System.out.println("Mengeksekusi penutupan akun paksa...");
                    nasabahAktif = null; 
                    System.out.println("PROSES... Object nasabahAktif telah di-set ke null.");
                    
                    System.out.println("SUKSES! Analisis siklus hidup objek telah dicetak di baris komentar.");
                    break;
            }
        } while (pilihan != 6);
        scanner.close();
    }
}

/**
 * Analisis : 
 * 
 * 1. BUKTI AGREGASI (Hubungan Longgar / Loose Coupling):
 *    Meskipun akun 'nasabahAktif' dihapus (di-set menjadi null), objek 'Rekening' 
 *    yang terhubung dengannya tidak akan ikut terhapus. Objek 'Rekening' tetap aman 
 *    tersimpan di memori data pusat karena siklus hidupnya berdiri sendiri dan tidak 
 *    tergantung pada objek 'Nasabah'. Kita masih bisa memanggil rekening tersebut 
 *    secara normal melalui 'salinanReferensiRekening'.
 *
 * 2. BUKTI KOMPOSISI (Hubungan Kuat / Strong Coupling):
 *    Sebaliknya, jika objek 'Rekening' dihapus dari sistem, maka objek 'BukuMutasi' 
 *    di dalamnya akan otomatis ikut terhapus total dari memori. Hal ini terjadi karena 
 *    'BukuMutasi' dibuat langsung di dalam konstruktor 'Rekening'. Tanpa adanya objek 
 *    'Rekening' sebagai pemilik, 'BukuMutasi' tidak bisa eksis sendirian karena 100% 
 *    siklus hidupnya bergantung pada objek 'Rekening'.
 */
