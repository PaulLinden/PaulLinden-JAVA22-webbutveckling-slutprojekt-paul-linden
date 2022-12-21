package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GettheWeather {

	public static void getWeather(weatherBean wBean) throws IOException {

		String API_KEY = "f64ed0fa9347cbaa362e70ce1ca9da6a";

		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=" + API_KEY + "&mode=xml&units=metric";

		URL line_api_url = new URL(URLtoSend);

		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		String inputLine;

		String ApiResponse = "";

		while ((inputLine = in.readLine()) != null) {
			ApiResponse += inputLine;
		}
		in.close();

		Document doc = convertStringToXMLDocument(ApiResponse);

		NodeList[] nList = { doc.getElementsByTagName("clouds"), doc.getElementsByTagName("temperature"),
				doc.getElementsByTagName("lastupdate"), doc.getElementsByTagName("timezone") };

		// --------For Clouds-------------------------
		for (int temp = 0; temp < nList[0].getLength(); temp++) {

			Node node = nList[0].item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;

				String XMLclouds = eElement.getAttribute("name");
				System.out.println(wBean.getCityStr() + " is now a " + XMLclouds);
				wBean.setCloudsStr(XMLclouds);
			}
		}
		// --------For temperature-------------------------
		for (int temp = 0; temp < nList[1].getLength(); temp++) {

			Node node = nList[1].item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;

				String XMLtemperature = eElement.getAttribute("value");
				String XMLunit = eElement.getAttribute("unit");

				System.out.println(wBean.getCityStr() + " is now " + XMLtemperature + " Celsius");
				wBean.setTempStr(XMLtemperature);
				wBean.setUnit(XMLunit);
			}
		}
		// --------For lastUpdate-------------------------
		for (int temp = 0; temp < nList[2].getLength(); temp++) {

			Node node = nList[2].item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;

				String XMLlastDate = eElement.getAttribute("value");

				System.out.println("Last search: " + XMLlastDate);
				wBean.setLastDate(XMLlastDate);
			}
		}
	}

	private static Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {

			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
