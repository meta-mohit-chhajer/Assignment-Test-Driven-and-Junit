package com.metacube.Testing;
import static org.junit.Assert.*; 

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTest {
	ArrayOperation aop=new ArrayOperation();
	public int[] array;
	public int x;
	public int y;
	public int[] result;
	
	public FixXYTest(int[] array, int x, int y, int[] result) {
		this.array = array;
		this.x = x;
		this.y = y;
		this.result = result;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{new int[]{5, 4, 9, 4, 9, 5}, 4, 5, new int[]{9, 4, 5, 4, 5, 9}},		// first test input
			{new int[]{1, 4, 1, 5}, 4, 5, new int[]{1, 4, 5, 1}},					// second test input
			{new int[]{1, 4, 1, 5, 5, 4, 1}, 4, 5, new int[]{1, 4, 5, 1, 1, 4, 5}}  // third test input
		});
	}
	
	/*
	 * Testing with above inputs
	 */
	@Test
	public void multipleParametersTest() {
		assertArrayEquals(this.result, aop.fixXY(this.array, this.x, this.y));
	}

	/*
	 * Test case for un-equal number of X and Y
	 */
	@Test(expected = AssertionError.class)
	public void unequalNumOFXY() {
		aop.fixXY(new int[]{4, 4, 4, 5, 5, 5, 5, 5}, this.x, this.y);
	}
	
	/*
	 * Test case for empty array
	 */
	@Test(expected = AssertionError.class)
	public void testEmptyArray() {
		aop.fixXY(new int[]{}, this.x, this.y);
	}
	
	/*
	 * Test case for X at last position
	 */
	@Test(expected = AssertionError.class)
	public void xAtLastPosition() {
		aop.fixXY(new int[]{1, 4, 1, 5, 5, 4, 4}, 4, 5);
	}
}
