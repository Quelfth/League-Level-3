package moreAndMoreTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoreAndMoreTests {

	public String multiply(int a, int b) {
		return a + " x " + b + " = " + a * b;
	}

	public boolean isPrime(int a) {
		if (a == 1)
			return false;
		for (int i = 2; i <= a / 2; i++)
			if (a % i == 0)
				return false;
		return true;
	}

	public boolean isSquare(int a) {
		for (int i = 0; i * i <= a; i++)
			if (i * i == a)
				return true;
		return false;
	}

	public boolean isCube(int a) {
		for (int i = 0; i * i * i <= a; i++)
			if (i * i * i == a)
				return true;
		return false;
	}

	@Test
	public void MultTest() {

		assertEquals("10 x 0 = 0", multiply(10, 0));
		assertEquals("10 x 10 = 100", multiply(10, 10));
		assertEquals("8 x 11 = 88", multiply(8, 11));
	}

	@Test
	public void PrimeTest() {

		assertTrue(isPrime(3));
		assertTrue(isPrime(5));
		assertTrue(isPrime(541));
		assertFalse(isPrime(4));
		assertFalse(isPrime(12));
		assertFalse(isPrime(527));

	}

	@Test
	public void SquareTest() {

		assertTrue(isSquare(4));
		assertTrue(isSquare(144));
		assertTrue(isSquare(64));
		assertTrue(isSquare(10201));
		assertTrue(isSquare(1));
		assertFalse(isSquare(3));
		assertFalse(isSquare(22));
		assertFalse(isSquare(143));

	}

	@Test
	public void CubeTest() {

		assertTrue(isCube(27));
		assertTrue(isCube(216));
		assertTrue(isCube(729));
		assertTrue(isCube(1));
		assertFalse(isCube(3));
		assertFalse(isCube(22));
		assertFalse(isCube(143));

	}

}
