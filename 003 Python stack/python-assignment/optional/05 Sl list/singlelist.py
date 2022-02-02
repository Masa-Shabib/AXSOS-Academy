class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
class List:
    def __init__(self):
        self.head = None
    def add_at_end(self,value):
        new_node= Node(value)
        if self.head == None :
            self.head = new_node
            return 
        last = self.head
        while last.next :
            last = last.next 
        last.next = new_node
        return 
    def print(self):
        current = self.head
        while current is not None:
            print (current.value, "---> ",end="")
            current = current.next




my_list = List()
my_list.add_at_end(141)
my_list.add_at_end(142)
my_list.add_at_end(143)
my_list.add_at_end(144)
my_list.add_at_end(145)
my_list.print()

