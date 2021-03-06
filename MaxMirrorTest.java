package com.metacube.Testing;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
	ArrayOperation aop=new ArrayOperation();
	public int[] array;
	public int len;
	public MaxMirrorTest(int[] array,int len) {
		this.array = array;
		this.len=len;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testValues() {
		return Arrays.asList(new Object[][]{
			{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3},		// first test case
			{new int[]{7, 1, 4, 9, 7, 4, 1}, 2},		// second test case
			{new int[]{1, 2, 1, 4}, 3},					// third test case
			{new int[]{1, 4, 5, 3, 5, 4, 1}, 7},		// fourth test case
			{new int[]{1, 2, 3}, 1},					// fifth test case
		});
	}
	
	/*
	 * Testing with above different inputs
	 */
	@Test
	public void multipleParametersTest() {
		aop.MaxMirror(this.array);
	}
	
	/*
	 * Testing with an empty array
	 */
	@Test(expected = AssertionError.class)
	public void testWithEmptyArray() {
		assertEquals(0,aop.MaxMirror(new int[]{}));
	}
}
