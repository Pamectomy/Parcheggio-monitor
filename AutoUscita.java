public class AutoUscita extends Thread{

    private int id;
    private Parcheggio parcheggio;

    public AutoUscita(int id, Parcheggio parcheggio){
        this.id = id;
        this.parcheggio = parcheggio;
    }

    public void run(){
        try{
            parcheggio.uscitaMacchina(id);
        
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        
    }
}
