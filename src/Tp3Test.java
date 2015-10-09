
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import junit.framework.TestCase;
import org.junit.Test;
import sun.misc.IOUtils;
import tp3.Arret;
import tp3.BusFactory;
import tp3.Metro;
import tp3.MetroFactory;
import tp3.ParseException;
import tp3.Parser;
import tp3.TramFactory;

public class Tp3Test extends TestCase {

	private Parser<Arret> parser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		parser = new Parser<>();
		parser.addFactory(new BusFactory());
		parser.addFactory(new TramFactory());
		parser.addFactory(new MetroFactory());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		parser = null;
	}

	@Test
	public void testParseOne() throws ParseException {
		Arret expected = new Metro(123, 8.5, 3.2, "nom", "arrondissement");
		Arret actual = parser.parseOne("123#8.5#3.2#nom#arrondissement#metro");
		Arret expected2 = new Metro(123, 8.5, 3.2, "nom", "arrondissement");
		Arret actual2 = parser.parseOne("123#8.5#3.2#nom#arrondissement#bus");
		assertEquals(expected, actual);
		assertNotSame(expected2, actual2);
	}
	
	@Test
	public void testAddFactory() throws ParseException{

	}
}
