
import pandas as pd
# Reading the file itself
data_url='/Users/HWAT/Desktop/CodingWork/adult.data'
df = pd.read_csv(data_url, header=None)
# Adding column headers for easier identification
column_names = ['age', 'workclass', 'fnlwgt', 'education', 'education_num', 'marital_status',
                'occupation', 'relationship', 'race', 'sex', 'capital_gain', 'capital_loss',
                'hours_per_week', 'native_country', 'income']
df.columns = column_names
# Getting rid of question marks and duplicates
df.replace(' ?', inplace=True)  
df.drop_duplicates(inplace=True)

# Merge self employed categories together
df['workclass']= df['workclass'].replace([' Self-emp-inc', ' Self-emp-not-inc'], ' Self-emp')
 
#Saving the cleaned data file
cleaned_data_file = '/Users/HWAT/Desktop/CodingWork/cleaned_adult_data.csv'
df.to_csv(cleaned_data_file, index=False)
print("Data cleaning completed. Cleaned dataset saved to", cleaned_data_file)




