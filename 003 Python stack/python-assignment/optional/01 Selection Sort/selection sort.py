def sort(arr):
    for i in range(0,len(arr)):
        smallest = i
        for x in range(i+1,len(arr)):
            if arr[x] < arr[smallest]:
                smallest=x
        arr[smallest],arr[i] =arr[i],  arr[smallest]
    return arr 
print(sort([9,8,7,6,5,4,3,2,1,0]))

def sort(arr):
    for i in range(0,len(arr)):
        for x in range(i+1,len(arr)):
            if arr[x] < arr[i]:
                arr[x],arr[i] =arr[i],  arr[x]
    return arr 
print(sort([9,8,10,6,13,4,3,2,1,5]))

