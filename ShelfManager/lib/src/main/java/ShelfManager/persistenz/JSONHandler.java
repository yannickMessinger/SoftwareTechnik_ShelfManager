package ShelfManager.persistenz;

import ShelfManager.Lager.*;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHandler {

    public static void safeLager(Lager lager) {
        JSONObject lagerObject = new JSONObject();
        lagerObject.put("hoehe", lager.getHoehe());
        lagerObject.put("breite", lager.getBreite());

        JSONArray regalArray = new JSONArray();

        for (Regal r : lager.getObservableRegalList()) {
            JSONObject regal = new JSONObject();
            regal.put("hoehe", r.getHoehe());
            regal.put("breite", r.getBreite());
            regal.put("tragkraft", r.getTragkraft());
            regal.put("xPos", r.getxPos());
            regal.put("yPos", r.getyPos());

            //Stuetzen

            JSONArray stuetzenArray = new JSONArray();
            for (Stuetze s : r.getStuetzen()) {
                JSONObject stuetze = new JSONObject();
                stuetze.put("hoehe", s.getHoehe());
                stuetze.put("breite", s.getBreite());
                stuetze.put("xPos", s.getxPos());
                stuetze.put("yPos", s.getyPos());
                stuetzenArray.add(stuetze);
            }
            regal.put("stuetzen", stuetzenArray);


            //Regalfaecher
            JSONArray faecherArray = new JSONArray();
            for (Regalfach rf : r.getRegalfaecher()) {
                JSONObject regalfach = new JSONObject();
                regalfach.put("hoehe", rf.getHoehe());
                regalfach.put("xPos", rf.getxPos());
                regalfach.put("yPos", rf.getyPos());

                Einlegeboden eb = rf.getBoden();
                JSONObject einlegeboden = new JSONObject();
                einlegeboden.put("hoehe", eb.getHoehe());
                einlegeboden.put("breite", eb.getBreite());
                einlegeboden.put("tragkraft", eb.getTragkraft());
                einlegeboden.put("xPos", eb.getxPos());
                einlegeboden.put("yPos", eb.getyPos());

                regalfach.put("boden", einlegeboden);

                ArrayList<Paket> pakete = rf.getPakete();
                JSONArray paketeArray = new JSONArray();
                for (Paket p : pakete) {
                    JSONObject paket = new JSONObject();

                    paket.put("paketName", p.getPaketName());
                    paket.put("hoehe", p.getHoehe());
                    paket.put("breite", p.getBreite());
                    paket.put("gewicht", p.getGewicht());
                    paket.put("farbe", p.getFarbe());
                    paket.put("tragkraft", p.getTragkraft());
                    paket.put("xPos", p.getxPos());
                    paket.put("yPos", p.getyPos());
                    // TODO: unvertraeglichkeiten
                    paketeArray.add(paket);

                }

                regalfach.put("pakete", paketeArray);

                faecherArray.add(regalfach);
            }
            regal.put("faecher", faecherArray);

            regalArray.add(regal);
        }

        lagerObject.put("regale", regalArray);


        try {
            FileWriter file = new FileWriter("ShelfManager/lib/src/main/java/ShelfManager/persistenz/lagerdatei.json");
            file.write(lagerObject.toJSONString());
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Lager loadLager() {
        JSONParser parser = new JSONParser();
        Lager loadedLager = new Lager();

        try (FileReader reader = new FileReader("ShelfManager/lib/src/main/java/ShelfManager/persistenz/lagerdatei.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            Lager parsedLager = parseLager(jsonObject);
            if (parsedLager != null) {
                loadedLager = parseLager(jsonObject);
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return loadedLager;
    }

    private static Lager parseLager(JSONObject lager) {
        if (lager.size() > 0) {
            int hoehe = ((Number)lager.get("hoehe")).intValue();
            int breite = ((Number)lager.get("breite")).intValue();

            JSONArray regale = (JSONArray) lager.get("regale");
            ObservableList<Regal> observableRegalList = FXCollections.observableArrayList();

            for (Object r : regale) {
                Regal parsedRegal = parseRegal((JSONObject) r);
                if (parsedRegal != null) {
                    observableRegalList.add(parsedRegal);
                }
            }

            // TODO: paketlisten
            ObservableList<Paket> observablePaketList = FXCollections.observableArrayList();
            ObservableList<Paket> allPakets = FXCollections.observableArrayList();

            return new Lager(hoehe, breite, observableRegalList, observablePaketList, allPakets);
        }

        return null;

    }

    private static Regal parseRegal(JSONObject regal) {
        if (regal.size() > 0) {
            int hoehe = ((Number) regal.get("hoehe")).intValue();
            int breite = ((Number) regal.get("breite")).intValue();
            int tragkraft = ((Number) regal.get("tragkraft")).intValue();
            int xPos = ((Number) regal.get("xPos")).intValue();
            int yPos = ((Number) regal.get("yPos")).intValue();

            JSONArray stuetzenArray = (JSONArray) regal.get("stuetzen");
            Stuetze[] stuetzen = new Stuetze[stuetzenArray.size()];
            for (int i = 0; i < stuetzenArray.size(); i++) {
                JSONObject stuetze = new JSONObject();
                Stuetze s = parseStuetze(stuetze);
                if (s != null) {
                    stuetzen[i] = s;
                }

            }

            JSONArray faecherArray = (JSONArray) regal.get("faecher");
            ArrayList<Regalfach> regalfaecher = new ArrayList<>();
            for (Object rf : faecherArray) {
                Regalfach parsedRegalfach = parseRegalfach((JSONObject) rf);
                if (parsedRegalfach != null) {
                    regalfaecher.add(parsedRegalfach);
                }
            }

            ObservableList<Einlegeboden> einlegeboeden = FXCollections.observableArrayList();

            return new Regal(regalfaecher, einlegeboeden, stuetzen, hoehe, breite, tragkraft, xPos, yPos);
        }

        return null;
    }

    private static Stuetze parseStuetze(JSONObject stuetze) {

        if (stuetze.size() > 0) {
            int hoehe = ((Number)stuetze.get("hoehe")).intValue();
            int breite = ((Number)stuetze.get("breite")).intValue();
            int xPos = ((Number)stuetze.get("xPos")).intValue();
            int yPos = ((Number)stuetze.get("yPos")).intValue();

            return new Stuetze(hoehe, breite, xPos, yPos);
        }

        return null;
    }

    private static Regalfach parseRegalfach(JSONObject regalFach) {

        if (regalFach.size() > 0) {
            JSONArray paketeArray = (JSONArray) regalFach.get("pakete");
            ArrayList<Paket> pakete = new ArrayList<>();
            for (Object p : paketeArray) {
                Paket parsedPaket = parsePaket((JSONObject) p);
                if (parsedPaket != null) {
                    pakete.add(parsedPaket);
                }

            }
            int hoehe = ((Number)regalFach.get("hoehe")).intValue();
            int xPos = ((Number)regalFach.get("xPos")).intValue();
            int yPos = ((Number)regalFach.get("yPos")).intValue();
            Einlegeboden boden = parseEinlegeboden((JSONObject) regalFach.get("boden"));

            return new Regalfach(boden, pakete, hoehe, xPos, yPos);
        }

        return null;
    }

    private static Paket parsePaket(JSONObject paket) {

        if (paket.size() > 0) {
            String paketName = (String) paket.get("paketName");
            int hoehe = ((Number)paket.get("hoehe")).intValue();
            int breite = ((Number)paket.get("breite")).intValue();
            int gewicht = ((Number)paket.get("gewicht")).intValue();
            Color farbe = (Color) paket.get("farbe");
            int tragkraft = ((Number)paket.get("tragkraft")).intValue();
            int xPos = ((Number)paket.get("xPos")).intValue();
            int yPos = ((Number)paket.get("yPos")).intValue();
            // TODO: unvertraeglichkeiten
            ArrayList<Color> unvertraeglichkeiten = new ArrayList<>();

            return new Paket(paketName, hoehe, breite, gewicht, farbe, tragkraft, xPos, yPos, unvertraeglichkeiten);
        }

        return null;

    }

    private static Einlegeboden parseEinlegeboden(JSONObject einlegeboden) {

        if (einlegeboden.size() > 0) {
            // TODO: regal
            Regal regal = null;
            int hoehe = ((Number)einlegeboden.get("hoehe")).intValue();
            int breite = ((Number)einlegeboden.get("breite")).intValue();
            int tragkraft = ((Number)einlegeboden.get("tragkraft")).intValue();
            int xPos = ((Number)einlegeboden.get("xPos")).intValue();
            int yPos = ((Number)einlegeboden.get("yPos")).intValue();

            return new Einlegeboden(regal, hoehe, breite, tragkraft, xPos, yPos);
        }

        return null;
    }

}
