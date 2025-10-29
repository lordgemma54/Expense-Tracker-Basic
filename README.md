# --- Expense Tracker App ---


## --- Inspiration --- 
I have experimented with budgeting software before and found them to be a little too bloated and 
offer too many features.  I wanted to keep things very simple and have a minimalist interface which allows me to log
expenses and income without too much visual clutter.

## --- Vision --- 
My goal is to create a simple app for adding income and expenses. The idea is to store user entries
to a local database that keeps track of all expenses and income.  
The user should be able to export a csv file of all transactions for a given time period. 

## --- Basic Functionality --- 
Totals are displayed after each addition or deletion of a transaction. The user can see an abridged
version (only the item and amount) of each transaction as a list. The user can see a detailed view of each transaction that
exposes the category, a note that provides additional details about the transaction, and whether the transaction is income or an expense. 
The user can add new transactions. 

## --- How to Use the expense tracker ---
The user clicks the '+' button to create a new entry. This creates a new window that allows the user to enter information.
They can add an item name, a category, a note, an amount, and designate the entry as income or as an expense.  
Incomes add to your total, expenses subtract from your total. After a transaction is added to the list, 
the user can click anywhere on the transaction to bring up an animated detail view. The user can use keyboard commands to execute items seen in the menu.   

## --- Still to come / Currently functional ---
I am yet to implement the .csv export function or storage of transactions to a local database. All other functionality described
above is live.


Dark Theme:
![darkTheme](https://github.com/user-attachments/assets/b20c37f1-aeb3-448f-983c-1ad728c819e9)


Light Theme:
![lightTheme_new](https://github.com/user-attachments/assets/3e6450c8-1de1-4b29-878a-65f999b6880c)
