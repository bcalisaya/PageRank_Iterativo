
public class Operation extends Thread{
	public float[] Cantidades(float[][] mat,int fil) {
		float[] salida = new float[fil];
		System.out.println("");
		for(int i=0; i<fil;i++) {
			for(int j=0; j<fil;j++) {
				salida[i]=mat[i][j]+salida[i];
			}
			System.out.print("|"+salida[i]+"|");
		}
		System.out.println("");
		System.out.println("");
		return salida;
	}
	public float[][] Calculo(float[][] mat1,float[] mat2) {
		System.out.println("Sumatoria de Columnas");
		float[][] salida = new float[mat2.length][mat2.length];
		for(int i=0; i<mat2.length;i++) {
			for(int j=0; j<mat2.length;j++) {
				salida[i][j]=mat1[i][j]/ mat2[i];
			}
		}
		System.out.println("Matiz con pesos de las paginas");
		for(int i=0; i<mat2.length;i++) {
			for(int j=0; j<mat2.length;j++) {
				System.out.print("|"+salida[j][i]+"|");
			}
			System.out.println();
		}
		return salida;
	}
	public float[] SumaTotal(float[][] mat,int fil) {
		float[] salida = new float[fil];
		for(int i=0; i<fil;i++) {
			for(int j=0; j<fil;j++) {
				salida[i]=mat[j][i]+salida[i];
			}
			System.out.println("|"+salida[i]+"|");
		}
		return salida;
	}
	public float[] Iteration(float[][] mat,int fil) {
		float[] iterador = new float[fil];
		float[] auxiliar= new float[fil];
		float[] momentaneo= new float[fil];
		float acumulador=0;
		int contg=0;
		float moment=0;
		boolean correcto=true;
		//Llenando la Matriz r'
		for(int i=0;i<fil;i++) {iterador[i]=1;}
		while(correcto) {
			//No funciona asi extraño no? => auxiliar=iterador;
			for(int i=0;i<fil;i++) {auxiliar[i]=iterador[i];}			
			for(int i=0; i<fil;i++) {
				for(int j=0; j<fil;j++) {
					momentaneo[i]=mat[j][i]*iterador[j];
					acumulador =momentaneo[i]+acumulador;
				}
					momentaneo[i] = acumulador;
					acumulador=0;
			}
			iterador=momentaneo;
			
				moment=0;
			for(int s=0; s<fil;s++) {
				//System.out.println(auxiliar[s]+"-"+iterador[s]+"+"+moment);
				moment=Math.abs(auxiliar[s]-iterador[s])+moment;contg++;	
			}
			if(moment>0.0001) {correcto =true; }else {correcto =false; }
			//System.out.println("-------"+contg+"-"+moment+"-*-");
						
		}
		for(int i=0; i<fil;i++) {
			System.out.println("|"+iterador[i]+"|");
		}
		
		return iterador;
	}
	
}
