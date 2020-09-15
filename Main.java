import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main
{
    public static class Node
    {
        private String value;

        private Node next;


        public Node()
        {
        }



        public Node(String inValue)
        {
            this.value = inValue;
        }



        String getValue()
        {
            return value;
        }



        void setValue(String inValue)
        {
            this.value = inValue;
        }



        Node getNext()
        {
            return next;
        }



        void setNext(Node inNode)
        {
            next = inNode;
        }
    }



    public static class LList
    {
        Node head;



        public LList()
        {

        }



        void add(String inValue)
        {
            Node nn = new Node(inValue);

            nn.setNext(head);

            head = nn;
        }



        void traverse()
        {
            Node current = new Node();

            for (current = head; current != null; current = current.getNext())
            {
                System.out.println(current.getValue());
            }
        }



        int getListSize()
        {
            int size = 0;

            Node current = new Node();

            for (current = head; current != null; current = current.getNext())
            {
                size++;
            }

            return size;
        }



        void delete(String inValue)
        {
            Node current = new Node();

            if (head != null)
            {
                if (head.value == inValue)
                {
                    head = head.next;
                }

                else
                {
                    current = head;

                    while (current.next != null &&
                            current.next.value != inValue)
                    {
                        current = current.next;
                    }

                    if (current.next != null)
                    {
                        current.next = current.next.next;
                    }
                }
            }
        }



        LList readFile(String fileName)
        {
            LList names = new LList();

            Scanner fileReader = null;

            try
            {
                fileReader = new Scanner(new File(fileName));
            }

            catch (FileNotFoundException fileError)
            {
                System.out.println(String.format("There was a problem opening file \"%s\": error = %s", fileName, fileError.getMessage()));

                System.out.println("Exiting program...");

                System.exit(1);
            }

            while (fileReader.hasNextLine())
            {
                String currentName = fileReader.nextLine().trim();

                names.add(currentName);
            }

            return names;
        }



        void splitMerge(LList myList1, LList myList2)
        {
            int splitSize = this.getListSize() / 2;

            Node current = new Node();

            int nodeCount = 0;
            for (current = head; current != null; current = current.getNext())
            {
                if (nodeCount < splitSize)
                {
                    myList1.add(current.value);
                }

                else
                {
                    myList2.add(current.value);
                }

                nodeCount++;
            }

            System.out.println();
            System.out.println("myList1: ");
            myList1.traverse();

            System.out.println();
            System.out.println("myList2: ");
            myList2.traverse();
        }



        LList merge(LList list1, LList list2)
        {
            Node current = new Node();

            LList mergedList = new LList();

            for (current = list1.head; current != null; current = current.getNext())
            {
                mergedList.add(current.value);
            }

            for (current = list2.head; current != null; current = current.getNext())
            {
                mergedList.add(current.value);
            }

            return mergedList;
        }
    }



    public static void main(String[] args)
    {
	    LList myList = new LList();

	    String file = "/home/izzy/IdeaProjects/SplitMerge/src/input.txt";

	    myList = myList.readFile(file);

	    LList list1 = new LList();
	    LList list2 = new LList();

        myList.splitMerge(list1, list2);

        LList mergedList = myList.merge(list1, list2);

        System.out.println();
        System.out.println("Merged list:");
        mergedList.traverse();
    }
}
