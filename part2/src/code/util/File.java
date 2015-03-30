package code.util;
import java.io.BufferedReader;
import java.io.FileReader;

	public class File {
		
		public static boolean exists(String file) {
			try {
				new FileReader(new java.io.File(file));
				
				return true;
			} catch (Exception e ) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		public static String read(String file) {
			BufferedReader in = null;
			
			try {
				in = new BufferedReader(new FileReader(new java.io.File(file)));
				String line;
				String out = "";
				
				while ( (line = in.readLine()) != null ) {
					out += line+"\n";
				}
				
				return out;
			} catch (Exception e ) {
				return null;
			} finally {
				try {
					in.close();
				} catch ( Exception e) { }
			}
		}
	}
