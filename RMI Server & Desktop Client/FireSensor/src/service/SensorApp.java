package service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class SensorApp {

	private static HttpURLConnection connection;

	public static void main(String[] args) {

		while (true) {

			BufferedReader reader;
			String line = "";
			StringBuffer responseContent = new StringBuffer();

			try {

				URL url = new URL("http://localhost:5000/sensors");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				// conn.setRequestProperty("Accept", "application/json");

				// Open a connection stream to the corresponding API.
				connection.connect();
				int responseCode = connection.getResponseCode();

				if (responseCode != 200)
					throw new RuntimeException("Http response code :" + responseCode);
				// from http response we get a inputstream

				else {
					reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					while ((line = reader.readLine()) != null) {
						responseContent.append(line);
						// System.out.println(responseContent.toString());
					}

					reader.close();

				}
				parse(responseContent.toString());

				SensorApp.ExpireTimer();

			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				connection.disconnect();
			}
		} // end of while

	}

	// method: to parse the http response data
	public static String parse(String responseBody) {
		int id, room_no, co2_level, smoke_level;
		String floor_no,sensor_name;
//		
//		Random co2Random = new Random();
//		Random smokeRandom = new Random();
//		
//		smokeLevel = 1 + smokeRandom.nextInt(10);
//		co2Level = 1 +  co2Random.nextInt(10);
//		
//		
//		if(co2Level > 5 || smokeLevel > 5) {
//			status=1;
//		}
//		
//		else {
//			status = 0;
//		}

		JSONArray array = new JSONArray(responseBody);

		for (int i = 0; i < array.length(); i++) {

			int co2Level = 0, smokeLevel = 0, status = 0;
			Random co2Random = new Random();
			Random smokeRandom = new Random();

			smokeLevel = 1 + smokeRandom.nextInt(10);
			co2Level = 1 + co2Random.nextInt(10);

			JSONObject object = array.getJSONObject(i);
			id = object.getInt("id");
			floor_no = object.getString("floor_no");
			room_no = object.getInt("room_no");
			co2_level = object.getInt("co2_level");
			smoke_level = object.getInt("smoke_level");
                        sensor_name=object.getString("sensor_name");
			//status = object.getInt("status");
//
//			if (co2Level > 5 || smokeLevel > 5) {
//				status = 1;
//			}
//
//			else {
//				status = 0;
//			}

//			System.out.println("id: " + id);
//			System.out.println("co2 : " + co2_level);
//			System.out.println("status :" + status);

			try {
				URL url = new URL("http://localhost:5000/sensors/" + id);
				connection = (HttpURLConnection) url.openConnection();

				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setRequestMethod("PUT");
				// connection.setFixedLengthStreamingMode(length);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Accept", "application/json");

				connection.connect();

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("floor_no", floor_no);
				jsonObject.put("room_no", room_no);
				jsonObject.put("co2_level", co2Level);
				jsonObject.put("smoke_level", smokeLevel);
                                jsonObject.put("sensor_name",sensor_name );
                                
				//jsonObject.put("status", status);

				OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
				wr.write(jsonObject.toString());
				wr.flush();

				StringBuilder sb = new StringBuilder();
				int HttpResult = connection.getResponseCode();
				if (HttpResult == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
					String line1 = null;
					while ((line1 = br.readLine()) != null) {
						sb.append(line1 + "\n");
					}
					br.close();
					System.out.println("" + sb.toString());
				} else {
					System.out.println(connection.getResponseMessage());
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.disconnect();
			}

		}

		return null;

	}

	public static void ExpireTimer() {

		try {
			Thread.sleep(10000);

		} catch (Exception e) {

		}

	}

}
