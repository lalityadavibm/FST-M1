from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/selects")
    print("Page title is: ", driver.title)

    dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-10")
    check = Select(dropdown)

    check.select_by_visible_text("Two")
    print("Second option: " + check.first_selected_option.text)

    check.select_by_index(3)
    print("Third option: " + check.first_selected_option.text)

    check.select_by_value("four")
    print("Fourth option: " + check.first_selected_option.text)

    allOptions = check.options
    print("Options in the dropdown: ")
    for option in allOptions: 
        print(option.text)