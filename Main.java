public class Main {
    public static void main(String[] args){

        Parcheggio parcheggio = new Parcheggio();

        Thread[] threads = new Thread[]{

            new AutoEntrata(1, parcheggio),
            new AutoEntrata(2, parcheggio),
            new AutoUscita(3, parcheggio),
            new AutoEntrata(4, parcheggio),
            new AutoEntrata(5, parcheggio),
            new AutoUscita(5, parcheggio),
            new AutoUscita(2, parcheggio),
            new AutoEntrata(3, parcheggio),
            new AutoEntrata(2, parcheggio),
            new AutoUscita(4, parcheggio),
        };

        for(Thread thread : threads){
            thread.start();
        }
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Fine del programma");
    }
}
