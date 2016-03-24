package util;

public class ArtistaNaoEncontradoException extends Exception {
	
	public ArtistaNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
