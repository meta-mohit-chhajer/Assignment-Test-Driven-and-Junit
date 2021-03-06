package com.metacube.Testing;


public class ArrayOperation {
	/*
	 * Find the Maximum Mirrors Element in an Array
	 * @param arr Array Input
	 * @return 
	 */
	public int MaxMirror(int[] arr)
	{
		if(arr.length==0)
			throw new AssertionError("Array is Empty");
		int i,j,temp,max,count;
		i=j=temp=max=count=0;
		while(i<arr.length-1){
			count=0;
			temp=i;
			j=arr.length-1;
			while(j>=temp){
				if(arr[temp]==arr[j]){
					count++;
					if(temp==j)count++;
					temp++;
				}
				else if(count>0)break;
				if(max<count) 
					max=count;
				j--;
				
			}
			i++;
		}
		return max;
	}
	
	/*
	 * To count adjacent values are same
	 * @param arr Array Input
	 * @return count number of clumps
	 */
	
	public int countClumps(int[] arr)
	{
		if(arr.length==0)
			throw new AssertionError("Array is Empty");
		int clumps=0;
		for(int i=0;i<arr.length-1;i++){
			int flag=0;
			while(i<arr.length-1 && arr[i]==arr[i+1]){
				flag=1;
				i++;
			}
			if(flag==1)
				clumps++;
		}
		return clumps;
	}
	
	/*
	 * Split Array in such a way left side sum is equal to right side sum
	 * @param arr:Array Input
	 * @return index of Where array is splitted
	 */
	
	public int splitArray(int[] arr)
	{
		if(arr.length==0)
			throw new AssertionError("Arrau is Empty");
		int leftsum=0;
		for(int i=0;i<arr.length;i++)
		{
			leftsum+=arr[i];
			int rightsum=0;
			for(int j=i+1;j<arr.length;j++)
			{
				rightsum+=arr[j];
			}
			if(leftsum==rightsum)
				return i+1;
		}
		return -1;
	}
	
	
	/*
	 * FixXY means replace position of Y just after X in an array
	 * @param arr Array Input
	 * @param X variable X
	 * @param Y Variable Y
	 * @return Repositioned Array 
	 */
	public int[] fixXY(int[] array,int x,int y)
	{
		int countX = 0;
		int countY = 0;
		int indexOfY = -1;
		boolean isXAfterX = false;
		
		if (array.length < 1) {
			throw new AssertionError("Array is empty");
		}
		
		if (array[array.length - 1] == x) {
			throw new AssertionError("X can not be at last index");
		}
		
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (array[arrayIndex] == x)
				countX++;
			if (array[arrayIndex] == y)
				countY++;
			if (arrayIndex < array.length - 1) {
				if (array[arrayIndex] == x && array[arrayIndex + 1] == x)
					isXAfterX = true;
			}
		}
	
		if (countX != countY) {
			throw new AssertionError("X and Y are unequal");
		}
		
		if (isXAfterX) {
			throw new AssertionError("X can not be at adjacent places");
		}
		
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (array[arrayIndex] == x && array[arrayIndex] != y) {
				indexOfY = getYIndex(array, x, y);
				int tempVar = array[indexOfY];
				array[indexOfY] = array[arrayIndex + 1];
				array[arrayIndex + 1] = tempVar;
			}
		}
		return array;
		
	}
	
	/*
	 * get the index of Y in array
	 * @param array
	 * @param x
	 * @param y
	 * @return index of Y if present else 0
	 */
	public int getYIndex (int array[], int x, int y) {
		if (array[0] == y) {
			return 0;
		}
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (array[arrayIndex] == y && array[arrayIndex - 1] != x) {
				return arrayIndex;
			}
		}
		return 0;
	}
	

	  
	  
	
	
	public static void main(String...arg)
	{
		int [] arr1=new int[]{7, 1, 4, 9, 7, 4, 1};
		int [] arr2=new int[]{1, 1, 2, 1, 1};
		int [] arr3=new int[]{10, 10};
		int [] arr4=new int[]{5, 4, 9, 4, 9, 5};
		ArrayOperation aop1=new ArrayOperation();
		System.out.println(aop1.MaxMirror(arr1));
		System.out.println(aop1.countClumps(arr2));
		System.out.println(aop1.splitArray(arr3));
		int[] arr6=aop1.fixXY(arr4, 4, 5);
		for(int ele : arr6)
		{
			System.out.print(ele+" ");
		}
	
		
	}
}
