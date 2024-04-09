
import pandas as pd
data_url='/Users/HWAT/Desktop/adult/adult.data'
df = pd.read_csv(data_url, header=None)

column_names = ['age', 'workclass', 'fnlwgt', 'education', 'education_num', 'marital_status',
                'occupation', 'relationship', 'race', 'sex', 'capital_gain', 'capital_loss',
                'hours_per_week', 'native_country', 'income']
df.columns = column_names

df.replace(' ?', pd.NA, inplace=True)  
df.dropna(inplace=True)

df.drop_duplicates(inplace=True)
cleaned_data_file = '/Users/HWAT/Desktop/adult/cleaned_adult_data.csv'
df.to_csv(cleaned_data_file, index=False)
print("Data cleaning completed. Cleaned dataset saved to", cleaned_data_file)

df.head()


