def insort(arr):
    for i in range(0,len(arr)):
        for x in range(i+1,len(arr)):
            if arr[x] < arr[i]:
                arr[x],arr[i] =arr[i],  arr[x]
    return arr 
print(insort([9,8,10,6,13,4,3,2,1,5]))
