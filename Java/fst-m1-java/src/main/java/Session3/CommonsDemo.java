package Session3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class CommonsDemo {
	
	public static void main(String[] args) throws IOException {
		
		
		InputStream in=new FileInputStream("filepath");
		System.out.println(IOUtils.toString(in, "UTF-8"));
		
//		File file=FileUtils.getFile("");
//		File tmpDir=FileUtils.getTempDirectory();
//		System.out.println(tmpDir);
//		FileUtils.copyFileToDirectory(file, tmpDir);
//		
//		//Temp file
		
	}

}
