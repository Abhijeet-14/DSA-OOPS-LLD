// LinkedList
// example -- Chain
// O-O-O-....
// []-[]-[]-...
// [] - value
// - - next direction
// data type -- int, string, array, boolean
// create a new data type - (int, next), (string, next) (array, next)

class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}
// MAP -- GOVINDPUR - SAKCHI --> TELCO --> NILDI

// 0-1-2-3-4-5-6
// let head = new Node(0);
// head.next = new Node(1);
// head.next.next = new Node(2);
// head.next.next.next = new Node(3);
// head.next.next.next.next = new Node(4);

// console.log(head)

function printLinkedList(head) {
  // Gdvp -- Sakchi

  // head.next.next.next.next.next = null tha --> null.data -- ERROR

  current_location = head;
  while (current_location !== null) {
    console.log(current_location.data); //  gvdp // telco // nildhi
    current_location = current_location.next; // telco // nildhi // golmuri
  }
}

// printLinkedList(head)

function insertInLinkedList(data, head) {
  // sakchi ko kaise phenchange?
  // data, next=null

  // EDGE CASE: agar gvdp exist nahi hai -- toh naya bana kar -- gvdp.next = null

  let current_location = head;
  while (current_location.next !== null) {
    //gvdp.next !== null ; false, telco.next // // // sakchi.next = null
    current_location = current_location.next; // current_location = telco // golmuri
  }
  current_location.next = new Node(data); // sakchi.next = new node(data)
}

// insertInLinkedList(5, head);
// insertInLinkedList(6, head);

// printLinkedList(head);

let head = new Node("Govindpur");
head = insertInLinkedList("Telco", head);
insertInLinkedList("nildhi", head);
insertInLinkedList("golmuri", head);
insertInLinkedList("Sakchi", head);

printLinkedList(head);

// nahi mila
{
  let a = 11;
  // nahi mila
  {
    // nahi mila
    {
      // nahi mila
      {
        console.log(a); // Nahi mila
        let b = 10;
      }
    }
    console.log(b);
  }
}
