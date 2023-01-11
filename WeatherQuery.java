package mde.weather;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class WeatherQuery {

    private static String url = "http://api.openweathermap.org/data/2.5/weather?zip=";
    private static String appId = "72a86ead024f76dea341d33723d9022d";

    public static void main(String[] args) throws Exception {

        try {
            String zip = getZip(args);

            if (zip.length() > 0) {
                String r = getResponse(url + zip + "&APPID=" + appId);

                JsonNode jsonTree = new ObjectMapper().readTree(r);
                System.out.println(jsonTree.toPrettyString());
            }
            else {
                System.out.println("No zip provided.");
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String getZip(String[] args) {
        // create Options object
        Options options = new Options();

        // add zip option
        Option zipOption = Option.builder("z").longOpt("zip")
                .argName("zip")
                .hasArg()
                .required(true)
                .desc("Zip to query with").build();
        options.addOption(zipOption);
        HelpFormatter helper = new HelpFormatter();

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("z")) {
                return cmd.getOptionValue("zip");
            }
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());
            helper.printHelp("Usage:", options);
            System.exit(0);
        }

        return "";
    }
    public static String getResponse(String url) {

        String json = "";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("accept", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

}
