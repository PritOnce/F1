import javax.swing.*;
import java.io.*;
import java.nio.BufferOverflowException;

public class Main {
    public static void main(String[] args) throws IOException {
        String r1 = JOptionPane.showInputDialog("INTRODUCE LA PRIMERA RUTA");
        String r2 = JOptionPane.showInputDialog("INTRODUCE LA SEGUNDA RUTA");
        String r3 = JOptionPane.showInputDialog("INTRODUCE LA RUTA FINAL");

        unirFicheros(r1, r2, r3);
    }

    public static void unirFicheros(String r1, String r2, String r3){
        File unionArchivos = new File(r3);
        String texto;
        try{
        BufferedReader br1 = new BufferedReader(new FileReader(r1));
        BufferedReader br2 = new BufferedReader(new FileReader(r2));
        BufferedWriter bw = new BufferedWriter(new FileWriter(unionArchivos,true));

        texto = br1.readLine();
        while(texto!=null){
            bw.write(texto);
            texto = br1.readLine();
        }
        br1.close();

        texto = br2.readLine();
        while(texto!=null){
            bw.write(texto);
            texto = br2.readLine();
        }
        br2.close();

        bw.flush();
        bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}