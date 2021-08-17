/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzeplantationfailures;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Wesley
 */
public class AnalyzePlantationFailures {

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        // TODO code application logic here
   // }
    
     public static File escolherArquivo() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showSaveDialog(null);
        if (i == 1) {

        } else {
            File arquivo = file.getSelectedFile();
            return arquivo;
        }
        return null;
    }
    
     public static float areaPixel(ImagePlus image, ImageProcessor ip,int pixel, ImageProcessor ipSaida){
     //captura os pixels da imagem e transfere para uma matriz
     float area=0;
        for (int linha = 0; linha < image.getWidth(); linha++) {
            for (int coluna = 0; coluna < image.getHeight(); coluna++) {
                
                
                if(ip.getPixel(linha, coluna)==pixel){
                    area++;
                    
                    if(ip.getPixel(linha, coluna)==0){
                    
                       int[] rgb = new int[3];
                       ip.getPixel(linha,coluna,rgb);
                        int R=rgb[0];
                        int G=rgb[1];
                        int B=rgb[2];
                        rgb[0]=255;
                        ipSaida.putPixel(linha,coluna, rgb);
                        
                    }
                    
                }}
            }
     return area;
     }
    
}
