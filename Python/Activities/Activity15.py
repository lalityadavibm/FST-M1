try:
    print(x)  # Attempt to print the value of x
except NameError:
    print("x hasn't been defined yet.")  # Handle the NameError if x is not defined
