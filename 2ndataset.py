#final 2
#imports
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import OneHotEncoder, StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.pipeline import Pipeline
from sklearn.compose import ColumnTransformer
from sklearn.metrics import accuracy_score, classification_report
import joblib

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

# Merge all the married people & create general Pre-HS
df['marital_status']=df['marital_status'].replace([' Married-civ-spouse', ' Married-spouse-absent',' Married-AF-spouse'], ' Married-etc')


# Saving the cleaned data file
cleaned_data_file = '/Users/HWAT/Desktop/CodingWork/cleaned_adult_data2.csv'
df.to_csv(cleaned_data_file, index=False)
print("Data cleaning completed. Cleaned dataset saved to", cleaned_data_file)