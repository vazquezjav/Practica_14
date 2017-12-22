package utilidades;

public class Texto {

	public static String tamano(String texto, int tamano){
		if(texto.length()>tamano)
			return texto.substring(tamano);
		for(int i=texto.length(); i<tamano; i++)
			texto+=" ";
		System.out.println(texto.length());
		return texto;
	}
}
