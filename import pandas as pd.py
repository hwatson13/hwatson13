#imports
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
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

df['education'] = df['education'].replace([' 7th-8th',' 10th',' 11th',' 1st-4th',' 5th-6th',' 12th', ' 9th',' Preschool'], ' Pre-HS')

# Saving the cleaned data file
cleaned_data_file = '/Users/HWAT/Desktop/CodingWork/cleaned_adult_data.csv'
df.to_csv(cleaned_data_file, index=False)
print("Data cleaning completed. Cleaned dataset saved to", cleaned_data_file)

# Assuming 'gender' 
X = df[['sex', 'education']]
y = df['income']

X = pd.get_dummies(X)

# Splitting the dataset into training versus testing
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

dt_classifier = DecisionTreeClassifier(random_state=42)
dt_classifier.fit(X_train,y_train)

rf_classifier = RandomForestClassifier(n_estimators=100,random_state=42)
rf_classifier.fit(X_train, y_train)

dt_y_pred = dt_classifier.predict(X_test)
dt_accuracy = accuracy_score(y_test, dt_y_pred)
print('Decision Tree Classifier Accuracy: ', dt_accuracy)
print('Decision Tree Classifier Classification Report:')
print(classification_report(y_test, dt_y_pred))

rf_y_pred = rf_classifier.predict(X_test)
rf_accuracy = accuracy_score(y_test, rf_y_pred)
print('\nRandom Forest Classifier Accuracy:', rf_accuracy)
print('Random Forest Classifier Classification Report:')
print(classification_report(y_test, rf_y_pred))

print('\nConfusion Matrix for Decision Tree Classifier:')
print(confusion_matrix(y_test, dt_y_pred))
print('\nConfusion Matrix for Random Forest Classifier:')
print(confusion_matrix(y_test, rf_y_pred))
# Train la model

