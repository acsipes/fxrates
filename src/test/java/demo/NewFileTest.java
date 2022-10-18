package demo;

import org.junit.Test;

import java.io.File;
import java.net.URI;

public class NewFileTest {

    @Test
    public void testNewFile() {
        File file = new File("c:/dev/servers/wildfly-10.1.0.Final/standalone/configuration/log4j2/log4j2euer.xml");
        System.out.println("the file is: " + file.toString());
        URI uri = file.toURI();
        System.out.println("The uri is: " + uri.toString());
    }

    @Test
    public void testfileDelete() {
        File tmp = new File("EUER_Riport_20180301_20190611_000527.zip");
        File tmp2 = new File("EUER_Hatosagi_Riport_20180301_20190611_000527.csv");
        File tmp3 = new File("EUER_Kerdes_lista_20180301_20190611_000527.csv");
        File tmp4 = new File("EUER_Minosito_Riport_20180301_20190611_000527.csv");

        boolean isTmpDeleteD = tmp.delete();
        printDeleteResult(tmp, isTmpDeleteD);

        boolean isTmp2DeleteD = tmp2.delete();
        printDeleteResult(tmp2, isTmp2DeleteD);

        boolean isTmp3DeleteD = tmp3.delete();
        printDeleteResult(tmp3, isTmp3DeleteD);

        boolean isTmp4DeleteD = tmp4.delete();
        printDeleteResult(tmp4, isTmp4DeleteD);
    }

    private void printDeleteResult(File file, boolean result ){
        System.out.println("Deleting " + file.toString() + " : " + result);
    }
}
