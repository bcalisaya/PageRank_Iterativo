import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
	    
	public static void main(String[] args) {    
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formateador = new DecimalFormat("0.");
		System.out.println("Ingrese Numero de Paginas");
		System.out.println("10 ,100 ,1K, 1M");
		int paginas=teclado.nextInt();
		float[][] matriz = new float[paginas][paginas];
		
		Random r = new Random();
		String sp;
		for(int i=0; i<paginas;i++) {
			for(int j=0; j<paginas;j++) {
				//int num = r.nextInt(46)+5;
				float num;
				num= Float.parseFloat(formateador.format (r.nextFloat()*45+5));
				if(num>9) {sp="";}else {sp=" ";}
				matriz[j][i] = num;
				System.out.print(" |"+num+sp+"| ");
			}
			System.out.println();
		}
		float[] matLin,resp;
		float[][] matCal;
		Operation MatrizLineal = new Operation();
		
		matLin=MatrizLineal.Cantidades(matriz,paginas);
		matCal=MatrizLineal.Calculo(matriz,matLin);
		System.out.println("Rankeo final de paginas");
		resp=MatrizLineal.Iteration(matCal,paginas);
		
		}		
}		
