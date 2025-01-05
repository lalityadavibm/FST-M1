def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number  # Add each number to total

    return sum  # Return the final sum after the loop finishes

# List of numbers to sum
numList = [10, 40, 60, 90]

# Call the function and print the result
result = calculate_sum(numList)
print("The sum of all elements is: " + str(result))
