package ews;


public class Main {
	
	public static void main(String[] args) {
		
		//ORDENACAO BUBBLE SORT
		int array[] =  {22, 10, 12, 30, 40, 80, 60, 70, 99, 90};
		int temp = 0;
		for (int i = 0; i < array.length -1; i++) {
			//compara se e maior que o proximo
			if (array[i] > array[i +1]) {
				temp = array[i];
				array[i] = array[i +1];
				array[i +1] = temp;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			 System.out.print(array[i] + "|");
		 }
		
		
	}

}
