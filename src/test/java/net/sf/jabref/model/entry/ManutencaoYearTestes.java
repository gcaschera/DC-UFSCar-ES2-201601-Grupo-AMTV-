package net.sf.jabref.model.entry;

import java.io.IOException;
import java.io.StringWriter;
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

    //TESTE 1:
    @Test
    public void testeYear01() throws IOException {
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

}