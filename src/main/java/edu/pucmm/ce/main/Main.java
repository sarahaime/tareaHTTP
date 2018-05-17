package edu.pucmm.ce.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

//https://jsoup.org/cookbook/extracting-data/example-list-links
public class Main {

    public static void main( String[] args) throws IOException {
        Document doc = getDocumentByURL();
        Elements media = doc.select("[src]");

        System.out.println("Cantidad de imágenes: " + countImgInP(doc));

    }


    private static Document getDocumentByURL(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                String URL = sc.nextLine();
                if(URL.indexOf("http://") != 0){
                    URL = "http://" + URL;
                }
                Document doc = Jsoup.connect(URL).get();

                return doc;

            }catch (Exception err){
                System.out.println("URL no válida, vuelva a intentar.. ");
            }
        }
    }


//    a) Indicar la cantidad de lineas del recurso retornado.

    private static int countLines(Document doc){
        String content = doc.outerHtml();
       // String[] lines = content.split("\r\n|\r|\n"); hay que probar
        String[] lines = content.split(System.getProperty("line.separator"));
        return  lines.length;
    }




//    b) Indicar la cantidad de párrafos (p) que contiene el documento HTML.
    private static int countP(Document doc){
        return doc.select("p").size();
    }


//    c) Indicar la cantidad de imágenes (img) dentro de los párrafos que
//    contiene el archivo HTML.
    private static int countImgInP(Document doc){
        Elements paragraphs = doc.select("p");
        int ans = 0;
        for(Element paragraph : paragraphs){
            ans += paragraph.select("img").size();
        }
        return ans;
    }

//    d) indicar la cantidad de formularios (form) que contiene el HTML por
//    categorizando por el método implementado POST o GET.

//    e) Para cada formulario mostrar los campos del tipo input y su
//    respectivo tipo que contiene en el documento HTML.

//    f) Para cada formulario “parseado”, identificar que el método de envío
//    del formulario sea POST y enviar una petición al servidor con el
//    parámetro llamado asignatura y valor practica1 y un header llamado
//    matricula con el valor correspondiente a matrícula asignada. Debe
//    mostrar la respuesta por la salida estándar.



}
/*
Para probar:

http://www.createafreewebsite.net/paragraph_images.html

 */