package pkt;

public class Validar {

	public static boolean validarString(String cadena, int longitudMax) {
		return (!cadena.isBlank() && cadena.length() < longitudMax);
	}
	
	
	
	public static boolean validarUnidades (int unidades) {
		return (unidades>=1)? true:false;
	}
	
	
	public static Categorias chkCategorias(String eCate) {
		char letra=' ';
		Categorias cat = null;
		
		if(eCate.length()==1) {
			letra=eCate.charAt(0);
		}
		
		if(eCate.equals(Categorias.CATA.getDesc().toUpperCase().replace("Í", "I"))
				|| letra == '1' || letra == 'A') {
				cat = Categorias.CATA;
				
			}else if(eCate.equals(Categorias.CATB.getDesc().toUpperCase().replace("Í", "I")) 
				|| letra == '2' || letra == 'B') {
				cat = Categorias.CATB;
				
			}else if(eCate.equals(Categorias.CATC.getDesc().toUpperCase().replace("Í", "I")) 
				|| letra == '3' || letra == 'C') {
				cat = Categorias.CATC;
				
			}else {
				System.out.println("Categoria no encontrada");
			}
		
		return cat;
	}
}
