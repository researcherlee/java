package test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Path#getRoot, getParent		
		System.out.println("Root of this path: " + Paths.get("sdfsdf"));
		System.out.println("Root of this path: " + Paths.get("/sdfsdf").getRoot());
		System.out.println("Root of this path: " + Paths.get("z://sdfsdf").getRoot());
		System.out.println("Root of this path: " + Paths.get("c://sdfsdf").getRoot());
		System.out.println("Root of this path: " + Paths.get("d:\\sdfsdf").getRoot());
		System.out.println("Root of this path: " + Paths.get("d:\\sdfsdf").getParent());
		System.out.println("Root of this path: " + Paths.get("d:\\sdfsdf").getNameCount());
		
		
		// Path#getName
		for (int i = 0 ; i < Paths.get("d:\\sdfsdf").getNameCount(); i++){
			System.out.println("Name element: " + i + " is: " + Paths.get("d:\\sdfsdf").getName(i));
			
		}
		
		// Path#subPath
		
		Path p = Paths.get("c:\\a\\b\\c\\d\\e");		
		System.out.println("SubPath(2,5): " + p.subpath(2, 5));
		
		// Path#toURI
		System.out.println("url " + p.toUri());
		
		// Path#toAbsolutePath
		for (int i = 0 ; i < Paths.get(".").toAbsolutePath().getNameCount(); i++){
			System.out.println("Name element: " + i + " is: " + Paths.get(".").toAbsolutePath().getName(i));
			
		}
		
		// Path#toRealPath
		System.out.println(Paths.get("c:\\users\\lee\\appdata\\roaming\\apple computer\\mobilesync\\backup").toRealPath());		
		System.out.println(Paths.get("c:\\users\\lee\\appdata\\roaming\\apple computer\\mobilesync\\backup").toRealPath(LinkOption.NOFOLLOW_LINKS));
//		System.out.println(Paths.get("c:\\users\\lee\\appdata\\roaming\\apple computer\\mobilesync\\bacss").toRealPath());
		
		// resolve Test		
		System.out.println(Paths.get("c:\\").resolve("a.txt").resolve("b.txt"));
		
		// resolveSibling
		System.out.println(Paths.get("c:\\").resolve("a.txt").resolveSibling("b.txt"));
		System.out.println(Paths.get("c:\\").resolveSibling("a.txt"));
		System.out.println(Paths.get("c:\\").resolveSibling("a.txt").toAbsolutePath());
		
		// relativize();
		
		Path p1 = Paths.get("a.txt");
		Path p2 = Paths.get("b.txt");		
		System.out.println(p1.relativize(p2));
		System.out.println(p2.relativize(p1));
		p1 = Paths.get("d:\\a/b/c");
		p2 = Paths.get("d:\\d/e/f");
//		p2 = Paths.get("c:\\d/e/f"); ERROR
		System.out.println(p1.relativize(p2));
		System.out.println(p2.relativize(p1));
		p1 = Paths.get("d:\\a/b/c");
		p2 = Paths.get("d:\\a/e/f");
		System.out.println(p1.relativize(p2));
		System.out.println(p2.relativize(p1));
		
		
		// FilesSystem
		System.out.println(FileSystems.getDefault().getRootDirectories());
		
		// FileAttributeView
		for (String view : FileSystems.getDefault().supportedFileAttributeViews()){
			System.out.println(view);
		}
		
	}

}
