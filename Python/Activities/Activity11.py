# Fruit storage dictionary with fruit names as keys and their prices as values
fruits_Storage = {
    "mango": 56,
    "orange": 90,
    "banana": 84,
    "guava": 76,
    "apple": 150
}

# Input from the user to check for fruit availability
available_fruit = input("Please check required fruit: ").lower()

# Check if the fruit is available and print its price if available
if available_fruit in fruits_Storage:
    print(f"Yes, {available_fruit} is available. Price: Rs.{fruits_Storage[available_fruit]}")
else:
    print(f"No, {available_fruit} is not available.")
