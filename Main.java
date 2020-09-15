public class Main
{
    public class Node
    {
        private int value;

        private Node next;


        public Node()
        {
        }



        public Node(int inValue)
        {
            this.value = inValue;
        }



        int getValue()
        {
            return value;
        }



        void setValue(int inValue)
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



    public class LList
    {
        Node head;

        void add(int inValue)
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



        void delete(int inValue)
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
	// write your code here
    }
}
