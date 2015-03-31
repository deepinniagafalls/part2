package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.util.ReaderTool;

public class ReaderToolTest {

	@Test
	public void test() {
		
		ReaderTool r = new ReaderTool();
		assertTrue("Bahama",r.getWords().contains("Bahama"));
	}
	@Test
	public void test2() {
		ReaderTool r = new ReaderTool();
		assertTrue("lavigne",r.getWords().contains("lavigne"));
	}
	@Test
	public void test3() {
		ReaderTool r = new ReaderTool();
		assertTrue("skillet",r.getWords().contains("skillet"));
	}
	@Test
	public void test4() {
		ReaderTool r = new ReaderTool();
		assertTrue("skillet",r.getWords().contains("skillet"));
	}
	@Test
	public void test5() {
		ReaderTool r = new ReaderTool();
		assertTrue("zygotes",r.getWords().contains("zygotes"));
	}

}
