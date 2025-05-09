public class Video extends ElementoMultimediale implements ElementoRiproducibile{
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata,int volume,int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume=volume;
        this.luminosita=luminosita;
    }
    public void alzaVolume () {
        volume++;
    }

    public void abbassaVolume() {
        if(volume>0){
            volume--;
        }
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(getTitolo() + "!" .repeat(volume) + "*" .repeat(luminosita));

        }

    }
}
