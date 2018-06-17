package nmu.devilliers;

import java.net.InetAddress;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;

public class TimerServer {
    //System Time
    //this.timestamp = System.currentTimeMillis() / 1000L;

   // public static final String TIME_SERVER = "nist1-ny.ustiming.org";
    public static final String TIME_SERVER = "time.google.com";

    public static void main(String[] args) throws Exception {
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            NtpV3Packet message = timeInfo.getMessage();
            long serverTime = message.getTransmitTimeStamp().getTime();
            Date time = new Date(serverTime);
            System.out.println("Time from " + TIME_SERVER + ": " + time + " : " + serverTime);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
//1528904794731
//1528904807769
//1528912123220
    }
    public static long getTime()
    {
        long ltime = 0;
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            NtpV3Packet message = timeInfo.getMessage();
            long serverTime = message.getTransmitTimeStamp().getTime();
            return serverTime;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return 0;

    }


}
