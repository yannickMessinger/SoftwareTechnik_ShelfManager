package ShelfManager.Lager.Exceptions;

public class LagerVollException extends Exception{

    public LagerVollException() {
        super("Das Lager ist voll!");
    }

}
