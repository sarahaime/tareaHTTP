package edu.pucmm.ce.main;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

//https://jsoup.org/cookbook/extracting-data/example-list-links
public class Main {

    public static void main( String[] args) throws IOException {
        getDocumentByURL();
        System.out.println("a - Cantidad de Lineas: " + countLines());
        System.out.println("b - Cantidad de Parrafos: " + countP());
        System.out.println("c - Cantidad de imágenes en parrafos: " + countImgInP());
        System.out.println("d - Cantidad de formularios: (POST) " + countFormByMetod("POST") + ", (GET) " + countFormByMetod("GET"));
        showFormInputs();
        sendPost();

    }

    private static Connection.Response CR;
    private static Document doc;
    private static String URL;


    private static void getDocumentByURL(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                URL = sc.nextLine();
                if(URL.indexOf("http") != 0)  URL = "http://" + URL;

                CR = Jsoup.connect(URL).execute();
                doc = Jsoup.connect(URL).get();
                return;
            }catch (Exception err){
                System.out.println("URL no válida, vuelva a intentar.. ");
            }
        }
    }


//    a) Indicar la cantidad de lineas del recurso retornado.
    private static int countLines(){
        String content = doc.html();
        String[] lines = content.split("\r\n|\n|\r");
        return  lines.length;
    }


//    b) Indicar la cantidad de párrafos (p) que contiene el documento HTML.
    private static int countP(){
        return doc.select("p").size();
    }


//    c) Indicar la cantidad de imágenes (img) dentro de los párrafos que
//    contiene el archivo HTML.
    private static int countImgInP(){
        Elements paragraphs = doc.select("p");
        int ans = 0;
        for(Element paragraph : paragraphs){
            ans += paragraph.select("img").size();
        }
        return ans;
    }

//    d) indicar la cantidad de formularios (form) que contiene el HTML por
//    categorizando por el método implementado POST o GET.

    private static int countFormByMetod(String metodo){
        Elements forms = doc.select("form");
        int ans = 0;
        for(Element form: forms){
            if(form.attr("method").equalsIgnoreCase(metodo)){
                ans++;
            }
        }

        return ans;
    }


//    e) Para cada formulario mostrar los campos del tipo input y su
//    respectivo tipo que contiene en el documento HTML.
    private static void showFormInputs(){
        System.out.println("e - Formularios: ");
        Elements forms = doc.select("form");
        int i = 1;
        for(Element form: forms){
            System.out.println("Formulario #"+  i + " (" + form.attr("method").toUpperCase() + ")");
            for(Element input: form.select("input") ){
                System.out.println("Nombre: " + input.attr("name") + "\t tipo: " + input.attr("type"));
            }
            i++;
            System.out.println();
        }
        return;
    }


//    f) Para cada formulario “parseado”, identificar que el método de envío
//    del formulario sea POST y enviar una petición al servidor con el
//    parámetro llamado asignatura y valor practica1 y un header llamado
//    matricula con el valor correspondiente a matrícula asignada. Debe
//    mostrar la respuesta por la salida estándar.

    private static void sendPost(){
        Elements forms = doc.select("form");
        int i = 1;
        for(Element form: forms){
            if(form.attr("method").equalsIgnoreCase("post")){
                System.out.println("Formulario Post #"+  i);
                String urlForm = form.absUrl("action");
                if(urlForm == "") urlForm =  URL;
                try {
                    Document doc = Jsoup.connect(urlForm).data("asignatura", "practica1").header("matricula","20132039").userAgent("Mozilla").post();
                    String salida = doc.html();
                    System.out.println(salida);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println();
                i++;
            }

        }
        return;

    }


}
/*
Para probar:
http://www.createafreewebsite.net/paragraph_images.html

https://www.xataka.com/empresas-y-economia/los-viejos-programadores-nunca-mueren-y-silicon-valley-se-esta-dando-cuenta-de-ello

https://www.samsung.com/us/support/register/
 */