package net.sf.jabref.model.entry;

import java.io.IOException;
import java.io.StringWriter;
import java.util.GregorianCalendar;
import java.util.Calendar;
import net.sf.jabref.Globals;
import net.sf.jabref.JabRefPreferences;
import net.sf.jabref.bibtex.BibEntryWriter;
import net.sf.jabref.exporter.LatexFieldFormatter;
import net.sf.jabref.model.database.BibDatabaseMode;
import net.sf.jabref.model.entry.BibEntry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManutencaoYearTestes {

    private BibEntryWriter writer;
    private static JabRefPreferences backup;


    @BeforeClass
    public static void setUp() {
        Globals.prefs = JabRefPreferences.getInstance();
        backup = Globals.prefs;
    }

    @AfterClass
    public static void tearDown() {
        Globals.prefs.overwritePreferences(backup);
    }

    @Before
    public void setUpWriter() {
        writer = new BibEntryWriter(new LatexFieldFormatter(), true);
    }

    //TESTE 1: Inserir ano igual ao ano mínimo.
    @Test
    public void testeYear01() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BibEntry input = new BibEntry("Livro X", "book");

        input.setField("title", "Livro X");
        input.setField("publisher", "UFSCar - Universidade Federal de São Carlos");
        input.setField("year", "1900");
        input.setField("author", "Dumblodore");
        input.setField("editor", "Snape");
        input.setCiteKey("X1");

        writer.write(input, stringWriter, BibDatabaseMode.BIBTEX);
        String string1 = stringWriter.toString();

        String string2 = Globals.NEWLINE + "@Book{x1," + Globals.NEWLINE + "  title     = {Livro X}," + Globals.NEWLINE
                + "  publisher = {UFSCar - Universidade Federal de São Carlos}," + Globals.NEWLINE
                + "  year      = {1900}," + Globals.NEWLINE
                + "  author    = {Dumblodore}," + Globals.NEWLINE + "  editor    = {Snape}," + Globals.NEWLINE + "}"
                + Globals.NEWLINE;

        Assert.assertEquals(string2, string1);


    }

    //TESTE 2: Inserir ano abaixo do ano mínimo.
    @Test
    public void testeYear02() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BibEntry input = new BibEntry("Livro X", "book");

        input.setField("title", "Livro X");
        input.setField("publisher", "UFSCar - Universidade Federal de São Carlos");
        input.setField("year", "1801");
        input.setField("author", "Dumblodore");
        input.setField("editor", "Snape");
        input.setCiteKey("X1");

        writer.write(input, stringWriter, BibDatabaseMode.BIBTEX);
        String string1 = stringWriter.toString();

        String string2 = Globals.NEWLINE + "@Book{x1," + Globals.NEWLINE + "  title     = {Livro X}," + Globals.NEWLINE
                + "  publisher = {UFSCar - Universidade Federal de São Carlos}," + Globals.NEWLINE
                + "  author    = {Dumblodore}," + Globals.NEWLINE + "  editor    = {Snape}," + Globals.NEWLINE + "}"
                + Globals.NEWLINE;

        Assert.assertEquals(string2, string1);

        Assert.assertNull(input.getField("year"));

    }

    //TESTE 3: Inserir ano igual ao ano máximo (atual).
    @Test
    public void testeYear03() throws IOException {
        StringWriter stringWriter = new StringWriter();
        Calendar calendar = GregorianCalendar.getInstance();
        BibEntry input = new BibEntry("Livro X", "book");

        int anoAtual = calendar.get(GregorianCalendar.YEAR);

        String anoAtualString = Integer.toString(anoAtual);

        input.setField("title", "Livro X");
        input.setField("publisher", "UFSCar - Universidade Federal de São Carlos");
        input.setField("year", anoAtualString);
        input.setField("author", "Dumblodore");
        input.setField("editor", "Snape");
        input.setCiteKey("X1");

        writer.write(input, stringWriter, BibDatabaseMode.BIBTEX);
        String string1 = stringWriter.toString();

        String string2 = Globals.NEWLINE + "@Book{x1," + Globals.NEWLINE + "  title     = {Livro X}," + Globals.NEWLINE
                + "  publisher = {UFSCar - Universidade Federal de São Carlos}," + Globals.NEWLINE + "  year      = {"
                + anoAtualString + "}," + Globals.NEWLINE + "  author    = {Dumblodore}," + Globals.NEWLINE
                + "  editor    = {Snape}," + Globals.NEWLINE + "}" + Globals.NEWLINE;

        Assert.assertEquals(string2, string1);

    }

    //TESTE 4: Inserir maior que ano máximo (atual).
    @Test
    public void testeYear04() throws IOException {
        StringWriter stringWriter = new StringWriter();
        Calendar calendar = GregorianCalendar.getInstance();
        BibEntry input = new BibEntry("Livro X", "book");

        int anoSuperior = calendar.get(GregorianCalendar.YEAR) + 1;

        String anoSuperiorString = Integer.toString(anoSuperior);

        input.setField("title", "Livro X");
        input.setField("publisher", "UFSCar - Universidade Federal de São Carlos");
        input.setField("year", anoSuperiorString);
        input.setField("author", "Dumblodore");
        input.setField("editor", "Snape");
        input.setCiteKey("X1");

        writer.write(input, stringWriter, BibDatabaseMode.BIBTEX);
        String string1 = stringWriter.toString();

        String string2 = Globals.NEWLINE + "@Book{x1," + Globals.NEWLINE + "  title     = {Livro X}," + Globals.NEWLINE
                + "  publisher = {UFSCar - Universidade Federal de São Carlos}," + Globals.NEWLINE
                + "  author    = {Dumblodore}," + Globals.NEWLINE + "  editor    = {Snape}," + Globals.NEWLINE + "}"
                + Globals.NEWLINE;

        Assert.assertEquals(string2, string1);

        Assert.assertNull(input.getField("year"));

    }

    //TESTE 5: Inserir ano dentro do domínio da entrada
    @Test
    public void testeYear05() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BibEntry input = new BibEntry("Livro X", "book");

        input.setField("title", "Livro X");
        input.setField("publisher", "UFSCar - Universidade Federal de São Carlos");
        input.setField("year", "2010");
        input.setField("author", "Dumblodore");
        input.setField("editor", "Snape");
        input.setCiteKey("X1");

        writer.write(input, stringWriter, BibDatabaseMode.BIBTEX);
        String string1 = stringWriter.toString();

        String string2 = Globals.NEWLINE + "@Book{x1," + Globals.NEWLINE + "  title     = {Livro X}," + Globals.NEWLINE
                + "  publisher = {UFSCar - Universidade Federal de São Carlos}," + Globals.NEWLINE
                + "  year      = {2010}," + Globals.NEWLINE + "  author    = {Dumblodore}," + Globals.NEWLINE
                + "  editor    = {Snape}," + Globals.NEWLINE + "}" + Globals.NEWLINE;

        Assert.assertEquals(string2, string1);

    }

}