package validointi;

public class Henkilo {

    private String nimi;
    private int ika;

    public Henkilo(String nimi, int ika) {
        if (nimi == null || nimi == "" || nimi.length() > 40) {
            throw new IllegalArgumentException("Nimi ei saa olla null, tyhjä tai yli 40 merkkiä pitkä");
        } else if (ika < 0 || ika > 120) {
            throw new IllegalArgumentException("Iän tulee olla väliltä 0-120");
        }
        
        this.nimi = nimi;
        this.ika = ika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIka() {
        return ika;
    }
}
