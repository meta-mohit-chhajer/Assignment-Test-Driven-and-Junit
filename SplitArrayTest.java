package com.metacube.Testing;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SplitArrayTest {
ArrayOperation aop=new ArrayOperation();
public int[] array;
public int index;

public SplitArrayTest(int[] array, int index) {
	this.array = array;
	this.index = index;
}

@Parameterized.Parameters
public static Collection<Object[]> testValues() {
	return Arrays.asList(new Object[][]{
		{new int[]{1, 1, 1, 2, 1}, 3},			// first test case
		{new int[]{2, 1, 1, 2, 1}, -1},			// second test case
		{new int[]{10, 10}, 1}					// third test case
	});
}

/*
 * Testing with above different test cases
 */
@Test
public void multipleParametersTest() {
	assertEquals(index, aop.splitArray(this.array));
}

/*
 * Testing with an empty array
 */
@Test(expected = AssertionError.class)
public void testEmptyArray() {
	aop.splitArray(new int[]{});
}
}
