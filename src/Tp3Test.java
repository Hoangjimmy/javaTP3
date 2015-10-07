
import junit.framework.TestCase;
import org.junit.Test;
import tp3.Metro;
import tp3.ParseException;
import tp3.Parser;


public class Tp3Test extends TestCase{
	
	protected  void setUp() throws Exception{
		super.setUp();
		Parser parse = new Parser();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
		Parser parse = null;
	}
	
	public void testFalse (){
	
	assertFalse(false);
	}
	
	@Test
	public void testParseOne() throws ParseException{
		Parser parse = new Parser();
		Metro met, met2;
		met = new Metro(123,8.5,3.2,"Chatelet","14eme Paris");
		met2 = (Metro) parse.parseOne("123#8.5#3.2#Chatelet#14eme Paris#Metro");
		
		assertEquals(met, met2);
	
	}
	
	
}
