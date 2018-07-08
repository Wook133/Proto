package nmu.devilliers.Trash;

import javafx.util.Pair;
import nmu.devilliers.GeneralHASH;
import nmu.devilliers.Leaf;
import nmu.devilliers.TimerServer;

import java.util.ArrayList;
import java.util.Comparator;

public class deVillSource extends Leaf {


    private String HashofFile;
    private String Timestamp;
    private String SizeofFile;
    private String pkAdder;
    private String OriginalURL;
    private ArrayList<Pair<String,String>> listMeta = new ArrayList<Pair<String,String>>();
    private ArrayList<String> moreLinks = new ArrayList<String>();
    private Integer sizeofSource;
    private Long LSize;

    public deVillSource(String hashofFile, String timestamp, String sizeofFile, String pkAdder, String originalURL) {
       // LSize = (long)hashofFile.length() + (long)timestamp.length() + (long)sizeofFile.length() + (long)pkAdder.length() + (long)originalURL.length();
        //if (LSize < maxNumberBytes) {
            HashofFile = hashofFile;
            Timestamp = timestamp;
            SizeofFile = sizeofFile;
            this.pkAdder = pkAdder;
            OriginalURL = originalURL;

        //}
    }

    public deVillSource(String hashofFile, String sizeofFile, String pkAdder, String originalURL) {
        HashofFile = hashofFile;
        Timestamp = TimerServer.toStringGetTime();
        SizeofFile = sizeofFile;
        this.pkAdder = pkAdder;
        OriginalURL = originalURL;
    }

    public Pair<String, String> removeMeta(int i)
    {

        //Pair<String, String> pCur = listMeta.get(i);
        //LSize = LSize - ((pCur.getKey().length()) +(pCur.getValue().length()));
        //pCur = null;
        return listMeta.remove(i);
    }
    public String removeLink(int i)
    {
       // String s = moreLinks.get(i);
       // LSize = LSize - (s.length());
       // s = null;
        return moreLinks.remove(i);
    }

    public Boolean addMeta(Pair<String, String> i)
    {
        /**Long size = Long.valueOf(i.getKey().length() + i.getValue().length());
        Long ltemp = size + LSize;
        if (ltemp < maxNumberBytes)
        {
            LSize = ltemp;**/
        if (listMeta.size() < 1000)
        {
            listMeta.add(i);
            return true;
        }
        else
            return false;
    }
    public Boolean addLink(String i)
    {

        if (moreLinks.size() < 1000)
        {
            moreLinks.add(i);
            return true;
        }
        else
            return false;
    }


    public String getHashofFile() {
        return HashofFile;
    }

    public void setHashofFile(String hashofFile) {
        HashofFile = hashofFile;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getSizeofFile() {
        return SizeofFile;
    }

    public void setSizeofFile(String sizeofFile) {
        SizeofFile = sizeofFile;
    }

    public String getPkAdder() {
        return pkAdder;
    }

    public void setPkAdder(String pkAdder) {
        this.pkAdder = pkAdder;
    }

    public String getOriginalURL() {
        return OriginalURL;
    }

    public void setOriginalURL(String originalURL) {
        OriginalURL = originalURL;
    }

    public ArrayList<Pair<String, String>> getListMeta() {
        return listMeta;
    }

    public void setListMeta(ArrayList<Pair<String, String>> listMeta) {
        this.listMeta = listMeta;
    }

    public ArrayList<String> getMoreLinks() {
        return moreLinks;
    }

    public void setMoreLinks(ArrayList<String> moreLinks) {
        this.moreLinks = moreLinks;
    }

    @Override
    public String toString()
    {
        String sout = "";
        sout = HashofFile + "_" + Timestamp + "_" + SizeofFile + "_" + pkAdder + "_" + OriginalURL;
        String stemp = "";
        for (int i =0; i <= listMeta.size() - 1; i++)
        {
            Pair pcur = listMeta.get(i);
            String skey = (String)pcur.getKey();
            String svalue = (String)pcur.getValue();
            stemp = stemp + "_" + skey + "_" + svalue;
        }
        sout = sout + "_" + stemp;
        stemp = "";
        for (int j = 0; j <= moreLinks.size() - 1; j++)
        {
            stemp = stemp + "_" + moreLinks.get(j);
        }
        sout = sout + "_" + stemp;
        return sout;
    }

    @Override
    public String Type() {
        return "deVill_Source";
    }

    @Override
    public String PrimaryKeyOfCreator() {
        return pkAdder;
    }

    @Override
    public Boolean equalsTo(Leaf obj1) {
        String s = this.toString();
        String sObj = obj1.toString();
        return (s.equals(sObj));

    }

    @Override
    public Integer compareTo(Leaf obj1) {
        String s = this.toString();
        String sObj = obj1.toString();
        return (s.compareTo(sObj));
    }



    @Override
    public ArrayList<Pair<String, String>> toArraylistPairForSending()
    {
        ArrayList<Pair<String, String>> listout = new ArrayList<Pair<String, String>>();
        /*
        private String OriginalURL;
        private ArrayList<Pair<String,String>> listMeta = new ArrayList<Pair<String,String>>();
        private ArrayList<String> moreLinks = new ArrayList<String>();
        */
        Pair<String, String> pairCur = new Pair<>("Hash", HashofFile);
        listout.add(pairCur);
        pairCur = new Pair<>("Timestamp", Timestamp);
        listout.add(pairCur);
        pairCur = new Pair<>("Size of File", SizeofFile);
        listout.add(pairCur);
        pairCur = new Pair<>("Primary Key Adder", pkAdder);
        listout.add(pairCur);
        pairCur = new Pair<>("Original Url", OriginalURL);
        listout.add(pairCur);
        for (int i = 0; i <= listMeta.size() - 1; i++)
        {
            pairCur = new Pair<>(listMeta.get(i).getKey(), listMeta.get(i).getValue());
            listout.add(pairCur);
        }
        for (int i = 0; i <= moreLinks.size() - 1; i++)
        {
            pairCur = new Pair<>("Link " + i + ": ", moreLinks.get(i));
            listout.add(pairCur);
        }
        return listout;
    }


    //Fix
    @Override
    public String hashCargo()
    {
        try
        {
            GeneralHASH gh = new GeneralHASH();
            String s = gh.HashnoPrint(cargoToString(), "SHA3-256");
            return s;
        }

        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("de Vill Source, No Such Class or Method: General Hash");
        }

        return getHashofFile();
    }
    //FIX
    @Override
    public String cargoToString()
    {
        return toString();
    }

    @Override
    public Boolean cargoEquals(Leaf obj) {
        return true;
    }

    @Override
    public Integer cargoCompareTo(Leaf obj) {
        return null;
    }

    @Override
    public void equalsTo() {

    }


}
