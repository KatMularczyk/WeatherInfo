package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.HELVETICA_BOLD;
import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.TIMES_ROMAN;


public class Decision {
    private int i=1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    Scanner in = new Scanner(System.in);
    public Decision(){
    }

    public String start(){
        System.out.print("Enter the city");
        //get the input - city name
        String input = in.nextLine();
        return input;
    }

    public void question(){
        System.out.println("Do you want to continue? y/n");
        String userDecision = in.nextLine();
        while(!(userDecision.equalsIgnoreCase("n")|userDecision.equalsIgnoreCase("y"))){
            System.out.println("Do you want to continue? y/n");
            userDecision = in.nextLine();
        }
        if(userDecision.equalsIgnoreCase("n")){
            i=0;
        }

    }
    public void createJson(List<Weather> list){

        Gson gson = new Gson();
        String json = gson.toJson(list);
        try {
            FileWriter writer = new FileWriter("WeatherList.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileReturnQuestion(List<Weather> listToFile){
        System.out.println("Do you want to receive file with weather list? Use P/X/J to get PDF/XML/JSON");
        String fileDecision = in.nextLine();
        if(fileDecision.equalsIgnoreCase("J")){
            createJson(listToFile);
        }
        if(fileDecision.equalsIgnoreCase("X")){
            createXml(listToFile);
        }
        if(fileDecision.equalsIgnoreCase(("P"))){
            createPdf(listToFile);
        }
    }

    public static void createXml(List<Weather> objectList) {

        XmlMapper xmlMapper = new XmlMapper();

        try {
            String xml = xmlMapper.writeValueAsString(objectList);

            // Print the generated XML string (optional)
            System.out.println("Generated XML:\n" + xml);
            FileWriter writer = new FileWriter("WeatherList.xml");
            writer.write(xml);
            writer.close();
            //return xml;
        } catch (JsonProcessingException e) {
           //return null;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

public static void createPdf(List<Weather> toSerialize) {
    try
            (PDDocument document = new PDDocument()) {
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(new PDType1Font(HELVETICA_BOLD), 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 700);
        for(Weather toWrite : toSerialize){
           // contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            contentStream.showText("City: " + toWrite.getCity());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Temperature: " + toWrite.getTemp() + " °C");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Humidity: " + toWrite.getHumidity() + "%");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Pressure: " + toWrite.getPressure() + "hPa");
            contentStream.newLineAtOffset(0, -50);
            //contentStream.endText();

        }
        contentStream.endText();
        contentStream.close();
        document.save("weather.pdf");
        document.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}

}
