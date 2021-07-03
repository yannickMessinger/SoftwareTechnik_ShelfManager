package ShelfManager.Lager.Exceptions;

public class RegalTraglastExceededException extends Exception {

    public RegalTraglastExceededException(){
        super("Traglast des Regals überschritten");
    }
}
