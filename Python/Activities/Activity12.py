def calculateSum(num):
    if num:
        return num + calculateSum(num-1)
    else:
        return 0

# Call the function and print the result
res = calculateSum(10)
print(res)
