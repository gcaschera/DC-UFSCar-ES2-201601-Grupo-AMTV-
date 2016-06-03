package net.sf.jabref.importer;


import java.io.*;
import java.util.*;
import net.sf.jabref.importer.ImportFormats;
import net.sf.jabref.model.entry.BibEntry;
import net.sf.jabref.importer.ImportFormatReader;

public class CSVimporter extends ImportFormats {

    public String getFormatName() {
        return "CSV Importer";
    }

    public boolean isRecognizedFormat(InputStream stream) throws IOException {
        return true; // this is discouraged except for demonstration purposes
    }

    public List importEntries(InputStream stream) throws IOException {
        ArrayList bibitems = new ArrayList();
        BufferedReader in = new BufferedReader(ImportFormatReader.getReaderDefaultEncoding(stream));

        String line = in.readLine();
        while (line != null) {
            if (!"".equals(line.trim())) {
                String[] fields = line.split(";");
                BibEntry be = new BibEntry();
                be.setType(BibEntry.DEFAULT_TYPE);
                be.setField("year", fields[0]);
                be.setField("author", fields[1]);
                be.setField("title", fields[2]);
                bibitems.add(be);
                line = in.readLine();
            }
        }
        return bibitems;
    }
}