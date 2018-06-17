package nmu.devilliers;

public class devilBlock
{
    int staticnumber;
    int blocksize;
    int numberofsources;
    private long nonce;
    private long timestamp;
    private String prevBlockHash;
    private String merkleRoot;

    public devilBlock(long timestamp, String prevBlockHash, String merkleRoot) {
        this.timestamp = TimerServer.getTime();
        this.prevBlockHash = prevBlockHash;
        this.merkleRoot = merkleRoot;
    }


}
