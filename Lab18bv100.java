/* Lab18bvst.java
 * apcs 2020-'21
 * June 8, 2021 */

import java.lang.*;
import java.io.*;

import java.util.*;
  
public class Lab18bv100
{
	public static void main(String[] args)
	{
		int[] jsaList1 = {101, 105, 115, 125, 145, 165, 175, 185, 195, 225, 235, 275, 305, 315, 325, 335, 345, 355, 375, 385};
		int[] jsaList2 = {110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 270, 280, 320, 350, 400};
		int len1 = jsaList1.length;
		int len2 = jsaList2.length;
		int[] array_3 = new int[len1+len2];		

		Array list1 = new Array(jsaList1,"List #1");
		Array list2 = new Array(jsaList2,"List #2");
		Array list3 = new Array("Merged List");


		list1.display();
		list2.display();
		
		list3.merge(jsaList1,jsaList2,len1,len2,array_3);

	}

}


class Array
{
	private ArrayList<Integer> list;
	private int size;
	private String listName;

	public Array(String ln)
	{
		list = new ArrayList<Integer>();
		size = 0;
		listName = ln;
	}

	public Array(int[] jsArray, String ln)
	{
		list = new ArrayList<Integer>();
		size = jsArray.length;
		listName = ln;
		for (int j = 0; j < size; j++)
			list.add( new Integer( jsArray[j] ));
	}

	public void display()
	{
		System.out.println("\n" + listName + ":\n");
		System.out.println(list + "\n");
	}
	/* Merges jsaList1 and jsaList2 into List3. */
	public void merge(int[] array1, int[] array2, int len1, int len2, int[] array3)
	{
	int i = 0, j = 0, k = 0;
	/* Traverses both Arrays*/     
        while (i < len1 && j < len2)
        {
            /* Check if current element of first
             * array is smaller than current element
             * of second array. If true: store first
             * array element and increment first array
             * index. Else: do same with second array */
            if (array1[i] < array2[j])
                array3[k++] = array1[i++];
            else
                array3[k++] = array2[j++];
        }
     
        /* Store remaining elements of first array */
        while (i < len1)
            array3[k++] = array1[i++];
     
        /* Store remaining elements of second array */
        while (j < len2)
            array3[k++] = array2[j++];
	/* Prints merged list */
	System.out.println("Merged List: ");
	System.out.println(Arrays.toString(array3));	

	}


}
