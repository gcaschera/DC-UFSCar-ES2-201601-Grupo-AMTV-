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

public class ManutencaoBibtexkeyTestes {

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
    //Bibtexkey com tamanho menor que 2 caracteres
    //Caracter sendo uma letra
    @Test
    public void bibtexkeyTeste1() throws IOException {

        StringWriter stringWriter = new StringWriter();
        BibEntry entry = new BibEntry();
        entry.setCiteKey("a");
        writer.write(entry, stringWriter, BibDatabaseMode.BIBTEX);
        
        Assert.assertNotEquals("a", entry.getCiteKey());
        System.out.println("Teste 1");
        System.out.println("Entrada: a");
        System.out.println("Saída:" + entry.getCiteKey());
        System.out.println("");
    }

    //TESTE 2:
    //Bibtexkey com tamanho menor que 2 caracteres
    //Caracter sendo um numero
    @Test
    public void bibtexkeyTeste2() throws IOException {

        StringWriter stringWriter = new StringWriter();
        BibEntry entry = new BibEntry();
        entry.setCiteKey("1");
        writer.write(entry, stringWriter, BibDatabaseMode.BIBTEX);

        Assert.assertNotEquals("1", entry.getCiteKey());
        System.out.println("Teste 2");
        System.out.println("Entrada: 1");
        System.out.println("Saída:" + entry.getCiteKey());
        System.out.println("");
    }

    //TESTE 3:
    //Bibtexkey com tamanho maior que 2 caracteres
    //Primeiro caracter sendo um numero
    @Test
    public void bibtexkeyTeste3() throws IOException {

        StringWriter stringWriter = new StringWriter();
        BibEntry entry = new BibEntry();
        entry.setCiteKey("1teste");
        writer.write(entry, stringWriter, BibDatabaseMode.BIBTEX);
        Assert.assertEquals("1teste", entry.getCiteKey());

        System.out.println("Teste 3");
        System.out.println("Entrada: 1teste");
        System.out.println("Saída:" + entry.getCiteKey());
        System.out.println("");
    }

    //TESTE 4:
    //Bibtexkey com tamanho maior que 2 caracteres
    //Primeiro caracter sendo uma letra minuscula
    @Test
    public void bibtexkeyTeste4() throws IOException {
        StringWriter stringWriter = new StringWriter();

        BibEntry entry = new BibEntry();

        entry.setCiteKey("teste");

        writer.write(entry, stringWriter, BibDatabaseMode.BIBTEX);

        Assert.assertEquals("teste", entry.getCiteKey());

        System.out.println("Teste 4");
        System.out.println("Entrada: teste");
        System.out.println("Saída:" + entry.getCiteKey());
        System.out.println("");
    }

    //TESTE 5:
    //Bibtexkey com tamanho maior que 2 caracteres
    //Primeiro caracter sendo uma letra maiuscula
    @Test
    public void bibtexkeyTeste5() throws IOException {

        StringWriter stringWriter = new StringWriter();
        BibEntry entry = new BibEntry();
        entry.setCiteKey("Abcd");
        writer.write(entry, stringWriter, BibDatabaseMode.BIBTEX);
        Assert.assertNotEquals("Abcd", entry.getCiteKey());

        System.out.println("Teste 5");
        System.out.println("Entrada: Abcd");
        System.out.println("Saída:" + entry.getCiteKey());
        System.out.println("");
    }

    //TESTE 6:
    //Bibtexkey com tamanho nulo
    @Test
    public void bibtexkeyTeste6() throws IOException {

        StringWriter stringWriter = new StringWriter();
        BibEntry entry = new BibEntry();
        writer.write(entry, stringWriter, BibDatabaseMode.BIBTEX);
        Assert.assertNull(entry.getCiteKey());

        System.out.println("Teste 6");
        System.out.println("Entrada: ");
        System.out.println("Saída: " + entry.getCiteKey());
        System.out.println("");
    }
}
