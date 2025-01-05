tuple = (8, 10, 33, 40, 7)
div = []
for num in tuple:
    if num % 5 == 0:
        div.append(str(num))

print(", ".join(div))
