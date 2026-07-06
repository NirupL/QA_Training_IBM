import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

data = {
    "First Name" : ["Satvik", "Avinash", "Lahri"],
    "Last Name" : ["Shah", "Kati", "Rath"],
    "Email" : ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    "PhoneNumber" : ["4537829158","5892184058","4528727830"],
}

df = pd.DataFrame(data)

#create the excel writer object
excel_writer = ExcelWriter("./activities/employee.xlsx")

#Write dataframe to excel file
df.to_excel(excel_writer,sheet_name="Sheet1",index=False)

#Save the excel file
excel_writer.close()

#-----------------------------------------------------

#to read from the excel file
df = pd.read_excel("./activities/employee.xlsx",sheet_name="Sheet1")

#print the number of rows
print(df.shape)

#print data in the email columns only
print(df["Email"])

#sorted by firstname
print(df.sort_values("First Name",ascending=True))