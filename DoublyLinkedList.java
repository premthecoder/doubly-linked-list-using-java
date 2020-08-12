import java.util.Scanner;

public class DoublyLinkedList {
    
    Node head;

    DoublyLinkedList() {
        this.head = null;
    }

    static class Node {
        int data;
        Node next;
        Node prev;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    void insertNode(int data) {
        Node track = this.head;
        Node node = new Node(data);
        if(track != null) {
            while (track.next != null) {
                track = track.next;
            }
            node.prev = track;
            track.next = node;
        } else {
            this.head = node;
        }
        System.out.println("Node inserted: " + data);
    }

    void insertAfter(int afterNodeData, int data) {
        Node track = this.head;
        Node node = new Node(data);
        boolean afterNodeExists = false;
        if(track != null) {
            while (track != null) {
                if(track.data == afterNodeData) {
                    afterNodeExists = true;
                    node.next = track.next;
                    node.prev = track;
                    if(track.next != null) {
                        (track.next).prev = node;
                    }
                    track.next = node;
                }
                track = track.next;
            }
            if(afterNodeExists) {
                System.out.println("Node inserted: " + data);
            } else {
                System.out.println("Node not found with data: " + afterNodeData);
            }
        } else {
            System.out.println("The linked list is empty!");
        }
    }

    void removeNode() {
        Node track = this.head;
        Node prevNode = null;
        if(track != null) {
            while(track.next != null) {
                prevNode = track;
                track = track.next;
            }
            System.out.println("Node removed: " + track.data);
            if(prevNode != null) {
                prevNode.next = null;
                track.prev = null;
            } else {
                this.head = null;
            }
        } else {
            System.out.println("The linked list is empty!");
        }
    }

    void removeNode(int data) {
        Node track = this.head;
        Node prevNode = null;
        boolean nodeFound = false;
        if(track != null) {
            while(track != null) {
                if(track.data == data) {
                    nodeFound = true;
                    if(prevNode != null) {
                        prevNode.next = track.next;
                    } else {
                        this.head = track.next;
                    }
                    if(track.next != null) {
                        (track.next).prev = track.prev;
                    } else {
                        prevNode.next = null;
                    }
                    track.next = null;
                    track.prev = null;
                    break;
                }
                prevNode = track;
                track = track.next;
            }
            if(nodeFound) {
                System.out.println("Node removed: " + data);
            } else {
                System.out.println("Node not found with data: " + data);
            }
            
        } else {
            System.out.println("The linked list is empty!");
        }
    }

    void getSize() {
        Node track = this.head;
        int size = 0;
        if(track != null) {
            while(track != null) {
                size++;
                track = track.next;
            }
        }
        System.out.println("Number of Nodes: " + size);
    }

    void printList() {
        if(this.head == null) {
            System.out.println("The linked List is empty!");
        } else {
            System.out.print("Linked List (forward): ");
            Node track = this.head;
            while(track != null)
            {
                System.out.print(track.data + " -> ");
                track = track.next;
            }
            System.out.print("\n");
        }
    }

    void printBackwards() {
        Node track = this.head;
        if(track != null) {
            track = this.head;
            while(track.next != null)
            {
                track = track.next;
            }
            System.out.print("Linked List (backward): ");
            Node trackBack = track;
            while (trackBack != null) {
                System.out.print(trackBack.data + " -> ");
                trackBack = trackBack.prev;
            }
            System.out.print("\n");
        } else {
            System.out.println("The linked List is empty!");
        }
    }

    public static void main(String args[]) {

        System.out.println("-- DoublyLinkedList Operations Menu --");
        System.out.println("Press 1 to Print in Forward direction");
        System.out.println("Press 2 to Print in Backward direction");
        System.out.println("Press 3 to Insert Empty Node (Data=0)");
        System.out.println("Press 4 to Insert Data Node at the End");
        System.out.println("Press 5 to Insert Data Node after another existing Node");
        System.out.println("Press 6 to Delete Last Node");
        System.out.println("Press 7 to Delete Data Node");
        System.out.println("Press 8 to Get Size");
        System.out.println("Press 0 to Exit");
        
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        do {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    doublyLinkedList.printList();
                    break;
                case 2:
                    doublyLinkedList.printBackwards();
                    break;
                case 3:
                    doublyLinkedList.insertNode(0);
                    break;
                case 4:
                    System.out.print("Enter new node data: ");
                    doublyLinkedList.insertNode(scan.nextInt());
                    break;
                case 5:
                    System.out.print("Enter existing node data: ");
                    int insertAfterNodeData = scan.nextInt();
                    System.out.print("Enter new node data: ");
                    doublyLinkedList.insertAfter(insertAfterNodeData, scan.nextInt());
                    break;
                case 6:
                    doublyLinkedList.removeNode();
                    break;
                case 7:
                    System.out.print("Enter node to be removed having data: ");
                    doublyLinkedList.removeNode(scan.nextInt());
                    break;
                case 8:
                    doublyLinkedList.getSize();
                    break;
                case 0:
                    System.out.println("GoodBye! See you later, Alligator.");
                    break;
                default:
                    System.out.println("Please enter a valid choice!");
                    break;
            }
        } while (choice != 0);
        scan.close();
    }

}
