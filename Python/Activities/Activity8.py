nums = list(input("Please enter your numbers: ").split(","))

firstNum=nums[0]
lastNum=nums[-1]

if(firstNum==lastNum):
    print(True)
else:
    print(False)