class User:		
    def __init__(self,int_rate, balance):
        self.int_rate= int_rate
        self.balance = balance
    def deposit(self, amount):
        self.balance += amount
        return self
    def withdrawal(self, amount):	
        self.balance -= amount
        if self.balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -=5
        return self
    def yield_interest(self):
        if self.balance > 0:
            self.balance=(self.balance * self.int_rate)+self.balance
        return self
    def display_account_info(self):
        print("Balance:",self.balance,"$")
        return self
masa = User(.05,500)
marah = User(.03,400)

# masa.deposit(100).deposit(300).deposit(200).withdrawal(200).yield_interest().display_account_info()
marah.deposit(100).deposit(500).withdrawal(100).withdrawal(400).withdrawal(200).yield_interest().display_account_info()
