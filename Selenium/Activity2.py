from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form")

    print("Page Title is: " + driver.title)

    driver.find_element (By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "passwors").send_keys("password")

    driver.find_element(By.XPATH, "//button[text()='Submit']" ).click

    message = driver.find_element(By.CSS_SELECTOR, "h1.text-center")
    print("Login message: ", message.text)
