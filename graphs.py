# imports
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

#loading data
df = pd.read_csv("cleaned_adult_data.csv")
print(df.dtypes)

# bar chart : income distribution by gender
sns.countplot(x='income', hue='sex', data=df)
plt.title('Income Distribution by Gender')
plt.xlabel('Income')
plt.ylabel('Count')
plt.show()

# grouped bar charted: looking at the proportions of income >50k, =<50k by gender and education level
grouped_data = df.groupby(['sex', 'income', 'education']).size().unstack(fill_value=0)
grouped_data.plot(kind='bar', stacked=True)
plt.title('Proportion of Income >50k by Education Level and Gender')
plt.xlabel('Gender')
plt.ylabel('Count')
plt.xticks(rotation=45)
plt.legend(title='Education level')
plt.show()

# clustered bar chart, comparing 
clustered_data = df.groupby(['marital_status', 'income', 'education']).size().unstack(fill_value=0)
clustered_data.plot(kind='bar')
plt.title('Income Distribution by Marital Status and Education Level')
plt.xlabel('Marital Status')
plt.ylabel('Count')
plt.xticks(rotation=45)
plt.legend(title='Education Level')
plt.show()

# heatmap: comparing education level, sex, and income
heatmap_data = df.pivot_table(index='education', columns='sex', values='income', aggfunc='count', fill_value=0)
plt.figure(figsize=(10, 8))
sns.heatmap(heatmap_data, cmap='viridis', annot=True, fmt='d')
plt.title('Income Distribution by Education Level and Gender')
plt.xlabel('Gender')
plt.ylabel('Education Level')
# Custom legend for income variable
color_bar = plt.colorbar()
color_bar.set_label('Count', rotation=270, labelpad=15)
plt.show()

# stacked bar chart: comparing education level and income by sex
stacked_data = df.groupby(['sex', 'income', 'education']).size().unstack(fill_value=0)
stacked_data.plot(kind='bar', stacked=True)
plt.title('Income Distribution by Gender and Education Level')
plt.xlabel('Gender')
plt.ylabel('Count')
plt.xticks(rotation=45)
plt.legend(title='Education Level')
plt.show()

# clustered bar chart: comparing education level and income by sex
clustered_data = df.groupby(['sex', 'income', 'education']).size().unstack(fill_value=0)
clustered_data.plot(kind='bar')
plt.title('Income Distribution by Gender and Education Level')
plt.xlabel('Gender')
plt.ylabel('Count')
plt.xticks(rotation=45)
plt.legend(title='Education Level')
plt.show()