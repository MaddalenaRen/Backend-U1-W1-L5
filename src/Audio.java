public class Audio extends ElementoMultimediale implements ElementoRiproducibile{
        private int durata;
        private int volume;

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void alzaVolume (){
        volume++;
    }

    public void abbassaVolume(){
        if(volume>0){
            volume--;
        }
    }


    @Override
    public void play() {

        for (int i = 0; i < durata ; i++) {
            System.out.println(getTitolo() + "!" .repeat(volume));
            
        }
    }
}
