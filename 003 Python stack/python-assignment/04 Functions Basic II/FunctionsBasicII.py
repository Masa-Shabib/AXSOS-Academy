def countd(x):
    new_list =[]
    for int in range (x,-1,-1):
        new_list.append(int)
    return new_list
print(countd(8))


def print_return(li):
    print(li[0])
    return li[1]
m = print_return([1,2])

def first_length(li):
    print(li[0]+ len(li))
    return li[1]
m = first_length([1,2,3,5,6])

def values_greater_than_second(li):
    new_li=[]
    count = 0
    for int in range (0,len(li)):
        if len(li)< 2 :
            print ("false")
        elif li[int] > li[1]:
            new_li.append(li[int])
    print(len(new_li))
    return new_li
p_li =values_greater_than_second([5])
print(p_li)

def length_and_value(y,x):
    new_li=[]
    for int in range (0,y):
        new_li.append(x)
    return new_li
m = length_and_value(5,7)
print(m)
