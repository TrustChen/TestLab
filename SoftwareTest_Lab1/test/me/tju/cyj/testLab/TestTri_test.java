package me.tju.cyj.testLab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTri_test {

	@Before
	public void init(){
		//TODO
	}

	@Test
	public void test2() {
		assertEquals(2,TestTri.checkTri(2, 2, 3));
	}
	
	@Test
	public void test1() {
		assertEquals(1,TestTri.checkTri(3, 4, 5));
	}
	
	@Test
	public void test0() {
		assertEquals(0,TestTri.checkTri(3, 3, 3));
	}
		
}
