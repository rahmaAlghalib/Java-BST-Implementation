
package UberSystemProgram;

public class CaptainNode {
    
    private int captianID;
    private String CaptainName;
    private int star;
    private boolean available;
    private CaptainNode right;
    private CaptainNode left;
    
        public CaptainNode(int id, String name){
        
        captianID = id;
        CaptainName = name;
        star = 0;
        available = true;
        left = null;
        right = null;
    }
    
    
    public CaptainNode(int id, String name, CaptainNode left, CaptainNode right){
        
        captianID = id;
        CaptainName = name;
        star = 0;
        available = true;
        this.left = left;
        this.right = right;
    }
    
    
    
    
    public int getCaptianID(){
        return captianID;
    }
    
    public String getCaptainName(){
        return CaptainName;
    }
    
    public int getStar(){
        return star;
    }  

    public boolean isAvailable() {
        return available;
    }

    public CaptainNode getRight() {
        return right;
    }

    public CaptainNode getLeft() {
        return left;
    }

    public void setCaptianID(int captianID) {
        this.captianID = captianID;
    }

    public void setCaptainName(String CaptainName) {
        this.CaptainName = CaptainName;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRight(CaptainNode right) {
        this.right = right;
    }

    public void setLeft(CaptainNode left) {
        this.left = left;
    }
    
    
    
    
    
    
    
}
