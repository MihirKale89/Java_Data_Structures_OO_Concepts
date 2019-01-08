// A complete working Java program to demonstrate all insertion methods
// on linked list
class LinkedListOperations
{
	Node head; // head of list

	/* Linked list Node*/
	class Node
	{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}

  /* Find if a node with the given key exists in the LinkedList. */
	public boolean find(int key)
	{
		/* 1: Create a temporary tNode and point it to the head */
		Node tNode = head;

    /* 2: Iterate though the linked list to find the specific key. */
    while (tNode != null){
      if (tNode.data == key) return true;
      tNode = tNode.next;
    }
    return false;
	}

	/* Inserts a new Node at front of the list. */
	public void prepend(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

  /* Inserts a new node at a given position if it exists. */
  /* Assuming the positions start with 1 */
	public void insertAt(int position, int new_data)
	{
		/* 1. Check if the given position is negative */
		if (position < 1){
			System.out.println("Sorry, cannot insert at non positive positions.");
			return;
		}
    if (position == 1) {
      prepend(new_data);
      return;
    }

		/* 2 & 3: Allocate the Node & Put in the data*/
		Node new_node = new Node(new_data);

    /* 5. Traverse until the given position using a temporary tNode*/
    Node tNode = head;
    while (position > 2){
      tNode = tNode.next;
      if (tNode == null) {
        System.out.println("Sorry, cannot insert at the index out of range.");
  			return;
      }
      position--;
    }

    /* 6. Make next of new Node as next of tNode */
    new_node.next = tNode.next;

    /* 7. make next of tNode as new_node */
    tNode.next = new_node;
	}

	/* Inserts a new node after the given prev_node. */
	public void insertAfter(Node prev_node, int new_data)
	{
		/* 1. Check if the given Node is null */
		if (prev_node == null)
		{
			System.out.println("The given previous node cannot be null");
			return;
		}

		/* 2 & 3: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}

	/* Appends a new node at the end. This method is
	defined inside LinkedList class shown above */
	public void append(int new_data)
	{
		/* 1. Allocate the Node &
		2. Put in the data
		3. Set next as null */
		Node new_node = new Node(new_data);

		/* 4. If the Linked List is empty, then make the
			new node as head */
		if (head == null)
		{
			head = new_node;
			return;
		}

		/* 4. This new node is going to be the last node, so
			make next of it as null */
		// new_node.next = null;

		/* 5. Else traverse till the last node */
		Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
		return;
	}

  /* Given a key, deletes the first occurrence of key in linked list */
  void deleteNode(int key)
  {
    // Store head node
    Node temp = head, prev = null;

    // If head node itself holds the key to be deleted
    if (temp != null && temp.data == key)
    {
        head = temp.next; // Changed head
        return;
    }

    // Search for the key to be deleted, keep track of the
    // previous node as we need to change temp.next
    while (temp != null && temp.data != key)
    {
        prev = temp;
        temp = temp.next;
    }

    // If key was not present in linked list
    if (temp == null) return;

    // Unlink the node from linked list
    prev.next = temp.next;
  }

  /* Given a reference (pointer to pointer) to the head of a list
     and a position, deletes the node at the given position */
  /* Assuming the positions start with 1 */
  void deleteNodeAt(int position)
  {
    // If linked list is empty
    if (head == null)
        return;

    // Store head node
    Node temp = head;

    // If head needs to be removed
    if (position == 1)
    {
        head = temp.next;   // Change head
        return;
    }

    // Find previous node of the node to be deleted
    for (int i=1; temp!=null && i<position-1; i++)
        temp = temp.next;

    // If position is more than number of ndoes
    if (temp == null || temp.next == null)
        return;

    // Node temp->next is the node to be deleted
    // Store pointer to the next of node to be deleted
    Node next = temp.next.next;

    temp.next = next;  // Unlink the deleted node from list
  }

  public void deleteFirst()
	{
    // 1. Return if linked list is empty
    if (head == null)
        return;

		/* 2. Make next of new head as head */
		head = head.next;
	}

  public void deleteLast()
	{
    // 1. Return if linked list is empty
    if (head == null)
        return;

    // 2. Set head as null if it is the last element
    if (head.next == null) head = null;

		// 3. Iterate the linkedlist until last but one node.
		Node tNode = head;
    while(tNode.next.next != null) tNode = tNode.next;

    // 4. Set the last node as null
    tNode.next = null;
	}

	/* This function prints contents of linked list starting from
		the given node */
	public void printList()
	{
		Node tnode = head;
    System.out.print("The elements in the linked list are: ");
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
    System.out.println("");
	}

	/* Driver program to test above functions. Ideally this function
	should be in a separate user class. It is kept here to keep
	code compact */
	public static void main(String[] args)
	{
		/* Start with the empty list */
		LinkedListOperations llist = new LinkedListOperations();

		// Insert 6. So linked list becomes 6->NullList
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NullList
		llist.prepend(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NullList
		llist.prepend(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NullList
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NullList
		llist.insertAfter(llist.head.next, 8);

    // Insert 3 at position 3. So linked list becomes
		// 1->7->3->8->6->4->NullList
		llist.insertAt(3, 3);

    // Insert 9 at position 7. So linked list becomes
		// 1->7->3->8->6->4->9->NullList
		llist.insertAt(7, 9);

    // Insert 5 at position 9. Expect proper error handling
		llist.insertAt(9, 5);
    llist.printList();

    // Delete node 7. So linked list becomes
		// 1->3->8->6->4->9->NullList
    llist.deleteNode(7);

    // Delete node at position 2. So linked list becomes
		// 1->8->6->4->9->NullList
    llist.deleteNodeAt(2);

    // Delete first node. So linked list becomes
		// 8->6->4->9->NullList
    llist.deleteFirst();

    // Delete last node. So linked list becomes
		// 8->6->4->NullList
    llist.deleteLast();

		llist.printList();
	}
}
// This code is contributed by Mihir Kale
