

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordCounter {

	public static void main(String[] args) {
		int tc = 0;
		int mc = 0;
		String maxWCFile = null;
		Map<String, String> fwcMap = new HashMap<String, String>();
		try {
			System.out.println("strat---------------------");
			// Open the folder to list all the files
			File folder = new File("home/data");

			// Create a text file to write the results
			File dir = new File("/home/output/");
		    if (!dir.exists()) dir.mkdirs();
			PrintWriter output = new PrintWriter("/home/output/result.txt");
			output.write("List of files in the folder /home/data \n");

			// List all the files available in the input folder
			File[] lf = folder.listFiles();
			// Loop through each file to get the word count
			for (int i = 0; i < lf.length; i++) {
				if (lf[i].isFile()) {
					String name = lf[i].getName();

					// get the word count in the file
					int wc = getWordCount("home/data/" + name);

					// check if the file has maximum words
					if (wc > mc) {
						mc = wc;
						maxWCFile = name;
					}

					// add word count of each file to the total count
					tc += wc;

					// save the file name and it's corresponding word count
					fwcMap.put(name, "WordCount: " + wc + " \n");

				} else if (lf[i].isDirectory()) {
					// skip if the file is a directory
					// System.out.println("Directory " + lf[i].getName());
				}
			}

			// write all the information to the result.txt file
			output.write("\n");
			output.write(fwcMap.keySet().toString().replaceAll("\\[", "").replaceAll("\\]", "") + "\n\n");
			output.write(fwcMap.entrySet().toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(", ", "")
					.replaceAll("=", " ") + "\n");
			output.write("Grand Total: " + tc + "\n\n");
			output.write("File name with maximum number of words: " + maxWCFile + ", WordCount: " + mc + "\n\n");
			output.write("IP Address: " + getIpAddress());
			output.flush();
			output.close();
		} catch (FileNotFoundException e1) {
		}

		try {
			// print the info in resul.txt file to the console
			try (Stream<String> lines = Files.lines(Paths.get("/home/output/result.txt"), Charset.defaultCharset())) {
				lines.forEachOrdered(System.out::println);
			}
		} catch (Exception e) {

		}
		
		/*try {
			
            File f = new File("/home/output/result.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
            }
            
            b.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
		
		System.out.println("end---------------------");
	}

	/* Get the IP Address */
	private static String getIpAddress() {
		String ip = null;
		try {
			ip = Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
		}
		return ip;
	}

	/* Calculate the word count in a file */
	private static int getWordCount(String fn) {
		int wc = 0;
		FileInputStream fileStream;
		try {
			String line;
			fileStream = new FileInputStream(fn);
			InputStreamReader input = new InputStreamReader(fileStream);
			BufferedReader reader = new BufferedReader(input);
			while ((line = reader.readLine()) != null) {
				String tl = line.trim();
				String[] wordList = tl.length() > 0 ? tl.split("\\s+") : null;
				wc += (null != wordList) ? wordList.length : 0;
			}
			reader.close();
			input.close();
			fileStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wc;
	}

}
