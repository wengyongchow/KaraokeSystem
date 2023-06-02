/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

import ENTITY.Booking;

/**
 *
 * @author Chow weng yong
 */
public class YYLinkedListBooking<T> implements YYBookingInt<T>{

    private Node firstNode;             // Indicates the first node
    private int numberOfBooking;  	// Indicates the number of entries in list


    @Override
    public boolean isEmpty() { // To check if the list is empty, return true if it is empty, otherwise false
        boolean result = false;
        if(numberOfBooking==0){
            result = true;
        }
        return result;
    }

    
    private Node toTheLastNode(Node tmp) { //browse and return the last node
        if (tmp.next == null) {
            return tmp;
        } else {
            return toTheLastNode(tmp.next);
        }
    }
    
    private Node toTheSpecifyLocation(Node tmp, int position) { //browse and return the node at the specified position
        if (position == 1) {
            return tmp;
        } else {
            return toTheSpecifyLocation(tmp.next, position - 1);
        }
    }
    
    
    @Override
    public boolean add(T newBooking) { //To add the newBooking element at the back of the list
        Node newNode = new Node(newBooking);	// Create the new node
        boolean result = false;
        if (isEmpty()) { //point the firsnode to newBooking if the list is empty
            firstNode = newNode;
            result = true;
        } else {                        // add to end of nonempty list
            Node tmp = toTheLastNode(firstNode);
            tmp.next = newNode; // make last node reference new node
            result = true;
        }

        numberOfBooking++;
        return result;
    }
    

    @Override
    public boolean remove(int position) { //Remove the element from the specified position, return true if position found, false otherwise
        boolean result = false;                 

        if ((position >= 1) && (position <= numberOfBooking)) {
            if (position == 1) {      // if the position is the first element, assign the first node point to the next node
                firstNode = firstNode.next;
                result = true;
            } else {                         //if the position is not the first element then browse to the specified node and remove the pointer
                Node nodeBefore = toTheSpecifyLocation(firstNode, position - 1);
                result = true;
                nodeBefore.next = nodeBefore.next.next;	// Make the node before the position to point to the node after the specify node
            }
            numberOfBooking--;
        }
        return result; // indicates the node is successfully removed
    }
    
    @Override
    public T removeLast(){ //remove the last element from the list, return null if there is nothing to remove
        T lastElement = null;
        if(!isEmpty()){
            lastElement = toTheLastNode(firstNode).data; //Assign the last node to return variable
            Node nodeBefore = toTheSpecifyLocation(firstNode, numberOfBooking - 1);//get the second last node
            nodeBefore.next = null; // assign null to the pointer of the second last node
            numberOfBooking--;
        }
        return lastElement;
    }

    @Override
    public T get(int position) { //To retrieve and return the element from the specified postion
        T result = null;
        if ((position >= 1) && (position <= numberOfBooking)) {
            Node currentNode = toTheSpecifyLocation(firstNode, position);
            result = currentNode.data;	// assign the node place at the specified location to return to the main class
        }
        return result;
    }

    @Override
    public boolean replace(int position, T editedBooking) { // replace the element with the specified element from the specified position
        
        boolean isSuccessful = true;

        if ((position >= 1) && (position <= numberOfBooking) && editedBooking!= null) { //To check if the specified position is within the length of the list
            Node currentNode = toTheSpecifyLocation(firstNode, position);
            currentNode.data = editedBooking;	//Assign the spcified element to replace the current element
        } else {
            isSuccessful = false; //return false if the position invalid
        }

        return isSuccessful;
    }

    @Override
    public String report(String date) { //To generate a report of the booking of tomorrow and the day after tomorrow
        String returnString = "";
        Booking classVar = new Booking();
        Node currecntNode = firstNode;
        while(currecntNode!=null){
            classVar = (Booking) currecntNode.data;
            if (classVar.getDate().compareTo(date) == 0) {
                returnString += String.format("|%15s|%15s|%15d|%15s|%15s|\n", classVar.getBookingID(), classVar.getUser(), classVar.getQuantity(), classVar.getDate(), classVar.getTime());
            }
            currecntNode = currecntNode.next;
        }
        
        return returnString;
    }
    
    @Override
    public String toString() {//To display the sequance and booking name from the list
        String outputStr = "";
        Booking classVar = new Booking();
        Node currentNode = firstNode;
        int count = 1;
        while (currentNode != null) {
            classVar = (Booking) currentNode.data;
            
            outputStr += count + ". " + classVar.getUser() + "\n";
            currentNode = currentNode.next;
            count++;
        }
        return outputStr;
    }
    
    
    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
