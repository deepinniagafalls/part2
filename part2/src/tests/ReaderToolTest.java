package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.util.ReaderTool;

public class ReaderToolTest {

	@Test
	public void test() {
		
		ReaderTool r = new ReaderTool();
		assertTrue("RAMSHACKLE",r.getWords().contains("RAMSHACKLE"));
	}
	@Test
	public void test2() {
		ReaderTool r = new ReaderTool();
		assertTrue("ALOFT",r.getWords().contains("ALOFT"));
	}
	@Test
	public void test3() {
		ReaderTool r = new ReaderTool();
		assertTrue("SKILLET",r.getWords().contains("SKILLET"));
	}
	@Test
	public void test4() {
		ReaderTool r = new ReaderTool();
		assertTrue("WAN",r.getWords().contains("WAN"));
	}
	@Test
	public void test5() {
		ReaderTool r = new ReaderTool();
		assertTrue("THOLE",r.getWords().contains("THOLE"));
	}

}
