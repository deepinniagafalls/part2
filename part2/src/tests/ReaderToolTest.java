package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.util.ReaderTool_047;

public class ReaderToolTest {

	@Test
	public void test() {
		
		ReaderTool_047 r = new ReaderTool_047("res/words.txt");
		assertTrue("RAMSHACKLE",r.getWords().contains("RAMSHACKLE"));
	}
	@Test
	public void test2() {
		ReaderTool_047 r = new ReaderTool_047("res/words.txt");
		assertTrue("ALOFT",r.getWords().contains("ALOFT"));
	}
	@Test
	public void test3() {
		ReaderTool_047 r = new ReaderTool_047("res/words.txt");
		assertTrue("SKILLET",r.getWords().contains("SKILLET"));
	}
	@Test
	public void test4() {
		ReaderTool_047 r = new ReaderTool_047("res/words.txt");
		assertTrue("WAN",r.getWords().contains("WAN"));
	}
	@Test
	public void test5() {
		ReaderTool_047 r = new ReaderTool_047("res/words.txt");
		assertTrue("THOLE",r.getWords().contains("THOLE"));
	}

}
