package nmu.devilliers;

import javafx.util.Pair;

import java.util.ArrayList;

public class deVillSource {
    private String HashofFile;
    private String Timestamp;
    private String SizeofFile;
    private String pkAdder;
    private String OriginalURL;
    private ArrayList<Pair<String,String>> listMeta = new ArrayList<Pair<String,String>>();
    private ArrayList<String> moreLinks = new ArrayList<String>();

    public deVillSource(String hashofFile, String timestamp, String sizeofFile, String pkAdder, String originalURL) {
        HashofFile = hashofFile;
        Timestamp = timestamp;
        SizeofFile = sizeofFile;
        this.pkAdder = pkAdder;
        OriginalURL = originalURL;
    }

    public Pair<String, String> removeMeta(int i)
    {
        return listMeta.remove(i);
    }
    public String removeLink(int i)
    {
        return moreLinks.remove(i);
    }

    public void addMeta(Pair<String, String> i)
    {
        listMeta.add(i);
    }
    public void addLink(String i)
    {
        moreLinks.add(i);
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


}
