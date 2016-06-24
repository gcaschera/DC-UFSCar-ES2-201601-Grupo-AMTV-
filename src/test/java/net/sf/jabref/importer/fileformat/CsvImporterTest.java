package net.sf.jabref.importer.fileformat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.sf.jabref.Globals;
import net.sf.jabref.JabRefPreferences;
import net.sf.jabref.importer.OutputPrinterToNull;
import net.sf.jabref.model.entry.BibEntry;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvImporterTest {

    private CSVimporter importer;


    @BeforeClass
    public static void setUp() {
        Globals.prefs = JabRefPreferences.getInstance();
        //importer = new CSVimporter();
    }

    @Test
    public void testIsRecognizedFormat1() throws IOException {
        importer = new CSVimporter();
        try (InputStream stream = CSVimporter.class.getResourceAsStream("CSVCompleto.csv")){
            assertTrue(importer.isRecognizedFormat(stream));
            }
        }

    @Test
    public void testIsRecognizedFormat2() throws IOException {
        importer = new CSVimporter();
        try (InputStream stream = CSVimporter.class.getResourceAsStream("CSVIncompleto.csv")){
            assertTrue(importer.isRecognizedFormat(stream));
            }
        }

    @Test
    //TESTE: importar arquivo com todos os campos obrigatórios preenchidos
    public void testImportCSVCopleto() throws IOException {
        importer = new CSVimporter();
        try (InputStream is = CSVimporter.class.getResourceAsStream("CSVCompleto.csv")) {
            List<BibEntry> entries = importer.importEntries(is, new OutputPrinterToNull());

            BibEntry testEntry = entries.get(0);
            Assert.assertEquals("2011", testEntry.getField("year"));
            Assert.assertEquals("Pressman R S", testEntry.getField("author"));
            Assert.assertEquals("Engenharia de Software: Uma Abordagem Profissional", testEntry.getField("title"));

            testEntry = entries.get(1);
            Assert.assertEquals("2007", testEntry.getField("year"));
            Assert.assertEquals("Sommerville I", testEntry.getField("author"));
            Assert.assertEquals("Engenharia de Software", testEntry.getField("title"));

            testEntry = entries.get(2);
            Assert.assertEquals("2004", testEntry.getField("year"));
            Assert.assertEquals("Pfleeger S L", testEntry.getField("author"));
            Assert.assertEquals("Engenharia de software: teoria e pratica", testEntry.getField("title"));

            testEntry = entries.get(3);
            Assert.assertEquals("2007", testEntry.getField("year"));
            Assert.assertEquals("J K Rowling", testEntry.getField("author"));
            Assert.assertEquals("Harry Potter and the Deathly Hallows", testEntry.getField("title"));

        }

    }

    @Test
    //TESTE: importar arquivo com apenas ALGUNS dos campos obrigatórios preenchidos
    public void testImportCSVIncompleto() throws IOException {
        importer = new CSVimporter();
        try (InputStream is = CSVimporter.class.getResourceAsStream("CSVIncompleto.csv")) {
            List<BibEntry> entries = importer.importEntries(is, new OutputPrinterToNull());

            BibEntry testEntry = entries.get(0);
            Assert.assertEquals("1993", testEntry.getField("year"));
            Assert.assertEquals("Tomas Borba", testEntry.getField("author"));
            Assert.assertEquals(" ", testEntry.getField("title"));

            /*testEntry = entries.get(1);
            Assert.assertEquals(" ", testEntry.getField("year"));
            Assert.assertEquals("Jose Saramago", testEntry.getField("author"));
            Assert.assertEquals("Ensaio Sobre a Cegueira", testEntry.getField("title"));*/

            testEntry = entries.get(1);
            Assert.assertEquals("2015", testEntry.getField("year"));
            Assert.assertEquals(" ", testEntry.getField("author"));
            Assert.assertEquals("Um Livro Mais ou Menos", testEntry.getField("title"));
        }
    }

}