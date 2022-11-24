
package UberSystemProgram;

import java.io.PrintWriter;

public class UberTree {

    private CaptainNode root;

    
    // CONSTRUCTER
    public UberTree() {
        root = null;
    }

    
// ADD CAPTAIN------------------------------------------------------------------
    public void add_captain(int id, String name, PrintWriter output) {

        CaptainNode cap = new CaptainNode(id, name); // create new node

        // print captain's details
        output.print("\t\t       ID: " + cap.getCaptianID());
        output.print("\n\t\t       Name: " + cap.getCaptainName());
        output.print("\n\t\t       Available: " + (cap.isAvailable() == true ? "True" : "False"));
        output.print("\n\t\t       Rating star: " + cap.getStar());
        output.println();

        // call add captain to insert node
        root = add_captain(root, cap);

    }

    private CaptainNode add_captain(CaptainNode root, CaptainNode newNode) {

        if (root == null) { 
            return newNode;
        } else { 

            if (newNode.getCaptianID() > root.getCaptianID()) { 

                CaptainNode temp = add_captain(root.getRight(), newNode);

                root.setRight(temp); 

            } else {

                CaptainNode temp = add_captain(root.getLeft(), newNode);

                root.setLeft(temp);

            }

        }

        return root;

    }
//------------------------------------------------------------------------------   
    

// SEARCH FOR CAPTAIN BY ID-----------------------------------------------------
    public CaptainNode search(int id) {

        return search(root, id);
    }

    private CaptainNode search(CaptainNode root, int id) {

        if (root == null) {
            return null;
        } else {
            if (root.getCaptianID() == id) {
                return root;
            } else if (root.getCaptianID() < id) {
                return search(root.getRight(), id);
            } else {
                return search(root.getLeft(), id);
            }
        }

    }
//------------------------------------------------------------------------------
    
    
// BOOK A RIDE WITH A CAPTAIN---------------------------------------------------   
    public void bookRide(int id, PrintWriter output) {

        CaptainNode cap = search(id);

        if (cap != null && cap.isAvailable()) { // if the captain is found and the captain is available then book a ride
            output.println("Command BOOK_RIDE: Book a new Ride with captain " + id);
            cap.setAvailable(false);
        } else if (cap != null && !cap.isAvailable()) { // if the captain is found but the captain already booked a ride or the captain is not available
            output.println("Command BOOK_RIDE: The captain " + cap.getCaptainName() + " is not available. He is on another ride!");
        } else { // if the captain is not found 
            output.println("Command BOOK_RIDE: Couldnâ€™t find any captain with ID number " + id);
        }

    }
//------------------------------------------------------------------------------
    
    
// DISPLAY INFO ABOUT A CHOSEN CAPTAIN------------------------------------------
    public void displayInfo(int id, PrintWriter output) {

        // search for captain 
        CaptainNode cap = search(id);

        if (cap != null) {
            // if the captain is found then print their details !
            output.println("Command DISPLAY_CAPTAIN_INFO:");
            output.print("\t\t       ID: " + cap.getCaptianID());
            output.print("\n\t\t       Name: " + cap.getCaptainName());
            output.print("\n\t\t       Available: " + (cap.isAvailable() == true ? "True" : "False"));
            output.print("\n\t\t       Rating star: " + cap.getStar());
            output.println();

        } else { // if the captain is not found
            output.println("Command DISPLAY_CAPTAIN_INFO: Couldnâ€™t find any captain with ID number " + id);
        }

    }
//------------------------------------------------------------------------------
    
    
// FINISH RIDE WITH A CAPTAIN---------------------------------------------------
    public void finishRide(int id, int rating, PrintWriter output) {

        // search for captain
        CaptainNode cap = search(id);

        if (cap != null && (!cap.isAvailable())) { // if the captain is found and he was at a ride or he is not available then change the rating

            // print details
            output.println("Command FINISH_RIDE: Finish ride with captain " + id);
            output.print("\n\t\t       ID: " + cap.getCaptianID());
            output.print("\n\t\t       Name: " + cap.getCaptainName());
            
            // set available to true
            cap.setAvailable(true);
            output.print("\n\t\t       Available: " + (cap.isAvailable() == true ? "True" : "False"));
            
            // change the rating
            cap.setStar(rating);
            output.print("\n\t\t       Rating star: " + cap.getStar());
            output.println();

        } else if (cap != null && cap.isAvailable()) { // if the captain is found and he was not booked for a ride or he is available 

            output.println("Command FINISH_RIDE: The captain " + cap.getCaptainName() + " is not in a ride!â€");

        } else { // if the captain is not found
            output.println("Command FINISH_RIDE: Couldnâ€™t find any captain with ID number " + id);
        }

    }
//------------------------------------------------------------------------------
    
    
// DELETE CAPTAIN BY ID---------------------------------------------------------
    public void deleteCaptain(int id, PrintWriter output){
        
        // search for captain
        CaptainNode cap = search(id);
        
        if (cap != null){ // if the captain is found then we can delete him
        root = deleteCaptain(root, id);
        output.println("Command DELETE_CAPTAIN:The captain "+ cap.getCaptainName() +" left Uber");
        }
        
        else{ // if the captain is not found
            output.println("Command DELETE_CAPTAIN: Couldnâ€™t find any captain with ID number " + id);
        }
        
    }
    
