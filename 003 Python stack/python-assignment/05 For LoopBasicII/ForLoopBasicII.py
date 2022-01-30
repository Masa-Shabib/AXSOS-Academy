def biggie_size(li):
    for int in range (0, len(li)):
        if li[int] > 0 :
            li[int] = "big"
    return li
# print(biggie_size([-1, 3, 5, -5]))

def count_positives(li):
    count = 0
    for int in range (0, len(li)):
        if li[int] > 0 :
            count +=1
    li[len(li)-1]= count
    return li
# print(count_positives([-1,1,1,1]))

def sum_total(li):
    sum = 0
    for int in range (0, len(li)):
        sum = sum +li[int]
    return sum
# print(sum_total([1,2,3,4]))

def average(li):
    sum = 0
    for int in range (0, len(li)):
        sum = sum +li[int]
    avg = sum / len(li)
    return avg
# print(average([1,2,3,4]))

def length(li):
    x=len(li)
    return x
# print(length([]))

def minimum(li):
        if len(li) == 0:
            return False
        else:
            min = li[0]
            for int in range (0, len(li)):
                if li[int] < min:
                    min = li[int]
        return min
# print(minimum([]))

def Maximum(li):
        if len(li) == 0:
            return False
        else:
            max = li[0]
            for int in range (0, len(li)):
                if li[int] > max:
                    max = li[int]
        return max
# print(Maximum([]))

def ultimate_analysis(li):
    dic = {}
    dic["sumTotal"]=sum_total(li)
    dic["average"]=average(li)
    dic["minimum"]=minimum(li)
    dic["maximum"]=Maximum(li)
    dic["length"]=len(li)
    return dic
# print(ultimate_analysis([37,2,1,-9]))

def revers(li):
    for i in range(0, int(len(li)/2)):
        x = li[i]
        li[i]= li[len(li)-1-i]
        li[len(li)-1-i] =x
    return li
print(revers([37,2,1,41,8,6,3,-9]))
