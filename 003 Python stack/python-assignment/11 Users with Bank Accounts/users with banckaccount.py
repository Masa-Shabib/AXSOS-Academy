class  BankAccount:	
    def __init__(self,int_rate, balance):
        self.int_rate= int_rate
        self.balance = balance
class User:		
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = [BankAccount(int_rate=0.02, balance=0)]
    def make_deposit(self, amount, accountnum):
        self.account[accountnum].balance += amount
        return self
    def make_withdrawal(self, amount):	
        self.account.balance -= amount
        if self.account.balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.account.balance -=5
        return self
    def yield_interest(self):
        if self.account.balance > 0:
            self.account.balance=(self.account.balance * self.account.int_rate)+ self.account.balance
        return self
    def display_user_balance(self, accountnum):
        print("User:",self.name,",","Balance from account number",accountnum,":",self.account[accountnum].balance,"$")
    def new_account (self):
        self.account.append(BankAccount(int_rate=0.02, balance=0))
        return self
masa = User("Masa Shabib","masa@yahoo.com")
# marah = User("Marah Shabib","marah@yahoo.com")
# mohammad= User("Mohammad Shabib","mohammad@yahoo.com")

masa.new_account().make_deposit(200,1).display_user_balance(1)
masa.make_deposit(100,0).display_user_balance(0)
masa.make_deposit(100,1).display_user_balance(1)