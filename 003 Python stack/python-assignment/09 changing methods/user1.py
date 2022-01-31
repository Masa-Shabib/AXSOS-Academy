class User:		# here's what we have so far
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    def make_deposit(self, amount):
        self.account_balance += amount
        return self
    def make_withdrawal(self, amount):	
        self.account_balance -= amount
        return self
    def transfer_money(self, other_user, amount) :
        self.account_balance -= amount
        other_user.account_balance += amount
    def display_user_balance(self):
        print("User:",self.name,",","Balance:",self.account_balance,"$")
        return self
masa = User("Masa Shabib","masa@yahoo.com")
marah = User("Marah Shabib","marah@yahoo.com")
mohammad= User("Mohammad Shabib","mohammad@yahoo.com")
# masa.make_deposit(100)
# masa.make_deposit(300)
# masa.make_deposit(200)
# masa.make_withdrawal(400)
# marah.make_deposit(100)
# marah.make_deposit(300)
# marah.make_withdrawal(400)
# marah.make_withdrawal(400)
# masa.transfer_money(marah, 200)
marah.transfer_money(masa, 200)
masa.make_deposit(100).make_deposit(200).make_withdrawal(400).display_user_balance()