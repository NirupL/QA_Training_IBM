import pandas as pd 

#write to csv file
#Create the dataset
data = {
    "Usernames" : ["admin", "charles","deku"],
    "Passwords" : ["password","Charl13","Allmight"]
 }

#Convert the data to dataframe
df = pd.DataFrame(data)

#Write dataframe to csv file
df.to_csv("usernames.csv",index=False)

