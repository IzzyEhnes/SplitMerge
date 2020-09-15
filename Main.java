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



        LList ReadFile(String fileName)
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
    }



    public static void main(String[] args)
    {
	    LList myList = new LList();

	    String file = "/home/izzy/IdeaProjects/SplitMerge/src/input.txt";

	    myList = myList.ReadFile(file);

        myList.traverse();

	    /*
	    myList.add("Izzy");
	    myList.add("Seamus");
	    myList.add("Jake");
	    myList.add("Kennedy");

	    myList.traverse();

	    myList.delete("Seamus");

        System.out.println();

        myList.delete("Ian");

	    myList.traverse();
	     */
    }
}
