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
    }



    public static void main(String[] args)
    {
	    LList myList = new LList();

	    myList.add("Izzy");
	    myList.add("Seamus");
	    myList.add("Jake");
	    myList.add("Kennedy");

	    myList.traverse();

	    myList.delete("Seamus");

        System.out.println();

	    myList.traverse();
    }
}
