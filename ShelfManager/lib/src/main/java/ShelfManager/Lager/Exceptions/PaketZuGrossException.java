package ShelfManager.Lager.Exceptions;

public class PaketZuGrossException extends Exception{

    public PaketZuGrossException() {
        super("Das Paket ist zu groß fuer dieses Regalfach");
    }
}
