

    import java.util.Scanner;

/**
 *
 * @author elfan and ricky
 */
public class prakpd {

    public static void main(String[] args) {
        menu_awal();
    }

    static Scanner sc = new Scanner(System.in);
    static String[] judul = {"Godzilla: King of Monsters 11.30", "Dilan 1991 18.00", "AVENGERS: ENDGAME 20.00"
            + ""};
    static int[][] studio = {{0,1},{1,2},{0,2}};
    static int[][] kursi = {{0,0,0,0,0,0,0,0,0,0},{1,0,0,0,1,1,1,0,0,0},{0,0,0,0,1,1,1,0,0,1}};
    static int harga = 0;
    static char ulang;

 
    public static void menu_awal() {
        int pilih_menu;
        ulang = 'S';
        do {
            System.out.println("========== Bioskop XXI ==========");
            System.out.println("1.\tJudul Film");
            System.out.println("2.\tTransaksi");
            System.out.println("=================================");
            System.out.print("Pilih : ");

            pilih_menu = sc.nextInt();

            System.out.println("");
            switch (pilih_menu) {
                case 1:
                    judul_film();
                    break;
             
                case 2:
                    transaksi();
                    break;
                
                default:
                    System.out.println("Inputan salah!");
            }
            System.out.print("ingin kembali ke menu awal ?(Y/T) ");
            ulang = sc.next().charAt(0);
        } while (ulang == 'Y' || ulang == 'y');
    }

    public static void judul_film() {
        System.out.println("Theater | Judul Film");
        for (int x = 0; x < judul.length; x++) {
            System.out.println((x + 1) + "\t| " + judul[x]);
        }

    }

  

    public static void transaksi() {
          int z = 1;
        while (z != 0) {
            System.out.println("");
            System.out.println("Hari");
            System.out.println("1. Senin");
            System.out.println("2. Selasa");
            System.out.println("3. Rabu");
            System.out.println("4. Kamis");
            System.out.println("5. Jumat");
            System.out.println("6. Sabtu");
            System.out.println("7. Minggu");
            System.out.print("Pilih Hari: ");
            int pilih_hari = sc.nextInt();
            if (pilih_hari >= 1 && pilih_hari <= 5) {
                harga = 30000;
                z = 0;
            } else if (pilih_hari >= 6 && pilih_hari <= 7) {
                harga = 50000;
                z = 0;
            } else {
                System.out.println("Pilih dengan benar");
            }
        }
        System.out.println("========== Transaksi ==========");
        System.out.println("No, | Judul Film");
        for (int x = 0; x < judul.length; x++) {
            System.out.println((x + 1) + "   | " + judul[x]);
        }
        System.out.println("===============================");
        System.out.print("Pilih : ");
        int pilih_judul = sc.nextInt();
        
        int[] kursi_dipesan = new int[10];
        
        int tiket=0;
        System.out.println("===========  Studio  ==========");
        System.out.println("Studio "+(studio[pilih_judul-1][0]+1));
        System.out.println("Studio "+(studio[pilih_judul-1][1]+1));
        System.out.println("===============================");
        System.out.print("Pilih : ");
        int pilih_studio = sc.nextInt();
        int pilih_kursi=0;
        int c=1;
        while(c!=0){
            for(int x=0;x<10;x++){
                if(kursi[pilih_studio-1][x]==0){
                    System.out.println("Kursi "+(x+1));
                }
            }
            System.out.print("Pilih Kursi: ");
            pilih_kursi = sc.nextInt();
            if(kursi[pilih_studio-1][pilih_kursi-1]==0){
               kursi[pilih_studio-1][pilih_kursi-1]=1;
               tiket +=1;
               kursi_dipesan[tiket-1] = pilih_kursi;
              
            }else{
                System.out.println("Kursi Sudah Dipesan!");
            }
                System.out.println("Ingin memesan tiket lagi Y/T");
             String tambah_kursi= sc.next();
             if(tambah_kursi.equalsIgnoreCase("Y")){
                 
             }else{
                 c=0;
             }
             
                   
        }
        
        int total = harga*tiket;
        System.out.println("");
        System.out.println("===============================");
        System.out.println(" Judul Film\t: " + judul[(pilih_judul - 1)]);
        System.out.println(" Studio\t\t: " + pilih_studio);
        System.out.print(" Kursi\t\t: ");
        for(int i=0;i<tiket;i++){
            if(kursi_dipesan[i] != 0){
                System.out.print(kursi_dipesan[i]+",");
            }
        }
        System.out.println("2");
        System.out.println(" Total Harga\t: " + total);
        System.out.println("===============================");

        
        
        System.out.print("Bayar\t: ");
        int bayar = 0;
        do {

            bayar = sc.nextInt();
            if (bayar < total) {
                System.out.println("Maaf, Uang anda kurang");
                System.out.print(" Bayar\t: ");

            } else {
            }
        } while (bayar < total);

        int kembalian = bayar - total;
        System.out.println(" Kembalian\t: " + kembalian);
        

        
    }

}
