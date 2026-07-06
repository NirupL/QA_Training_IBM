import pandas as pd

df = pd.read_csv("./activities/usernames.csv")

print(df["Usernames"])

print("-------------------------------------------")

print(df["Usernames"][1])

print("-------------------------------------------")
print(df.sort_values("Usernames",ascending=True))
print("-------------------------------------------")

print(df.sort_values("Passwords", ascending=False))