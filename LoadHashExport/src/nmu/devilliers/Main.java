package nmu.devilliers;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
	// write your code here
        GeneralHASH gh = new GeneralHASH();
        gh.Hash("Hello", "SHA-1");
        gh.Hash("Hello", "SHA-224");

        gh.Hash("Hello", "SHA-384");
        gh.Hash("Hello", "SHA-512");


        gh.Hash("Hello", "SHA3-224");
        gh.Hash("Hello", "SHA3-256");
        gh.Hash("Hello", "SHA3-384");
        gh.Hash("Hello", "SHA3-512");


        gh.Hash("Hello", "SHA-256");
        //gh.hashoffile();
      //  gh.bufferedHashofFile("", "he.png");

       // gh.bhof("", "he.png");
        gh.naiveFileReaderHash("he.png", "SHA-256", 4096);

    }


}
