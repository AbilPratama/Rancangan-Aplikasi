package penerjemah;

class Pengguna {
    private int idPengguna;
    private String namaPengguna; 
    private String kataSandi;
    private String email;
    private Bahasa bahasaPilihan; 

    void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }
    
    void setNamaPengguna(String namaPengguna) { 
        this.namaPengguna = namaPengguna;
    }
    
    void setEmail(String email) {
        this.email = email;
    }
    
    void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }
    
    void setBahasaPilihan(Bahasa bahasa) {
        this.bahasaPilihan = bahasa;
    }
    
    int getIdPengguna() {
        return this.idPengguna;
    }
    
    String getNamaPengguna() {
        return this.namaPengguna; 
    }
    
    String getEmail() {
        return this.email;
    }
    
    String getKataSandi() {
        return this.kataSandi;
    }
    
    Bahasa getBahasaPilihan() { 
        return this.bahasaPilihan;
    }
}

class PermintaanTerjemahan {  
    private String teks;
    private Bahasa sumber;  
    private Bahasa target;

    void setTeks(String teks) {
        this.teks = teks;
    }

    void setSumber(Bahasa sumber) {  
        this.sumber = sumber;
    }

    void setTarget(Bahasa target) {
        this.target = target;
    }

    String getTeks() {
        return this.teks;
    }

    Bahasa getSumber() {  
        return this.sumber;
    }

    Bahasa getTarget() {
        return this.target;
    }
}

class HasilTerjemahan {  
    private String teksAsli;
    private String teksHasil;
    private Bahasa sumber; 
    private Bahasa target;

    void setTeksAsli(String teksAsli) {
        this.teksAsli = teksAsli;
    }

    void setTeksHasil(String teksHasil) {
        this.teksHasil = teksHasil;
    }

    void setBahasa(Bahasa sumber, Bahasa target) {  
        this.sumber = sumber;
        this.target = target;
    }

    String getTeksAsli() {
        return this.teksAsli;
    }

    String getTeksHasil() {
        return this.teksHasil;
    }

    void tampilkanHasil() { 
        System.out.println("Terjemahan (" + sumber.getNamaBahasa() + " > " + target.getNamaBahasa() + "):");
        System.out.println(teksAsli + " > " + teksHasil);
    }
}

class Bahasa {
    private int idBahasa;
    private String namaBahasa;
    private String wilayah;

    void setIdBahasa(int idBahasa) {
        this.idBahasa = idBahasa;
    }
    
    void setNamaBahasa(String namaBahasa) {
        this.namaBahasa = namaBahasa;
    }
    
    void setWilayah(String wilayah) { 
        this.wilayah = wilayah;
    }
    
    int getIdBahasa() {  
        return this.idBahasa;
    }
    
    String getNamaBahasa() {  
        return this.namaBahasa;
    }
    
    String getWilayah() {  
        return this.wilayah;
    }
}

public class Penerjemah {
    public static void main(String[] args) {
        Pengguna translator = new Pengguna();
        translator.setIdPengguna(1);
        translator.setNamaPengguna("Abil");
        translator.setEmail("abil@translate.com");
        
        Bahasa indonesia = new Bahasa();
        indonesia.setIdBahasa(62);
        indonesia.setNamaBahasa("Indonesia");
        indonesia.setWilayah("ID");
        
        Bahasa inggris = new Bahasa();
        inggris.setIdBahasa(102);
        inggris.setNamaBahasa("English");
        inggris.setWilayah("US");
        
        translator.setBahasaPilihan(indonesia);

        PermintaanTerjemahan permintaan = new PermintaanTerjemahan();
        permintaan.setTeks("Halo dunia!");
        permintaan.setSumber(indonesia);
        permintaan.setTarget(inggris);

        HasilTerjemahan hasil = new HasilTerjemahan();
        hasil.setTeksAsli(permintaan.getTeks());
        hasil.setTeksHasil("Hello world!");
        hasil.setBahasa(indonesia, inggris);

        System.out.println("Nama translator: " + translator.getNamaPengguna());
        System.out.println("Email: " + translator.getEmail());
        
        System.out.println("\nBahasa Pilihan:");
        System.out.println("ID: " + translator.getBahasaPilihan().getIdBahasa());
        System.out.println("Nama: " + translator.getBahasaPilihan().getNamaBahasa());
        System.out.println("Wilayah: " + translator.getBahasaPilihan().getWilayah());
        
        System.out.println("\nHasil Terjemahan:");
        hasil.tampilkanHasil();
    }
}