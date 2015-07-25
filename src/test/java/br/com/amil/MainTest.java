package br.com.amil;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	
	private Main m;
	
	public MainTest() {
		m = new Main();
	}
	
	@Test
	public void testReadLog(){
		Set<String> mock = new HashSet<String>();
		Set<String> retorno = m.readLog();
		Assert.assertNotSame(mock, retorno);
	}

}