    private CaptainNode deleteCaptain(CaptainNode root, int id){
       
        CaptainNode captainToDelete, parent;
        
        // 1- Find the node you want to delete 
        captainToDelete = search(id);
        
        // if the node is not found then return the root. there is nothing to delete !
        if(captainToDelete == null){
            return root;
        }
        
        // 2- if the node to delete is found, then find the parent of the node 
        parent = parent(captainToDelete);
        
        // 3- Check if the node is Leaf, has only right child, has only left child or has two children
       // but in this program we have only two conditions... the node is either has a right child or is a leaf
        if(isLeaf(captainToDelete)){ 
            
            if(parent == null){// if there is no parent then it's the only node so return null
                return null;
            }
            
            // if the parent is found then check if it's child is right or left and set it to null
            if(id < parent.getCaptianID()){
                captainToDelete.setLeft(null);
            }
            else if(id > parent.getCaptianID()){
                captainToDelete.setRight(null);
            }
            
            // finally when it's set return the root
            return root;
        }
        
        else if(hasOnlyRightChild(captainToDelete)){ 
            
            if(parent == null){// if there is no parent (the node is the root), then just return the child of the node to 
                return captainToDelete.getRight();
            }
            
            // if the parent is found then check if the parent...
            // 1- if the parent id is higher than the child (Node to delete), then set the parent's left to the right child of the node to delete
            // 2- if the parent id is lower than the child (Node to delete), then set the parent's right to the right child of the node to delete           
	    if (id < parent.getCaptianID())                                           
		parent.setLeft(parent.getLeft().getRight());
            else 
                parent.setRight(parent.getRight().getRight());
            
            // finally when it's set return the root
            return root;
        }
       
        
        return root;

    }
    
    
// FIND PARENT OF A NODE--------------------------------------------------------
    public CaptainNode parent(CaptainNode cap){
        return parent(root, cap);
    }
    
    private CaptainNode parent(CaptainNode root, CaptainNode cap){
        
        // if there is no parent or the root is null
        if(root == null || cap == root){
            return null;
        }
        
        // if the current root is the parent
        if(root.getRight() == cap || root.getLeft() == cap){
            return root;
        }
        
        
        if(cap.getCaptianID() > root.getCaptianID()){
            return parent(root.getRight(), cap);
        }
        else if(cap.getCaptianID() < root.getCaptianID()){
            return parent(root.getLeft(), cap);
        }
        
        else{
            return null;
        }   
        
    }
//------------------------------------------------------------------------------   
    

// FIND WHAT KIND OF NODE-------------------------------------------------------
 	public boolean isLeaf(CaptainNode cap) {
		return (cap.getLeft()==null && cap.getRight()==null);
	}

	public boolean hasOnlyRightChild(CaptainNode cap) {
		return (cap.getLeft()==null && cap.getRight()!=null);
	}   
//------------------------------------------------------------------------------  
     
    
    
// DISPLAY ALL CAPTAINS---------------------------------------------------------
    
    public void displayAllCaptains(PrintWriter output){
        
        displayAllCaptains(root,output);
    }
    
    
    private void displayAllCaptains(CaptainNode root, PrintWriter output){
        
        // IN ORDER TRAVERSE
        if (root != null){
            displayAllCaptains(root.getLeft(), output);
            output.println();
            output.print("\t\t       ID: " + root.getCaptianID());
            output.print("\n\t\t       Name: " + root.getCaptainName());
            output.print("\n\t\t       Available: " + (root.isAvailable() == true ? "True" : "False"));
            output.print("\n\t\t       Rating star: " + root.getStar());
            output.println("\n"); 
            output.println("----------------------------------------------------------------");
            displayAllCaptains(root.getRight(), output);
        }
        
    }
//------------------------------------------------------------------------------
    
    
    
    
    
    
    
    
    

}
