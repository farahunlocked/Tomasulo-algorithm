public class CDB {
    private long cdbRes;
    private String cdbSrc;
    //----------------getters----------------
    public long getResult() {
        return cdbRes;
    }
    public String getSrc() {
        return cdbSrc;
    }

    //-------------setters
    public void setResult(long result) {
        this.cdbRes = result;
    }

    public void setSrc(String stationName) {
        this.cdbSrc = stationName;
    }
}
