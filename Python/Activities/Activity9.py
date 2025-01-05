listOne=[12,23,3,4,5]
listTwo=[2,6,5,8,7]

print("FirstList: ", listOne)
print("SecondList: ", listTwo)

thirdList=[]

for num in listOne:
 if (num % 2 != 0):
    thirdList.append(num)

    for num in listTwo:
        if(num % 2==0):
            thirdList.append(num)

            print("FinalList: ", thirdList)
