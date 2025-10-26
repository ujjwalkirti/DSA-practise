class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Add to end
    append(value) {
        const newNode = new Node(value);
        if (!this.head) {
            // First node
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    // Add to beginning
    prepend(value) {
        const newNode = new Node(value);
        if (!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    // Print list
    print() {
        let current = this.head;
        let result = "";
        while (current) {
            result += current.value + " -> ";
            current = current.next;
        }
        console.log(result + "null");
    }

    // Remove by index
    remove(index) {
        if (index < 0 || index >= this.length) return null;

        if (index === 0) {
            this.head = this.head.next;
            this.length--;
            return;
        }

        let current = this.head;
        let previous = null;
        let count = 0;

        while (count < index) {
            previous = current;
            current = current.next;
            count++;
        }

        previous.next = current.next;

        if (index === this.length - 1) {
            this.tail = previous;
        }

        this.length--;
    }
}


const list = new LinkedList();
list.append(10);
list.append(20);
list.prepend(5);
list.print(); // 5 -> 10 -> 20 -> null

