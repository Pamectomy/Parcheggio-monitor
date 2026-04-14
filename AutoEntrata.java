public class AutoEntrata extends Thread{

    private int id;
    private Parcheggio parcheggio;

    public AutoEntrata(int id, Parcheggio parcheggio){
        this.id = id;
        this.parcheggio = parcheggio;
    }

    public void run(){
        try{    
            parcheggio.entrataMacchina(id);

        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}