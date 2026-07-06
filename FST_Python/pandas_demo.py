import pandas as pd

#create the dataset
data = {
    "X" : [1,2,3,4,5],
    "Y" : [10,20,30,40,50],
    "Z" : [11,12,13,14,15],
}

#convert data set to dataframe
df = pd.DataFrame(data)

print(df)

print(df["X"][2])

print(df.shape)