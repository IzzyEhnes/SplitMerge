/**
 * Author: Izzy Ehnes
 * Class: CS130, Section 5
 * Date completed: 17 September 2020
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



    class Node
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






    class LList
    {
        private Node head;



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
                if (head.getValue() == inValue)
                {
                    head = head.getNext();
                }

                else
                {
                    current = head;

                    while (current.getNext() != null &&
                            current.getNext().getValue() != inValue)
                    {
                        current = current.getNext();
                    }

                    if (current.getNext() != null)
                    {
                        current.setNext(current.getNext().getNext());
                    }
                }
            }
        }



        LList split()
        {
            LList list2 = new LList();

            int splitSize = this.getListSize() / 2;

            int nodeCount = 0;
            for (Node current = head; current != null; current = current.getNext())
            {
                if (nodeCount == splitSize - 1)
                {
                    list2.head = current.getNext();

                    current.setNext(null);

                    break;
                }

                nodeCount++;
            }

            System.out.println("\nlist1: ");
            this.traverse();

            System.out.println("\nlist2: ");
            list2.traverse();

            return list2;
        }



        void merge(LList list2)
        {
            for (Node current = head; current != null; current = current.getNext())
            {
                if (current.getNext() == null)
                {
                    current.setNext(list2.head);

                    list2.head = null;

                    break;
                }
            }
        }
    }






    public class Main
    {
        static LList readFile(String fileName)
        {
            LList names = new LList();

            Scanner fileReader = null;

            try
            {
                fileReader = new Scanner(new File(fileName));
            }

            catch (FileNotFoundException fileError)
            {
                System.out.println(String.format("There was a problem opening file \"%s\": \n\tError = %s", fileName, fileError.getMessage()));

                System.out.println("Exiting program...");

                System.exit(1);
            }

            while (fileReader.hasNextLine())
            {
                String currentName = fileReader.next().trim();

                names.add(currentName);
            }

            return names;
        }



        public static void main(String[] args)
        {
            String file = "/home/izzy/IdeaProjects/SplitMerge/src/input.txt";

            LList list1 = readFile(file);

            System.out.println("BEFORE SPLIT");
            
            System.out.println("\nlist1: ");
            list1.traverse();

            System.out.println("\n**********************************");

            System.out.println("AFTER SPLIT");

            LList list2 = list1.split();

            list1.merge(list2);

            System.out.println("\n**********************************");

            System.out.println("AFTER MERGE");

            System.out.println("\nlist1:");
            list1.traverse();
        }
}



/* Sample output:

BEFORE SPLIT

list1:
Tate
Kyle
Max
Roger
Josh
Cory
Kayla
Tristan
Connor
Kylie
Payton
David
Sofia
Grant
Dhruva
Shivani
Ella
Lucas
Bradley
Mason
Will
Colin
Julie
Quinn
Carter
Ian
Kennedy
Jake
Seamus
Izzy

**********************************
AFTER SPLIT

list1:
Tate
Kyle
Max
Roger
Josh
Cory
Kayla
Tristan
Connor
Kylie
Payton
David
Sofia
Grant
Dhruva

list2:
Shivani
Ella
Lucas
Bradley
Mason
Will
Colin
Julie
Quinn
Carter
Ian
Kennedy
Jake
Seamus
Izzy

**********************************
AFTER MERGE

list1:
Tate
Kyle
Max
Roger
Josh
Cory
Kayla
Tristan
Connor
Kylie
Payton
David
Sofia
Grant
Dhruva
Shivani
Ella
Lucas
Bradley
Mason
Will
Colin
Julie
Quinn
Carter
Ian
Kennedy
Jake
Seamus
Izzy

 */
