public class Parcheggio {
    
    private int nPosti = 5;
    private int numAttesaEntrata = 0;
    private int numAttesaUscita = 0;
    private boolean full = false; //Segnala se il parcheggio è pieno

    public synchronized void entrataMacchina(int idAuto)
        throws InterruptedException
    {
        numAttesaEntrata++;

        while(nPosti < 0){
            full = true;
            Thread.sleep(2000);
            wait();
        }

        nPosti--;
        numAttesaEntrata--;

        System.out.println("L'auto " + idAuto + " e' entrata nel parcheggio.");
    }

    public synchronized void uscitaMacchina(int idAuto)
        throws InterruptedException
    {
        numAttesaUscita++;

        nPosti++;
        System.out.println("L'auto " + idAuto + " e' uscita dal parcheggio.");

        numAttesaUscita--;
        notifyAll();
    }
}
