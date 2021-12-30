public class LoadBuffer {
    public long address;
    public boolean busy;




    public void removeLoad(){
        busy=false;
        address=0;

    }
}
