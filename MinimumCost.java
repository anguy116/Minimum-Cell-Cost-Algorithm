import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumCost{

	public int getLength(int[][] matrix) {
		int result=0;
		int max=0;
		for(int[] list: matrix) {
			result=0;
			for(int element:list) {
				result++;
			}
			if(max<result) {
				max=result;
			}
		}
		result=max;
		return result;
	}

	public  int getHeight(int[][] matrix) {
		int result=0;

		for(int[] list: matrix) {
			result++;

		}
		return result;
	}

	public int[][] MinimalCell(int[][] matrix) throws Exception {


		int len=getLength(matrix);
		int height=getHeight(matrix);




		int[][] solution=new int[height-1][len-1];



		int[][]visited=new int[height-1][len-1];

		//WHOLE MATRIX IN FOR LOOP: HEIGHT & LEN
		//SOLUTION MATRIX IN FOR LOOP: HEIGHT-1 & LEN-1

		for(int i=0;i<height-1;i++) {
			for(int k=0;k<len-1;k++) {
				visited[i][k]=0;
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<height-1;i++) {
			for(int k=0;k<len-1;k++) {
//				if(matrix[i][k]!=0) {
				list.add(matrix[i][k]);
//				}
			}
		}

		Collections.sort(list);
		int index=0;
		int minx=0,miny=0;
		





		//				for(int i=0;i<height-1;i++) {
		//					for(int k=0;k<len-1;k++) {
		//						System.out.println(visited[i][k]);
		//					}
		//				}

		int goal=0;
		
		int constraint=(height-1)+(len-1)-1;
		

	
		
		while(goal<constraint) {
			//
			//Finds minimal cell
			//makes sure it wasn't visited prior
			if(index==list.size()) {
				throw new Exception("degenerate case");
			}
			
			label1:
				for(int i=0;i<height-1;i++) {
					for(int k=0;k<len-1;k++) {

						if(visited[i][k]!=0) {

						}
						else if(visited[i][k]==0){
							if(matrix[i][k]==list.get(index)) {
								minx=k;
								miny=i;
								visited[i][k]=1;
								index=index+1;
								break label1;
							}
							
						}
					}
				}
				
		
		

		


		//Checks if the minimum cost's demand isn't 0 or supply isn't 0
		//if it is zero dont do anything and find another minimum

		

			//demand=matrix[height-1][minx]
			//supply=matrix[miny][len-1]

			//demand<supply

			if(matrix[height-1][minx]<=matrix[miny][len-1]) {
				
				
				if(matrix[height-1][minx]!=0&&matrix[miny][len-1]!=0) {

				//add all demand as products in solution
				solution[miny][minx]=matrix[height-1][minx];

				//take away all demand from supply(will have remainder)
				matrix[miny][len-1]=matrix[miny][len-1]-matrix[height-1][minx];

				//set the demand to zero

				matrix[height-1][minx]=0;
				goal+=1;


				}
			}
			//demand>supply
			else if(matrix[height-1][minx]>matrix[miny][len-1]) {
				if(matrix[height-1][minx]!=0&&matrix[miny][len-1]!=0) {
				//add all of supply to the solution
				solution[miny][minx]=matrix[miny][len-1];


				//take away the amount of supply from demand
				matrix[height-1][minx]=matrix[height-1][minx]-matrix[miny][len-1];

				//set the supply to zero
				matrix[miny][len-1]=0;
				goal+=1;
				}

			}

		




		}




















		return solution;
	}

public int sum(int[]row) {
	int result=0;
	for(int i=0;i<row.length;i++) {
		result++;
	}
	return result;
}



	public int solutionCount(int[][]visited) {
		int height=getHeight(visited);
		int len=getLength(visited);

		int count=0;
		for(int i=0;i<height-1;i++) {
			for(int k=0;k<len-1;k++) {
				if(visited[i][k]>0) {

					count++;
				}
			}
		}
		return count;
	}
}