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
    def delete(self,index):
        if self.head == None:
            return
        if index == 0:
            self.head = self.head.next
            return
        position = 1
        # while current is not None:
        #     if position == index :
        #         current.next=current.next.next
        #         position+=1
        #     return
    def delete1(self,index):
        if index == 0:
            return self.head.next 
        current = self.head
        for i in range (index-1):
            current= current.next
        current.next = current.next.next
        return
    def delete_end(self):
        last = self.head
        while last.next is not None :
            last = last 
        last = None
        return

    def reverse(self):
        prev = None
        current = self.head
        while(current is not None):
            next = current.next
            current.next = prev
            prev = current
            current = next
        self.head = prev
    
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
my_list.add_at_end(146)
my_list.add_at_end(147)
# my_list.delete1(1)
my_list.print()
print("\n")
my_list.reverse()
my_list.print()
