import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import tp3.Arret;
import tp3.ArretComparators;
import tp3.Bus;
import tp3.BusFactory;
import tp3.Metro;
import tp3.MetroFactory;
import tp3.ParseException;
import tp3.Parser;
import tp3.Tram;
import tp3.TramFactory;

public class Tp3Test extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testParseOne() throws ParseException {
		{
			Parser<Arret> parser = new Parser<>();
			parser.addFactory(new MetroFactory());
			Arret expected = new Metro(123, 8.5, 3.2, "nom", "arrondissement");
			Arret actual = parser.parseOne("123#8.5#3.2#nom#arrondissement#metro");
			assertEquals(expected, actual);
		}
		{
			Parser<Arret> parser = new Parser<>();
			parser.addFactory(new BusFactory());
			Arret expected = new Bus(123, 8.5, 3.2, "nom", "arrondissement");
			Arret actual = parser.parseOne("123#8.5#3.2#nom#arrondissement#bus");
			assertEquals(expected, actual);
		}
		{
			Parser<Arret> parser = new Parser<>();
			parser.addFactory(new TramFactory());
			Arret expected = new Tram(123, 8.5, 3.2, "nom", "arrondissement");
			Arret actual = parser.parseOne("123#8.5#3.2#nom#arrondissement#tram");
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testParseMultiple() throws ParseException {
		Parser<Arret> parser = new Parser<>();
		parser.addFactory(new MetroFactory());
		parser.addFactory(new BusFactory());
		parser.addFactory(new TramFactory());

		List<Arret> expected = new ArrayList<>();
		expected.add(new Metro(123, 1.1, 1.2, "nom1", "arrondissement1"));
		expected.add(new Bus(456, 2.1, 2.2, "nom2", "arrondissement2"));
		expected.add(new Tram(789, 3.1, 3.2, "nom3", "arrondissement3"));

		InputStream stream = new ByteArrayInputStream("123#1.1#1.2#nom1#arrondissement1#metro\n456#2.1#2.2#nom2#arrondissement2#bus\n789#3.1#3.2#nom3#arrondissement3#tram".getBytes(StandardCharsets.UTF_8));
		List<Arret> actual = parser.parse(stream);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testAddFactory() throws ParseException {

	}

    @Test
    public void testIdSorting() {
        Arret arr1 = new Metro(1, 8.5, 3.2, "nom2", "arrondissement3");
        Arret arr2 = new Tram(2, 8.5, 3.2, "nom1", "arrondissement2");
        Arret arr3 = new Bus(3, 8.5, 3.2, "nom3", "arrondissement2");

        List<Arret> expected = new ArrayList<>();
        expected.add(arr1);
        expected.add(arr2);
        expected.add(arr3);

        List<Arret> actual = new ArrayList<>();
        actual.add(arr2);
        actual.add(arr1);
        actual.add(arr3);

        Collections.sort(actual, ArretComparators.parId);

        assertEquals(expected, actual);
    }

    @Test
    public void testArrNameSorting() {
        Arret arr1 = new Metro(1, 8.5, 3.2, "nom2", "arrondissement3");
        Arret arr2 = new Tram(2, 8.5, 3.2, "nom1", "arrondissement2");
        Arret arr3 = new Bus(3, 8.5, 3.2, "nom3", "arrondissement2");

        List<Arret> expected = new ArrayList<>();
        expected.add(arr2);
        expected.add(arr3);
        expected.add(arr1);

        List<Arret> actual = new ArrayList<>();
        actual.add(arr1);
        actual.add(arr2);
        actual.add(arr3);

        Collections.sort(actual, ArretComparators.parArrondissmentEtNom);

        assertEquals(expected, actual);

    }

    public void testException() {
        Parser<Arret> parser = new Parser<>();
        parser.addFactory(new BusFactory());

        try {
            parser.addFactory(new BusFactory());
            Arret arret = parser.parseOne("123#8.5#3.2#nom#arrondissement#metro");
            fail("Object should not have been constructed : " + arret);
        } catch (ParseException p) {
        }
    }
}
