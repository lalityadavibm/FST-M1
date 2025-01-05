def fibonacci(number, memo={}):
    # Check if the value is already computed
    if number in memo:
        return memo[number]
    
    # Base case
    if number <= 1:
        return number
    
    # Recursively calculate the Fibonacci number and store it in the memo dictionary
    memo[number] = fibonacci(number - 1, memo) + fibonacci(number - 2, memo)
    return memo[number]

# Get user input for the number of terms
nterms = int(input("Enter a number: "))

if nterms <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(nterms):
        print(fibonacci(i))
